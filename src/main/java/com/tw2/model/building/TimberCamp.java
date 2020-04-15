package com.tw2.model.building;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class TimberCamp extends ResourceBuilding {
    public TimberCamp(boolean isConstruct, int level, int levelUpGoing) {
        super(BuildingName.TIMBER_CAMP, isConstruct, level, levelUpGoing);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(40, 50, 30, 1, 30, 3, 6));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(50, 60, 40, 1, 60, 3, 7));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(60, 80, 50, 1, 90, 4, 9));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(80, 100, 60, 1, 120, 4, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 120, 70, 1, 150, 4, 12));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 200, 100, 1, 210, 5, 15));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 200, 100, 2, 300, 5, 18));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 200, 100, 2, 600, 6, 21));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 300, 200, 2, 1200, 6, 26));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(300, 400, 200, 2, 1800, 7, 31));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(400, 500, 300, 3, 2400, 8, 37));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(500, 600, 300, 3, 3000, 9, 45));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(600, 700, 400, 4, 3600, 9, 53));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(700, 900, 500, 5, 4500, 1, 64));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(900, 1000, 700, 5, 5400, 1, 77));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 1000, 800, 5, 6300, 1, 92));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 2000, 1000, 7, 7200, 1, 111));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 2000, 1000, 8, 9000, 1, 133));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 3000, 2000, 9, 10800, 1, 160));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3000, 3000, 2000, 10, 14400, 1, 192));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3000, 4000, 2000, 12, 5 * 3600, 2, 230));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4000, 5000, 3000, 14, 6 * 3600, 2, 276));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5000, 6000, 4000, 16, 7 * 3600, 2, 331));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(6000, 8000, 5000, 19, 8 * 3600, 2, 397));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(8000, 10000, 6000, 21, 9 * 3600, 3, 477));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(10000, 12000, 7000, 24, 10 * 3600, 3, 572));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(12000, 16000, 9000, 29, 12 * 3600, 3, 687));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(16000, 19000, 12000, 33, 14 * 3600, 3, 824));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(19000, 24000, 15000, 38, 16 * 3600, 4, 989));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(24000, 30000, 18000, 43, 18 * 3600, 4, 1187));
    }
}
