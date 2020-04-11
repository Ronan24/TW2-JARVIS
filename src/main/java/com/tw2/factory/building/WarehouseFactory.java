package com.tw2.factory.building;

import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.Warehouse;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class WarehouseFactory extends BuildingFactory {
    public WarehouseFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.WAREHOUSE);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.WAREHOUSE) : -1;

        return new Warehouse(isConstructed, level);
    }
}
