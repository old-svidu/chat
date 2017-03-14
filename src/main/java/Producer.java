import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * Created by root on 14.03.17.
 */
public class Producer implements Runnable {
    @Override
    public void run() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            Connection conn = factory.createConnection();
            conn.start();
            Session session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("Dest");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage message = session.createTextMessage("why so serious");
            producer.send(message);
            session.close();
            conn.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
