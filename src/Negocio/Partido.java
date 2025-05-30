package Negocio;

public abstract class Partido {
   
    private Jugada myJugada1;
    private Jugada myJugada2;
    private boolean juegaLaCasa;
    private Persona ganador;
    private Persona perdedor;
    private int cuentasParaLaCasa;
    private String estado="Vigente";

    public Partido(Jugada jugada1, Jugada jugada2, boolean juegaCasa) {
        this.myJugada1 = jugada1;
        this.myJugada2 = jugada2;
        this.juegaLaCasa=juegaCasa;
        
    }

    public Jugada getMyJugada1() {
        return myJugada1;
    }

    public void setMyJugada1(Jugada myJugada1) {
        this.myJugada1 = myJugada1;
    }

    public Jugada getMyJugada2() {
        return myJugada2;
    }

    public void setMyJugada2(Jugada myJugada2) {
        this.myJugada2 = myJugada2;
    }

    public boolean isJuegaLaCasa() {
        return juegaLaCasa;
    }

    public void setJuegaLaCasa(boolean juegaLaCasa) {
        this.juegaLaCasa = juegaLaCasa;
    }

    public Persona getGanador() {
        return ganador;
    }

    public void setGanador(Persona ganador) {
        this.ganador = ganador;
    }

    public Persona getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(Persona perdedor) {
        this.perdedor = perdedor;
    }

    public int getCuentasParaLaCasa() {
        return cuentasParaLaCasa;
    }

    public void setCuentasParaLaCasa(int cuentasParaLaCasa) {
        this.cuentasParaLaCasa = cuentasParaLaCasa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
