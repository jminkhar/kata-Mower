package mowitnow.enums;

public enum Orders {
    ADVANCE("A"),
    TURNLEFT("G"),
    TURNRIGHT("D"),
    NULL("");

    private String status;

    public String getStatus() {
        return status;
    }

    Orders(String status) {
        this.status = status;
    }

    public static Orders getNameByCode(String code) {
        for (Orders e : Orders.values()) {
            if (code.equals(e.status)) return e;
        }
        return NULL;
    }
}
