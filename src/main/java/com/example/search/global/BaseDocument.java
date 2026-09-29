package com.example.search.global;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
@ToString
public class BaseDocument<ID> implements Persistable<ID> {

    @Id
    private ID id;

    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime lastModifiedAt;

    @Override
    public boolean isNew() {
        return id == null || (createdAt == null && lastModifiedAt == null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseDocument<?> that = (BaseDocument<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
