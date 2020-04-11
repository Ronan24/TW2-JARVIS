package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.IronMine;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class IronMineFactory extends BuildingFactory {
    public IronMineFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.IRON_MINE);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.IRON_MINE) : -1;

        return new IronMine(isConstructed, level);
    }
}
