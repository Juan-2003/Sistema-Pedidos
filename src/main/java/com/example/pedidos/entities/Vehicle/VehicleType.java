package com.example.pedidos.entities.Vehicle;

public enum VehicleType {
    CAR("car", "carro"),
    MOTORCYCLE("motorcycle", "motocicleta"),
    BICYCLE("bicycle", "bicicleta");

    private String englishVehicle;
    private String spanishVehicle;

     VehicleType(String englishVehicle, String spanishVehicle){
        this.englishVehicle = englishVehicle;
        this.spanishVehicle = spanishVehicle;
    }

    public static VehicleType fromString(String text){
         for(VehicleType vehicleType : VehicleType.values()){
             if(vehicleType.englishVehicle.equalsIgnoreCase(text)){
                 return vehicleType;
             }
         }
         throw new RuntimeException("The vehicle was not found");
    }

    public static VehicleType fromSpanish(String text){
         for(VehicleType vehicleType : VehicleType.values()){
             if(vehicleType.spanishVehicle.equalsIgnoreCase(text)){
                 return vehicleType;
             }
         }
         throw new RuntimeException("The vehicle was not found");
    }
}
