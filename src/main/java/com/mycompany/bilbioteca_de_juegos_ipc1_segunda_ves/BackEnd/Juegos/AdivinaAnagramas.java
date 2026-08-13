package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Juegos;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.BibliotecaReportesGlobales;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Anagramas.AnagramasBancoDePalabras;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.MenusInformativos;

public class AdivinaAnagramas extends Juegos {

    private InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    private AnagramasBancoDePalabras banco = new AnagramasBancoDePalabras();
    private Scanner scanner = new Scanner(System.in);
    private BibliotecaReportesGlobales reportesDatos;
    private MenusInformativos informativos = new MenusInformativos();
    private final static double PORCENTAJE_DE_ACEPTACION = 0.5;

    public void jugar(int dificultad,BibliotecaReportesGlobales reportesDatosEntrante) {

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
                        informativos.mensajeDeErrorRepetidoAnagramas();
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
                        intentos = registrarIntentoFallido(palabraUsuario, palabrasFallidas, contadroMalas, intentos);
                        contadroMalas++;
                    }
                }

            } else {
                intentos = registrarIntentoFallido(palabraUsuario, palabrasFallidas, contadroMalas, intentos);
                contadroMalas++;
            }

            if (condicionDeVictoria(mapeoDeAnagramas)) {
                reportesDatos.addCantidadDePartidasGanadasA(1);
                informativos.mensajeDeVictoriaAnagramas();
                scanner.nextLine();
                break;
            } else if (intentos <= 0) {
                informativos.mensajeDeDerrotaAnagramas();
                scanner.nextLine();
                break;
            }
        }
    }

    private int registrarIntentoFallido(String palabraUsuario, String[] palabrasFallidas, int contadorMalas, int intentos) {
        if (contadorMalas < palabrasFallidas.length) {
            palabrasFallidas[contadorMalas] = palabraUsuario.toUpperCase();
        }
        reportesDatos.addIntentosFallidosA(1);
        informativos.mensajeDeErrorAnagramas();
        return intentos - 1;
    }

    private boolean condicionDeVictoria(String[] mapeadorDepalabras) {
        for (int i = 0; i < mapeadorDepalabras.length; i++) {
            if (mapeadorDepalabras[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected String getNombre() {
        return "|   Bienvenido al juego Adivina Anagramas   |";
    }

}
