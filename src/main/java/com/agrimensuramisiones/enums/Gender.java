
package com.agrimensuramisiones.enums;

public enum Gender {
    FEMENINO("Femenino"), MASCULINO("Masculino"), OTRO("Otro");
    
    private String displayValue;

    private Gender(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
}
