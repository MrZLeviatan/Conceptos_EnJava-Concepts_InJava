# _Ejercicio TCP:_

La conexion TCP (Transmission Control Protocol) es un protocolo de comunicacion el cual el
servidor conoce quien está conectado mediante puertos de conexion. 


## _Problematica_
En este ejemplo se demuestra una conexion entre "Cliente" y "Servidor".

## _Tool_

- Java 17
- Maven
- IDE Intellij

____

# _Classes_

Se ejecuta primero el Servidor, posteriormente el Cliente.

### _Class Servidor:_

Servidor TCP del programa.

```java
public class Servidor {

    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        
        DataInputStream in;
        DataOutputStream out;


        final int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);

            System.out.println(" \n Servidor Iniciado");

            while (true) {
                
                
                sc = servidor.accept();
                
                System.out.println(" \n Cliente iniciado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());


                String mensaje = in.readUTF();

                System.out.println(mensaje);
                
                out.writeUTF(" Hola Mundo Desde El Servidor ");

                sc.close();

                System.out.println("\n Cliente desconectado");

            }
            
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

    public static void main (String [] args){


        final String HOST = "127.0.0.1";
        final int PUERTO =  5000;
        DataInputStream in;
        DataOutputStream out;


        try {
            
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(" \n Hola desde el cliente");

            String mensaje = in.readUTF();

            System.out.println(mensaje);

            sc.close();


        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
```