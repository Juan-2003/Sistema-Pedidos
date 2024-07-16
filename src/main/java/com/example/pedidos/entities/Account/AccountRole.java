package com.example.pedidos.entities.Account;

public enum AccountRole {
    DELIVERY_DRIVER("delivery driver", "repartidor"),
    USER("user", "usuario"),
    ADMINISTRATOR("administrator", "administrador");

    private String englishAccountRoles;
    private String spanishAccountRoles;

    AccountRole(String englishAccountRoles, String spanishAccountRoles){
        this.englishAccountRoles = englishAccountRoles;
        this.spanishAccountRoles = spanishAccountRoles;
    }

    public static AccountRole fromString(String text){
        for(AccountRole accountRole : AccountRole.values()){
            if(accountRole.englishAccountRoles.equalsIgnoreCase(text)){
                return accountRole;
            }
        }
        throw new RuntimeException("The account role was not found");
    }

    public static AccountRole fromSpanish(String text){
        for(AccountRole accountRole : AccountRole.values()){
            if(accountRole.spanishAccountRoles.equalsIgnoreCase(text)){
                return accountRole;
            }
        }
        throw new RuntimeException("The account role was not found");
    }
}
