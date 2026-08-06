package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

public class BibliotecaReportesGlobales {

    // ================= ANAGRAMAS =================
    private int partidasJugadasA = 0;
    private int palabrasAdivinadasA = 0;
    private int intentosFallidosA = 0;
    private int cantidadDePartidasGanadasA = 0;

    // ================= TIC TAC TOE =================
    private int victoriasJugadorT = 0;
    private int victoriasMaquinaT = 0;
    private int empatesT = 0;
    private int rachaVictoriasT = 0;
    private int rachaDerrotasT = 0;
    private int jugadasAcumuladasT = 0;

    // ================= SUDOKU =================
    private int partidasGanadasS = 0;
    private int partidasAbandonadasS = 0;
    private int partidasJugadasS = 0;
    private int jugadasInvalidasS = 0;
    private int recordMenosJugadasS = Integer.MAX_VALUE;

    // ----------------- GETTERS Y SETTERS ANAGRAMAS -----------------
    public int getPartidasJugadasA() {
        return partidasJugadasA;
    }

    public void addPartidasJugadasA(int cantidad) {
        this.partidasJugadasA += cantidad;
    }

    public int getPalabrasAdivinadasA() {
        return palabrasAdivinadasA;
    }

    public void addPalabrasAdivinadasA(int cantidad) {
        this.palabrasAdivinadasA += cantidad;
    }

    public int getIntentosFallidosA() {
        return intentosFallidosA;
    }

    public void addIntentosFallidosA(int cantidad) {
        this.intentosFallidosA += cantidad;
    }

    public void addCantidadDePartidasGanadasA(int cantidad) {
        this.cantidadDePartidasGanadasA += cantidad;
    }

    public double getPorcentajeVictoriasA() {
        if (partidasJugadasA == 0)
            return 0.0;
        return ((double) cantidadDePartidasGanadasA / partidasJugadasA) * 100.0;
    }

    // ----------------- GETTERS Y SETTERS TIC TAC TOE -----------------
    public int getVictoriasJugadorT() {
        return victoriasJugadorT;
    }

    public void addVictoriasJugadorT(int cantidad) {
        this.victoriasJugadorT += cantidad;
    }

    public int getVictoriasMaquinaT() {
        return victoriasMaquinaT;
    }

    public void addVictoriasMaquinaT(int cantidad) {
        this.victoriasMaquinaT += cantidad;
    }

    public int getEmpatesT() {
        return empatesT;
    }

    public void addEmpatesT(int cantidad) {
        this.empatesT += cantidad;
    }

    public int getRachaVictoriasT() {
        return rachaVictoriasT;
    }

    public void setRachaVictoriasT(int rachaVictoriasT) {
        this.rachaVictoriasT = rachaVictoriasT;
    }

    public void addRachaVictoriasT(int cantidad) {
        this.rachaVictoriasT += cantidad;
    }

    public int getRachaDerrotasT() {
        return rachaDerrotasT;
    }

    public void setRachaDerrotasT(int rachaDerrotasT) {
        this.rachaDerrotasT = rachaDerrotasT;
    }

    public void addRachaDerrotasT(int cantidad) {
        this.rachaDerrotasT += cantidad;
    }

    public void addJugadasAcumuladasT() {
        this.jugadasAcumuladasT++;
    }

    public double getPromedioJugadasT() {
        int totalPartidas = victoriasJugadorT + victoriasMaquinaT + empatesT;
        if (totalPartidas == 0)
            return 0.0;
        return (double) jugadasAcumuladasT / totalPartidas;
    }

    // ----------------- GETTERS Y SETTERS SUDOKU -----------------
    public int getPartidasGanadasS() {
        return partidasGanadasS;
    }

    public void addPartidasGanadasS(int cantidad) {
        this.partidasGanadasS += cantidad;
    }

    public int getPartidasAbandonadasS() {
        return partidasAbandonadasS;
    }

    public void addPartidasAbandonadasS(int cantidad) {
        this.partidasAbandonadasS += cantidad;
    }

    public void addPartidasJugadasS() {
        this.partidasJugadasS++;
    }

    public void addJugadasInvalidasS() {
        this.jugadasInvalidasS++;
    }

    public double getPromedioJugadasInvalidasS() {
        if (partidasJugadasS == 0)
            return 0.0;
        return (double) jugadasInvalidasS / partidasJugadasS;
    }

    public int getRecordMenosJugadasS() {
        return recordMenosJugadasS;
    }

    public void setRecordMenosJugadasS(int recordMenosJugadasS) {
        this.recordMenosJugadasS = recordMenosJugadasS;
    }
}
