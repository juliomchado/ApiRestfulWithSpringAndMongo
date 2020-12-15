package com.demo.services;

import java.util.List;
import java.util.Optional;

import com.demo.domain.Post;
import com.demo.repository.PostRepository;
import com.demo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not exists"));
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
