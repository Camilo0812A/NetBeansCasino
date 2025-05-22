package Negocio;

public class Blackjack {
    
    public Blackjack(){
        
    }
    
    public boolean youWin(int valor1, int valor2, int valor3, int valor4, int valor5){
        if(valor3==0&&valor4==0&&valor5==0){
            if((valor1+valor2)==21){
            return true;
        }
        } else if(valor4==0&&valor5==0){
            if((valor1+valor2+valor3)==21){
            return true;
        }
        } else if(valor5==0){
            if((valor1+valor2+valor3+valor4)==21){
            return true;
        }
        } else if(valor1!=0&&valor2!=0&&valor3!=0&&valor4!=0&&valor5!=0){
            if((valor1+valor2+valor3+valor4+valor5)==21){
            return true;
        }
        }
        return false;
    }
    public String compararPuntaje(int puntaje1, int puntaje2){
        if(puntaje1 > puntaje2){
            return "Ganador jugador1";
        }
        return "Ganador jugador2";
    }
    public boolean youLose(int valor1, int valor2, int valor3, int valor4, int valor5){
        if(valor3==0&&valor4==0&&valor5==0){
            if((valor1+valor2)>21){
            return true;
        }
        } else if(valor4==0&&valor5==0){
            if((valor1+valor2+valor3)>21){
            return true;
        }
        } else if(valor5==0){
            if((valor1+valor2+valor3+valor4)>21){
            return true;
        }
        } else if(valor1!=0&&valor2!=0&&valor3!=0&&valor4!=0&&valor5!=0){
            if((valor1+valor2+valor3+valor4+valor5)>21){
            return true;
        }
        }
        return false;
    }
}
