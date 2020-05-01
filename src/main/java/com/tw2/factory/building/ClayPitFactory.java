package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.ClayPit;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class ClayPitFactory extends BuildingFactory {
    public ClayPitFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.CLAY_PIT);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.CLAY_PIT) : 0;
        int levelUpGoing = getLevelUpGoingBuildingByBuilding(BuildingName.CLAY_PIT);

        return new ClayPit(isConstructed, level, levelUpGoing);
    }
}
