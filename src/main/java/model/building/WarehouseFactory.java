package model.building;

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
