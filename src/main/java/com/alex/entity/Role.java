package com.alex.entity;


import com.alex.util.RoleType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId; //columna role_id PK autoincrementable

    @Column(unique = true, nullable = false)
    private String tipo = RoleType.USER.name();


    public Role() {
    }

    public Role(Integer roleId, String tipo) {
        this.roleId = roleId;
        this.tipo = tipo;

    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
