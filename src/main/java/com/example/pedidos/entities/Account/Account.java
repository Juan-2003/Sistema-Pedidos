package com.example.pedidos.entities.Account;

import com.example.pedidos.Data.Data;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Entity(name = "Account")
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Account implements UserDetails {
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

    public Account(RegisterAccountDTO registerAccountDTO, String encodedPassword){
        this.mail = registerAccountDTO.mail();
        this.password = encodedPassword;
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + accountRole.name()));
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername() {
        return data.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
