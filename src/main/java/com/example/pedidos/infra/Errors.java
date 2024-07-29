package com.example.pedidos.infra;

import com.example.pedidos.entities.ProductAndOrder.Order.DetailsOrderDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Errors {

    @ExceptionHandler(ClientNotFound.class)
    public ResponseEntity<DetailsErrorValidation> handleClientNotFound(ClientNotFound e){
        DetailsErrorValidation detailsErrorValidation = new DetailsErrorValidation(
                "Client Not Found", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detailsErrorValidation);
    }

    @ExceptionHandler(DeliverymanNotAvailable.class)
    public ResponseEntity<DetailsErrorValidation> handleDeliverymanNotAvailable(DeliverymanNotAvailable e){
        DetailsErrorValidation detailsErrorValidation = new DetailsErrorValidation(
                "Deliveryman Not Available", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detailsErrorValidation);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<DetailsErrorValidation> handleProductNotFound(ProductNotFound e){
        DetailsErrorValidation detailsErrorValidation = new DetailsErrorValidation(
                "Product Not Found", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detailsErrorValidation);
    }

    private record DetailsErrorValidation(String title, String mesaje){
        public DetailsErrorValidation(String title, String mesaje){
            this.title = title;
            this.mesaje = mesaje;
        }
    }
}
