# _Ejercicio UDP:_

La conexion UDP (User Datagram Protocol) es un protocolo de transporte sin conexion y no
orientado a la conexion. Esto significa que no hay establecimiento de conexion antes
de la transferencia de datos, y no se garantiza la entrega ordenada y sin errores de los
datos. 


<p align="center">
  <img src="https://user-images.githubusercontent.com/117557162/282655641-a1907e8e-272d-4025-9ae7-a07d51775e5a.jpg" />
</p>

## _Problematica_
En este ejemplo se demuestra una conexion UDP "Cliente" y "Servidor".

## _Tool_

- Java 17
- Maven
- IDE Intellij

____

# _Classes_

Se ejecuta primero el Servidor, posteriormente el Cliente.


### _Class Servidor:_

Servidor UDP del programa.

```java
public class Servidor {

    public static void main (String[] args){
        
        
        final int PUERTO = 5000;

        byte[] buffer = new byte[1024];


        try {
            System.out.println("\n Servidor UDP ah sido Invocado");

            DatagramSocket socketUDP = new DatagramSocket(PUERTO);


            while (true)

                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                socketUDP.receive(peticion);

                System.out.println("\n -Se ah recibido la informacion del Cliente:");


                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);


                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                
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
```
### _Class Cliente:_

Cliente para ingresar al servidor.

```java
public class Cliente {


    public static void main (String[] args){

        final int PUERTO_SERVIDOR = 5000;

        byte[] buffer = new byte[1024];

        try {

            InetAddress direccionServidor = InetAddress.getByName("localhost");

            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = "!Hola mundo desde el Cliente!";

            buffer = mensaje.getBytes();
            
            DatagramPacket pregunta = new DatagramPacket(buffer,buffer.length, direccionServidor, PUERTO_SERVIDOR);

            System.out.println(" -Se envia el datagrama");
            socketUDP.send(pregunta);


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
```


