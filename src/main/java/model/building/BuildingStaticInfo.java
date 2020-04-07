package model.building;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class BuildingStaticInfo {
    private final int woodCost;
    private final int clayCost;
    private final int ironCost;
    private final int provisionCost;
    private final int duration;
    private final int hitPoints;
    private final int points;

    public BuildingStaticInfo(int woodCost, int clayCost, int ironCost, int provisionCost, int duration, int hitPoints, int points) {
        this.woodCost = woodCost;
        this.clayCost = clayCost;
        this.ironCost = ironCost;
        this.provisionCost = provisionCost;
        this.duration = duration;
        this.hitPoints = hitPoints;
        this.points = points;
    }

    public int getWoodCost() {
        return woodCost;
    }

    public int getClayCost() {
        return clayCost;
    }

    public int getIronCost() {
        return ironCost;
    }

    public int getProvisionCost() {
        return provisionCost;
    }

    public int getDuration() {
        return duration;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getPoints() {
        return points;
    }
}
