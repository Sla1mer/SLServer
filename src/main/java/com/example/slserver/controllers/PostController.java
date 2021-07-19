package com.example.slserver.controllers;

import com.example.slserver.models.Post;
import com.example.slserver.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostRepo postRepo;

    @Autowired
    public PostController(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping
    public List<Post> getAllPost(){
        return postRepo.findAll();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepo.save(post);
    }
}
