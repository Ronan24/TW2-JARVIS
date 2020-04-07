package model.building;

/*
  Created by ronan
  on 05/04/2020.
 */
public class Farm extends Building {
    public Farm(boolean isConstruct, int level) {
        super(BuildingName.FARM, isConstruct, level);
        this.buildingStaticInfoList.add(new BuildingStaticInfo(40, 50, 30, 0, 60, 	5, 5));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(50, 70, 40, 0, 90, 	6, 6));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(70, 90, 50, 0, 120, 	6, 7));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(90, 110, 70, 0, 300, 	7, 9));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(120, 150, 90, 0, 450, 	7, 10));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(150, 190, 120, 0, 600, 	8, 12));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(200, 250, 150, 0, 1800, 	9, 15));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(260, 330, 200, 0, 2400, 	10, 18));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(350, 430, 260, 0, 3000, 	11, 21));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(500, 600, 300, 0, 3600, 	12, 26));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(600, 700, 400, 0, 4500, 	13, 31));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(800, 1000, 600, 0, 5400, 	14, 37));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1000, 1300, 800, 0, 6300, 	16, 45));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1300, 1700, 1000, 0, 7200, 	17, 53));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(1800, 2200, 1300, 0, 9000, 	19, 64));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(2300, 2900, 1700, 0, 10800, 	21, 77));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3000, 3800, 2300, 0, 12600, 	23, 92));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(3900, 4900, 3000, 0, 14400, 	25, 111));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(5200, 6500, 3900, 0, 20000, 	28, 133));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(6800, 8500, 5100, 0, 23600, 	31, 160));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(8900, 11100, 6600, 0, 27200, 	34, 192));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(12000, 15000, 9000, 0, 8*3600, 	37, 230));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(15000, 19000, 11000, 0, 10*3600, 	41, 276));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(20000, 25000, 15000, 0, 12*3600, 	45, 331));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(26000, 33000, 20000, 0, 14*3600, 	49, 397));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(34000, 43000, 26000, 0, 16*3600, 	54, 477));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(45000, 56000, 34000, 0, 18*3600, 	60, 572));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(59000, 73000, 44000, 0, 22*3600, 	66, 687));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(77000, 96000, 58000, 0, 26*3600, 	72, 824));
        this.buildingStaticInfoList.add(new BuildingStaticInfo(101000, 126000, 76000, 0, 30*3600, 	79, 989));

    }
}
