package com.tw2.model.building;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class ClayPit extends ResourceBuilding {
    public ClayPit(boolean isConstruct, int level, int levelUpGoing) {
        super(BuildingName.CLAY_PIT, isConstruct, level, levelUpGoing);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(50, 40, 30, 1, 30, 	3, 6));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(60, 50, 40, 1, 60, 	3, 7));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(80, 60, 50, 2, 90, 	4, 9));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 80, 60, 2, 120, 	4, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 100, 70, 2, 150, 	4, 12));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 100, 90, 2, 210, 	5, 15));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 200, 100, 3, 300, 	5, 18));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 200, 100, 3, 600, 	6, 21));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(300, 200, 200, 4, 1200, 	6, 26));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(400, 300, 200, 4, 1800, 	7, 31));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(500, 400, 300, 4, 2400, 	8, 37));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(600, 500, 300, 5, 3000, 	9, 45));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(700, 600, 400, 6, 3600, 	9, 53));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(900, 700, 500, 7, 4500, 	10, 64));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 900, 700, 8, 5400, 	11, 77));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 1000, 800, 8, 6300, 	13, 92));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 1000, 1000, 10, 7200, 	14, 111));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 2000, 1000, 12, 9000, 	15, 133));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3000, 2000, 2000, 13, 10800, 	17, 160));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3000, 3000, 2000, 15, 14400, 	18, 192));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4000, 3000, 2000, 16, 5*3600, 	20, 230));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5000, 4000, 3000, 20, 6*3600, 	22, 276));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(6000, 5000, 4000, 22, 7*3600, 	24, 331));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(8000, 6000, 5000, 25, 8*3600, 	27, 397));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(10000, 8000, 6000, 28, 9*3600, 	30, 477));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(12000, 10000, 7000, 33, 10*3600, 	33, 572));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(16000, 12000, 9000, 37, 12*3600, 	36, 687));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(19000, 16000, 12000, 42, 14*3600, 	39, 824));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(24000, 19000, 15000, 48, 16*3600, 	43, 989));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(30000, 24000, 18000, 55, 18*3600, 	48, 1187));
    }
}
