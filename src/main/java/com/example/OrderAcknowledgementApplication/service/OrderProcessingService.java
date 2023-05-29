package com.example.OrderAcknowledgementApplication.service;

import com.example.OrderAcknowledgementApplication.dto.OrderDetailDTO;
import com.example.OrderAcknowledgementApplication.entity.OrderDetail;
import com.example.OrderAcknowledgementApplication.entity.OrderItem;
import com.example.OrderAcknowledgementApplication.repository.OrderDetailRepository;
import com.example.OrderAcknowledgementApplication.repository.OrderItemRepository;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Service()
@Transactional
public class OrderProcessingService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public int placeOrder(OrderDetailDTO orderDetailDTO) throws NamingException {
        InitialContext context = new InitialContext();
        Topic topic = (Topic) context.lookup("topic/orderTopic");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderDetailDTO.getOrderId());
            orderDetail.setCustomerName(orderDetailDTO.getCustomerName());
            orderDetail.setEmail(orderDetailDTO.getEmail());
            orderDetail.setShippingAddress(orderDetailDTO.getShippingAddress());

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(orderDetailDTO.getOrderItems().getProductId());
            orderItem.setProductName(orderDetailDTO.getOrderItems().getProductName());
            orderItem.setUnitPrice(orderDetailDTO.getOrderItems().getUnitPrice());
            orderItem.setQuantity(orderDetailDTO.getOrderItems().getQuantity());
            orderItem.setSubTotal(orderDetailDTO.getOrderItems().getSubTotal());

            orderDetail.setOrderItems(orderItem);

            orderDetail.setTotalAmount(orderDetailDTO.getTotalAmount());
            orderDetail.setOrderDate(orderDetailDTO.getOrderDate());
            orderDetail.setStatus(orderDetailDTO.getStatus());
            orderItemRepository.save(orderItem);
            orderDetailRepository.save(orderDetail);

            ObjectMessage message = jmsContext.createObjectMessage(orderDetail);
            jmsContext.createProducer().send(topic, message);
            System.out.println("Message sent");
        }
        return orderDetailDTO.getOrderId();
    }
}


