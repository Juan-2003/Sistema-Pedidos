package com.example.pedidos.entities.ProductAndOrder.Order;

public enum OrderStatus {
    PENDING("pending", "pendiente"),
    IN_TRANSIT("in transit", "en camino"),
    DEVOTED("devoted", "entregado");

    private String englishStatus;
    private String spanishStatus;

    OrderStatus(String englishStatus, String spanishStatus){
        this.englishStatus = englishStatus;
        this.spanishStatus = spanishStatus;
    }

    public static OrderStatus fromString(String text){
        for(OrderStatus orderStatus : OrderStatus.values()){
            if(orderStatus.englishStatus.equalsIgnoreCase(text)){
                return orderStatus;
            }
        }
        throw new RuntimeException("The status was not found");
    }

    public static OrderStatus fromSpanish(String text){
        for(OrderStatus orderStatus : OrderStatus.values()){
            if(orderStatus.spanishStatus.equalsIgnoreCase(text)){
                return orderStatus;
            }
        }
        throw new RuntimeException("The status was not found");
    }
}
