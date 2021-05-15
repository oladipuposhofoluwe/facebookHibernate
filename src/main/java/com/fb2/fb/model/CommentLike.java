package com.fb2.fb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="commentLikes")
public class CommentLike {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long commentID;

    @JoinColumn(name = "comment_id")
    @ManyToOne
    private Comment comment;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

}
