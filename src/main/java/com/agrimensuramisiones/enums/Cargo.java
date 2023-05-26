
package com.agrimensuramisiones.enums;

public enum Cargo {
    PRESIDENTE("Presidente"), SECRETARIO_GENERAL("Secretario General"), TESORERO("Tesorero"), 
    PRIMER_VOCAL_TITULAR("1er Vocal Titular"), SEGUNDO_VOCAL_TITULAR("2do Vocal Titular"), 
    PRIMER_VOCAL_SUPLENTE("1er Vocal Suplente"), SEGUNDO_VOCAL_SUPLENTE("1er Vocal Suplente"), 
    REVISOR_CUENTAS_TITULAR("Revisor de Cuentas Titular"), REVISOR_CUENTAS_SUPLENTE("Revisor de Cuentas Suplente");
    
    private String displayValue;

    private Cargo(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
}
