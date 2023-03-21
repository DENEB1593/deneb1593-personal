package io.study.deneb.model.post;

import io.study.deneb.controller.post.WriteRequest;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

@Table(name = "posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Post() { }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post(WriteRequest writeRequest) {
        this(writeRequest.title(), writeRequest.content());
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("content", content)
                .append("createdAt", createdAt)
                .toString();
    }
}
