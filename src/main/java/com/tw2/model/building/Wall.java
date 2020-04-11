package com.tw2.model.building;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Wall extends Building {
    public Wall(boolean isConstruct, int level) {
        super(BuildingName.WALL, isConstruct, level);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(50, 100, 20, 1, 150, 3, 8));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(60, 130, 30, 1, 300, 3, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(80, 160, 30, 1, 900, 4, 12));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 210, 40, 1, 1800, 4, 14));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(130, 260, 50, 1, 2700, 4, 17));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(160, 340, 60, 2, 4800, 5, 20));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 430, 80, 2, 7200, 5, 24));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(250, 550, 100, 2, 10800, 6, 29));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(320, 700, 130, 3, 14400, 6, 34));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(400, 890, 160, 3, 5*3600, 7, 41));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(500, 1100, 200, 5, 6*3600, 8, 50));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(640, 1400, 250, 1, 7*3600, 9, 59));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(800, 1800, 320, 1, 9*3600, 9, 71));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 2400, 400, 1, 12*3600, 10, 86));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1300, 3000, 510, 1, 14*3600, 11, 103));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1600, 3800, 640, 2, 18*3600, 13, 123));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 4900, 810, 2, 22*3600, 14, 148));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2500, 6200, 1000, 2, 26*3600, 15, 177));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3200, 7900, 1300, 3, 31*3600, 17, 213));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4000, 10100, 1600, 3, 36*3600, 18, 256));

    }
}
