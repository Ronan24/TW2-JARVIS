package model.building;

import model.ResourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class Building {
    private BuildingName buildingName;
    private boolean isConstruct;
    private int level;
    protected List<BuildingStaticInfo> buildingStaticInfoList;

    public Building(BuildingName buildingName, boolean isConstruct, int level) {
        this.buildingName = buildingName;
        this.isConstruct = isConstruct;
        this.level = level;
        this.buildingStaticInfoList = new ArrayList<>();
    }

    public boolean isConstruct() {
        return isConstruct;
    }

    public int getLevel() {
        return level;
    }

    public BuildingName getBuildingName() {
        return buildingName;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingName=" + buildingName +
                ", isConstruct=" + isConstruct +
                ", level=" + level +
                '}';
    }

    public int getResourceCost(int level, ResourceType resourceType) {
        return this.buildingStaticInfoList.get(level).getResourceCost(resourceType);
    }

    public int getDuration(int level) {
        return this.buildingStaticInfoList.get(level).getDuration();
    }
}
