package io.study.deneb.model.post;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class PostDto {
    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    public PostDto() { }

    public PostDto(Long id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public PostDto(Post post) {
        BeanUtils.copyProperties(post, this);
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
