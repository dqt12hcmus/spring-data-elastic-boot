package com.example.es.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "APP_ROLE", uniqueConstraints = {
        @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name")
})
@Getter
@Setter
public class AppRole {
    @Id
    @GeneratedValue
    @Column(name = "Role_Id", nullable = false)
    private Long roleId;
    @Column(name = "Role_Name", nullable = false, length = 30)
    private String roleName;
}
