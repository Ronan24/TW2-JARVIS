package com.tw2.model.building;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Statue extends Building {
    public Statue(boolean isConstruct, int level, int levelUpGoing) {
        super(BuildingName.STATUE, isConstruct, level, levelUpGoing);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 100, 200, 0, 120, 3, 6));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(500, 500, 1000, 0, 600, 3, 7));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 2000, 4000, 0, 3600, 4, 9));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5000, 5000, 10000, 0, 4*3600, 4, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(10000, 10000, 20000, 0, 8*3600, 4, 12));

    }
}
