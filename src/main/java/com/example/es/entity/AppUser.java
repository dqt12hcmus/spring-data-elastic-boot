package com.example.es.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "App_User", uniqueConstraints = {
        @UniqueConstraint(name = "APP_USER_UK",
                columnNames = "User_Name")})
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "User_Id", nullable = false)
    private Long userId;
    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;
    @Column(name = "ENCRYTED_PASSWORD", length = 128, nullable = false)
    private String encryptedPassword;
    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;
}
