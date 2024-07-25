package com.example.pedidos.entities.ProductAndOrder.Order;

import com.example.pedidos.entities.Client.Client;
import com.example.pedidos.entities.Client.ClientRepository;
import com.example.pedidos.entities.DeliveryMan.Deliveryman;
import com.example.pedidos.entities.DeliveryMan.DeliverymanRepository;
import com.example.pedidos.entities.ProductAndOrder.Product.Product;
import com.example.pedidos.entities.ProductAndOrder.Product.ProductRepository;
import com.example.pedidos.entities.ProductAndOrder.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Autowired
    private ProductRepository productRepository;

    public DetailsOrderDTO registerOrder(RegisterOrderDTO registerOrderDTO){
        Client client = clientRepository.findById(registerOrderDTO.idClient())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Deliveryman deliveryman = deliverymanRepository.findById(registerOrderDTO.idDeliveryman())
                .orElseThrow(() -> new RuntimeException("Deliveryman not found"));

        Order order = new Order(client, deliveryman);

        for(Long productId : registerOrderDTO.productsId()){
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
            ProductOrder productOrder = new ProductOrder(product, order);
            order.getProductList().add(productOrder);
        }
        order.calculateTotalPrice();

        return new DetailsOrderDTO(order);
    }
}
