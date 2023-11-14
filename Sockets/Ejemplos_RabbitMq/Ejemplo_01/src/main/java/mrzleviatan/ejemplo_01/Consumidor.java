package mrzleviatan.ejemplo_01;


import mrzleviatan.ejemplo_01.Controller.ModelFactoryControllerConsumidor;

public class Consumidor {

    public static void main (String[] args){

        ModelFactoryControllerConsumidor modelFactoryController = ModelFactoryControllerConsumidor.getInstance();
        modelFactoryController.consumirMensajeSercicio1();

    }



}
