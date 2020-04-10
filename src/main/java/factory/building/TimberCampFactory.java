package factory.building;

import model.building.Building;
import model.building.BuildingName;
import model.building.TimberCamp;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class TimberCampFactory extends BuildingFactory {
    public TimberCampFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.TIMBER_CAMP);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.TIMBER_CAMP) : -1;

        return new TimberCamp(isConstructed, level);
    }
}
