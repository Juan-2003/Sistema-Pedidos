package com.example.pedidos.entities.Vehicle;

public enum Vehicle {
    CAR("car", "carro"),
    MOTORCYCLE("motorcycle", "motocicleta"),
    BICYCLE("bicycle", "bicicleta");

    private String englishVehicle;
    private String spanishVehicle;

     Vehicle(String englishVehicle, String spanishVehicle){
        this.englishVehicle = englishVehicle;
        this.spanishVehicle = spanishVehicle;
    }

    public static Vehicle fromString(String text){
         for(Vehicle vehicle : Vehicle.values()){
             if(vehicle.englishVehicle.equalsIgnoreCase(text)){
                 return vehicle;
             }
         }
         throw new RuntimeException("The vehicle was not found");
    }

    public static Vehicle fromSpanish(String text){
         for(Vehicle vehicle : Vehicle.values()){
             if(vehicle.spanishVehicle.equalsIgnoreCase(text)){
                 return vehicle;
             }
         }
         throw new RuntimeException("The vehicle was not found");
    }
}
