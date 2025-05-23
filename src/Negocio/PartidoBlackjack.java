package Negocio;

import Vista.Ventana;

public class PartidoBlackjack extends Partido {

    BarajaBlackjack myBaraja = new BarajaBlackjack();
    Blackjack myBlackjack = new Blackjack();
    int totalApuesta=super.getMyJugada1().getApuestaJugador()+super.getMyJugada2().getApuestaJugador();

    public PartidoBlackjack(Jugada jugada1, Jugada jugada2, boolean juegaCasa) {
        super(jugada1, jugada2, juegaCasa);
        myBaraja.barajar();
        darCartaJ1();
        darCartaJ2();
        darCartaJ1();
        darCartaJ2();
    }

    String validarBlackjack() {
        if (super.getMyJugada1().getPuntaje() == 21) {
            return "El jugador 1 ha ganado con un blackjack";
        }
        if (super.getMyJugada2().getPuntaje() == 21) {
            return "El jugador 2 ha ganado con un blackjack";
        }
        return "";
    }

    public String darCartaJ1() {
        if (super.getMyJugada1().getMyCartas().size() < 5) {
            Carta temp = myBaraja.repartirCarta();
            super.getMyJugada1().getMyCartas().add(temp);
            try {
                super.getMyJugada1().setPuntaje(super.getMyJugada1().getPuntaje() + Integer.parseInt(temp.getValor()));
            } catch (NumberFormatException e) {
                if (temp.getValor().equalsIgnoreCase("A")) {
                    if (super.getMyJugada1().getPuntaje() > 10) {
                        super.getMyJugada1().setPuntaje(super.getMyJugada1().getPuntaje() + 1);
                    } else {
                        super.getMyJugada1().setPuntaje(super.getMyJugada1().getPuntaje() + 11);
                    }
                } else {
                    super.getMyJugada1().setPuntaje(super.getMyJugada1().getPuntaje() + 10);
                }
            }
            System.out.println(super.getMyJugada1().getPuntaje());
            if (super.getMyJugada1().getPuntaje() == 21) {
                return "Has obtenido 21";
            }
            if (super.getMyJugada1().getPuntaje() > 21) {
                return "Te has pasado de 21";
            }
            return "";
        }
        return "Ya tienes una mano de 5 cartas";
    }

    public String darCartaJ2() {
        if (super.getMyJugada2().getMyCartas().size() < 5) {
            Carta temp = myBaraja.repartirCarta();
            super.getMyJugada2().getMyCartas().add(temp);
            try {
                super.getMyJugada2().setPuntaje(super.getMyJugada2().getPuntaje() + Integer.parseInt(temp.getValor()));
            } catch (NumberFormatException e) {
                if (temp.getValor().equalsIgnoreCase("A")) {
                    if (super.getMyJugada2().getPuntaje() > 10) {
                        super.getMyJugada2().setPuntaje(super.getMyJugada2().getPuntaje() + 1);
                    } else {
                        super.getMyJugada2().setPuntaje(super.getMyJugada2().getPuntaje() + 11);
                    }
                } else {
                    super.getMyJugada2().setPuntaje(super.getMyJugada2().getPuntaje() + 10);
                }
            }
            System.out.println(super.getMyJugada2().getPuntaje());
            return "";
        }
        return "Ya tienes una mano de 5 cartas";
    }

    public String finalizarPartido() {
    int puntaje1 = super.getMyJugada1().getPuntaje();
    int puntaje2 = super.getMyJugada2().getPuntaje();
    int apuesta1 = super.getMyJugada1().getApuestaJugador();
    int apuesta2 = super.getMyJugada2().getApuestaJugador();

    int montoTotal = apuesta1 + apuesta2;

    if (puntaje1 > puntaje2) {
        super.setGanador(super.getMyJugada1().getMyJugador());
        super.setPerdedor(super.getMyJugada2().getMyJugador());

        Jugador ganador = (Jugador) super.getGanador();
        ganador.setSaldo(ganador.getSaldo() + montoTotal);

        if (super.getMyJugada2().getMyJugador() instanceof Jugador jugadorPerdedor) {
            jugadorPerdedor.setSaldo(jugadorPerdedor.getSaldo() - apuesta2);
        } else if (super.getMyJugada2().getMyJugador() instanceof Crupier) {
            super.setCuentasParaLaCasa(-apuesta2);
        } else {
            super.setCuentasParaLaCasa(0);
        }

    } else if (puntaje1 < puntaje2) {
        super.setGanador(super.getMyJugada2().getMyJugador());
        super.setPerdedor(super.getMyJugada1().getMyJugador());

        if (super.getGanador() instanceof Jugador ganador) {
            ganador.setSaldo(ganador.getSaldo() + montoTotal);
            super.setCuentasParaLaCasa(0);
        } else if (super.getGanador() instanceof Crupier) {
            super.setCuentasParaLaCasa(apuesta1);
        }

        Jugador jugadorPerdedor = (Jugador) super.getMyJugada1().getMyJugador();
        jugadorPerdedor.setSaldo(jugadorPerdedor.getSaldo() - apuesta1);

    } else {
        super.setCuentasParaLaCasa(0);
        return "Empate: No hay ganador ni perdedor. Las apuestas se devuelven./0";
    }

    return "Ganador: " + super.getGanador().getNombre() +
           "\nPerdedor: " + super.getPerdedor().getNombre() +
           "\nSe han transferido $" + montoTotal + " al saldo del ganador./" +
           super.getCuentasParaLaCasa();
}



}
