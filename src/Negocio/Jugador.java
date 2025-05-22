package Negocio;

/**
 *
 * @author Usuario
 */
public class Jugador extends Persona {
    
    private int saldo;
    private int cantidadCambios;
    private Carta[] myCartas=new Carta[5];

    public Jugador(String nombre, String cedula, int edad, int saldo, String telefono) {
        super(nombre, cedula, edad, telefono);
        this.saldo=saldo;
    }
    
    public int añadirSaldo(int saldoMas){
        int salida = this.saldo+saldoMas;
        return salida;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
}
