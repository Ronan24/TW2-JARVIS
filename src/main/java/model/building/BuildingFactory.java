package model.building;

import model.WebSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public abstract class BuildingFactory {

    private final WebSetup webSetup;

    public BuildingFactory() {
        this.webSetup = WebSetup.getInstance();
    }

    public abstract Building buildBuilding();

    protected boolean getIsConstructedByBuildingName(BuildingName buildingName) {
        try {
            getLevelBuildingByBuilding(buildingName);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected int getLevelBuildingByBuilding(BuildingName buildingName) throws NoSuchElementException {
        return this.webSetup.readInteger(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-" +
                buildingName.getLabelIdFromMap() +
                "']/a[@class='level-indicator']/span[@class='building-level']/span[1]"));
    }
}
