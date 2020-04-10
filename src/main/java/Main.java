import controller.BasicController;
import controller.LoginController;
import factory.VillageFactory;
import model.Player;
import model.unit.Army;
import model.Village;
import controller.WebSetup;
import model.building.BuildingName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ruler.RuleAttackBarbaric;
import ruler.RuleImproveBuildings;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static String username;
    private static String password;
    private static String url;
    private static String worldName;

    public static void main(String[] args) {

        loadProperties();

        WebSetup websetup = WebSetup.getInstance();
        try {
            LoginController.login(websetup, username,
                    password, worldName, url);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }

        VillageFactory villageFactory = new VillageFactory(websetup);
        BasicController basicController = new BasicController(websetup);
        RuleAttackBarbaric ruleAttackBarbaric = new RuleAttackBarbaric();

        Player player = new Player(basicController.getUserName(), basicController.getUserRank(), basicController.getUserPoints());

        try {
            basicController.goToMainMenu();
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }

        while (true) {

            Village village = null;
            try {
                village = villageFactory.buildVillage();
            } catch (InterruptedException e) {
                try {
                    basicController.goToMainMenu();
                } catch (InterruptedException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }


            try {


                if (basicController.getQueueSize() == 0) {
                    LOGGER.debug("We can construct");
                    Optional<BuildingName> toImprove = RuleImproveBuildings.findBestImprove(village);

                    if (toImprove.isPresent()) {

                        basicController.goToBuilding(BuildingName.HEADQUARTER);
                        try {
                            websetup.moveAndClickOn(By.xpath("//div[@class='building-container building-" +
                                    toImprove.get().getLabelIdFromMap() +
                                    "']//div//div//span[@class='size-44x44 btn-upgrade btn-orange']"));
                        } catch (NoSuchElementException e) {
                            LOGGER.debug("{} not found ...", toImprove.get().getLabelIdFromMap());
                        }

                        Thread.sleep(1000);
                        basicController.goBack();
                    } else {
                        LOGGER.debug("Not enough resources...");
                    }
                } else {
                    LOGGER.debug("Can't construct yet");
                }

                Map<Point, Army> toAttackOptional = ruleAttackBarbaric.findBestBarbaricVillageToAttack(village);

                for (Map.Entry<Point,Army> attackToPerform : toAttackOptional.entrySet()) {
                    Thread.sleep(1000);
                    basicController.attackVillage(attackToPerform.getKey(), village.getArmy(), attackToPerform.getValue());

                    Thread.sleep(1000);
                }

                websetup.clickOn(By.xpath("//a[@id='switch-village-next']"));
                Thread.sleep(1000);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }

        }
    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream("src\\main\\resources\\config.properties")) {

            Properties prop = new Properties();

            //load a properties file from class path, inside static method
            prop.load(input);

            // get the property value and print it out
            url = prop.getProperty("tw2.url");
            username = prop.getProperty("tw2.user");
            password = prop.getProperty("tw2.password");
            worldName = prop.getProperty("tw2.world");

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
    }

}