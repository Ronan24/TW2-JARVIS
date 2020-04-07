import model.UnitStaticInfo;
import model.Village;

import java.awt.*;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class RuleAttackBarbaric {
    private Queue<Point> myBarbaricVillages;

    public RuleAttackBarbaric() {
        this.myBarbaricVillages = new LinkedList<>();

        this.myBarbaricVillages.add(new Point(448,521));
        this.myBarbaricVillages.add(new Point(455,518));
        this.myBarbaricVillages.add(new Point(454,525));
        this.myBarbaricVillages.add(new Point(449,524));
        this.myBarbaricVillages.add(new Point(452,520));
        this.myBarbaricVillages.add(new Point(452,528));
        this.myBarbaricVillages.add(new Point(453,516));
    }

    public Optional<Point> findBestBarbaricVillageToAttack(Village village) {
        if (village.getUnitNumberByUnit(UnitStaticInfo.SPEARMAN) < 20){
            return Optional.empty();
        } else {
            Point next = this.myBarbaricVillages.poll();
            this.myBarbaricVillages.add(next);
            return Optional.of(next);
        }
    }
}
