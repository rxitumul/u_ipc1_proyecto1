package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Anagramas;

import java.util.Random;

public class AnagramasBancoDePalabras {
    private final static String[][] BANCO_DE_ANAGRAMAS = {
        {"AMOR", "ROMA", "MORA", "RAMO", "ARMO"},
        {"GATO", "TOGA", "GOTA"},
        {"CASO", "COSA", "SACO"},
        {"PARO", "PROA", "ROPA", "PORA"},
        {"ASIR", "IRAS", "RIAS"},
        {"ALEGRA", "LAGEAR", "REGALA", "ALEGAR"}
    };

    private String palabraDesOrdenadaFinal;
    private String[] palabrasAGenerar;
    private Random random = new Random();

    public void generadorDePartidaAnagramas() {
        int numeroSeleccionado = random.nextInt(BANCO_DE_ANAGRAMAS.length);
        String[] grupoSeleccionado = BANCO_DE_ANAGRAMAS[numeroSeleccionado];

        palabrasAGenerar = grupoSeleccionado.clone();

        String palabraBase = grupoSeleccionado[random.nextInt(grupoSeleccionado.length)];
        palabraDesOrdenadaFinal = desordenarPalabra(palabraBase);
    }

    public String[] getPalabrasGeneradaDesOrdenada() {
        return palabrasAGenerar;
    }

    public String getPalabraDesOrdenada() {
        return palabraDesOrdenadaFinal;
    }

    private String desordenarPalabra(String palabra) {
        char[] letras = palabra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            int xTemp = random.nextInt(letras.length);
            int yTemp = random.nextInt(letras.length);
            char temp = letras[xTemp];
            letras[xTemp] = letras[yTemp];
            letras[yTemp] = temp;
        }
        return new String(letras);
    }
}
