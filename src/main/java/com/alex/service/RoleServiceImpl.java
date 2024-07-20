package com.alex.service;

import com.alex.entity.Role;
import com.alex.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository repository;

    @Override
    public Collection<Role> findAll() {
        return List.of();
    }
}
