package com.andrelake.desafiopicpaybackend.domain;

import com.andrelake.desafiopicpaybackend.domain.enums.UserType;
import com.andrelake.desafiopicpaybackend.services.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
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

    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.document = userDTO.getDocument();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.userType = UserType.valueOf(userDTO.getUserType().name());
    }
}
