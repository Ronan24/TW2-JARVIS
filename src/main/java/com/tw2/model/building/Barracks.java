package com.tw2.model.building;

import com.tw2.model.unit.UnitStaticInfo;

import java.util.EnumMap;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Barracks extends UnlockBuilding<UnitStaticInfo> {

    public Barracks(boolean isConstruct, int level) {
        super(BuildingName.BARRACKS, isConstruct, level);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(400, 500, 600, 7, 60, 3, 16));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(480, 600, 720, 1, 150, 3, 19));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(580, 720, 860, 2, 240, 4, 23));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(700, 860, 1030, 2, 330, 4, 28));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(840, 1030, 1240, 3, 420, 4, 33));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1800, 2000, 2200, 2, 510, 5, 40));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2200, 2400, 2600, 4, 600, 5, 48));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2600, 2900, 3100, 4, 720, 6, 57));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3100, 3500, 3700, 5, 840, 6, 69));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3700, 4200, 4400, 6, 960, 7, 83));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(6000, 7000, 8000, 7, 1080, 8, 99));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(7200, 8400, 9600, 9, 1200, 9, 119));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(8600, 10100, 11500, 10, 1500, 9, 143));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(10300, 12100, 13800, 13, 1800, 10, 171));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(12400, 14500, 16600, 15, 2700, 11, 205));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(21000, 23000, 25000, 18, 3600, 13, 247));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(22000, 25000, 26000, 21, 2 * 3600, 14, 296));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(23000, 28000, 27000, 26, 3 * 3600, 15, 355));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(24000, 31000, 28000, 31, 4 * 3600, 17, 426));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(25000, 34000, 29000, 38, 5 * 3600, 18, 511));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(26000, 37000, 30000, 44, 6 * 3600, 20, 613));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(27000, 41000, 32000, 54, 7 * 3600, 22, 736));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(28000, 45000, 34000, 64, 8 * 3600, 24, 883));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(29000, 50000, 36000, 78, 9 * 3600, 27, 1060));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(30000, 55000, 38000, 92, 10 * 3600, 30, 1272));

        this.unlockList = new EnumMap<>(UnitStaticInfo.class);
        this.unlockList.put(UnitStaticInfo.SWORDSMAN, 3);
        this.unlockList.put(UnitStaticInfo.AXE_FIGHTER, 5);
        this.unlockList.put(UnitStaticInfo.ARCHER, 9);
        this.unlockList.put(UnitStaticInfo.LIGHT_CAVALRY, 11);
        this.unlockList.put(UnitStaticInfo.MOUNTED_ARCHER, 13);
        this.unlockList.put(UnitStaticInfo.RAM, 15);
        this.unlockList.put(UnitStaticInfo.CATAPULT, 17);
        this.unlockList.put(UnitStaticInfo.HEAVY_CAVALRY, 21);

    }
}
