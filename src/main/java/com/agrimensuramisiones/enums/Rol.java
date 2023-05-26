
package com.agrimensuramisiones.enums;

public enum Rol {
    ADMIN("Administrador"), AUTHORITY("Authority"), PARTNER("Partner");
    
    private String displayValue;

    private Rol(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
}
