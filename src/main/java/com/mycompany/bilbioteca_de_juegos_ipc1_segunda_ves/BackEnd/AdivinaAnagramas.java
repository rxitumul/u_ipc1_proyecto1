package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;

public class AdivinaAnagramas {

    InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    BibliotecaDeDatosJuegos bibliotecaDeDatosJuegos = new BibliotecaDeDatosJuegos();

    public void jugarAdivinaAnagramas() {
        String[] mapeoDeAnagramas = bibliotecaDeDatosJuegos.getBaseDeDatosDeAnagramas();
        interfasDeJuegos.adivinaAnagramas(mapeoDeAnagramas[0]);
    }

}
