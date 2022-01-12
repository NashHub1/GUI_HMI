package app.gui_hmi;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class publisher {

    static String topic = "/21WS-SysArch/foo";
    static int qos = 2;
    static String broker = "tcp://localhost:1888";
    static String clientId = "HMI-Publisher-H2";
    static MemoryPersistence persistence = new MemoryPersistence();

    static String Username = "H2";
    static String Password = "DFB";


    public void createPub(){

        try {
            MqttClient publisherClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(Username);
            connOpts.setPassword(Password.toCharArray());
            connOpts.setKeepAliveInterval(30);

            System.out.println("Connecting to broker: " + broker);
            publisherClient.connect(connOpts);
            System.out.println("Connected");
            publisherClient.disconnect();

        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }

    }

    public static void sendMessage(String s){

        String content = s;
        try {
            MqttClient publisherClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(Username);
            connOpts.setPassword(Password.toCharArray());
            connOpts.setKeepAliveInterval(30);
            publisherClient.connect(connOpts);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            publisherClient.publish(topic, message);
            System.out.println("Message published");
            publisherClient.disconnect();
            System.out.println("Disconnected");
        } catch (MqttException e) {
            e.printStackTrace();
        }



    }

}


