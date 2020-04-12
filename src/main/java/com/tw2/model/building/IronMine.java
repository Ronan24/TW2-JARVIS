package com.tw2.model.building;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class IronMine extends ResourceBuilding {
    public IronMine(boolean isConstruct, int level) {
        super(BuildingName.IRON_MINE, isConstruct, level);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(60, 50, 60, 1, 30, 3, 6));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(70, 60, 70, 2, 60, 3, 7));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(90, 80, 90, 2, 90, 4, 9));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 100, 100, 2, 120, 4, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 100, 100, 3, 150, 4, 12));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 200, 200, 3, 210, 5, 15));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 200, 200, 4, 300, 5, 18));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(300, 200, 300, 4, 600, 6, 21));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(400, 300, 400, 5, 1200, 6, 26));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(400, 400, 400, 6, 1800, 7, 31));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(500, 500, 500, 7, 2400, 8, 37));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(700, 600, 700, 8, 3000, 9, 45));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(800, 700, 800, 10, 3600, 9, 53));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 900, 1000, 11, 4500, 10, 64));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 1000, 1000, 13, 5400, 11, 77));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 1000, 2000, 15, 6300, 13, 92));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 2000, 2000, 18, 7200, 14, 111));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3000, 2000, 3000, 21, 9000, 15, 133));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3000, 3000, 3000, 25, 10800, 17, 160));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4000, 3000, 4000, 28, 14400, 18, 192));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5000, 4000, 5000, 34, 5 * 3600, 20, 230));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(6000, 5000, 6000, 39, 6 * 3600, 22, 276));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(8000, 6000, 8000, 46, 7 * 3600, 24, 331));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(10000, 8000, 10000, 54, 8 * 3600, 27, 397));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(12000, 10000, 12000, 63, 9 * 3600, 30, 477));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(15000, 12000, 15000, 74, 10 * 3600, 33, 572));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(19000, 16000, 19000, 86, 12 * 3600, 36, 687));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(23000, 19000, 23000, 100, 14 * 3600, 39, 824));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(29000, 24000, 29000, 118, 16 * 3600, 43, 989));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(36000, 30000, 36000, 138, 18 * 3600, 48, 1187));
    }
}
