package com.example.search.domain.post.comment.repository;

import com.example.search.domain.post.comment.document.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommentRepository extends ElasticsearchRepository<Comment,String> {
}
