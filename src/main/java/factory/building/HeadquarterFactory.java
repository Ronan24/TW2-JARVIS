package factory.building;

import model.building.Building;
import model.building.BuildingName;
import model.building.Headquarter;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class HeadquarterFactory extends BuildingFactory {
    public HeadquarterFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.HEADQUARTER);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.HEADQUARTER) : -1;

        return new Headquarter(isConstructed, level);
    }
}
