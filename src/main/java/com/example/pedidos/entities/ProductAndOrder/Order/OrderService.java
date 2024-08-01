package com.example.pedidos.entities.ProductAndOrder.Order;

import com.example.pedidos.entities.Client.Client;
import com.example.pedidos.entities.Client.ClientRepository;
import com.example.pedidos.entities.DeliveryMan.Deliveryman;
import com.example.pedidos.entities.DeliveryMan.DeliverymanRepository;
import com.example.pedidos.entities.ProductAndOrder.Product.Product;
import com.example.pedidos.entities.ProductAndOrder.Product.ProductRepository;
import com.example.pedidos.entities.ProductAndOrder.ProductOrder;
import com.example.pedidos.infra.errors.ClientNotFound;
import com.example.pedidos.infra.errors.DeliverymanNotAvailable;
import com.example.pedidos.infra.errors.OrderNotFound;
import com.example.pedidos.infra.errors.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new ClientNotFound("Client with id " + registerOrderDTO.idClient() + " doesn't exist"));

        Deliveryman deliveryman = deliverymanRepository.foundAvailableDeliveryman()
                .orElseThrow(() -> new DeliverymanNotAvailable(
                        "There are no available any deliveryman in this moment"));

        deliveryman.setAvailable(false);
        deliverymanRepository.save(deliveryman);
        Order order = new Order(client, deliveryman);

        for(Long productId : registerOrderDTO.productsId()){
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFound("Product with id " + productId + " not found"));
            ProductOrder productOrder = new ProductOrder(product, order);
            order.getProductOrderList().add(productOrder);
        }

        order.calculateTotalPrice();
        orderRepository.save(order);
        return new DetailsOrderDTO(order);
    }

    public DetailsOrderDTO updateOrder(UpdateOrderDTO updateOrderDTO){
        Order order = orderRepository.getReferenceById(updateOrderDTO.id());
        order.updateOrderStatus(updateOrderDTO);

        return new DetailsOrderDTO(order);
    }

    public Boolean deleteOrder(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFound("Order with id " + id + " not Found"));

        Deliveryman deliveryman = order.getDeliveryman();
        deliveryman.setAvailable(true);
        deliverymanRepository.save(deliveryman);

        orderRepository.delete(order);
        return true;
    }
}
