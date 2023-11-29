package mrzleviatan.ejercicio_01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente implements Runnable{

    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje){

        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {

        final String HOST = "127.0.0.1";

        DataOutputStream out;


        try {

            Socket sc = new Socket(HOST,puerto);

            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(mensaje);

            sc.close();



        }catch (IOException ex){

            throw new RuntimeException(ex);

        }

    }
}
