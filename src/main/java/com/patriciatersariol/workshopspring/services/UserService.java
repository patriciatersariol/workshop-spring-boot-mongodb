package com.patriciatersariol.workshopspring.services;

import com.patriciatersariol.workshopspring.domain.User;
import com.patriciatersariol.workshopspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
