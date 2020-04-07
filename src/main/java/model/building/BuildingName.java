package model.building;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public enum BuildingName {
    HEADQUARTER("headquarter", new HeadquarterFactory()),
    CLAY_PIT("clay_pit", new ClayPitFactory()),
    IRON_MINE("iron_mine", new IronMineFactory()),
    FARM("farm", new FarmFactory()),
    WAREHOUSE("warehouse", new WarehouseFactory()),
//    CHAPEL("chapel", new TimberCampFactory()),
//    RALLY_POINT("rally_point", new TimberCampFactory()),
    BARRACKS("barracks", new BarracksFactory()),
//    STATUE("statue", new TimberCampFactory()),
    WALL("wall", new WallFactory()),
    HOSPITAL("hospital", new HospitalFactory()),
    MARKET("market", new MarketFactory()),
//    TAVERN("tavern", new TimberCampFactory()),
//    ACADEMY("academy", new TimberCampFactory()),
//    HALL_OF_ORDERS("hall_of_orders", new TimberCampFactory()),
    TIMBER_CAMP("timber_camp", new TimberCampFactory());

    private String labelIdFromMap;
    private BuildingFactory buildingFactory;

    BuildingName(String labelIdFromMap, BuildingFactory buildingFactory) {
        this.labelIdFromMap = labelIdFromMap;
        this.buildingFactory = buildingFactory;
    }

    public String getLabelIdFromMap() {
        return labelIdFromMap;
    }

    public BuildingFactory getBuildingFactory() {
        return buildingFactory;
    }
}
