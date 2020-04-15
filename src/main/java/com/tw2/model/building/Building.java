package com.tw2.model.building;

import com.tw2.model.ResourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public abstract class Building {
    private BuildingName buildingName;
    private boolean isConstruct;
    private int level;
    private int levelUpGoing;
    protected List<BuildingStaticInfo> buildingStaticInfoList;

    public Building(BuildingName buildingName, boolean isConstruct, int level, int levelUpGoing) {
        this.buildingName = buildingName;
        this.isConstruct = isConstruct;
        this.level = level;
        this.levelUpGoing = levelUpGoing;
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

    public int getLevelUpGoing() {
        return levelUpGoing;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingName=" + buildingName +
                ", isConstruct=" + isConstruct +
                ", level=" + level +
                ", levelUpGoing=" + levelUpGoing +
                '}';
    }

    public int getResourceCost(int level, ResourceType resourceType) {
        return this.buildingStaticInfoList.get(level-1).getResourceCost(resourceType);
    }

    public int getDuration(int level) {
        return this.buildingStaticInfoList.get(level-1).getDuration();
    }
}
