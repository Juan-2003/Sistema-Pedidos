package com.example.pedidos.infra.errors;

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

    @ExceptionHandler(OrderNotFound.class)
    public ResponseEntity<DetailsErrorValidation> handleOrderNotFound(OrderNotFound e){
        DetailsErrorValidation detailsErrorValidation = new DetailsErrorValidation(
                "Order Not Found", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detailsErrorValidation);
    }

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<DetailsErrorValidation> handleAccountNotFound(AccountNotFound e){
        DetailsErrorValidation detailsErrorValidation = new DetailsErrorValidation(
                "Account Not Found", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detailsErrorValidation);
    }

    @ExceptionHandler(DeliverymanNotFound.class)
    public ResponseEntity<DetailsErrorValidation> handleDeliverymanNotFound(DeliverymanNotFound e){
        DetailsErrorValidation detailsErrorValidation = new DetailsErrorValidation(
                "Deliveryman Not Found", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detailsErrorValidation);
    }

    @ExceptionHandler(AccountDuplicated.class)
    public ResponseEntity<DetailsErrorValidation> handleAccountDuplicaded(AccountDuplicated e){
        DetailsErrorValidation detailsErrorValidation = new DetailsErrorValidation(
                "Account Duplicated", e.getMessage());
        return ResponseEntity.badRequest().body(detailsErrorValidation);
    }


    private record DetailsErrorValidation(String title, String mesaje){
        public DetailsErrorValidation(String title, String mesaje){
            this.title = title;
            this.mesaje = mesaje;
        }
    }
}
