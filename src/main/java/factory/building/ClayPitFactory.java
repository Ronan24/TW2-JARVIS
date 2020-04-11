package factory.building;

import model.building.Building;
import model.building.BuildingName;
import model.building.ClayPit;

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
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.CLAY_PIT) : -1;

        return new ClayPit(isConstructed, level);
    }
}
