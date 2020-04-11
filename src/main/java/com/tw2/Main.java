package com.tw2;

import com.tw2.controller.BasicController;
import com.tw2.controller.LoginController;
import com.tw2.controller.ResourceDepositController;
import com.tw2.controller.VillageController;
import com.tw2.factory.VillageFactory;
import com.tw2.model.Player;
import com.tw2.model.Village;
import com.tw2.model.building.BuildingName;
import com.tw2.model.unit.Army;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tw2.ruler.RuleAttackBarbaric;
import com.tw2.ruler.RuleImproveBuildings;

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
        ResourceDepositController resourceDepositController = ResourceDepositController.getInstance();

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

                Optional<BuildingName> toImprove = RuleImproveBuildings.findBestImprove(village);
                if (toImprove.isPresent()) {
                    villageController.improveBuilding(toImprove.get());
                } else {
                    LOGGER.debug("Not enough resources...");
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

            resourceDepositController.execute();

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