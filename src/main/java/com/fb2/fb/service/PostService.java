package com.fb2.fb.service;

import com.fb2.fb.model.Post;
import com.fb2.fb.model.User;
import com.fb2.fb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;


    public Iterable<Post> getAllPost() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public void addPost(Post post, User user) {
        post.setUser(user);
        postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.getPostById(id);
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    public void editPost(Post post, String message) {
        post.setMessage(message);
        postRepository.save(post);
    }
}
