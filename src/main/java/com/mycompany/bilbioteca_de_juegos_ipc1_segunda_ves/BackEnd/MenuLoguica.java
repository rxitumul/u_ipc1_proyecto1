/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.MenuInicial;

/**
 *
 * @author ricardocastillo
 */
public class MenuLoguica {
    MenuInicial menu = new MenuInicial();
    Scanner scanner = new Scanner(System.in);
    int opcionDeJuego;

    public void menuDeOpciones() {
        menu.pantallaDeOpciones();
        // menu.pantallaDeOpciones

        try {
            opcionDeJuego = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            // menu.pantallaDeOpciones();
        }
    }
}
