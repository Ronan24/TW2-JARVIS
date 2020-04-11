package com.tw2.model.unit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ronan
 * on 07/04/2020.
 */
public class Army {
    private Map<UnitStaticInfo, Integer> unitMap;

    public Army() {
        this.unitMap = new HashMap<>();
    }

    public void addUnit(UnitStaticInfo unitStaticInfo, int numberOfUnits) {
        this.unitMap.put(unitStaticInfo, numberOfUnits);
    }

    public Integer getUnitNumberByUnit(UnitStaticInfo unit) {
        return unitMap.get(unit) == null ? 0 : unitMap.get(unit);
    }
}
