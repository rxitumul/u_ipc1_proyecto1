package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Anagramas.AnagramasBancoDePalabras;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;

public class AdivinaAnagramas {

    private InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    private AnagramasBancoDePalabras banco = new AnagramasBancoDePalabras();
    private Scanner scanner = new Scanner(System.in);
    private BibliotecaReportesGlobales reportesDatos;

    private final static double PORCENTAJE_DE_ACEPTACION = 0.5;

    public void jugarAdivinaAnagramas(BibliotecaReportesGlobales reportesDatosEntrante) {

        reportesDatos = reportesDatosEntrante;
        reportesDatos.addPartidasJugadasA(1);
        banco.generadorDePartidaAnagramas();

        String[] mapeoDeAnagramas = banco.getPalabrasGeneradaDesOrdenada();
        String[] palabrasUsadasCorrectas = new String[mapeoDeAnagramas.length];
        String[] palabrasFallidas = new String[mapeoDeAnagramas.length];

        String palabraLimpia = banco.getPalabraDesOrdenada();
        String palabraConColor = "\u001B[33m" + palabraLimpia + "\u001B[0m";
        String palabraUsuario;

        boolean palabraUsada = false;
        boolean palabraEncontrada = false;

        int contadorBuenas = 0;
        int contadroMalas = 0;
        int intentos = (int) (PORCENTAJE_DE_ACEPTACION * mapeoDeAnagramas.length);
        if (intentos == 0) {
            intentos = 1;

        }

        while (true) {
            palabraEncontrada = false;
            palabraUsada = false;

            interfasDeJuegos.adivinaAnagramas(palabraConColor, palabrasUsadasCorrectas, palabrasFallidas, intentos);
            palabraUsuario = scanner.nextLine();

            if (palabraUsuario.equalsIgnoreCase("x")) {
                break;
            }

            if (palabraUsuario.length() == palabraLimpia.length()) {

                for (int i = 0; i < palabrasUsadasCorrectas.length; i++) {
                    if (palabrasUsadasCorrectas[i] != null
                            && palabraUsuario.equalsIgnoreCase(palabrasUsadasCorrectas[i])) {
                        palabraUsada = true;
                        mensajeDeErrorRepetido();
                        break;
                    }
                }

                if (!palabraUsada) {
                    for (int i = 0; i < mapeoDeAnagramas.length; i++) {
                        if (mapeoDeAnagramas[i] != null && palabraUsuario.equalsIgnoreCase(mapeoDeAnagramas[i])) {
                            palabraEncontrada = true;
                            reportesDatos.addPalabrasAdivinadasA(1);
                            palabrasUsadasCorrectas[contadorBuenas] = palabraUsuario.toUpperCase();
                            contadorBuenas++;
                            mapeoDeAnagramas[i] = null;
                            break;
                        }
                    }
                    if (!palabraEncontrada) {
                        if (contadroMalas < palabrasFallidas.length) {
                            palabrasFallidas[contadroMalas] = palabraUsuario.toUpperCase();
                            contadroMalas++;
                        }
                        mensajeDeError();
                        intentos--;
                    }
                }

            } else {
                if (contadroMalas < palabrasFallidas.length) {
                    palabrasFallidas[contadroMalas] = palabraUsuario.toUpperCase();
                    contadroMalas++;
                }
                mensajeDeError();
                intentos--;
            }

            if (condicionDeVictoria(mapeoDeAnagramas)) {
                mensajeDeVictoria();
                break;
            } else if (intentos <= 0) {
                mensajeDeDerrota();
                break;
            }
        }
    }

    private boolean condicionDeVictoria(String[] mapeadorDepalabras) {
        for (int i = 0; i < mapeadorDepalabras.length; i++) {
            if (mapeadorDepalabras[i] != null) {
                return false;
            }
        }
        return true;
    }

    private void mensajeDeDerrota() {
        System.out.println("\n|----------------------------------------|");
        System.out.println("|               ¡PERDISTE!               |");
        System.out.println("|      Te has quedado sin intentos.      |");
        System.out.println("|----------------------------------------|\n");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private void mensajeDeVictoria() {
        reportesDatos.addCantidadDePartidasGanadasA(1);
        System.out.println("\n|----------------------------------------|");
        System.out.println("|               ¡GANASTE!                |");
        System.out.println("|   ¡Encontraste todos los anagramas!    |");
        System.out.println("|----------------------------------------|\n");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private void mensajeDeErrorRepetido() {
        System.out.println("\n|----------------------------------------|");
        System.out.println("|  Esa palabra ya la habías encontrado.  |");
        System.out.println("|        Intenta con otra distinta.      |");
        System.out.println("|----------------------------------------|\n");
    }

    private void mensajeDeError() {
        reportesDatos.addIntentosFallidosA(1);
        System.out.println("\n|----------------------------------------|");
        System.out.println("|  Palabra inválida o no es un anagrama. |");
        System.out.println("|            ¡Intento fallido!           |");
        System.out.println("|----------------------------------------|\n");
    }

}
