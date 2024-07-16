package com.example.pedidos.entities.Account;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Account")
@Table(name = "account")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String mail;
    String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    AccountRole accountRole;

    public Account(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    @Override
    public String toString() {
        return  "Mail='" + mail + '\'' +
                "Password='" + password;
    }
}
