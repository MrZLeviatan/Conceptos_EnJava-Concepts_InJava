package mrzleviatan.ejercicio_tcp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;

        //SIRVE PARA ENVIAR Y RECIBIR DEL SERVIDOR. En sí es la comunicacion.
        DataInputStream in;
        DataOutputStream out;


        final int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);

            System.out.println(" \n Servidor Iniciado");

            while (true) {

                //METODO PARA QUE ESPERE UNA ACTION OH USUARIO
                sc = servidor.accept();


                System.out.println(" \n Cliente iniciado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());


                //MENSAJE QUE LLEGA.
                String mensaje = in.readUTF();

                System.out.println(mensaje);

                //MENSAJE DE ENVIADO
                out.writeUTF(" Hola Mundo Desde El Servidor ");

                sc.close();

                System.out.println("\n Cliente desconectado");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}