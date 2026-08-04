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
                System.out.println(
                        "\033[31m"
                                + "!!!!!!!! Error: Opción inválida. Por favor de ingresar un numero o una opción válida. !!!!!!!!\033[0m");
            }
        }
    }

    public void llamadaDeMenuDeJuegos(int opcionDeJuego) {

        
        menu.menuDeJuegos(opcionDeJuego);
        
        switch (opcionDeJuego) {
            case 1:
                AdivinaAnagramas adivinaAnagramas = new AdivinaAnagramas();
                adivinaAnagramas.jugarAdivinaAnagramas();
                break;
            case 2:
                TicTicTac ticTacToe = new TicTicTac();
                ticTacToe.jugarTicTacToe();
                break;
            case 3:
                Sudoku sudoku = new Sudoku();
                sudoku.jugarSudoku();
                break;
        }


    }
}
