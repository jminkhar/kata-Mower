package mowitnow;

import mowitnow.enums.Cardinals;
import mowitnow.enums.Orders;

import java.util.Arrays;
import java.util.List;

public class Tondeuse {
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    private int x;
    private int y;
    private int maxX;
    private int maxY;
    private String orientation;
    private static final List<String> CARDINALS = Arrays.asList(Cardinals.NORTH.getValue(), Cardinals.EAST.getValue(), Cardinals.SOUTH.getValue(), Cardinals.WEST.getValue());

    public Tondeuse(){}
    public Tondeuse(int x, int y, String orientation, int pelouseHeight, int pelouseWidth) throws IllegalArgumentException {
        if (y > pelouseHeight || x > pelouseWidth || x < 0 || y < 0)
            throw new IllegalArgumentException("The mower is out of bound!!");
        if (!CARDINALS.contains(orientation))
            throw new IllegalArgumentException("The orientation should be in : " + CARDINALS.toString());
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.maxY = pelouseHeight;
        this.maxX = pelouseWidth;
    }

    public void moveToNewPosition(List<Orders> commands) {
        if (!commands.isEmpty()) {
            if (!commands.stream().allMatch(s -> s.getStatus().matches("[ADG]"))){
                throw new IllegalArgumentException("Commands should be A or D or G ");
            }
            String command = commands.get(0).getStatus();
            if (Orders.ADVANCE.getStatus().equals(command)) {
                advance();
            } else if (Orders.TURNRIGHT.getStatus().equals(command)) {
                changeOrientation(1);
            } else if (Orders.TURNLEFT.getStatus().equals(command)) {
                changeOrientation(-1);
            }
            commands.remove(0);
            moveToNewPosition(commands);
        }
    }

    private void advance() {
        if (Cardinals.NORTH.getValue().equals(this.orientation)) this.y = this.y + 1 <= this.maxX ? this.y + 1 : this.y;
        if (Cardinals.EAST.getValue().equals(this.orientation)) this.x = this.x + 1 <= this.maxY ? this.x + 1 : this.x;
        if (Cardinals.SOUTH.getValue().equals(this.orientation)) this.y = this.y - 1 >= 0 ? this.y - 1 : this.y;
        if (Cardinals.WEST.getValue().equals(this.orientation)) this.x = this.x - 1 >= 0 ? this.x - 1 : this.x;
    }

    public void changeOrientation(int sign) {
        int indexOfThisOrientation = CARDINALS.indexOf(this.orientation);
        this.orientation = CARDINALS.get((CARDINALS.size() + indexOfThisOrientation + sign) % 4);
    }

    public String getPosition() {
        return this.x + " " + this.y + " " + this.orientation;
    }
}
