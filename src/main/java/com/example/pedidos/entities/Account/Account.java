package com.example.pedidos.entities.Account;

import com.example.pedidos.entities.Data;
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

    @Embedded
    private Data data;

    public Account(String mail, String password, Data data) {
        this.mail = mail;
        this.password = password;
        this.data = new Data(data.getName(), data.getMaternalSurName(), data.getPaternalSurName(),
                data.getAddress(), data.getPhoneNumber(), data.getBirthday());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", accountRole=" + accountRole +
                '}';
    }
}
