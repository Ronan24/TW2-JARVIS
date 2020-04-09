package model.building;

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
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.STATUE) : -1;

        return new Statue(isConstructed, level);
    }
}
