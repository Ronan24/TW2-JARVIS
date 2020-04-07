package model.building;

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
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.BARRACKS) : -1;

        return new Barracks(isConstructed, level);
    }
}
