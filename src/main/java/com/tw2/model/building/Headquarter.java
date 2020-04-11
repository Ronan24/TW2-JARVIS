package com.tw2.model.building;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Headquarter extends Building {
    public Headquarter(boolean isConstruct, int level) {
        super(BuildingName.HEADQUARTER, isConstruct, level);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(0, 0, 0, 1, 30, 	3, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(700, 750, 650, 1, 120, 	3, 12));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 1300, 900, 1, 180, 	4, 14));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1400, 1500, 1300, 1, 300, 	4, 17));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1900, 2000, 1800, 1, 420, 	4, 21));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2300, 2500, 2100, 2, 540, 	5, 25));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2800, 3000, 2600, 2, 720, 	5, 30));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3800, 4000, 3600, 2, 900, 	6, 36));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4800, 5000, 4600, 3, 1080, 	6, 43));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5600, 6000, 5200, 3, 1260, 	7, 52));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(7600, 8000, 7200, 3, 1500, 	8, 62));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(9000, 10000, 8000, 4, 1800, 	9, 74));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(14000, 15000, 13000, 5, 2100, 	9, 89));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(19000, 20000, 18000, 5, 2700, 	10, 107));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(23000, 25000, 20000, 7, 3600, 	11, 128));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(27000, 30000, 22000, 8, 5400, 	13, 154));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(31000, 35000, 24000, 9, 7200, 	14, 185));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(35000, 40000, 26000, 10, 3*3600, 	15, 222));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(38000, 45000, 28000, 12, 4*3600, 	17, 266));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(40000, 50000, 30000, 15, 5*3600, 	18, 319));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(42000, 55000, 32000, 17, 6*3600, 	20, 383));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(44000, 60000, 34000, 19, 7*3600, 	22, 460));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(46000, 65000, 36000, 23, 8*3600, 	24, 552));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(48000, 70000, 38000, 27, 9*3600, 	27, 662));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(50000, 75000, 40000, 31, 10*3600, 	30, 795));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(53000, 80000, 42000, 37, 11*3600, 	33, 954));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(56000, 85000, 44000, 43, 12*3600, 	36, 1145));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(59000, 90000, 46000, 51, 13*3600, 	39, 1374));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(62000, 95000, 48000, 59, 14*3600, 	43, 1648));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(65000, 100000, 50000, 69, 15*3600, 	48, 1978));

    }
}
