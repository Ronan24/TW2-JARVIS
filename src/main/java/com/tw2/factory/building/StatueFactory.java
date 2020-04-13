package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.Statue;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class StatueFactory extends BuildingFactory {
    public StatueFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.STATUE);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.STATUE) : 0;

        return new Statue(isConstructed, level);
    }
}
