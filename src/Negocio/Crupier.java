package Negocio;


public class Crupier extends Persona{
    
    private int balanceDinero;
    
    public Crupier(String nombre, String cedula, int edad, String telefono) {
        super(nombre, cedula, edad, telefono);
    }
    
    public boolean pedirCarta(int puntaje){
        if(puntaje>=17){
            return false;
        }
        return true;
    }
    
    public String mostrar(){
        return "nombre: "+super.nombre+"\ncedula: "+super.cedula+"\nedad: "+super.edad+"\nTelefono: "+super.telefono+"\nBalance para la casa: "+this.balanceDinero+"\n";
    }
}