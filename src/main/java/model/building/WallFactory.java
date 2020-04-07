package model.building;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class WallFactory extends BuildingFactory {
    public WallFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.WALL);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.WALL) : -1;

        return new Wall(isConstructed, level);
    }
}
