package model.building;

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
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.FARM) : -1;

        return new Farm(isConstructed, level);
    }
}
