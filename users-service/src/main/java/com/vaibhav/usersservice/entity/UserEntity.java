package com.vaibhav.usersservice.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="users")
@Data
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -8103667799983028076L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;
    private String lastName;
    @Column(nullable = false, length = 120 , unique = true)
    private String email;

    @Column(nullable = false , unique = true)
    private String encryptedPassword;

    @Column(nullable = false , unique = true)
    private String userId;

}
