package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ronan
 * on 10/04/2020.
 */
public class Player {

    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);

    private String userName;
    private int rank;
    private int points;
    private Map<Point, Village> villages;

    public Player(String userName, int rank, int points) {
        this.userName = userName;
        this.rank = rank;
        this.points = points;

        this.villages = new HashMap<>();

        LOGGER.debug("Successfully created {}", this.userName);
    }

    public String getUserName() {
        return this.userName;
    }

    public int getRank() {
        return this.rank;
    }

    public int getPoints() {
        return this.points;
    }

    public Iterator<Village> getVillagesIterator() {
        return this.villages.values().iterator();
    }

    public void addVillage(Village village) {
        this.villages.put(village.getLocalisation(), village);
    }

    public Village getVillage(Point point) {
        return this.villages.get(point);
    }
}
