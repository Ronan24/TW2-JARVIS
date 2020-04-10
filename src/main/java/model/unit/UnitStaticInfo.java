package model.unit;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public enum UnitStaticInfo {
    SPEARMAN(1, 50, 30, 20, 1, 10, 25, 45, 10, 25, 840, 90),
    SWORDSMAN(2, 30, 30, 70, 1, 25, 55, 5, 30, 15, 1080, 120),
    AXE_FIGHTER(3, 60, 30, 40, 1, 45, 10, 5, 10, 20, 840, 150),
    ARCHER(4, 80, 30, 60, 1, 25, 10, 30, 60, 10, 840, 180),
    LIGHT_CAVALRY(5, 125, 100, 250, 4, 130, 30, 40, 30, 50, 480, 360),
    MOUNTED_ARCHER(6, 250, 200, 100, 5, 150, 40, 30, 50, 50, 480, 450),
    HEAVY_CAVALRY(7, 200, 150, 600, 6, 150, 200, 160, 180, 50, 540, 600),
    RAM(8, 300, 200, 200, 5, 2, 20, 50, 20, 0, 1440, 480),
    CATAPULT(9, 320, 400, 100, 8, 100, 100, 50, 100, 0, 1440, 450),
    BERSERKER(10, 1200, 1200, 2400, 6, 300, 100, 100, 50, 10, 840, 1200),
    TREBUCHET(11, 4000, 2000, 2000, 10, 30, 200, 250, 200, 0, 3000, 1200),
    NOBLEMAN(12, 40000, 50000, 50000, 100, 30, 100, 50, 100, 0, 2100, 10800),
    PALADIN(13, 0, 0, 0, 1, 150, 250, 400, 150, 100, 480, 21600);

    private int index;
    private int woodCost;
    private int clayCost;
    private int ironCost;
    private int provisionsCost;
    private int attack;
    private int defense;
    private int cavalryDefense;
    private int archerDefense;
    private int capacity;
    private int speed;
    private int recruitTime;

    UnitStaticInfo(int index, int woodCost, int clayCost, int ironCost, int provisionsCost, int attack, int defense, int cavalryDefense, int archerDefense, int capacity, int speed, int recruitTime) {
        this.index = index;
        this.woodCost = woodCost;
        this.clayCost = clayCost;
        this.ironCost = ironCost;
        this.provisionsCost = provisionsCost;
        this.attack = attack;
        this.defense = defense;
        this.cavalryDefense = cavalryDefense;
        this.archerDefense = archerDefense;
        this.capacity = capacity;
        this.speed = speed;
        this.recruitTime = recruitTime;
    }

    public int getIndex() {
        return index;
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

    public int getProvisionsCost() {
        return provisionsCost;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getCavalryDefense() {
        return cavalryDefense;
    }

    public int getArcherDefense() {
        return archerDefense;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRecruitTime() {
        return recruitTime;
    }
}
