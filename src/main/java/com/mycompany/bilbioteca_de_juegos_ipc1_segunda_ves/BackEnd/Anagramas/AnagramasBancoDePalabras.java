package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Anagramas;

import java.util.Random;

public class AnagramasBancoDePalabras {
    private final static String[] BANCO_DE_PALABRAS = { "AMOR", "ROMA", "MORA", "RAMO", "ARMO", "GATO", "TOGA", "GOTA",
            "CASO", "COSA", "SACO", "PARO", "PROA", "ROPA","PORA", "ASIR", "IRAS", "RIAS", "ALEGRA", "LAGEAR", "REGALA" };
    private String palabraElegida;
    private String palabraDesOrdenadaFinal;
    private String[] palabrasAGenerar;
    private Random random = new Random();

    public void generadorDePartidaAnagramas() {

        int numeroSelecionado = random.nextInt(BANCO_DE_PALABRAS.length);
        palabraElegida = BANCO_DE_PALABRAS[numeroSelecionado];
        palabrasAGenerar = selector(palabraElegida);
        palabraDesOrdenadaFinal = palabraDesordenada(palabraElegida); 

    }

    public String[] getPalabrasGeneradaDesOrdenada() {
        return palabrasAGenerar;
    }

    public String getPalabraDesOrdenada() {
        return palabraDesOrdenadaFinal;
    }

    private String[] selector(String palabraBase) {
        char[] verificacionLetras = new char[palabraBase.length()];

        String bancoPalabra;
        int contador = 0;
        int contadorAreglo = 0;
        int contadorDeVultas = 0;
        String[] palabrasValidas = new String[0];
        while (true) {

            for (int j = 0; j < BANCO_DE_PALABRAS.length; j++) {
                bancoPalabra = BANCO_DE_PALABRAS[j];
                char[] letraUsuario = new char[bancoPalabra.length()];
                contador = 0;
                for (int i = 0; i < palabraBase.length(); i++) {
                    verificacionLetras[i] = palabraBase.charAt(i);
                }
                for (int z = 0; z < bancoPalabra.length(); z++) {
                    letraUsuario[z] = bancoPalabra.charAt(z);

                }

                for (int i = 0; i < palabraBase.length(); i++) {

                    if (verificacionLetras[i] != 0) {

                        for (int z = 0; z < bancoPalabra.length(); z++) {

                            if (verificacionLetras[i] == letraUsuario[z]) {
                                verificacionLetras[i] = 0;
                                letraUsuario[z] = 0;
                                contador++;
                                break;
                            }
                        }
                    }
                }

                if (contadorDeVultas == 1 && contador == palabraBase.length()
                        && palabraBase.length() == bancoPalabra.length()) {
                    palabrasValidas[contadorAreglo] = bancoPalabra;
                }
                if (contador == palabraBase.length() && palabraBase.length() == bancoPalabra.length()) {
                    contadorAreglo++;
                }
            }
            if (contadorDeVultas == 1) {
                return palabrasValidas;
            } else {
                palabrasValidas = new String[contadorAreglo];
                contadorAreglo = 0;
                contadorDeVultas++;
            }

        }
    }

    private String palabraDesordenada(String palabra) {
        char[] palabraOrdenada = new char[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            palabraOrdenada[i] = palabra.charAt(i);
        }
        for (int i = 0; i < palabra.length(); i++) {
            int xTemp = random.nextInt(palabra.length());
            int yTemp = random.nextInt(palabra.length());
            char temp = palabraOrdenada[xTemp];
            palabraOrdenada[xTemp] = palabraOrdenada[yTemp];
            palabraOrdenada[yTemp] = temp;
        }
        return String.copyValueOf(palabraOrdenada);

    }

}
