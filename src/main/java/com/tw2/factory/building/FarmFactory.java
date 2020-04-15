package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.Farm;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class FarmFactory extends BuildingFactory {
    public FarmFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.FARM);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.FARM) : 0;
        int levelUpGoing = getLevelUpGoingBuildingByBuilding(BuildingName.FARM);

        return new Farm(isConstructed, level, levelUpGoing);
    }
}
