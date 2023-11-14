package mrzleviatan.ejemplo_01;


import mrzleviatan.ejemplo_01.Controller.ModelFactoryControllerProductor;

import static mrzleviatan.ejemplo_01.Utils.Constantes.QUEUE_NUEVA_PUBLICACION;

public class Producer {


    public static void main(String[] args) throws InterruptedException {

        ModelFactoryControllerProductor modelFactoryControllerPorducer = ModelFactoryControllerProductor.getInstance();
        String mensaje = " ";
        mensaje += "Hola Mundo Desde RabbitMq: ";

        for (int i = 0; i < 20; i++) {

            mensaje += i;

            Thread.sleep(3000);

            modelFactoryControllerPorducer.producirMensaje(QUEUE_NUEVA_PUBLICACION, mensaje);

        }

    }
}