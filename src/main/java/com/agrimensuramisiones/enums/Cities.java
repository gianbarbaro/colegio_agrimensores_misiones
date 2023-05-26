
package com.agrimensuramisiones.enums;

public enum Cities {
    
    VEINTICINCO_DE_MAYO("25 de Mayo"), ARISTOBULO_DEL_VALLE("Aristóbulo del Valle"), ALBA_POSE("Alba Pose"), 
    APOSTOLES("Apostoles"), AZARA("Azara"), BERNANRDO_DE_IRIGOYEN("Bernardo de Irigoyen"), BONPLAND("Bonpland"), 
    CAMPO_GRANDE("Campo Grande"), CANDELARIA("Candelaria"), CAPIOVY("Capiovy"), CERRO_AZUL("Cerro Azul"),
    CERRO_CORA("Cerro Cora"), COLONIA_GUARANI("Colonia Guaraní"), COLONIA_VICTORIA("Colonia Victoria"), 
    COLONIA_WANDA("Colonia Wanda"), CONCEPCION_DE_LA_SIERRA("Concepción de la Sierra"), CORPUS("Corpus"), 
    ELDORADO("Eldorado"), GARUPA("Garupa"), GENERAL_ALVEAR("General Alvear"), GOBERNADOR_ROCA("Gobernador Roca"), 
    IGUAZU("Iguazú"), ITACABURE("Itacabure"), JARDIN_AMERICA("Jardín América"), LEANDRO_N_ALEM("Leandro N. Alem"), 
    LIBERTAD("Libertad"), MONTECARLO("Montecarlo"), OBERA("Oberá"), ANDRADE("Andrade"), PICADITA("Picadita"),
    POSADAS("Posadas"), PUERTO_ALCAZAR("Puerto Alcazar"), PUERTO_ESPERANZA("Puerto Esperanza"), PUERTO_PIRAY("Puerto Piray"),
    PUERTO_RICO("Puerto Rico"), SAN_IGNACIO("San Ignacio"), SAN_JAVIER("San Javier"), SAN_JOSE("San Jose"), 
    SAN_VICENTE("San Vicente"), SANTA_ANA("Santa Ana"), SANTO_PIPO("Santo Pipó");
    
    private String displayValue;

    private Cities(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
}
