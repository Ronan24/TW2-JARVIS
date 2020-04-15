package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.Hospital;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class HospitalFactory extends BuildingFactory {
    public HospitalFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.HOSPITAL);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.HOSPITAL) : 0;
        int levelUpGoing = getLevelUpGoingBuildingByBuilding(BuildingName.HOSPITAL);

        return new Hospital(isConstructed, level, levelUpGoing);
    }
}
