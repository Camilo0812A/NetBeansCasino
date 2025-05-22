package Negocio;

public class PartidoBlackjack extends Partido{
    
    BarajaBlackjack myBaraja=new BarajaBlackjack();
    Blackjack myBlackjack=new Blackjack();
    
    public PartidoBlackjack(Jugada jugada1,Jugada jugada2, boolean juegaCasa) {
        super(jugada1, jugada2, juegaCasa);
        myBaraja.barajar();
        jugada1.getMyCartas().add(myBaraja.repartirCarta());
        jugada2.getMyCartas().add(myBaraja.repartirCarta());
        jugada1.getMyCartas().add(myBaraja.repartirCarta());
        jugada2.getMyCartas().add(myBaraja.repartirCarta());
    }
    
    String validarBlackjack(int puntaje){
        if(puntaje==21){
            return "Has ganado con un blackjack";
        }
        return "";
    }
    
    public String darCartaJ1(){
        if(super.getMyJugada1().getMyCartas().size()<5){
            super.getMyJugada1().getMyCartas().add(myBaraja.repartirCarta());
            return "";
        }
        return "Ya tienes una mano de 5 cartas";
    }
    
    public String darCartaJ2(){
        if(super.getMyJugada2().getMyCartas().size()<5){
            super.getMyJugada2().getMyCartas().add(myBaraja.repartirCarta());
            return "";
        }
        return "Ya tienes una mano de 5 cartas";
    }
    
    public void modificarPuntaje(){
        int puntaje1=0;
        for(Carta a : super.getMyJugada1().getMyCartas()){
            try{
                puntaje1+=Integer.parseInt(a.getValor());
            }catch(NumberFormatException e){
                if(a.getValor().equalsIgnoreCase("A")){
                    if(super.getMyJugada1().getPuntaje()>10){
                        puntaje1+=1;
                    }else{
                        puntaje1+=11;
                    }
                }
            }
        }
    }
    
}
