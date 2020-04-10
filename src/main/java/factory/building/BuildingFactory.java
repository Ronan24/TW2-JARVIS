package factory.building;

import controller.VillageController;
import model.building.Building;
import model.building.BuildingName;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public abstract class BuildingFactory {

    private final VillageController villageController;

    public BuildingFactory() {
        this.villageController = VillageController.getInstance();
    }

    public abstract Building buildBuilding();

    protected boolean getIsConstructedByBuildingName(BuildingName buildingName) {
        return this.villageController.getIsConstructedByBuildingName(buildingName);
    }

    protected int getLevelBuildingByBuilding(BuildingName buildingName) {
        return this.villageController.getLevelBuildingByBuilding(buildingName);
    }
}
