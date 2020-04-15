package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.TimberCamp;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class TimberCampFactory extends BuildingFactory {
    public TimberCampFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.TIMBER_CAMP);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.TIMBER_CAMP) : 0;
        int levelUpGoing = getLevelUpGoingBuildingByBuilding(BuildingName.TIMBER_CAMP);

        return new TimberCamp(isConstructed, level, levelUpGoing);
    }
}
