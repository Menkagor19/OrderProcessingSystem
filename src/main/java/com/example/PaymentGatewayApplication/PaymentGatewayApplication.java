package com.example.PaymentGatewayApplication;

import com.example.OrderAcknowledgementApplication.entity.OrderDetail;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PaymentGatewayApplication {
    public static void main(String[] args) throws NamingException, JMSException {
        InitialContext context = new InitialContext();
        Topic topic = (Topic) context.lookup("topic/orderTopic");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {

            JMSConsumer consumer = jmsContext.createConsumer(topic);
            Message message = consumer.receive();
            OrderDetail orderDetail = message.getBody(OrderDetail.class);
            System.out.println("Payment gateway started for order id: " + orderDetail.getOrderId());
        }
    }
}