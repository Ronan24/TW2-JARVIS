package model;


import model.building.Building;
import model.building.BuildingName;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class Village {
    private Map<BuildingName, Building> villageBuildings;
    private Army army;
    private Map<ResourceType, Integer> resourceMap;
    private int point;
    private int gold;
    private int provisions;
    private int iron;
    private int wood;
    private int clay;

    public Village() {
        this.villageBuildings = new HashMap<>();
        this.army = new Army();
        this.resourceMap = new HashMap<>();
    }

    public Building getBuildingByBuildingName(BuildingName buildingName) {
        return villageBuildings.get(buildingName);
    }

    public Integer getUnitNumberByUnit(UnitStaticInfo unit) {
        return this.army.getUnitNumberByUnit(unit);
    }

    public void addBuilding(BuildingName buildingName, Building building) {
        System.out.println("Add building : " + building);
        this.villageBuildings.put(buildingName, building);
    }

    public void addUnit(UnitStaticInfo unitStaticInfo, int numberOfUnits) {
        System.out.println("We have " +
                numberOfUnits +
                " of " + unitStaticInfo.name());
        this.army.addUnit(unitStaticInfo, numberOfUnits);
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addResource(ResourceType resourceType, int amount) {
        System.out.println(resourceType.name() + " : " + amount);
        this.resourceMap.put(resourceType, amount);
    }

    public int getResourceByType(ResourceType resourceType){
        return this.resourceMap.get(resourceType);
    }

    public Collection<Building> getVillageBuildings() {
        return villageBuildings.values();
    }

    public Army getArmy() {
        return army;
    }

    public boolean improveIsValid(BuildingName buildingName){
        Building building = this.getBuildingByBuildingName(buildingName);

        return building.getWoodCost(building.getLevel()) <= this.getResourceByType(ResourceType.WOOD) &&
                building.getClayCost(building.getLevel()) <= this.getResourceByType(ResourceType.CLAY) &&
                building.getIronCost(building.getLevel()) <= this.getResourceByType(ResourceType.IRON);
    }
}
