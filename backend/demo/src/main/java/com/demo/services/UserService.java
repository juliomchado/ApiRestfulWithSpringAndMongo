package com.demo.services;

import java.util.List;
import java.util.Optional;

import com.demo.domain.User;
import com.demo.dto.UserDTO;
import com.demo.repository.UserRepository;
import com.demo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not exists"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
