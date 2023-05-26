
package com.agrimensuramisiones.enums;

public enum NormativeAlcance {
    NACIONAL("Nacional"), PROVINCIAL("Porvincial"), MUNICIPAL("Municipal");
    
    private String displayValue;

    private NormativeAlcance(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
}
