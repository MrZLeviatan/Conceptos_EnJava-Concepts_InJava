package mrzleviatan.ejemplo_01.Config;


import com.rabbitmq.client.ConnectionFactory;

public class Rabbitactory {

    private ConnectionFactory connectionFactory;
    public Rabbitactory(){

        this.connectionFactory = new ConnectionFactory();
        this.connectionFactory.setHost("localhost");
        this.connectionFactory.setPort(5672);
        this.connectionFactory.setUsername("MrZLeviatanLx");
        this.connectionFactory.setPassword("281002");

    }

    public ConnectionFactory getConnectionFactory(){

        return connectionFactory;
    }


}
