import model.Village;
import model.building.Building;
import model.building.BuildingName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class RuleImproveBuildings {
    public static Optional<BuildingName> findBestImprove(Village village) {
        Collection<Building> buildings = new ArrayList<>();

        buildings.add(village.getBuildingByBuildingName(BuildingName.TIMBER_CAMP));
        buildings.add(village.getBuildingByBuildingName(BuildingName.CLAY_PIT));
        buildings.add(village.getBuildingByBuildingName(BuildingName.IRON_MINE));

        buildings = buildings.stream().filter(building -> village.improveIsValid(building.getBuildingName())).collect(Collectors.toList());

        Optional<Building> buildingOptional = buildings.stream().min(Comparator.comparingInt(Building::getLevel));

        return buildingOptional.map(Building::getBuildingName);
    }
}
