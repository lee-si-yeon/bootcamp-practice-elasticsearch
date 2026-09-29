package com.example.search.domain.post.comment.service;

import com.example.search.domain.post.comment.document.Comment;
import com.example.search.domain.post.comment.repository.CommentRepository;
import com.example.search.domain.post.post.document.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public long count() {
        return commentRepository.count();
    }

    public Comment create(Post post, String content, String author) {
        Comment comment = new Comment(post.getId(), content, author);
        return commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
