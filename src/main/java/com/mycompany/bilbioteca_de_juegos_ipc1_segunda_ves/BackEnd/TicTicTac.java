package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.AiBotPorFor;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.Casilla;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.CasillaBot;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.CasillaJugador;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.ConfiguracionDeVisualBiblioteca;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;

public class TicTicTac {

    private InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    private BibliotecaDeDatosJuegos bibliotecaDeDatosJuegos = new BibliotecaDeDatosJuegos();
    private ConfiguracionDeVisualBiblioteca configuracionesProyectoVisual = new ConfiguracionDeVisualBiblioteca();
    private Scanner scanner = new Scanner(System.in);
    private AiBotPorFor bot = new AiBotPorFor();
    private BibliotecaReportesGlobales reportesDatos;

    public void jugarTicTacToe(BibliotecaReportesGlobales reportesDatosEntrante) {
        reportesDatos = reportesDatosEntrante;

        Casilla[][] mapeoDeTicTacToe = bibliotecaDeDatosJuegos.getBaseDeDatosDeTicTacToe();
        String movimientoJugador;

        while (true) {
            try {
                interfasDeJuegos.ticTacToe(mapeoDeTicTacToe, "0");
                movimientoJugador = scanner.nextLine();

                if (movimientoJugador.length() == 2) {

                    char fila = movimientoJugador.charAt(0);
                    char columna = movimientoJugador.charAt(1);

                    boolean filaValida = Character.isDigit(fila);
                    boolean columnaValida = Character.isLetter(columna);
                    // validacion de movimiento del jugador
                    if (filaValida && columnaValida
                            && mapeoDeTicTacToe[Character.getNumericValue(fila)][Character.toUpperCase(columna) - 'A']
                                    .estaOcupada() == false) {
                                        reportesDatos.addJugadasAcumuladasT();

                        pintorDeCasillas(mapeoDeTicTacToe, fila, columna);

                        if (condicionDeVictoria(mapeoDeTicTacToe, "Jugador")) {
                            interfasDeJuegos.ticTacToe(mapeoDeTicTacToe, "0");
                            reportesDatos.addVictoriasJugadorT(1);
                            reportesDatos.addRachaVictoriasT(1);
                            reportesDatos.setRachaDerrotasT(0);
                            System.out.println("\n¡El Jugador gana!");
                            System.out.println("Presione Enter para continuar...");
                            scanner.nextLine();
                            break;
                        } else if (condicionDeEmpate(mapeoDeTicTacToe)) {
                            interfasDeJuegos.ticTacToe(mapeoDeTicTacToe, "0");
                            reportesDatos.addEmpatesT(1);
                            System.out.println("\n¡Es un Empate!");
                            System.out.println("Presione Enter para continuar...");
                            scanner.nextLine();
                            break;
                        }

                        // juego del bot
                        traductorDeBot(mapeoDeTicTacToe, fila, columna);

                        if (condicionDeVictoria(mapeoDeTicTacToe, "Bot")) {
                            interfasDeJuegos.ticTacToe(mapeoDeTicTacToe, "0");
                            System.out.println("\n¡El Bot gana!");
                            reportesDatos.addVictoriasMaquinaT(1);
                            reportesDatos.setRachaVictoriasT(0);
                            reportesDatos.addRachaDerrotasT(1);
                            System.out.println("Presione Enter para continuar...");
                            scanner.nextLine();
                            break;
                        }

                        else if (condicionDeEmpate(mapeoDeTicTacToe)) {
                            interfasDeJuegos.ticTacToe(mapeoDeTicTacToe, "0");
                            reportesDatos.addEmpatesT(1);
                            System.out.println("\n¡Es un Empate!");
                            reportesDatos.setRachaVictoriasT(0);
                            reportesDatos.setRachaDerrotasT(0);
                            System.out.println("Presione Enter para continuar...");
                            scanner.nextLine();
                            break;
                        }

                    } else {
                        mensajeDeError();
                    }
                } else {
                    mensajeDeError();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                mensajeDeError();
            }
        }

    }

    private void traductorDeBot(Casilla[][] mapeoDeTicTacToe, char fila, char columna) {

        int filaIndice = Character.getNumericValue(fila);
        bot.hacerMovimiento(mapeoDeTicTacToe, filaIndice, Character.toUpperCase(columna) - 'A');
        casillaSeleccionada(mapeoDeTicTacToe, bot.getFilaBot(), bot.getColumnaBot(), false);

    }

    private void pintorDeCasillas(Casilla[][] mapeoDeTicTacToe, char fila, char columna) {

        int filaIndice = Character.getNumericValue(fila);
        casillaSeleccionada(mapeoDeTicTacToe, filaIndice, Character.toUpperCase(columna) - 'A', true);

    }

    private void casillaSeleccionada(Casilla[][] mapeoDeTicTacToe, int filaIndice, int columnaIndice, boolean caso) {
        if (caso) {
            mapeoDeTicTacToe[filaIndice][columnaIndice] = new CasillaJugador();
            ((CasillaJugador) mapeoDeTicTacToe[filaIndice][columnaIndice]).cambioSimbolo();
        } else {
            mapeoDeTicTacToe[filaIndice][columnaIndice] = new CasillaBot();
            ((CasillaBot) mapeoDeTicTacToe[filaIndice][columnaIndice]).cambioSimbolo();
        }
    }

    private boolean condicionDeVictoria(Casilla[][] mapeoDeTicTacToe, String jugador) {
        // Verifica las 3 filas
        for (int i = 0; i < 3; i++) {
            if (mapeoDeTicTacToe[i][0].estaOcupada() && mapeoDeTicTacToe[i][0].jugadorOcupando().equals(jugador) &&
                    mapeoDeTicTacToe[i][1].estaOcupada() && mapeoDeTicTacToe[i][1].jugadorOcupando().equals(jugador) &&
                    mapeoDeTicTacToe[i][2].estaOcupada() && mapeoDeTicTacToe[i][2].jugadorOcupando().equals(jugador)) {
                return true;
            }
        }

        // Verifica las 3 columnas
        for (int i = 0; i < 3; i++) {
            if (mapeoDeTicTacToe[0][i].estaOcupada() && mapeoDeTicTacToe[0][i].jugadorOcupando().equals(jugador) &&
                    mapeoDeTicTacToe[1][i].estaOcupada() && mapeoDeTicTacToe[1][i].jugadorOcupando().equals(jugador) &&
                    mapeoDeTicTacToe[2][i].estaOcupada() && mapeoDeTicTacToe[2][i].jugadorOcupando().equals(jugador)) {
                return true;
            }
        }

        // Verifica diagonal principal
        if (mapeoDeTicTacToe[0][0].estaOcupada() && mapeoDeTicTacToe[0][0].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[1][1].estaOcupada() && mapeoDeTicTacToe[1][1].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[2][2].estaOcupada() && mapeoDeTicTacToe[2][2].jugadorOcupando().equals(jugador)) {
            return true;
        }

        // Verifica diagonal secundaria
        if (mapeoDeTicTacToe[0][2].estaOcupada() && mapeoDeTicTacToe[0][2].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[1][1].estaOcupada() && mapeoDeTicTacToe[1][1].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[2][0].estaOcupada() && mapeoDeTicTacToe[2][0].jugadorOcupando().equals(jugador)) {
            return true;
        }

        return false;
    }

    private void mensajeDeError() {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        System.out.print("\033[38;5;208m");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("Movimiento invalido, intente de nuevo");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.print("\033[0m");
    }

    private boolean condicionDeEmpate(Casilla[][] mapeoDeTicTacToe) {
        for (int i = 0; i < mapeoDeTicTacToe.length; i++) {
            for (int j = 0; j < mapeoDeTicTacToe[i].length; j++) {
                if (!mapeoDeTicTacToe[i][j].estaOcupada()) {
                    return false;
                }
            }
        }
        return true;
    }
}
