package com.alex.service;

import com.alex.entity.UserE;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    public abstract void insert(UserE user);
    public abstract void update(UserE user);
    public abstract void delete(Integer userId);
    public abstract UserE findById(Integer userId);
    public abstract Collection<UserE> findAll();

    public abstract UserE findByUsername(String username);

}
