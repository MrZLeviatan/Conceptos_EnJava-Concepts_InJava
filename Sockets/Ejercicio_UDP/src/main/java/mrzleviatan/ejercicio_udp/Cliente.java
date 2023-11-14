package mrzleviatan.ejercicio_udp;


import java.io.IOException;
import java.net.*;

public class Cliente {


    public static void main (String[] args){

        //Puerto del servidor.
        final int PUERTO_SERVIDOR = 5000;

        //Buffer donde se almacenara los mensajes.
        byte[] buffer = new byte[1024];

        try {

            //Obtengo la localizacion de localhost.
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            //Creacion del socket de UDP.
            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = "!Hola mundo desde el Cliente!";

            //Convierto el mensaje en bytes,
            buffer = mensaje.getBytes();

            //Sirve para enviar el mensaje al servidor.
            DatagramPacket pregunta = new DatagramPacket(buffer,buffer.length, direccionServidor, PUERTO_SERVIDOR);

            System.out.println(" -Se envia el datagrama");
            socketUDP.send(pregunta);


            //Se recibe un mensaje del servidor.
            DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);

            socketUDP.receive(peticion);
            System.out.println(" -Se ah recibido un mensaje del servidor");

            mensaje = new String(peticion.getData());

            System.out.println(mensaje);

            socketUDP.close();


        } catch (SocketException e) {
            throw new RuntimeException(e);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

