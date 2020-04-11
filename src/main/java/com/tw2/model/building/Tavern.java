package com.tw2.model.building;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Tavern extends Building {
    public Tavern(boolean isConstruct, int level) {
        super(BuildingName.TAVERN, isConstruct, level);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(150, 100, 110, 2, 300, 3, 15));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 130, 140, 3, 600, 3, 18));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(250, 170, 180, 3, 1200, 4, 22));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(330, 230, 230, 4, 2400, 4, 26));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(430, 300, 300, 6, 3600, 4, 31));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(560, 400, 380, 7, 6000, 5, 37));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(720, 530, 480, 9, 8400, 5, 45));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(940, 700, 620, 11, 7*1800, 6, 54));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1200, 900, 790, 15, 5*3600, 6, 64));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1600, 1200, 1000, 18, 7*3600, 7, 77));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2100, 1600, 1300, 23, 9*3600, 8, 93));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2700, 2100, 1700, 30, 11*3600, 9, 111));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3500, 2800, 2100, 37, 14*3600, 9, 134));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4500, 3700, 2700, 48, 18*3600, 10, 160));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5900, 4900, 3500, 60, 24*3600, 11, 193));

    }
}
