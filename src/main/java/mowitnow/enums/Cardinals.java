package mowitnow.enums;

public enum Cardinals {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String value;

    Cardinals(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
