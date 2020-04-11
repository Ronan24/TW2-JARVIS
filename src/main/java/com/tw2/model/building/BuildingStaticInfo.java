package com.tw2.model.building;

import com.tw2.model.ResourceType;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class BuildingStaticInfo {
    private Map<ResourceType, Integer> resourceMap;
    private final int duration;
    private final int hitPoints;
    private final int points;

    public BuildingStaticInfo(int woodCost, int clayCost, int ironCost, int provisionCost, int duration, int hitPoints, int points) {
        this.resourceMap = new EnumMap<>(ResourceType.class);
        this.resourceMap.put(ResourceType.WOOD, woodCost);
        this.resourceMap.put(ResourceType.CLAY, clayCost);
        this.resourceMap.put(ResourceType.IRON, ironCost);
        this.resourceMap.put(ResourceType.PROVISION, provisionCost);
        this.duration = duration;
        this.hitPoints = hitPoints;
        this.points = points;
    }

    public int getResourceCost(ResourceType resourceType) {
        return this.resourceMap.get(resourceType);
    }

    public int getDuration() {
        return duration;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getPoints() {
        return points;
    }
}
