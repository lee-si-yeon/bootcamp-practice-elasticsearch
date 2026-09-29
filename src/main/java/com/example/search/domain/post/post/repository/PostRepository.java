package com.example.search.domain.post.post.repository;

import com.example.search.domain.post.post.document.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostRepository extends ElasticsearchRepository<Post, String> {
}
