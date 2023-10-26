package mrzleviatan.ejercicio_01;

public class HiloServicio2 extends Thread{

	boolean runHilo;
	int contador;
	
	
	public HiloServicio2() {
		this.runHilo = true;
		this.contador = 1;
		start();
	}
	
	
	@Override
	public void run() {
		
		while(runHilo){
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Hilo servicio 2 en ejecuci�n..................");
			contador++;
		}
		System.out.println(" \n Hilo 2 Se Ah Detenido");
	}

	public void detener() {
		this.runHilo = false;
	}
}
