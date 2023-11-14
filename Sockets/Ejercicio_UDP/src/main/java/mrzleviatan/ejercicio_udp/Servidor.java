package mrzleviatan.ejercicio_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

    public static void main (String[] args){

        //Puerto Del Servidor.
        final int PUERTO = 5000;

        //Buffer donde se almacenara los mensajes
        byte[] buffer = new byte[1024];


        try {
            System.out.println("\n Servidor UDP ah sido Invocado");

            //Creacion del socket.
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);


            //Se pone en un while para que el servidor se mantenga abierto.
            while (true) {

                //Se recibe la información del que se contacta.

                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                socketUDP.receive(peticion);

                System.out.println("\n -Se ah recibido la informacion del Cliente:");


                //Convierto lo recibido para mostrar el mensaje.
                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);


                // Se obtiene el puerto del que se contacta al server.
                // Se obtiene la direccion del que contacta al server.
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();


                //Se envia un mensaje al contactado.

                mensaje = " -!Hola mundo desde el servidor!";
                buffer = mensaje.getBytes();

                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

                System.out.println("\n -Se ah enviado la informacion al Cliente");
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {

            throw new RuntimeException(e);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }


    }

}
