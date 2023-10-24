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

		hiloServicio4 = new Thread(this);
		starHiloServicio4(num);
		hiloServicio5 = new Thread(this, "Hilo 5");
		starHiloServicio5();
		
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
		hiloServicio3 = new HiloServicio3();
	}

	public void detenerHiloServicio3() {
		
		if(hiloServicio3 != null)
			hiloServicio3.detener();
	}

	public void starHiloServicio4(Integer num){

		hiloServicio4.start();
	}

	public void deteneHiloServicio4(){

			this.runHilo4 = false;
	}

	public void starHiloServicio5(){

		hiloServicio5.start();

	}

	public void detenerServicio5(){

			this.runHilo5 = false;
	}



	@Override
	public void run() {

		if(Thread.currentThread().equals(hiloServicio4)){

			while (runHilo4)

				try {
					synchronized (num) {
						for (int i = 1; i <= 10; i++) {
							sum = num * i;
							System.out.println(num + " x " + i + " = " + sum);
							Thread.sleep(1500);
						}
					}
				}catch (Exception e){}

        }else if(Thread.currentThread()==hiloServicio5){

			while (runHilo5)
				try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


	}
}
