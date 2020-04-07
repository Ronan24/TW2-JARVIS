import controller.BasicController;
import controller.LoginController;
import model.Village;
import model.WebSetup;
import model.building.BuildingName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class Main {

    private static String USERNAME;
    private static String PASSWORD;
    private static String URL;
    private static String WORLD_NAME;

    public static void main(String[] args) {

        loadProperties();

        WebSetup websetup = WebSetup.getInstance();
        try {
            LoginController login = new LoginController(websetup.getChromeWebDriver(), websetup.getWait(), USERNAME,
                    PASSWORD, WORLD_NAME, URL);

            VillageFactory villageFactory = new VillageFactory(websetup);
            BasicController basicController = new BasicController(websetup.getChromeWebDriver(), websetup.getWait(), websetup.getAWTRobot());
            RuleAttackBarbaric ruleAttackBarbaric = new RuleAttackBarbaric();

            basicController.goToMainMenu();

            while (true) {
                Village village = villageFactory.buildVillage();

                if (basicController.getQueueSize() == 0) {
                    System.out.println("We can construct");
                    Optional<BuildingName> toImprove = RuleImproveBuildings.findBestImprove(village);

                    if (toImprove.isPresent()) {

                        basicController.goToBuilding(BuildingName.HEADQUARTER);
                        try {
                            WebElement element = websetup.getChromeWebDriver().findElement(By.xpath("//div[@class='building-container building-" +
                                    toImprove.get().getLabelIdFromMap() +
                                    "']//div//div//span[@class='size-44x44 btn-upgrade btn-orange']"));
                            element.click();
                        } catch (NoSuchElementException e) {
                            System.out.println(toImprove.get().getLabelIdFromMap() + " not found ...");
                        }

                        Thread.sleep(1000);
                        basicController.goBack();
                    } else {
                        System.out.println("Not enough resources...");
                    }
                } else {
                    System.out.println("Can't construct yet");
                }

                Optional<Point> toAttackOptional = ruleAttackBarbaric.findBestBarbaricVillageToAttack(village);

                if (toAttackOptional.isPresent()) {

                    Thread.sleep(1000);
                    basicController.goToVillage(toAttackOptional.get());

                    Thread.sleep(1000);
                    basicController.goBack();
                } else {
                    System.out.println("Not enough units...");
                }

                Thread.sleep(60000);

            }


        } catch (InterruptedException v) {
            System.out.println(v);
            try {
                //	atac.service.shutdownNow();//test needed
                websetup.quitWithDelay();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream("src\\main\\resources\\config.properties")) {

            Properties prop = new Properties();

            //load a properties file from class path, inside static method
            prop.load(input);

            // get the property value and print it out
            URL = prop.getProperty("tw2.url");
            USERNAME = prop.getProperty("tw2.user");
            PASSWORD = prop.getProperty("tw2.password");
            WORLD_NAME = prop.getProperty("tw2.world");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}