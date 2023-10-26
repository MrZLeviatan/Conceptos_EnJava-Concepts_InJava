package mrzleviatan.ejercicio_01;

public class HiloServicio1 extends Thread{

	boolean runHilo;
	int contador;
	
	
	public HiloServicio1() {
		this.runHilo = true;
		this.contador = 1;
		start();

	}


	@Override
	public void run() {
		
		while(runHilo){
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Hilo servicio 1 en ejecuci�n: "+contador);
			contador++;
		}
		System.out.println("\n Hilo Servicio 1 Se Ah Detenido");
	}


	public void detener() {

		this.runHilo = false;
	}
	
}
