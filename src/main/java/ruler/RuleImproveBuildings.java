package ruler;

import model.Village;
import model.building.Building;
import model.building.BuildingName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class RuleImproveBuildings {
    public static Optional<BuildingName> findBestImprove(Village village) {
        if (village.getConstructionQueueSize() >= 2) {
            return Optional.empty();
        }

        Collection<Building> buildings = new ArrayList<>();

        Collection<Building> finalBuildings = buildings;
        Stream.of(BuildingName.values()).forEach(buildingName -> finalBuildings.add(village.getBuildingByBuildingName(buildingName)));

        buildings = finalBuildings.stream()
                .filter(Building::isConstruct)
                .filter(building -> village.improveIsValid(building.getBuildingName()))
                .collect(Collectors.toList());

        Optional<Building> buildingOptional = buildings.stream()
                .min(Comparator.comparingInt(value -> value.getDuration(value.getLevel())));

        return buildingOptional.map(Building::getBuildingName);
    }
}
