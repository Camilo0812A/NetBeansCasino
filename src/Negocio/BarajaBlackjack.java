/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Usuario
 */


import java.util.ArrayList;
import java.util.Random;

public class BarajaBlackjack {
    private ArrayList<Carta> cartas;

    public BarajaBlackjack() {
        cartas = new ArrayList<>();
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
        String[] palos = {"Corazones", "Diamantes", "Espadas", "Picas"};

        // Crear el mazo con todas las cartas posibles
        for (String palo : palos) {
            for (String valor : valores) {
                String imagen = "src/images/" + valor + "De" + palo + ".png";
                cartas.add(new Carta(valor, palo, imagen));
            }
        }
    }

    // Método para barajar las cartas manualmente
    public void barajar() {
        Random rand = new Random();
        int n = cartas.size();

        // Intercambiar cartas en posiciones aleatorias
        for (int i = 0; i < n; i++) {
            int j = rand.nextInt(n);
            Carta temp = cartas.get(i);
            cartas.set(i, cartas.get(j));
            cartas.set(j, temp);
        }
    }

    // Método para repartir una carta
    public Carta repartirCarta() {
        if (cartas.isEmpty()) return null; // Si no hay cartas disponibles
        return cartas.remove(0); // Quitar la carta de la lista y devolverla
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}
