package model.building;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class TavernFactory extends BuildingFactory {
    public TavernFactory() {
        super();
    }

    @Override
    public Building buildBuilding() {
        boolean isConstructed = super.getIsConstructedByBuildingName(BuildingName.TAVERN);
        int level = isConstructed ? getLevelBuildingByBuilding(BuildingName.TAVERN) : -1;

        return new Tavern(isConstructed, level);
    }
}
