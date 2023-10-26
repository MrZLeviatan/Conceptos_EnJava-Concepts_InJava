# _Ejercicio 01_

Demostrar en una interfaz creada por la libreria Fx varios botones con diferentes funcionalidades:

- En el BotonFx "Main01" imprime un conteo de 1-50 sin poder ser interrumpido.
- En el BotonFx "Main02" imprime un hola sin poder ser interrumpido.
- Hilo 1: Se implementan dos BotonesFx. En el BotonFx "Star" imprime el nombre del Hilo y
  un conteo. En el BotonFx "Stop" se detienen el proceso.
- Hilo 2: Se implementan dos BotonesFx. En el BotonFx "Star" imprime el nombre del Hilo. En
  el BotonFx "Stop" se detiene el proceso.
- Hilo 3: Se implementan dos BotonesFx. En el BotonFx "Star" imprime el nombre del Hilo con un
  conteo. En el BotonFx "Stop" se detiene el proceso.
- Hilo 4: Se pide un número por TextField y se implementan dos BotonesFx. En el BotonFx "Star"
  imprime la tabla de multiplicacion. En el BotonFx "Stop" se detiene el proceso.
- Hilo 5: Se pide un número por TextField y se implementandos BotonesFx. En el BotonFx "Star"
  imprime el doble del mismo sucesivamente. En el BotonFx "Stop" se detiene el proceso.

## _Tool_

- Java 17
- Maven
- IDE Intellij
- JavaFx 20

___

# _Class_

- ### _App01_
Muestra la visualicacion de la aplicacion mediante el Fx.

```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App01 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("VistaPrincipal.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("Ejemplo 01");
        stage.getIcons().add(new Image(App01.class.getResourceAsStream("/Images/Logo.jpg")));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
```
___

## _Hilos_

- ### _Manejador De Hilos_

    Se crea el controlador de los hilos donde también se crearan el run() del Hilo 4 y el Hilo 5.

```java

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
```


- ### _Hilo Servicio 01_

  Se crea el Hilo 1 en una clase extendida de Thread.

```java

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
        System.out.println("Hilo Servicio ` Se Ah Detenido");

    }
    
	public void detener() {
		this.runHilo = false;
	}
}
```

- ### _Hilo Servicio 02_

Se crea el Hilo 2 en una clase extendida de Threads.
```java

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
```

- ### _Hilo Servicio 03_

  Se crea el Hilo 3 en una clase extendida de Threads.

```java

public class HiloServicio3 extends Thread{

	boolean runHilo;
	int contador;
	
	
	public HiloServicio3(String nombre) {
		this.runHilo = true;
		this.contador = 1;
		start();

	}
	
	@Override
	public void run() {
		
		while(runHilo){
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Hilo servicio 3 en ejecuci�n: "+contador);
			contador++;
		}

		System.out.println("\n Hilo Servicio 3 Se Ah Detenido");

	}

	public void detener() {

		this.runHilo = false;

	}
}
```

___

## _Fx_

- ### _VistaController_

Controlador de la vista del .fxml donde se pondrán los controladores de los eventos y
diferentes objetos Fx.

```java

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import mrzleviatan.ejercicio_01.utils.TextFormatterUtil;


public class VistaController {

    ManejadorHilo manejadorHilo;


    @FXML
    private TextField txtNumero;



    @FXML
    private void initialize(){

        manejadorHilo=new ManejadorHilo();
        txtNumero.setTextFormatter(new TextFormatter<>(TextFormatterUtil :: integerFormat));
    }


    @FXML
    void eventoContar(ActionEvent event) throws InterruptedException {

        for (int contar=0; contar<=50; contar++){
            Thread.sleep(500);
            System.out.println("El recuento es: "+contar);
        }
    }

    @FXML
    void eventoImprimir(ActionEvent event) {

        System.out.println("Hola");
    }

    @FXML
    void eventoStarServicio1(ActionEvent event) {
        manejadorHilo.starHiloServicio1();

    }

    @FXML
    void eventoStarServicio2(ActionEvent event) {
        manejadorHilo.starHiloServicio2();

    }

    @FXML
    void eventoStarServicio3(ActionEvent event) {
        manejadorHilo.starHiloServicio3();
    }

    @FXML
    void eventoStopServicio1(ActionEvent event) {
        manejadorHilo.detenerHiloServicio1();
    }

    @FXML
    void eventoStopServicio2(ActionEvent event) {
        manejadorHilo.detenerHiloServicio2();
    }

    @FXML
    void eventoStopServicio3(ActionEvent event) {
        manejadorHilo.detenerHiloServicio3();
    }

    public void eventoStarServicio4(ActionEvent actionEvent) {

        Integer num = Integer.parseInt(txtNumero.getText());
        manejadorHilo.setNum(num);
        manejadorHilo.starHiloServicio4();

    }

    public void eventoStopServicio4(ActionEvent actionEvent) {
        manejadorHilo.deteneHiloServicio4();
    }

    public void eventoStarServicio5(ActionEvent actionEvent) {

        Integer num = Integer.parseInt(txtNumero.getText());
        manejadorHilo.setNum(num);
        manejadorHilo.starHiloServicio5();
    }

    public void eventoStopServicio5(ActionEvent actionEvent) {
        manejadorHilo.detenerServicio5();
    }
}
```

- ### _resources / Vista Principal.fxml_

Se crea el .fxml que sirve como interfaz gracias a la libreria Fx.

```java

// ![ImagenEjemplo](https://user-images.githubusercontent.com/117557162/278242450-1db220cc-d43f-4bc5-808c-a7035756472f.jpg)
```



