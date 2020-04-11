package factory.building;

import model.building.Building;
import model.building.BuildingName;
import model.building.Hospital;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class HospitalFactory extends BuildingFactory {
    public HospitalFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.HOSPITAL);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.HOSPITAL) : -1;

        return new Hospital(isConstructed, level);
    }
}
