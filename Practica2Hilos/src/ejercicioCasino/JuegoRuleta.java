package ejercicioCasino;

import java.util.Random;

public class JuegoRuleta {

	private int saldoBanca;// saldo inicial de la banca
	private int[] jugadores; // saldos iniciales de los jugadores

	public JuegoRuleta() {
		this.saldoBanca = 50000;
		this.jugadores = new int[] { 1000, 1000, 1000, 1000 };
	}

	// metodo para simular el lanzamiento de la ruleta
	Random random = new Random();

	public int lanzarRuleta() {

		int numeroRuleta = this.random.nextInt(37);//entre 0 y 36
		System.out.println("CRUPIER SACA EL NUMERO   " + numeroRuleta + " DE LA RULETA");
		return numeroRuleta;
	}

	// metodo para que los hilos apuesten a un numero concreto

	public synchronized void apostarNumeroConcreto(int jugador, int numeroApostado) {
		// si el numero apostado coincide con el numero de la ruleta

		if (numeroApostado == lanzarRuleta()) {
			System.out.println(
					"--------Jugador " + jugador + " aposto por " + numeroApostado + " Ha ACERTADO!!!--------");
			jugadores[jugador] += 360;// incrementa al jugador en concreto

			saldoBanca -= 360;

		} else {
			System.out.println("--------Jugador " + jugador + " aposto por " + numeroApostado + " Ha perdido!--------");
			jugadores[jugador] -= 10;
			saldoBanca += 10;
		}

		// si la banca se queda sin dinero finalizamos el juego
		if (saldoBanca <= 0) {
			System.out.println("El casino ha quebrado. Saldo total de la banca: " + saldoBanca + "€");
			System.exit(0);
		}
	}

	// metodo para apostar a numero par o impar
	public synchronized void apostarParImpar(int jugador, int numeroApostado, boolean tipoApuesta) {
		// si el numero apostado coincide con el numero de la ruleta

		// tiramos la ruleta
		int numeroRuleta = lanzarRuleta();

		if ((numeroRuleta % 2 == 0 && (tipoApuesta = true))) {
			// quiere decir que el numero de la ruleta es par y que el jugador juega a par
			System.out.println("--------Jugador " + jugador + "juega a par aposto por " + numeroApostado
					+ " Ha ACERTADO!!!--------");
			jugadores[jugador] += 20;// incrementa al jugador en concreto
			saldoBanca -= 20;

		} else if (numeroRuleta % 2 != 0 && (tipoApuesta = false)) {
			// si ha tocado impar y tambien el jugador juega a impar
			System.out.println("--------Jugador " + jugador + "juega a impar  aposto por " + numeroApostado
					+ " Ha ACERTADO!!!--------");
			jugadores[jugador] += 20;// incrementa al jugador en concreto
			saldoBanca -= 20;

		} else {
			System.out.println("--------Jugador " + jugador + " aposto por " + numeroApostado + " Ha perdido!--------");
			jugadores[jugador] -= 10;
			saldoBanca += 10;
		}

		// si la banca se queda sin dinero finalizamos el juego
		if (saldoBanca <= 0) {
			System.out.println("El casino ha quebrado. Saldo total de la banca: " + saldoBanca + "€");
			System.exit(0);
		}
	}

	public synchronized void apostarMartingala(int jugador, int numeroApostado) {
		// tiramos la ruleta
		int numeroRuleta = lanzarRuleta();

		if (numeroApostado == numeroRuleta) {
			System.out.println(
					"--------Jugador " + jugador + " aposto por " + numeroApostado + " Ha ACERTADO!!!--------");

			jugadores[jugador] += 360;
			this.saldoBanca -= 360;

		} else {
			System.out.println("--------Jugador " + jugador + " aposto por " + numeroApostado + " Ha perdido!--------");

			jugadores[jugador] -= 10;
			this.saldoBanca += 10;

			// juego martingala
			int apuestaActual = 10;
			while (numeroApostado != lanzarRuleta()) {
				jugadores[jugador] -= apuestaActual;
				this.saldoBanca += apuestaActual;
				apuestaActual *= 2;
				System.out.println("--------Jugador " + jugador + " aposto por " + numeroApostado
						+ " Ha vuelto a perder!--------");
				
				if(jugadores[jugador]<0) {
					System.out.println("El jugador "+ jugador + " se ha quedado sin saldo.");
					Thread.currentThread().interrupt();//problema aqui
					break;
				}

			}
			jugadores[jugador] += 360;
			this.saldoBanca -= 360;
		}

		// si la banca se queda sin dinero finalizamos el juego
		if (this.saldoBanca <= 0) {
			System.out.println("El casino ha quebrado. Saldo total de la banca: " + saldoBanca + "€");
			System.exit(0);
		}

	}

	// metodo para imprimir el saldo de la banca y los jugadores
	public synchronized void imprimirSaldos() {
		System.out.println("*******ACTUALIZACION DE SALDOS*******");
		System.out.println("* Saldo de la banca " + saldoBanca + "€");
		System.out.println("* Saldo de los jugadores: ");
		for (int i = 0; i < jugadores.length; i++) {
			System.out.println("* Jugador " + i + ": " + jugadores[i] + "€");
		}
		System.out.println("*******FIN DE ACTUALIZACION DE SALDOS*******");
	}

}
