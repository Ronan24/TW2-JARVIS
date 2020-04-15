package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.Wall;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class WallFactory extends BuildingFactory {
    public WallFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.WALL);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.WALL) : 0;
        int levelUpGoing = getLevelUpGoingBuildingByBuilding(BuildingName.WALL);

        return new Wall(isConstructed, level, levelUpGoing);
    }
}
