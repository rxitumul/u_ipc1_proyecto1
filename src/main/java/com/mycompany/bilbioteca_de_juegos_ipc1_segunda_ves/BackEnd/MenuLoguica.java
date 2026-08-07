/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.MenusIniciales;

/**
 *
 * @author ricardocastillo
 */
public class MenuLoguica {

    private MenusIniciales menu = new MenusIniciales();
    private Scanner scanner = new Scanner(System.in);
    private int opcionDeJuego;
    private BibliotecaReportesGlobales reportesDatos = new BibliotecaReportesGlobales();

    public void menuDeOpciones() {
        boolean opcionValida = true;
        while (opcionValida) {
            menu.pantallaDeOpciones();
            try {
                opcionDeJuego = Integer.parseInt(scanner.nextLine());
                if (opcionDeJuego >= 1 && opcionDeJuego <= 3) {
                    llamadaDeMenuDeJuegos(opcionDeJuego);
                } else if (opcionDeJuego == 4) {
                    menu.pantallaDeSalida();
                    opcionValida = false;
                } else {
                    menu.pantallaDeError();
                }
            } catch (Exception e) {
                System.out.println(e);
                menu.pantallaDeError();
            }
        }
    }

    public void llamadaDeMenuDeJuegos(int opcionDeJuego) {

        String continuar;
        int dificultad = 0;
        while (true) {

            try {
                switch (opcionDeJuego) {
                    case 3:
                        menu.selectorDeDificultad();
                        dificultad = Integer.parseInt(scanner.nextLine());
                        switch (dificultad) {
                            case 1:
                                dificultad = 30;
                                break;
                            case 2:
                                dificultad = 46;
                                break;

                            default:
                                dificultad = 64;
                                break;
                        }
                        break;
                }
                break;

            } catch (NumberFormatException e) {
                menu.pantallaDeError();
            }
        }

        menu.menuDeJuegos(opcionDeJuego);
        continuar = scanner.nextLine();
        if (continuar.equalsIgnoreCase("1")) {
            switch (opcionDeJuego) {
                case 1:
                    AdivinaAnagramas adivinaAnagramas = new AdivinaAnagramas();
                    adivinaAnagramas.jugarAdivinaAnagramas(reportesDatos);
                    break;
                case 2:
                    TicTicTac ticTacToe = new TicTicTac();
                    ticTacToe.jugarTicTacToe(reportesDatos);
                    break;
                case 3:
                    SudokuJuego sudoku = new SudokuJuego();
                    sudoku.jugarSudoku(dificultad, reportesDatos);
                    break;
                case 4:
                    ReportesGlobales reportes = new ReportesGlobales();
                    reportes.reportes(reportesDatos);
                    break;
            }
        } else {
            menu.regresandoAlMenuPrincipal();
        }

    }
}
