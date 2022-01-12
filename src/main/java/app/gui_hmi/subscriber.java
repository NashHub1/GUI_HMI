package app.gui_hmi;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class subscriber {

    public void createSub(){

        String topic = "/21WS-SysArch/foo";
        String content = "Message from MqttPublishSample";
        int qos = 2;
        String broker = "tcp://localhost:1888";
        //String broker = "tcp://80.130.93.205:1883"; Test versuch mit Jan Merz,Nachricht hat er erhalten
        String subClientId = "HMI-Subscriber-H2";
        MemoryPersistence persistence = new MemoryPersistence();

        String Username = "H2";
        String Password = "DFB";
        Password.toCharArray();


        try {
            MqttClient subSampleClient = new MqttClient(broker, subClientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(Username);
            connOpts.setPassword(Password.toCharArray());
            connOpts.setKeepAliveInterval(30);

            subSampleClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("connection Lost");

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("Message: " + message.toString());
                    //GUI_elevator GUI = new GUI_elevator();
                    //GUI.setAnimation(message.toString());
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    System.out.println("deliveryComplete");

                }

            });

            System.out.println("Subscriber Connecting to broker: " + broker);
            subSampleClient.connect(connOpts);
            System.out.println("Subscriber Connected");
            subSampleClient.subscribe(topic);
            System.out.println("Subscribed");

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
