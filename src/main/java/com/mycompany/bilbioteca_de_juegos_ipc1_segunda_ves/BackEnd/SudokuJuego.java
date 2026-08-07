package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.CasillaSudoku;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.MenusIniciales;

public class SudokuJuego {
    private InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    private BibliotecaDeDatosJuegos bibliotecaDeDatosJuegos = new BibliotecaDeDatosJuegos();
    private Scanner scanner = new Scanner(System.in);
    private MenusIniciales menuInicial = new MenusIniciales();
    private BibliotecaReportesGlobales reportesDatos;

    public void jugarSudoku(int dificultad, BibliotecaReportesGlobales reportesDatosEntrante) {
        int contadorDeJugadas = 0;
        reportesDatos = reportesDatosEntrante;
        reportesDatos.addPartidasJugadasS();

        String opcionDeJugador;
        CasillaSudoku[][] mapeoDeSudoku = bibliotecaDeDatosJuegos.getBaseDeDatosDeSudoku(dificultad);
        int numero;
        int filaNumero;
        int columnaNumero;
        while (true) {
            try {

                interfasDeJuegos.sudoku(mapeoDeSudoku);
                opcionDeJugador = scanner.nextLine();
                contadorDeJugadas++;
                if (opcionDeJugador.length() == 2) {

                    char fila = opcionDeJugador.charAt(0);
                    char columna = opcionDeJugador.charAt(1);

                    boolean filaValida = Character.isDigit(fila);
                    boolean columnaValida = Character.isLetter(columna);

                    filaNumero = Character.getNumericValue(fila);
                    columnaNumero = Character.toUpperCase(columna) - 'A';

                    // validacion de movimiento del jugador
                    if (filaNumero < 9 && columnaNumero < 9 && filaValida && columnaValida
                            && mapeoDeSudoku[filaNumero][columnaNumero].getGeneradoInicial() == false) {

                        System.out.println("Ingrese un numero del 1 al 9");
                        numero = Integer.parseInt(scanner.nextLine());

                        if (numero >= 1 && numero <= 9
                                && esValidoVictoria(filaNumero, columnaNumero, numero, mapeoDeSudoku)) {

                            mapeoDeSudoku[filaNumero][columnaNumero] = bibliotecaDeDatosJuegos.tablaDeNumeros(numero);
                            mapeoDeSudoku[filaNumero][columnaNumero].setGeneradoInicial(false);
                            mapeoDeSudoku[filaNumero][columnaNumero].condicionesIniciales();

                        } else {
                            reportesDatos.addJugadasInvalidasS();
                            menuInicial.pantallaDeError();
                        }

                    } else {
                        reportesDatos.addJugadasInvalidasS();
                        menuInicial.pantallaDeError();
                    }

                } else if (opcionDeJugador.equalsIgnoreCase("x")) {
                    reportesDatos.addPartidasAbandonadasS(1);
                    break;
                } else {
                    reportesDatos.addJugadasInvalidasS();
                    menuInicial.pantallaDeError();
                }
                if (condicionDeVictoria(mapeoDeSudoku)) {
                    reportesDatos.addPartidasGanadasS(1);
                    int record = reportesDatos.getRecordMenosJugadasS();
                    if (contadorDeJugadas < record) {
                        reportesDatos.setRecordMenosJugadasS(contadorDeJugadas);
                    }
                    System.out.println("\n|----------------------------------------|");
                    System.out.println("|         ¡FELICIDADES! GANASTE          |");
                    System.out.println("|   Completaste el Sudoku correctamente  |");
                    System.out.println("|----------------------------------------|\n");
                    System.out.println("Presione Enter para continuar...");
                    scanner.nextLine();
                    break;
                }
            } catch (NullPointerException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
                menuInicial.pantallaDeError();
                reportesDatos.addJugadasInvalidasS();
            }
        }
    }

    private boolean condicionDeVictoria(CasillaSudoku[][] mapeoDeSudoku) {
        int sumador;
        for (int i = 0; i < mapeoDeSudoku.length; i++) {
            sumador = 0;
            for (int j = 0; j < mapeoDeSudoku[i].length; j++) {
                if (esValidoVictoria(i, j, mapeoDeSudoku[i][j].getValorDeCasilla(), mapeoDeSudoku)) {
                    sumador = mapeoDeSudoku[i][j].getValorDeCasilla() + sumador;
                }
            }
            if (sumador != 45) {
                return false;
            }
        }

        for (int i = 0; i < mapeoDeSudoku.length; i++) {
            sumador = 0;
            for (int j = 0; j < mapeoDeSudoku[i].length; j++) {
                if (esValidoVictoria(j, i, mapeoDeSudoku[j][i].getValorDeCasilla(), mapeoDeSudoku)) {
                    sumador = mapeoDeSudoku[j][i].getValorDeCasilla() + sumador;
                }
            }
            if (sumador != 45) {
                return false;
            }
        }
        return true;
    }

    private boolean esValidoVictoria(int fila, int columna, int num, CasillaSudoku[][] mapaDeSudokuLocal) {
        for (int i = 0; i < 9; i++) {

            if (mapaDeSudokuLocal[fila][i].getValorDeCasilla() == num && i != columna) {
                return false;
            }
            if (mapaDeSudokuLocal[i][columna].getValorDeCasilla() == num && i != fila) {
                return false;

            }
        }
        int inicioFila = (fila / 3) * 3;
        int inicioColumna = (columna / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (mapaDeSudokuLocal[inicioFila + i][inicioColumna + j].getValorDeCasilla() == num
                        && (fila != inicioFila + i || columna != inicioColumna + j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
