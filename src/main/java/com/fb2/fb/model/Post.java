package com.fb2.fb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "users_id")
    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String message;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostLike> likes;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", message='" + message + '\'' +
                '}';
    }
}

