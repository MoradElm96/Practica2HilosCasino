package ejercicioCasino;

import java.util.Random;

public class HiloJugadorMartingGala implements Runnable {

	private int numero;
	private JuegoRuleta juego;

	Random random = new Random();

	public HiloJugadorMartingGala(int numero, JuegoRuleta juego) {
		this.numero = numero;
		this.juego = juego;
	}

	@Override
	public void run() {

		while (true) {

			// jugador elige un numero al azar

			int numeroQueDice = this.random.nextInt(37);
			// el jugador apuesta el numero

			System.out.println(
					"Hilo jugador " + Thread.currentThread().getName() + "apuesta por el numero " + numeroQueDice);
			juego.apostarMartingala(numero, numeroQueDice);
			// se imprimen los saldos de los jugadores y la banca
			juego.imprimirSaldos();
			try {
				// duerme el hilo durante 3 segundos
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
