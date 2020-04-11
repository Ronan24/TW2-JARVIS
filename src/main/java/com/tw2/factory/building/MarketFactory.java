package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.Market;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class MarketFactory extends BuildingFactory {
    public MarketFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.MARKET);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.MARKET) : -1;

        return new Market(isConstructed, level);
    }
}
