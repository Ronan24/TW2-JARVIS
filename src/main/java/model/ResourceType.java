package model;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public enum ResourceType {
    WOOD(1),
    CLAY(2),
    IRON(3),
    PROVISION(4);

    private int index;

    ResourceType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
