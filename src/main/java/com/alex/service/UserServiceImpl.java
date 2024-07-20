package com.alex.service;

import com.alex.entity.Role;
import com.alex.entity.UserE;
import com.alex.repository.RoleRepository;
import com.alex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void insert(UserE user) {

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        for (Role role : user.getRole()) {
            Role existingRole = roleRepository.findById(role.getRoleId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role no encontrado"));
            roles.add(existingRole);
        }
        user.setRole(roles);

        repository.save(user);
    }

    @Override
    @Transactional
    public void update(UserE user) {

        String bCrypt=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(bCrypt);
        repository.save(user);

    }

    @Override
    @Transactional
    public void delete(Integer userId) {
        UserE user = repository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        user.getRole().clear();
        repository.save(user);

        repository.deleteById(userId);
    }

    @Override
    @Transactional(readOnly=true)
    public UserE findById(Integer userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<UserE> findAll() {
        return repository.findAll();
    }

    @Override
    public UserE findByUsername(String username) {
        return repository.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserE userDb = this.repository.findByUsername(username);

        if(userDb != null)
        {
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            // Roles del usuario
            for(Role role:userDb.getRole())
                authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getTipo()));

            //usuario preparado
            return new User(userDb.getUsername(), userDb.getPassword(), authorities);

        }
        throw new UsernameNotFoundException("Username " + username + " no existe");
    }
}
