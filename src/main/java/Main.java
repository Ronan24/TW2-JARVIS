import controller.BasicController;
import controller.LoginController;
import controller.VillageController;
import factory.VillageFactory;
import model.Player;
import model.Village;
import model.building.BuildingName;
import model.unit.Army;
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

    public static void main(String[] args) throws InterruptedException {

        loadProperties();

        LoginController.login(username, password, worldName, url);

        VillageFactory villageFactory = new VillageFactory();
        BasicController basicController = BasicController.getInstance();
        VillageController villageController = VillageController.getInstance();
        RuleAttackBarbaric ruleAttackBarbaric = new RuleAttackBarbaric();

        Player player = new Player(basicController.getUserName(), basicController.getUserRank(), basicController.getUserPoints());

        while (true) {
            Point villageLocation = basicController.getCurrentLocation();
            Village village = player.getVillage(villageLocation);

            basicController.enterIntoVillage(villageLocation);

            try {
                if (village == null) {
                    String villageName = basicController.getCurrentVillageName();
                    village = villageFactory.buildVillage(villageLocation, villageName);
                    player.addVillage(village);
                } else {
                    villageFactory.update(village);
                }

                if (village.getConstructionQueueSize() == 0) {
                    LOGGER.debug("We can construct");
                    Optional<BuildingName> toImprove = RuleImproveBuildings.findBestImprove(village);

                    if (toImprove.isPresent()) {
                        villageController.improveBuilding(toImprove.get());
                    } else {
                        LOGGER.debug("Not enough resources...");
                    }
                } else {
                    LOGGER.debug("Can't construct yet");
                }

                Map<Point, Army> toAttackOptional = ruleAttackBarbaric.findBestBarbaricVillageToAttack(village);

                for (Map.Entry<Point, Army> attackToPerform : toAttackOptional.entrySet()) {
                    Thread.sleep(1000);
                    basicController.attackVillage(attackToPerform.getKey(), village.getArmy(), attackToPerform.getValue());

                    Thread.sleep(1000);
                }

                basicController.nextVillage();
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