package mrzleviatan.ejemplo_01.Controller;



import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import mrzleviatan.ejemplo_01.Config.Rabbitactory;
import mrzleviatan.ejemplo_01.Controller.Service.IModelFactoryServiceConsumidor;
import static mrzleviatan.ejemplo_01.Utils.Constantes.QUEUE_NUEVA_PUBLICACION;


public class ModelFactoryControllerConsumidor implements IModelFactoryServiceConsumidor, Runnable {


    Rabbitactory rabbitactory;
    ConnectionFactory connectionFactory;

    Thread hiloServicioConsumer1;


    private static class SingletonHolder {
        private final static ModelFactoryControllerConsumidor eINSTANCE = new ModelFactoryControllerConsumidor();
    }

    public static ModelFactoryControllerConsumidor getInstance(){
        return SingletonHolder.eINSTANCE;

    }

    public ModelFactoryControllerConsumidor(){

        initRabbitConnection();
    }


    private void initRabbitConnection(){

        rabbitactory = new Rabbitactory();
        connectionFactory = rabbitactory.getConnectionFactory();
        System.out.println("Conexion Establecida");

    }

    public void consumirMensajeSercicio1(){

        hiloServicioConsumer1 = new Thread(this);
        hiloServicioConsumer1.start();
    }


    @Override
    public void run() {

        Thread currentThread = Thread.currentThread();
        if (currentThread == hiloServicioConsumer1){
            consumirMensaje();
        }
    }

    private void consumirMensaje(){

        try {

            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NUEVA_PUBLICACION,false,false,false,null );


            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody());
                System.out.println("Mensaje recibido: " + message);
                //actualizarEstado(message);
            };
            while (true) {
                channel.basicConsume(QUEUE_NUEVA_PUBLICACION, true, deliverCallback, consumerTag -> { });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
