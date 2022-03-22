package by.gsu.epamlab.enums;

import by.gsu.epamlab.Constants;

public enum EnumRow {

    NAME("%s"), PRICE("%s"), NUMBER("%s"), DISCOUNT("%s"), COST("%s");

    private final String nameEnum;

    
    EnumRow(String value) {
        this.nameEnum = value;
    }

    public String get() {
        return nameEnum;
    }

    public String toString() {
        return name()+Constants.DELIMITER;
    }
}