package com.tw2.ruler;

import com.tw2.model.ResourceType;
import com.tw2.model.Village;
import com.tw2.model.building.BuildingName;
import com.tw2.model.building.Warehouse;
import com.tw2.model.unit.Army;
import com.tw2.model.unit.UnitStaticInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class RuleRecruitUnit {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuleRecruitUnit.class);

    public Optional<Army> findArmyToRecruit(Village village) {
        Army result = new Army();

        Warehouse warehouse = (Warehouse) village.getBuildingByBuildingName(BuildingName.WAREHOUSE);
        double maxCapacity = warehouse.getMaxCapacity();

        boolean shouldWeRecruit = true;

        for (ResourceType resource : ResourceType.values()) {
            shouldWeRecruit = shouldWeRecruit && (resource == ResourceType.PROVISION || (double)(village.getResourceByType(resource))/maxCapacity > 0.75);
            if (resource != ResourceType.PROVISION){
                LOGGER.debug("For the resource {}, we have {}% !", resource, (100*(double)(village.getResourceByType(resource))/maxCapacity));
            }
        }

        shouldWeRecruit = shouldWeRecruit && village.getResourceByType(ResourceType.PROVISION) > 100;
        LOGGER.debug("For the resource PROVISION, we have {} !", village.getResourceByType(ResourceType.PROVISION));

        if (shouldWeRecruit){
            result.addUnit(UnitStaticInfo.SWORDSMAN, 10);
            result.addUnit(UnitStaticInfo.SPEARMAN, 10);
            return Optional.of(result);
        }else {
            LOGGER.debug("Not enough resources to recruit yet...");
            return Optional.empty();
        }

    }
}
