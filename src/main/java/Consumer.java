import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by root on 14.03.17.
 */
public class Consumer implements Runnable {
    @Override
    public void run() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            Connection conn = factory.createConnection();
            conn.start();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("Dest");
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive(1000);
            System.out.println(((TextMessage)message).getText());
            consumer.close();
            conn.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}