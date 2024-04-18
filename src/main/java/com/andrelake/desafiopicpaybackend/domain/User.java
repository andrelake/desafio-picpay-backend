package com.andrelake.desafiopicpaybackend.domain;

import com.andrelake.desafiopicpaybackend.domain.enums.UserType;
import com.andrelake.desafiopicpaybackend.services.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private BigDecimal balance;

    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.document = userDTO.getDocument();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.userType = UserType.valueOf(userDTO.getUserType().name());
        this.balance = BigDecimal.ZERO;
    }
}
