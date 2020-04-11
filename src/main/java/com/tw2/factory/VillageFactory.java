package com.tw2.factory;

import com.tw2.controller.VillageController;
import com.tw2.model.ResourceType;
import com.tw2.model.Village;
import com.tw2.model.building.Building;
import com.tw2.model.building.BuildingName;
import com.tw2.model.unit.Army;
import com.tw2.model.unit.UnitStaticInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class VillageFactory {
    private VillageController villageController;

    private static final Logger LOGGER = LoggerFactory.getLogger(VillageFactory.class);

    public VillageFactory() {
        this.villageController = VillageController.getInstance();
    }

    public Village buildVillage(Point villageLocation, String villageName) {
        Village village = new Village(villageLocation, villageName);
        this.update(village);

        LOGGER.info("Village {} created", village.getVillageName());

        return village;
    }

    public void update(Village village) {
        Map<BuildingName, Building> villageBuildings = new EnumMap<>(BuildingName.class);
        Map<ResourceType, Integer> resourceMap = new EnumMap<>(ResourceType.class);
        Army army = new Army();

        int constructionQueueSize = this.villageController.getQueueSize();

        for (BuildingName buildingName : BuildingName.values()) {
            villageBuildings.put(buildingName, buildingName.getBuildingFactory().buildBuilding());
        }

        for (ResourceType resourceType : ResourceType.values()) {
            resourceMap.put(resourceType, this.villageController.getResourceByType(resourceType));
        }

        for (UnitStaticInfo unitStaticInfo : UnitStaticInfo.values()) {
            army.addUnit(unitStaticInfo, this.villageController.getAmountUnits(unitStaticInfo));
        }

        village.update(villageBuildings, resourceMap, army, constructionQueueSize);
    }
}
