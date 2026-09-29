package com.example.search.domain.post.comment.repository;

import com.example.search.domain.post.comment.document.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CommentRepository extends ElasticsearchRepository<Comment,String> {

    List<Comment> findAll();

    List<Comment> findByPostId(String postId);
}
