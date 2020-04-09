import javafx.util.Pair;
import model.Army;
import model.UnitStaticInfo;
import model.Village;

import java.awt.*;
import java.util.*;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class RuleAttackBarbaric {
    private Queue<Point> myBarbaricVillages;

    public RuleAttackBarbaric() {
        this.myBarbaricVillages = new LinkedList<>();

        this.myBarbaricVillages.add(new Point(453,516));
        this.myBarbaricVillages.add(new Point(448,521));
        this.myBarbaricVillages.add(new Point(455,518));
        this.myBarbaricVillages.add(new Point(455,523));
        this.myBarbaricVillages.add(new Point(453,529));
        this.myBarbaricVillages.add(new Point(454,529));
        this.myBarbaricVillages.add(new Point(456,526));
        this.myBarbaricVillages.add(new Point(448,525));
        this.myBarbaricVillages.add(new Point(451,523));
        this.myBarbaricVillages.add(new Point(454,525));
        this.myBarbaricVillages.add(new Point(449,524));
        this.myBarbaricVillages.add(new Point(452,520));
        this.myBarbaricVillages.add(new Point(452,528));
    }

    public Map<Point, Army> findBestBarbaricVillageToAttack(Village village) {
        Map<Point, Army> map = new HashMap<>();
        Army army = new Army();

        int numberOfSpearMen = village.getUnitNumberByUnit(UnitStaticInfo.SPEARMAN);
        boolean paladinIsPresent = village.getUnitNumberByUnit(UnitStaticInfo.PALADIN) == 1;

        while (numberOfSpearMen >= 20){
            Point next = this.myBarbaricVillages.poll();
            this.myBarbaricVillages.add(next);

            army.addUnit(UnitStaticInfo.SPEARMAN, 20);
            if (paladinIsPresent){
                army.addUnit(UnitStaticInfo.PALADIN, 1);
                paladinIsPresent = false;
            }

            map.put(next, army);

            numberOfSpearMen -= 20;
        }


        return map;
    }
}
