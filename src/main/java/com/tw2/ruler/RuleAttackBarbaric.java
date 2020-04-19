package com.tw2.ruler;

import com.tw2.model.unit.Army;
import com.tw2.model.unit.UnitStaticInfo;
import com.tw2.model.Village;

import java.awt.*;
import java.util.*;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class RuleAttackBarbaric {
    private Queue<Point> myBarbaricVillages;

    private final int NUMBER_SPEAR_MEN = 30;

    public RuleAttackBarbaric() {
        this.myBarbaricVillages = new LinkedList<>();

//        this.myBarbaricVillages.add(new Point(449,520));
        this.myBarbaricVillages.add(new Point(449,519));
        this.myBarbaricVillages.add(new Point(456,519));
        this.myBarbaricVillages.add(new Point(467,510));
        this.myBarbaricVillages.add(new Point(465,510));
        this.myBarbaricVillages.add(new Point(458,517));
        this.myBarbaricVillages.add(new Point(467,523));
        this.myBarbaricVillages.add(new Point(462,513));
        this.myBarbaricVillages.add(new Point(455,513));
        this.myBarbaricVillages.add(new Point(464,516));
        this.myBarbaricVillages.add(new Point(465,517));
        this.myBarbaricVillages.add(new Point(458,513));
        this.myBarbaricVillages.add(new Point(461,518));
        this.myBarbaricVillages.add(new Point(463,521));
        this.myBarbaricVillages.add(new Point(461,520));
        this.myBarbaricVillages.add(new Point(460,508));
        this.myBarbaricVillages.add(new Point(455,518));
//        this.myBarbaricVillages.add(new Point(460,518));
        this.myBarbaricVillages.add(new Point(463,523));
        this.myBarbaricVillages.add(new Point(466,531));
        this.myBarbaricVillages.add(new Point(462,527));
        this.myBarbaricVillages.add(new Point(453,516));
        this.myBarbaricVillages.add(new Point(456,515));
        this.myBarbaricVillages.add(new Point(456,513));
        this.myBarbaricVillages.add(new Point(457,533));
        this.myBarbaricVillages.add(new Point(462,526));
        this.myBarbaricVillages.add(new Point(454,529));
        this.myBarbaricVillages.add(new Point(462,531));
        this.myBarbaricVillages.add(new Point(456,527));
        this.myBarbaricVillages.add(new Point(454,525));
        this.myBarbaricVillages.add(new Point(450,512));
        this.myBarbaricVillages.add(new Point(439,507));
        this.myBarbaricVillages.add(new Point(452,528));
        this.myBarbaricVillages.add(new Point(445,511));
        this.myBarbaricVillages.add(new Point(450,511));
        this.myBarbaricVillages.add(new Point(445,520));
        this.myBarbaricVillages.add(new Point(449,524));
        this.myBarbaricVillages.add(new Point(458,518));
        this.myBarbaricVillages.add(new Point(445,521));
        this.myBarbaricVillages.add(new Point(448,521));
        this.myBarbaricVillages.add(new Point(453,532));
        this.myBarbaricVillages.add(new Point(461,524));
        this.myBarbaricVillages.add(new Point(460,527));
        this.myBarbaricVillages.add(new Point(456,526));
        this.myBarbaricVillages.add(new Point(461,538));
        this.myBarbaricVillages.add(new Point(451,514));
        this.myBarbaricVillages.add(new Point(443,522));
        this.myBarbaricVillages.add(new Point(452,520));
        this.myBarbaricVillages.add(new Point(439,508));
        this.myBarbaricVillages.add(new Point(451,523));
        this.myBarbaricVillages.add(new Point(445,515));
        this.myBarbaricVillages.add(new Point(448,525));
        this.myBarbaricVillages.add(new Point(451,515));
        this.myBarbaricVillages.add(new Point(458,523));
        this.myBarbaricVillages.add(new Point(443,527));
        this.myBarbaricVillages.add(new Point(453,529));
        this.myBarbaricVillages.add(new Point(463,538));
        this.myBarbaricVillages.add(new Point(442,511));
        this.myBarbaricVillages.add(new Point(446,508));
        this.myBarbaricVillages.add(new Point(440,518));
        this.myBarbaricVillages.add(new Point(452,531));
        this.myBarbaricVillages.add(new Point(456,538));
        this.myBarbaricVillages.add(new Point(440,524));
        this.myBarbaricVillages.add(new Point(436,518));
        this.myBarbaricVillages.add(new Point(440,516));
        this.myBarbaricVillages.add(new Point(443,536));
        this.myBarbaricVillages.add(new Point(442,525));
        this.myBarbaricVillages.add(new Point(440,527));
        this.myBarbaricVillages.add(new Point(447,529));
        this.myBarbaricVillages.add(new Point(442,529));
        this.myBarbaricVillages.add(new Point(452,519));
        this.myBarbaricVillages.add(new Point(440,537));
        this.myBarbaricVillages.add(new Point(439,528));
        this.myBarbaricVillages.add(new Point(442,521));
        this.myBarbaricVillages.add(new Point(449,531));
        this.myBarbaricVillages.add(new Point(436,522));
        this.myBarbaricVillages.add(new Point(439,521));

    }

    public Map<Point, Army> findBestBarbaricVillageToAttack(Village village) {
        Map<Point, Army> map = new HashMap<>();

        int numberOfSpearMen = village.getUnitNumberByUnit(UnitStaticInfo.SPEARMAN);
        boolean paladinIsPresent = village.getUnitNumberByUnit(UnitStaticInfo.PALADIN) == 1;

        while (numberOfSpearMen >= NUMBER_SPEAR_MEN){
            Army army = new Army();

            Point next;

            do {
                next = this.myBarbaricVillages.poll();
                this.myBarbaricVillages.add(next);
            } while (next.distance(village.getLocalisation()) > 10);

            army.addUnit(UnitStaticInfo.SPEARMAN, NUMBER_SPEAR_MEN);
            if (paladinIsPresent){
                army.addUnit(UnitStaticInfo.PALADIN, 1);
                paladinIsPresent = false;
            }

            map.put(next, army);

            numberOfSpearMen -= NUMBER_SPEAR_MEN;
        }


        return map;
    }
}
