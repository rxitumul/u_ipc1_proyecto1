package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

public class ConfiguracionDeVisualBiblioteca {
    private final static String LIMPIADOR_DE_PANTALLA = "\033[H\033[2J";
    private final static String SEPARADOR_DE_PANTALLA = "|"+"-".repeat(40)+"|";

    public void limpiarPantalla() {
        System.out.print(LIMPIADOR_DE_PANTALLA);
    }

    public void separadorDeLineas() {
        System.out.println(SEPARADOR_DE_PANTALLA);
    }

}
