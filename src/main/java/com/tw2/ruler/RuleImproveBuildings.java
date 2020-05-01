package com.tw2.ruler;

import com.tw2.Main;
import com.tw2.model.Village;
import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(RuleImproveBuildings.class);

    public static Optional<BuildingName> findBestImprove(Village village) {
        if (village.getConstructionQueueSize() >= 2) {
            LOGGER.debug("No space into the construction queue.");
            return Optional.empty();
        }

        Collection<Building> buildings = new ArrayList<>();

        Collection<Building> finalBuildings = buildings;
        Stream.of(BuildingName.values()).forEach(buildingName -> finalBuildings.add(village.getBuildingByBuildingName(buildingName)));

        buildings = finalBuildings.stream()
                .filter(building -> building.getBuildingName() != BuildingName.BARRACKS)
                .filter(building -> building.getBuildingName() != BuildingName.MARKET)
                .filter(building -> village.improveIsValid(building.getBuildingName()))
                .collect(Collectors.toList());

        Optional<Building> buildingOptional = buildings.stream()
                .min(Comparator.comparingInt(value -> value.getDuration(value.getLevel() + value.getLevelUpGoing() + 1)));

        return buildingOptional.map(Building::getBuildingName);
    }
}
