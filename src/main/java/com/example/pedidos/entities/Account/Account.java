package com.example.pedidos.entities.Account;

import com.example.pedidos.entities.Data;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Account")
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;
    private String password;
    private AccountRole accountRole;

    @Embedded
    private Data data;

    public Account(String mail, String password, String name,
                   String maternalSurName, String paternalSurName,
                   String address, String phoneNumber, LocalDate birthday) {
        this.mail = mail;
        this.password = password;
        this.data = new Data(name, maternalSurName, paternalSurName, address, phoneNumber, birthday);
    }

    @Override
    public String toString() {
        return "Account{" +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", accountRole=" + accountRole +
                '}';
    }
}
