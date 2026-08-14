package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

public class ConfiguracionDeVisualBiblioteca {
    private final int TIEMPO = 1100;
    private final int ANCHO = 42;
    private final static String LIMPIADOR_DE_PANTALLA = "\033[H\033[2J";
    private final static String SEPARADOR_DE_PANTALLA = "|" + "-".repeat(40) + "|";

    public void limpiarPantalla() {
        System.out.print(LIMPIADOR_DE_PANTALLA);
    }

    public void separadorDeLineas() {
        System.out.println(SEPARADOR_DE_PANTALLA);
    }

    public String formatearCentrado(String texto) {
        int interior = ANCHO - 2;

        // Longitud visual: sin contar los códigos ANSI de color
        String textoSinAnsi = texto.replaceAll("\u001B\\[[\\d;]*m", "");
        int longitudVisible = textoSinAnsi.length();

        if (longitudVisible > interior) {
            // Truncar basado en la longitud visible, no el total con ANSI
            texto = textoSinAnsi.substring(0, interior);
            longitudVisible = interior;
        }

        int espaciosIzquierda = (interior - longitudVisible) / 2;
        int espaciosDerecha = interior - longitudVisible - espaciosIzquierda;

        String formato = "|" + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + "|";

        return formato;
    }

    public void delayThread() {

        try {
            Thread.sleep(TIEMPO);
        } catch (InterruptedException ex) {
        }

        System.out.flush();
    }

}
