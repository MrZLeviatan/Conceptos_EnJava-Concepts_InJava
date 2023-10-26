package mrzleviatan.ejercicio_01;

public class ManejadorHilo implements Runnable {

	private Integer num;
	private int sum;
	boolean runHilo4, runHilo5;

	HiloServicio1 hiloServicio1;
	HiloServicio2 hiloServicio2;
	HiloServicio3 hiloServicio3;

	Thread hiloServicio4;

	Thread hiloServicio5;
	
	
	public ManejadorHilo() {

		hiloServicio4 = new Thread(this, "Hilo 4");
		hiloServicio5 = new Thread(this, "Hilo 5");
		
	}

	public void starHiloServicio1() {
		hiloServicio1 = new HiloServicio1();

	}

	public void detenerHiloServicio1() {
		
		if(hiloServicio1 != null)
			hiloServicio1.detener();
	}
	
	public void starHiloServicio2() {
		hiloServicio2 = new HiloServicio2();
	}

	public void detenerHiloServicio2() {
		
		if(hiloServicio2 != null)
			hiloServicio2.detener();
	}
	
	public void starHiloServicio3() {
		hiloServicio3 = new HiloServicio3("Hilo 3");
	}

	public void detenerHiloServicio3() {
		
		if(hiloServicio3 != null)
			hiloServicio3.detener();
	}

	public void starHiloServicio4(){

		runHilo4 = true;
		hiloServicio4 = new Thread(this, "Hilo 4");
		hiloServicio4.start();
		System.out.println(hiloServicio4.getName() + " Ah Iniciado");

	}

	public void deteneHiloServicio4(){

			this.runHilo4 = false;
			hiloServicio4.interrupt();
			System.out.println(hiloServicio4.getName() + " Ah Sido Detenido");
			run();
	}

	public void starHiloServicio5(){

		this.runHilo5 = true;
		hiloServicio5 = new Thread(this, "Hilo 5");
		hiloServicio5.start();
		System.out.println(hiloServicio5.getName() + " Ah Iniciado");

	}

	public void detenerServicio5(){

			this.runHilo5 = false;
			hiloServicio5.interrupt();
			System.out.println(hiloServicio5.getName() + " Ah Sido Detenido");
			run();
	}

	public  void setNum(int num){

		this.num = num;
	}


	@Override
	public void run() {

		Thread hiloActivo = Thread.currentThread();
		if(hiloActivo == hiloServicio5 || runHilo5 == true) {

			while (runHilo5) {

				try {


					while (runHilo5) {

						System.out.println("El doble de " + num + " es : " + num * num);
						num = num*num;
						Thread.sleep(1500);
					}


				} catch (Exception e) {
				}
			}


		}else if(hiloActivo == hiloServicio4 || runHilo4 == true){

			while (runHilo4){

				try {

					synchronized (num){
						int i = 1;
						while (runHilo4){
							sum=num*i;
							System.out.println(num + " x " + i + " = " +sum);
							Thread.sleep(1500);
							i +=1;
						}
					}
				}catch (Exception e){}
			}
		}
	}
}
