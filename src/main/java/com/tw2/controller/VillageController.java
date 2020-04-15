package com.tw2.controller;

import com.tw2.model.ResourceType;
import com.tw2.model.building.BuildingName;
import com.tw2.model.unit.UnitStaticInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class VillageController {
    private static final VillageController instance = new VillageController();

    private static final Logger LOGGER = LoggerFactory.getLogger(VillageController.class);

    public static VillageController getInstance() {
        return instance;
    }

    private WebSetup webSetup;

    private VillageController() {
        this.webSetup = WebSetup.getInstance();
    }

    public void goToBuilding(BuildingName buildingName) {
        this.webSetup.clickOn(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-" +
                buildingName.getLabelIdFromMap() +
                "']/a[@class='level-indicator']"));

        this.webSetup.clickOn(By.xpath("//li[@class='context-menu-item open-screen']//div//div[@class='border']"));
    }

    public void improveBuilding(BuildingName buildingName) {
        this.goToBuilding(BuildingName.HEADQUARTER);
        try {
            this.webSetup.moveAndClickOn(By.xpath("//div[@class='building-container building-" +
                    buildingName.getLabelIdFromMap() +
                    "']//div//div//span[@class='size-44x44 btn-upgrade btn-orange']"), 10);
        } catch (TimeoutException e) {
            LOGGER.info("{} not found ...", buildingName.getLabelIdFromMap());
        } finally {
            this.webSetup.clickOn(By.xpath("//html//body//div//section//div//div//header//ul//li//a"));
        }
    }

    public int getQueueSize() {
        try {
            return this.webSetup.readInteger(By.xpath("//div[@class='in-queue building-queue short']"));
        } catch (TimeoutException e) {
            try {
                return this.webSetup.readInteger(By.xpath("//div[@class='in-queue building-queue medium']"));
            } catch (TimeoutException e1) {
                try {
                    return this.webSetup.readInteger(By.xpath("//div[@class='in-queue building-queue long']"));
                } catch (TimeoutException e2) {
                    return 0;
                }
            }
        }
    }

    public boolean getIsConstructedByBuildingName(BuildingName buildingName) {
        try {
            getLevelBuildingByBuilding(buildingName);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public int getLevelBuildingByBuilding(BuildingName buildingName) {
        try {
            return this.webSetup.readInteger(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-" +
                    buildingName.getLabelIdFromMap() +
                    "']/a[@class='level-indicator']/span[@class='building-level']/span[1]"), 2);
        } catch (TimeoutException e) {
            String potentialLevelString = this.webSetup.readValue(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-" +
                    buildingName.getLabelIdFromMap() +
                    "']/a[@class='level-indicator']/span[@class='building-level upgrading']/span[1]"));
            return Integer.parseInt(potentialLevelString.split("\n")[0]);
        }
    }

    public int getResourceByType(ResourceType resourceType) {
        return this.webSetup.readInteger(By.xpath("//body/div[@id='wrapper']/div[@id='interface-top']/div[@class='interface-wrapper']/div[@id='top-wrapper']/div[@id='resource-bar']/div[@id='resources-wrapper']/div[" +
                resourceType.getIndex() +
                "]/div[2]/div[1]"));
    }

    public int getAmountUnits(UnitStaticInfo unitStaticInfo) {
        String amountString = this.webSetup.readValue(By.xpath("//div[@id='topinterface-right-wrapper']//li[" +
                unitStaticInfo.getIndex() +
                "]//div[1]//div[1]"));

        if (amountString.isEmpty()) {
            amountString = this.webSetup.readValue(By.xpath("//body/div[@id='wrapper']/div[@id='topinterface-right-wrapper']/div[@id='unit-bar']/ul/li[" +
                    unitStaticInfo.getIndex() +
                    "]/div[1]/div[1]"));
        }

        return Integer.parseInt(amountString);
    }

    public int getLevelUpGoingByBuildingName(BuildingName buildingName) {
        try {
            return Integer.parseInt(this.webSetup.readValue(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-" +
                    buildingName.getLabelIdFromMap() +
                    "']/a[@class='level-indicator']/span[@class='building-level upgrading']/span[1]/span[1]"), 2).split("\\+")[1]);
        } catch (TimeoutException e){
            return 0;
        }
    }
}
