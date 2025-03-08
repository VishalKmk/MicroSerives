package com.ecommerce.orders.service;

import com.ecommerce.orders.model.Order;
import com.ecommerce.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate; // For making REST calls

    private static final String PRODUCT_SERVICE_URL = "http://localhost:8081/products/";

    public Order placeOrder(Order order) {
        // Fetch product price from Product Service Application
        Double productPrice = getProductPrice(order.getProductId());

        if (productPrice == null) {
            throw new RuntimeException("Product not found, order cannot be placed.");
        }

        double totalPrice = productPrice * order.getQuantity(); // calculate total price eg., 4500 * 2 = 9000
        order.setTotalPrice(totalPrice);

        Order savedOrder = orderRepository.save(order);

        savedOrder.setTotalPrice(totalPrice);
        return savedOrder;
    }

    private Double getProductPrice(Long productId) {
        try {
            String url = PRODUCT_SERVICE_URL + productId; // e.g., http://localhost:8081/products/1
            ProductResponse product = restTemplate.getForObject(url, ProductResponse.class);
            return (product != null) ? product.getPrice() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
