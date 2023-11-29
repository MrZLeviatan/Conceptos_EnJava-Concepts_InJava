package mrzleviatan.ejercicio_01;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Servidor extends Observable implements Runnable {

    private int puerto;

    public Servidor(int puerto){

        this.puerto= puerto;
    }

    @Override
    public void run() {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;


        try {

            servidor = new ServerSocket(puerto);
            System.out.println(" El Servidor Ah Sido Invodado");

            while (true){

                sc = servidor.accept();

                System.out.println(" Usuario Conectado ");
                in = new DataInputStream(sc.getInputStream());


                String mensaje = in.readUTF();


                System.out.println(mensaje);

                //Metodos Heredado de Observable, sirven para notificar los cambios y subirlo.
                //El metodo es modo sandwich, sirven los tres en orden específico.
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();


                sc.close();
                System.out.println(" Usuario Desconectado ");


            }

        }catch (IOException ex){
            throw new RuntimeException(ex);

        }
    }
}
