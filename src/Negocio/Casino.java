/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Casino {

    private ArrayList<Persona> myPersonas = new ArrayList<>();
    private ArrayList<Partido> myPartidos = new ArrayList<>();
    private Crupier crupierEncargado;

    public Casino() {
    }

    public ArrayList<Jugador> getJugadores() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (Persona p : myPersonas) {
            if (p instanceof Jugador) {
                jugadores.add((Jugador) p);
            }
        }
        return jugadores;
    }

    public String registrarJugador(String nombre, String cedula, int edad, int saldoInicial, String telefono) {
        if (edad < 18) {
            return "Necesitas tener al menos 18 años";
        } else if (saldoInicial < 50000) {
            return "Monto inicial minimo de 50000";
        }
        for (Persona j : myPersonas) {
            if (j.getCedula().equalsIgnoreCase(cedula)) {
                return "Esa cedula ya está registrada.";
            }
        }
        Jugador nuevo = new Jugador(nombre, cedula, edad, saldoInicial, telefono);
        myPersonas.add(nuevo);
        return "Registro exitoso";
    }

    public String registrarCrupier(String nombre, String cedula, int edad, String telefono) {
        for (Persona j : myPersonas) {

            if (j.getCedula().equalsIgnoreCase(cedula)) {
                return "Esa cedula ya está registrada.";
            }
        }

        if (edad < 18) {
            return "Necesitas tener al menos 18 años";
        }

        myPersonas.add(new Crupier(nombre, cedula, edad, telefono));
        return "Registro exitoso";
    }

    public String asignarCrupier(String cedula) {
        for (Persona c : myPersonas) {
            if (c instanceof Crupier) {
                if (c.getCedula().equalsIgnoreCase(cedula)) {
                    this.crupierEncargado = (Crupier) c;
                    return "Se ha encargado correctamente a " + c.getNombre() + " como crupier encargado.";
                }
            }
        }
        return "No se ha encontrado ningun crupier con esa cedula.";
    }

    public String mostrarCrupiers() {
        String cad = "";
        for (Persona a : myPersonas) {
            if (a instanceof Crupier) {
                cad += ((Crupier) a).mostrar() + "\n"; // o algún separador
            }
        }
        if (cad.isEmpty()) {
            return "No hay crupiers.";
        }
        return cad;

    }

    public String despedirCrupier(String cedula) {
        for (Persona c : myPersonas) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                String salida = "Se ha despedido al crupier " + c.getNombre() + ".";
                if (c == this.crupierEncargado) {
                    crupierEncargado = null;
                }
                myPersonas.remove(c);
                return salida;
            }
        }
        return "Quien es ese we.";
    }

    private Jugador buscarJugadorPorCedula(String cedula) {
        for (Persona p : myPersonas) {
            if (p instanceof Jugador && p.getCedula().equalsIgnoreCase(cedula)) {
                return (Jugador) p;
            }
        }
        return null;
    }

    public String nuevoPartido(String cedula1, String cedula2, int apuesta1, int apuesta2, String juego, boolean juegaCasa) {
        Jugador jugador1 = buscarJugadorPorCedula(cedula1);
        Persona jugador2 = buscarJugadorPorCedula(cedula2);

        if (juegaCasa) {
            jugador2 = crupierEncargado;
        }

        if (jugador1 == null) {
            return "La cedula 1 no corresponde a ningun jugador";
        }

        if (juegaCasa) {
            if (juego.equalsIgnoreCase("Blackjack")) {
                if (apuesta1 < 50000 || apuesta1 > 500000) {
                    return "Recordatorio: La apuesta para blackjack debe ser de minimo 50000 y maximo 500000";
                }
                myPartidos.add(new PartidoBlackjack(new Jugada(jugador1, apuesta1), new Jugada((Crupier) jugador2, apuesta2), juegaCasa));
                return "Partido contra crupier.";
            }
            return "Proximamente.";
        } else {
            if (jugador2 == null) {
                return "La cedula 2 no corresponde a ningun jugador";
            }
            if (juego.equalsIgnoreCase("Blackjack")) {
                if (apuesta1 < 50000 || apuesta1 > 500000 || apuesta2 < 50000 || apuesta2 > 500000) {
                    return "Recordatorio: La apuesta para blackjack debe ser de minimo 50000 y maximo 500000";
                }
                if (apuesta1 != apuesta2) {
                    return "Recordatorio: En el blackjack, las apuestas deben ser iguales";
                }
                myPartidos.add(new PartidoBlackjack(new Jugada(jugador1, apuesta1), new Jugada((Jugador) jugador2, apuesta2), juegaCasa));
                return "Partido entre 2 jugadores.";
            }
            return "Proximamente.";
        }
    }

    public boolean confirmarContraseñaAdmin(String contraseña) {

        if (contraseña.equalsIgnoreCase("Pingos123")) {
            return true;
        }
        return false;
    }

    public boolean revisarJugadorRegistrado(String cedula) {
        for (Persona p : myPersonas) {
            if (p.getCedula().equalsIgnoreCase(cedula)) {
                return true;
            }
        }
        return false;
    }

    public String noRepetirCedula(String cedula1, String cedula2) {
        String rec = "";
        if (cedula1.equalsIgnoreCase(cedula2)) {
            rec = "La cedula del jugador 1 es igual a la del jugador 2";
        }
        return rec;
    }

    public String mostrarCrupierEncargado() {
        return crupierEncargado.getNombre();
    }

    public boolean hayCrupierEncargado() {
        if (crupierEncargado == null) {
            return false;
        }
        return true;
    }

    public String enviarInfoPartido() {
        return myPartidos.getLast().getMyJugada1().getMyJugador().getNombre() + "/"
                + myPartidos.getLast().getMyJugada2().getMyJugador().getNombre() + "/"
                + myPartidos.getLast().getMyJugada1().getApuestaJugador() + "/"
                + myPartidos.getLast().getMyJugada1().getApuestaJugador() + "/"
                + myPartidos.size() + "/" + ((myPartidos.getLast().isJuegaLaCasa()) ? "0" : "1");
    }

    public String mostrarCartas() {
        String cad = "";
        for (Carta a : myPartidos.getLast().getMyJugada1().getMyCartas()) {
            if (a != null) {
                cad += a.getImagen() + "/";
                continue;
            }
            cad += "/";
        }
        for (Carta a : myPartidos.getLast().getMyJugada2().getMyCartas()) {
            if (a != null) {
                cad += a.getImagen() + "/";
                continue;
            }
            cad += "/";
        }
        return cad;
    }

    public String pedirCartaBlackjack(String jugador) {
        if (jugador.equalsIgnoreCase("1")) {
            return ((PartidoBlackjack) myPartidos.getLast()).darCartaJ1();
        }
        if (jugador.equalsIgnoreCase("2")) {
            return ((PartidoBlackjack) myPartidos.getLast()).darCartaJ2();
        }
        return "";
    }

    public boolean puedeJugarTurnoCrupier() {
        if (myPartidos.getLast().getMyJugada2().getMyCartas().size() < 5) {
            return ((Crupier) myPartidos.getLast().getMyJugada2().getMyJugador()).pedirCarta(myPartidos.getLast().getMyJugada2().getPuntaje());
        }
        return false;
    }
    
    public boolean plantarJugador1(){
        if(myPartidos.getLast().isJuegaLaCasa()){
            boolean jugarCrupier=puedeJugarTurnoCrupier();
            while(jugarCrupier==true){
                jugarCrupier=puedeJugarTurnoCrupier();
            }
            return true;
        }
        return false;
    }

    public ArrayList<Persona> getMyPersonas() {
        return myPersonas;
    }

    public void setMyPersonas(ArrayList<Persona> myPersonas) {
        this.myPersonas = myPersonas;
    }

    public Crupier getCrupierEncargado() {
        return crupierEncargado;
    }

    public void setCrupierEncargado(Crupier crupierEncargado) {
        this.crupierEncargado = crupierEncargado;
    }

}
