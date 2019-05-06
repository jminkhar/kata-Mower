package mowitnow;

import mowitnow.enums.Orders;

import java.util.LinkedHashMap;
import java.util.List;

public class Pelouse {
    private int height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private int width;
    private LinkedHashMap<Tondeuse, List<Orders>> mapTondeuses = new LinkedHashMap<>();

    public Pelouse(int height, int width) {
        if (height < 0 || width < 0) throw new IllegalArgumentException("Dimensions should be positives");
        this.height = height;
        this.width = width;
    }

    public void addTondeuseAndCommands(Tondeuse tondeuse, List<Orders> commands) {
        mapTondeuses.put(tondeuse, commands);
    }

    public LinkedHashMap<Tondeuse, List<Orders>> getMapTondeusesCommands() {
        return mapTondeuses;
    }

}
