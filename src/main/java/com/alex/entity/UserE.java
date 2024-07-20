package com.alex.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="users")
public class UserE implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId; //columna user_id PK autoincrementable

    @Column(unique=true,nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column
    private String nombre;

    @Column
    private String apellidos;


    @Column(unique=true,nullable=false)
    private String email;

    @Column(unique=true,nullable=false)
    private String celular;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="users_roles",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="role_id")
    )
    private Set<Role> role;

    public UserE() {}

    public UserE(Integer userId, String username, String password, String nombre, String apellidos, String email, String celular) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.celular = celular;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
