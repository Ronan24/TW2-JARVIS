package com.tw2.factory.building;

import com.tw2.model.building.Barracks;
import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class BarracksFactory extends BuildingFactory {
    public BarracksFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.BARRACKS);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.BARRACKS) : 0;
        int levelUpGoing = getLevelUpGoingBuildingByBuilding(BuildingName.BARRACKS);

        return new Barracks(isConstructed, level, levelUpGoing);
    }
}
