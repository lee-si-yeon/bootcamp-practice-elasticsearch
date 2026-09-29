
package com.example.search.domain.post.post.document;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.OffsetDateTime;

@Document(indexName = "posts")
@Data
public class Post implements Persistable<String> {

    @Id
    private String id;

    @Field(type= FieldType.Text)
    private String title;

    @Field(type= FieldType.Text)
    private String content;

    @Field(type= FieldType.Keyword)
    private String author;

    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime lastModifiedAt;

    public Post(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public boolean isNew() {
        return id == null || (createdAt == null && lastModifiedAt == null);
    }
}
