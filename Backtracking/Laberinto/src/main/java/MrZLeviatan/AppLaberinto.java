package MrZLeviatan;


import java.util.ArrayList;
import java.util.List;

public class AppLaberinto {

	private List <char[][]> soluciones = new ArrayList<>();

	public char[][] laberinto = {

			{'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', '#'},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
			{' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#'},
			{' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
			{'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
			{'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' '},
			{'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
			{'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
			{'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
			{'#', '#', '#', '#', ' ', ' ', ' ', '#', '#', '#'},
	};


	public static void main(String[] args) {

		AppLaberinto m = new AppLaberinto(); 												// construimos un objeto de la clase AppLaberinto por defecto
		m.laberinto[1][1] = 'X'; 													// introducimos en este caso, la salida (X) en las coordenadas (1,1)
		m.resuelve(5, 6);
		m.imprimirSolutions();// imprimimos el laberinto ya resuelto (si tiene solución)
	}


	public void resuelve(int x, int y){				// permite introducir unas coordenadas (x, y)
		paso(x, y);
	}
	//X= FILA Y=COLUMNA
	private void paso(int x, int y)
	{

		if (laberinto[x][y]=='X'){ // si hemos llegado a X quiere decir que hemos encontrado solución
			char[][] solution = copyLaberinto();
			soluciones.add(solution);
			return;
		}


		if (laberinto[x][y]=='#'||laberinto[x][y]=='*' ||laberinto[x][y]=='f') { // si llegamos a una pared o al mismo punto,
			return; // entonces el laberinto no puede resolverse y termina.
		}

		int numRows = laberinto.length;
		int numCols = laberinto[0].length;


		// si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
		// caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
		laberinto[x][y]='*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y

		boolean result = false; //

		// Verificar límites antes de moverse


		// Esta línea verifica si es seguro moverse hacia la DERECHA.
		// Si x (la fila actual) está dentro de los límites del laberinto, y si aumentar y en 1 (moverse hacia la derecha)
		// también está dentro de los límites del laberinto, entonces es seguro hacerlo.
		if (x >= 0 && x < numRows && y + 1 >= 0 && y + 1 < numCols) {
			paso(x, y + 1);
		}

		//Esta línea verifica si es seguro moverse hacia ARRIBA.
		// Si x menos 1 (moverse hacia arriba) todavía está dentro de los límites del laberinto,
		// y y está dentro de los límites del laberinto, entonces es seguro hacerlo.
		if (x - 1 >= 0 && x - 1 < numRows && y >= 0 && y < numCols) { //Arriba
			paso(x - 1, y);
		}

		// Esta línea verifica si es seguro moverse hacia la IZQUIERDA.
		// Similar al primer caso, verifica si x está dentro de los límites y si disminuir
		// y en 1 (moverse hacia la izquierda) está dentro de los límites.
		if (x >= 0 && x < numRows && y - 1 >= 0 && y - 1 < numCols) { //Izquierda
			paso(x, y - 1);
		}

		// Esta línea verifica si es seguro moverse hacia abajo. Al igual que los otros casos,
		// verifica si aumentar x en 1 (moverse hacia abajo) está dentro de los límites y si y está dentro de los límites.
		if (x + 1 >= 0 && x + 1 < numRows && y >= 0 && y < numCols) { //Abajo
			paso(x + 1, y);
		}

		laberinto[x][y] = ' ';

	}

	private char[][] copyLaberinto() {
		char[][] copy = new char[laberinto.length][laberinto[0].length];
		for (int i = 0; i < laberinto.length; i++) {
			System.arraycopy(laberinto[i], 0, copy[i], 0, laberinto[i].length);
		}
		return copy;
	}

	private void imprimirSolutions() {
		if (soluciones.isEmpty()) {
			System.out.println("No hay soluciones.");
			return;
		}

		System.out.println("Todas las soluciones:");
		for (int i = 0; i < soluciones.size(); i++) {
			char[][] solution = soluciones.get(i);
			System.out.println("Solucion " + (i + 1) + ":");
			for (char[] row : solution) {
				for (char cell : row) {
					System.out.print(cell + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}


}