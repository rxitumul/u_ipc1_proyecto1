package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Juegos;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.BibliotecaDeDatosJuegos;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.BibliotecaReportesGlobales;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.CasillaSudoku;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.MenusInformativos;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.MenusIniciales;

public class SudokuJuego extends Juegos {
    private InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    private BibliotecaDeDatosJuegos bibliotecaDeDatosJuegos = new BibliotecaDeDatosJuegos();
    private Scanner scanner = new Scanner(System.in);
    private MenusIniciales menuInicial = new MenusIniciales();
    private BibliotecaReportesGlobales reportesDatos;
    private MenusInformativos informativo = new MenusInformativos();

    public void jugar(int dificultad, BibliotecaReportesGlobales reportesDatosEntrante) {
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
                            && !mapeoDeSudoku[filaNumero][columnaNumero].isEsInicial()) {

                        System.out.println("Ingrese un numero del 1 al 9");
                        numero = Integer.parseInt(scanner.nextLine());

                        if (numero >= 1 && numero <= 9
                                && esValidoVictoria(filaNumero, columnaNumero, numero, mapeoDeSudoku)) {

                            mapeoDeSudoku[filaNumero][columnaNumero].setValor(numero);

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
                    informativo.mensajeDeVictoriaSudoku();
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
                if (esValidoVictoria(i, j, mapeoDeSudoku[i][j].getValor(), mapeoDeSudoku)) {
                    sumador = mapeoDeSudoku[i][j].getValor() + sumador;
                }
            }
            if (sumador != 45) {
                return false;
            }
        }

        for (int i = 0; i < mapeoDeSudoku.length; i++) {
            sumador = 0;
            for (int j = 0; j < mapeoDeSudoku[i].length; j++) {
                if (esValidoVictoria(j, i, mapeoDeSudoku[j][i].getValor(), mapeoDeSudoku)) {
                    sumador = mapeoDeSudoku[j][i].getValor() + sumador;
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

            if (mapaDeSudokuLocal[fila][i].getValor() == num && i != columna) {
                return false;
            }
            if (mapaDeSudokuLocal[i][columna].getValor() == num && i != fila) {
                return false;

            }
        }
        int inicioFila = (fila / 3) * 3;
        int inicioColumna = (columna / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (mapaDeSudokuLocal[inicioFila + i][inicioColumna + j].getValor() == num
                        && fila != inicioFila + i && columna != inicioColumna + j) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    protected String getNombre() {
        return "|         Bienvenido al juego Sudoku         |";

    }

}
