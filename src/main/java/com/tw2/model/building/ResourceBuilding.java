package com.tw2.model.building;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public abstract class ResourceBuilding extends Building {
    private List<Integer> productionPerHourList;

    public ResourceBuilding(BuildingName buildingName, boolean isConstruct, int level) {
        super(buildingName, isConstruct, level);
        this.productionPerHourList = new ArrayList<>();

        this.productionPerHourList.add(120);
        this.productionPerHourList.add(132);
        this.productionPerHourList.add(146);
        this.productionPerHourList.add(162);
        this.productionPerHourList.add(180);
        this.productionPerHourList.add(200);
        this.productionPerHourList.add(222);
        this.productionPerHourList.add(248);
        this.productionPerHourList.add(276);
        this.productionPerHourList.add(308);
        this.productionPerHourList.add(343);
        this.productionPerHourList.add(383);
        this.productionPerHourList.add(429);
        this.productionPerHourList.add(480);
        this.productionPerHourList.add(536);
        this.productionPerHourList.add(600);
        this.productionPerHourList.add(673);
        this.productionPerHourList.add(756);
        this.productionPerHourList.add(846);
        this.productionPerHourList.add(948);
        this.productionPerHourList.add(1064);
        this.productionPerHourList.add(1194);
        this.productionPerHourList.add(1340);
        this.productionPerHourList.add(1504);
        this.productionPerHourList.add(1690);
        this.productionPerHourList.add(1897);
        this.productionPerHourList.add(2130);
        this.productionPerHourList.add(2392);
        this.productionPerHourList.add(2688);
        this.productionPerHourList.add(3020);
    }

    public int getProductionPerHour() {
        return this.productionPerHourList.get(getLevel() - 1);
    }
}
