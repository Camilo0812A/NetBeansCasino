/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
/**
 *
 * @author estudiante
 */
public class Jugada {
    private Persona myJugador;
    private int apuestaJugador;
    private ArrayList<Carta> myCartas=new ArrayList<>();
    private int puntaje;
    
    public Jugada(Jugador myJugador, int apuestaJugador) {
        this.myJugador = myJugador;
        this.apuestaJugador = apuestaJugador;
    }
    
    public Jugada(Crupier myJugador, int apuestaJugador) {
        this.myJugador = myJugador;
        this.apuestaJugador = apuestaJugador;
    }
    
    

    public Persona getMyJugador() {
        return myJugador;
    }

    public void setMyJugador(Persona myJugador) {
        this.myJugador = myJugador;
    }

    public int getApuestaJugador() {
        return apuestaJugador;
    }

    public void setApuestaJugador(int apuestaJugador) {
        this.apuestaJugador = apuestaJugador;
    }

    public ArrayList<Carta> getMyCartas() {
        return myCartas;
    }

    public void setMyCartas(ArrayList<Carta> myCartas) {
        this.myCartas = myCartas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    

    
    
}

