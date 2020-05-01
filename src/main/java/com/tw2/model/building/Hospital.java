package com.tw2.model.building;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Hospital extends Building {
    public Hospital(boolean isConstruct, int level, int levelUpGoing) {
        super(BuildingName.HOSPITAL, isConstruct, level, levelUpGoing);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(50, 80, 30, 2, 180, 3, 15));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 160, 60, 3, 300, 3, 18));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 320, 120, 3, 600, 4, 22));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(400, 640, 240, 4, 900, 4, 26));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 1600, 600, 5, 1800, 4, 31));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 3200, 1200, 7, 3600, 5, 37));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4000, 6400, 2400, 8, 2*3600, 5, 45));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(8000, 12000, 4800, 11, 4*3600, 6, 54));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(16000, 24000, 9600, 14, 12*3600, 6, 64));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(32000, 48000, 19200, 17, 24*3600, 7, 77));

    }
}
