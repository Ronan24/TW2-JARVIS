package model;


import model.building.Building;
import model.building.BuildingName;
import model.unit.Army;
import model.unit.UnitStaticInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class Village {

    private static final Logger LOGGER = LoggerFactory.getLogger(Village.class);

    private Map<BuildingName, Building> villageBuildings;
    private Army army;
    private Point localisation;
    private String villageName;
    private Map<ResourceType, Integer> resourceMap;
    private int constructionQueueSize;

    public Village(Point localisation, String villageName) {
        this.localisation = localisation;
        this.villageName = villageName;
        this.villageBuildings = new EnumMap<>(BuildingName.class);
        this.army = new Army();
        this.resourceMap = new EnumMap<>(ResourceType.class);
        this.constructionQueueSize = 0;
    }

    public Point getLocalisation() {
        return localisation;
    }

    public String getVillageName() {
        return villageName;
    }

    public Building getBuildingByBuildingName(BuildingName buildingName) {
        return villageBuildings.get(buildingName);
    }

    public Integer getUnitNumberByUnit(UnitStaticInfo unit) {
        return this.army.getUnitNumberByUnit(unit);
    }

    public int getConstructionQueueSize() {
        return constructionQueueSize;
    }

    public void addBuilding(BuildingName buildingName, Building building) {
        LOGGER.debug("Add building : {}", building);
        this.villageBuildings.put(buildingName, building);
    }

    public void addUnit(UnitStaticInfo unitStaticInfo, int numberOfUnits) {
        LOGGER.debug("We have {} of {}", numberOfUnits, unitStaticInfo);
        this.army.addUnit(unitStaticInfo, numberOfUnits);
    }

    public void addResource(ResourceType resourceType, int amount) {
        LOGGER.debug("{} : {}", resourceType, amount);
        this.resourceMap.put(resourceType, amount);
    }

    public int getResourceByType(ResourceType resourceType) {
        return this.resourceMap.get(resourceType);
    }

    public Collection<Building> getVillageBuildings() {
        return villageBuildings.values();
    }

    public Army getArmy() {
        return army;
    }

    public boolean improveIsValid(BuildingName buildingName) {
        Building building = this.getBuildingByBuildingName(buildingName);

        boolean result = true;

        for (ResourceType resourceType : ResourceType.values()) {
            result = result && building.getResourceCost(building.getLevel(), resourceType) <= this.getResourceByType(resourceType);
        }

        return result;
    }

    public void update(Map<BuildingName, Building> villageBuildings, Map<ResourceType, Integer> resourceMap, Army army, int constructionQueueSize) {
        this.villageBuildings = villageBuildings;
        this.resourceMap = resourceMap;
        this.army = army;
        this.constructionQueueSize = constructionQueueSize;
    }
}
