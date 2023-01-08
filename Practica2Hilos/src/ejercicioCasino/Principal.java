package ejercicioCasino;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		JuegoRuleta juego = new JuegoRuleta();
		
		Scanner sc = new Scanner(System.in);
		
		int opcion;
		
		//menu para elegir opciones de simulacion de  juego
	    do {
            System.out.println("\nBienvenido al Casino de Morad . Introduce una opción: ");
            System.out.println("1. Jugar a numero concreto");
            System.out.println("2. Jugar a par o impar");
            System.out.println("3. Jugar a martin gala");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido Jugar a numero concreto");
                    		
                    		lanzarJugarAunNumero(juego);
                    break;
                case 2:
                    System.out.println("Has elegido Jugar a par o impar");
                			lanzarJugarParImpar(juego);
                    
                    break;
                case 3:
                    System.out.println("Has elegido Jugar a martin gala");
                    
                    		lanzarJuegoMartingala(juego);
            		
                    
                    break;
                case 0:
                    System.out.println("Has elegido salir, hasta pronto");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
		
		
		
        

	}

	//metodo que lanza jugar a un numero concreto o primera estrategia
	private static void lanzarJugarAunNumero(JuegoRuleta juego) {
		HiloJugadorNumConcreto jugador1 = new HiloJugadorNumConcreto(0,juego);
		HiloJugadorNumConcreto jugador2 = new HiloJugadorNumConcreto(1,juego);
		HiloJugadorNumConcreto jugador3 = new HiloJugadorNumConcreto(2,juego);
		HiloJugadorNumConcreto jugador4 = new HiloJugadorNumConcreto(3,juego);
		Thread Tjugador1 = new Thread(jugador1);
		Thread Tjugador2 = new Thread(jugador2);
		Thread Tjugador3 = new Thread(jugador3);
		Thread Tjugador4 = new Thread(jugador4);
		Tjugador1.start();
		Tjugador2.start();
		Tjugador3.start();
		Tjugador4.start();
	}

	
	//metodo que lanza jugar par o impar o segunda estrategia
	private static void lanzarJugarParImpar(JuegoRuleta juego) {
		
		boolean tipoApuesta = false;//inicializamos
		
		HiloJugadorImparPar jugador1 = new HiloJugadorImparPar(0,juego,tipoApuesta);
		HiloJugadorImparPar jugador2 = new HiloJugadorImparPar(1,juego,tipoApuesta);
		HiloJugadorImparPar jugador3 = new HiloJugadorImparPar(2,juego,tipoApuesta);
		HiloJugadorImparPar jugador4 = new HiloJugadorImparPar(3,juego,tipoApuesta);
		Thread Tjugador1 = new Thread(jugador1);
		Thread Tjugador2 = new Thread(jugador2);
		Thread Tjugador3 = new Thread(jugador3);
		Thread Tjugador4 = new Thread(jugador4);
		Tjugador1.start();
		Tjugador2.start();
		Tjugador3.start();
		Tjugador4.start();
	}

	
	//metodo que implementa el modo de juego martingala
	private static void lanzarJuegoMartingala(JuegoRuleta juego) {
		
		HiloJugadorMartingGala jugador1 = new HiloJugadorMartingGala(0,juego);
		HiloJugadorMartingGala jugador2 = new HiloJugadorMartingGala(1,juego);
		HiloJugadorMartingGala jugador3 = new HiloJugadorMartingGala(2,juego);
		HiloJugadorMartingGala jugador4 = new HiloJugadorMartingGala(3,juego);
		Thread Tjugador1 = new Thread(jugador1);
		Thread Tjugador2 = new Thread(jugador2);
		Thread Tjugador3 = new Thread(jugador3);
		Thread Tjugador4 = new Thread(jugador4);
		Tjugador1.start();	
		Tjugador2.start();	
		Tjugador3.start();	
		Tjugador4.start();
	}

}
