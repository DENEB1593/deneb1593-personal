package io.study.deneb.model.user;

import io.study.deneb.controller.user.JoinRequest;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    public User() { }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(JoinRequest joinRequest) {
        this(joinRequest.name(), joinRequest.email());
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                .append("name", name)
                .append("email", email)
                .append("createdAt", createdAt)
                .toString();
    }
}
