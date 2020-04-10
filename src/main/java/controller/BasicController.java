package controller;

import model.unit.Army;
import model.unit.UnitStaticInfo;
import model.building.BuildingName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class BasicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicController.class);

    private WebSetup webSetup;

    public BasicController(WebSetup webSetup) {
        this.webSetup = webSetup;
    }

    public void goToBuilding(BuildingName buildingName) {
        webSetup.clickOn(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-" +
                buildingName.getLabelIdFromMap() +
                "']/a[@class='level-indicator']"));

        webSetup.clickOn(By.xpath("//li[@class='context-menu-item open-screen']//div//div[@class='border']"));
    }

    public int getQueueSize() {
        try {
            return webSetup.readInteger(By.xpath("//div[@class='in-queue building-queue short']"));
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public void goBack() throws InterruptedException {
        webSetup.clickOn(By.xpath("//div[@class='tribe-crest-front level-0']"));
        Thread.sleep(1000);
        webSetup.clickOn(By.xpath("//div[@class='tribe-crest-front level-0']"));
        Thread.sleep(1000);
    }

    public void goToMainMenu() throws InterruptedException {
        Thread.sleep(8000);

        webSetup.clickOn(By.id("village-zoom"));

        Thread.sleep(3000);
    }

    public void attackVillage(Point point, Army army, Army armyToSend) throws InterruptedException {
        this.goToVillage(point);

        webSetup.clickOn(By.xpath("//li[contains(@class,'context-menu-item custom-army')]//div//div[contains(@class,'border')]"));
        Thread.sleep(3000);

        int index = 1;

        for (UnitStaticInfo unitStaticInfo : UnitStaticInfo.values()) {
            if (army.getUnitNumberByUnit(unitStaticInfo) > 0) {
                if (armyToSend.getUnitNumberByUnit(unitStaticInfo) != 0) {
                    LOGGER.debug("Let's send {} {}", armyToSend.getUnitNumberByUnit(unitStaticInfo), unitStaticInfo);

                    webSetup.sendKey(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[" +
                                    index +
                                    "]/div[1]/div[3]/input[1]"),
                            String.valueOf(armyToSend.getUnitNumberByUnit(unitStaticInfo)));
                }
                index++;
            }
        }

        webSetup.clickOn(By.xpath("//a[contains(@class,'btn-orange btn-form btn-border no-padding')]"));

        this.goToMainMenu();
    }

    public void goToVillage(Point point) {
        webSetup.clickOn(By.id("world-map"));
        webSetup.sendKey(By.xpath("//input[@type='number']"), String.valueOf(point.x));
        webSetup.sendKey(By.xpath("(//input[@type='number'])[2]"), String.valueOf(point.y));
        webSetup.clickOn(By.xpath("//footer[@id='interface-bottom-container']//td[3]//div[1]"));
    }

    public String getUserName() {
        String userInfo = webSetup.readValue(By.xpath("//div[@id='info-player']//h4"));
        return userInfo.split(" ")[0];
    }

    public int getUserRank() {
        return webSetup.readInteger(By.xpath("//div[@id='info-player-rank']//div[@class='info-player-text']"));
    }

    public int getUserPoints() {
        return webSetup.readInteger(By.xpath("//div[@id='info-player-money']//div[@class='info-player-text']"));
    }
}
