/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Usuario
 */

public class Carta {
    private String valor;
    private String palo;
    private String imagen; // Nombre del archivo de la imagen de la carta

    public Carta(String valor, String palo, String imagen) {
        this.valor = valor;
        this.palo = palo;
        this.imagen = imagen;
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getImagen() {
        return imagen;
    }
}
