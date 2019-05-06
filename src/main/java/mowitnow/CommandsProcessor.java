package mowitnow;

import mowitnow.utils.UtilsMowItNow;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommandsProcessor {

    private List<String> commands;
    public Pelouse getPelouse() {
        return pelouse;
    }

    private Pelouse pelouse;

    public void setUp(File testFile) throws IOException {
        this.commands = UtilsMowItNow.readCommandsFromFile(testFile);
    }
    public void setUp(List<String> commands){
        this.commands = commands;
    }
    public void servePelouseWithTendeuses() {
        String[] pelouseDimension = commands.get(0).split(" ");
        try {
            pelouse = new Pelouse(Integer.valueOf(pelouseDimension[0]), Integer.valueOf(pelouseDimension[1]));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Dimensions should be numbers");
        }

        for (int i = 1; i < commands.size(); i = i + 2) {
            try {
                String[] coordinate = commands.get(i).split(" ");
                int cordX = Integer.valueOf(coordinate[0]);
                int cordY = Integer.valueOf(coordinate[1]);
                String orientation = coordinate[2];
                Tondeuse tondeuse = new Tondeuse(cordX, cordY, orientation, pelouse.getHeight(), pelouse.getWidth());
                pelouse.addTondeuseAndCommands(tondeuse, UtilsMowItNow.convertToListCommands(commands.get(i+1)));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Position's couple should be numbers");
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
        this.startTondeuses();
    }

    public void startTondeuses() {
        pelouse.getMapTondeusesCommands().forEach((t, c) -> t.moveToNewPosition(c));
    }
}
