package com.tw2.model.building;

import java.util.Map;

/**
 * Created by ronan
 * on 12/04/2020.
 */
public abstract class UnlockBuilding<E extends Enum> extends Building {

    protected Map<E, Integer> unlockList;

    public UnlockBuilding(BuildingName buildingName, boolean isConstruct, int level) {
        super(buildingName, isConstruct, level);
    }

    public int getLevelToUnlock(E e) {
        Integer value = this.unlockList.get(e);
        return value == null ? 1 : value;
    }

    public boolean isUnlock(E e) {
        return getLevelToUnlock(e) <= this.getLevel();
    }
}
