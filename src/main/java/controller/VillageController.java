package controller;

import model.ResourceType;
import model.building.BuildingName;
import model.unit.UnitStaticInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

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

    public void improveBuilding(BuildingName buildingName){
        this.goToBuilding(BuildingName.HEADQUARTER);
        try {
            this.webSetup.moveAndClickOn(By.xpath("//div[@class='building-container building-" +
                    buildingName.getLabelIdFromMap() +
                    "']//div//div//span[@class='size-44x44 btn-upgrade btn-orange']"));
        } catch (NoSuchElementException e) {
            LOGGER.debug("{} not found ...", buildingName.getLabelIdFromMap());
        } finally {
            this.webSetup.clickOn(By.xpath("//html//body//div//section//div//div//header//ul//li//a"));
        }
    }

    public int getQueueSize() {
        try {
            return this.webSetup.readInteger(By.xpath("//div[@class='in-queue building-queue short']"));
        } catch (NoSuchElementException e) {
            try {
                return this.webSetup.readInteger(By.xpath("//div[@class='in-queue building-queue medium']"));
            } catch (NoSuchElementException e1) {
                try {
                    return this.webSetup.readInteger(By.xpath("//div[@class='in-queue building-queue long']"));
                } catch (NoSuchElementException e2) {
                    return 0;
                }
            }
        }
    }

    public boolean getIsConstructedByBuildingName(BuildingName buildingName) {
        try {
            getLevelBuildingByBuilding(buildingName);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public int getLevelBuildingByBuilding(BuildingName buildingName) {
        return this.webSetup.readInteger(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-" +
                buildingName.getLabelIdFromMap() +
                "']/a[@class='level-indicator']/span[@class='building-level']/span[1]"));
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
}
