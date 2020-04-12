package com.tw2.model.building;

import java.util.ArrayList;
import java.util.List;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Market extends Building {

    private List<Integer> numberTraders;

    public Market(boolean isConstruct, int level) {
        super(BuildingName.MARKET, isConstruct, level);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(100, 100, 100, 20, 300, 3, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(130, 130, 130, 3, 900, 3, 12));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(160, 160, 160, 4, 1500, 4, 14));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 210, 200, 5, 2100, 4, 17));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(250, 260, 250, 5, 3000, 4, 21));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(320, 340, 320, 7, 4200, 5, 25));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(400, 430, 400, 7, 5400, 5, 30));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(500, 550, 500, 9, 6600, 6, 36));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(640, 700, 640, 10, 7800, 6, 43));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(800, 890, 800, 12, 9000, 7, 52));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 1100, 1000, 14, 3*3600, 8, 62));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1300, 1400, 1300, 16, 12600, 9, 74));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1600, 1800, 1600, 20, 4*3600, 9, 89));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2000, 2400, 2000, 22, 9*1800, 10, 107));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2500, 3000, 2500, 26, 5*3600, 11, 128));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3200, 3800, 3200, 31, 350*60, 13, 154));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(4000, 4900, 4000, 36, 400*60, 14, 185));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5100, 6200, 5100, 42, 8*3600, 15, 222));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(6400, 7900, 6400, 49, 19*1800, 17, 266));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(8100, 10100, 8100, 57, 11*3600, 18, 319));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(10200, 12900, 10200, 67, 25*1800, 20, 383));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(12800, 16400, 12800, 79, 15*3600, 22, 460));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(16100, 21000, 16100, 92, 37*1800, 24, 552));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(20300, 26700, 20300, 107, 45*1800, 27, 662));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(25600, 34100, 25600, 126, 28*3600, 30, 795));

        this.numberTraders = new ArrayList<>();

        this.numberTraders.add(1);
        this.numberTraders.add(2);
        this.numberTraders.add(3);
        this.numberTraders.add(4);
        this.numberTraders.add(5);
        this.numberTraders.add(6);
        this.numberTraders.add(7);
        this.numberTraders.add(8);
        this.numberTraders.add(9);
        this.numberTraders.add(10);
        this.numberTraders.add(11);
        this.numberTraders.add(14);
        this.numberTraders.add(19);
        this.numberTraders.add(26);
        this.numberTraders.add(35);
        this.numberTraders.add(46);
        this.numberTraders.add(59);
        this.numberTraders.add(74);
        this.numberTraders.add(91);
        this.numberTraders.add(110);
        this.numberTraders.add(131);
        this.numberTraders.add(154);
        this.numberTraders.add(179);
        this.numberTraders.add(206);
        this.numberTraders.add(235);

    }

    public int getNumberTraders() {
        return this.numberTraders.get(getLevel() - 1);
    }
}
