package com.tw2.model.building;

import java.util.ArrayList;
import java.util.List;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Warehouse extends Building {

    private List<Integer> maxCapacity;

    public Warehouse(boolean isConstruct, int level) {
        super(BuildingName.WAREHOUSE, isConstruct, level);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 190, 170, 0, 30, 	3, 6));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(240, 230, 210, 0, 60, 	3, 7));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(290, 280, 250, 0, 90, 	4, 9));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(350, 340, 300, 0, 120, 	4, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(430, 410, 360, 0, 150, 	4, 12));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(520, 490, 440, 0, 240, 	5, 15));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(630, 600, 530, 0, 360, 	5, 18));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(760, 720, 650, 0, 600, 	6, 21));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(920, 870, 780, 0, 1200, 	6, 26));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1100, 1100, 900, 0, 2400, 	7, 31));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1300, 1300, 1100, 0, 3600, 	8, 37));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1600, 1500, 1400, 0, 5400, 	9, 45));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 1900, 1700, 0, 7200, 	9, 53));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2400, 2300, 2000, 0, 9000, 	10, 64));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2900, 2700, 2500, 0, 10800, 	11, 77));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3500, 3300, 3000, 0, 12600, 	13, 92));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4200, 4000, 3600, 0, 4*3600, 	14, 111));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5100, 4900, 4300, 0, 5*3600, 	15, 133));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(6200, 5900, 5300, 0, 6*3600, 	17, 160));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(7500, 7100, 6400, 0, 7*3600, 	18, 192));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(9100, 8600, 7700, 0, 8*3600, 	20, 230));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(11000, 10000, 9000, 0, 10*3600, 	22, 276));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(13000, 13000, 11000, 0, 12*3600, 	24, 331));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(16000, 15000, 14000, 0, 14*3600, 	27, 397));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(19000, 18000, 16000, 0, 16*3600, 	30, 477));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(23000, 22000, 20000, 0, 18*3600, 	33, 572));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(28000, 27000, 24000, 0, 20*3600, 	36, 687));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(34000, 33000, 29000, 0, 22*3600, 	39, 824));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(42000, 40000, 35000, 0, 26*3600, 	43, 989));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(50000, 48000, 43000, 0, 30*3600, 	48, 1187));

        this.maxCapacity = new ArrayList<>();

        this.maxCapacity.add(1000);
        this.maxCapacity.add(1229);
        this.maxCapacity.add(1512);
        this.maxCapacity.add(1859);
        this.maxCapacity.add(2285);
        this.maxCapacity.add(2810);
        this.maxCapacity.add(3454);
        this.maxCapacity.add(4247);
        this.maxCapacity.add(5222);
        this.maxCapacity.add(6420);
        this.maxCapacity.add(7893);
        this.maxCapacity.add(9705);
        this.maxCapacity.add(11932);
        this.maxCapacity.add(14670);
        this.maxCapacity.add(18037);
        this.maxCapacity.add(22177);
        this.maxCapacity.add(27266);
        this.maxCapacity.add(33523);
        this.maxCapacity.add(41217);
        this.maxCapacity.add(50675);
        this.maxCapacity.add(62305);
        this.maxCapacity.add(76604);
        this.maxCapacity.add(94184);
        this.maxCapacity.add(115798);
        this.maxCapacity.add(142373);
        this.maxCapacity.add(175047);
        this.maxCapacity.add(215219);
        this.maxCapacity.add(264610);
        this.maxCapacity.add(325337);
        this.maxCapacity.add(400000);
        
    }

    public int getMaxCapacity() {
        return this.maxCapacity.get(getLevel() - 1);
    }
}
