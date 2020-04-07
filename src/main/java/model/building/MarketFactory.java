package model.building;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class MarketFactory extends BuildingFactory {
    public MarketFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.MARKET);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.MARKET) : -1;

        return new Market(isConstructed, level);
    }
}
