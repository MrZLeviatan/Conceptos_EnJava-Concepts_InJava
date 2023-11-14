package mrzleviatan.ejemplo_01.Controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import mrzleviatan.ejemplo_01.Config.Rabbitactory;
import mrzleviatan.ejemplo_01.Controller.Service.IModelFactoryServiceProducer;

import java.nio.charset.StandardCharsets;

public class ModelFactoryControllerProductor implements IModelFactoryServiceProducer {

   Rabbitactory rabbitactory;
   ConnectionFactory connectionFactory;

   private  static class SingletonHolder{
       private final static ModelFactoryControllerProductor eINSTANCE = new ModelFactoryControllerProductor();
   }

   public static ModelFactoryControllerProductor getInstance(){
       return SingletonHolder.eINSTANCE;
   }


   public ModelFactoryControllerProductor(){
       initRabbitConnection();
   }

   private void initRabbitConnection(){

       rabbitactory = new Rabbitactory();
       connectionFactory = rabbitactory.getConnectionFactory();
       System.out.println("Conexion Establecida");

   }


    @Override
    public void producirMensaje(String queue, String mensaje) {
        try (Connection connection = connectionFactory.newConnection();

             Channel channel = connection.createChannel()) {
            channel.queueDeclare(queue, false, false, false, null);
            channel.basicPublish("", queue, null, mensaje.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mensaje + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
