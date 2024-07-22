package com.example.pedidos.entities.Account;

import com.example.pedidos.Data.Data;
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

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
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

    public Account(RegisterAccountDTO registerAccountDTO){
        this.mail = registerAccountDTO.mail();
        this.password = registerAccountDTO.password();
        this.accountRole = AccountRole.fromString(registerAccountDTO.role());
        this.data = new Data(registerAccountDTO.dataDTO());
    }

    public void update(UpdateAccountDTO updateAccountDTO){
        if(updateAccountDTO.updateDataDTO() != null){
            data.update(updateAccountDTO.updateDataDTO());
        }
        if(updateAccountDTO.password() != null){
            this.password = updateAccountDTO.password();
        }
    }

    @Override
    public String toString() {
        return  data.toString() +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", accountRole=" + accountRole +
                '}';
    }
}
