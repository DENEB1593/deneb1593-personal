package io.study.deneb.repo.post;

import io.study.deneb.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
