package ejercicioCasino;

import java.util.Random;

public class HiloJugadorImparPar implements Runnable {

	private int numero;
	private JuegoRuleta juego;
	boolean tipoApuesta; // true para par y false para impar

	Random random = new Random();

	public HiloJugadorImparPar(int numero, JuegoRuleta juego, boolean tipoApuesta) {
		this.numero = numero;
		this.juego = juego;
		this.tipoApuesta = tipoApuesta;
	}

	@Override
	public void run() {

		while (true) {

			// jugador elige un numero al azar entre 1 y 36

			int numeroQueDice = this.random.nextInt(36)+1;
			// el jugador apuesta el numero

			if (numeroQueDice % 2 == 0) {
				// es par
				this.tipoApuesta = true;
				System.out.println("Hilo jugador " + Thread.currentThread().getName() + "apuesta por el numero PAR "
						+ numeroQueDice);

			} else {
				// ES IMPAR
				this.tipoApuesta = false;
				System.out.println("Hilo jugador " + Thread.currentThread().getName() + "apuesta por el numero IMPAR "
						+ numeroQueDice);
			}

			juego.apostarParImpar(numero, numeroQueDice, tipoApuesta);
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
