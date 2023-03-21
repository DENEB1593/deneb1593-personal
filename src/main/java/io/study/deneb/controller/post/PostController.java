package io.study.deneb.controller.post;

import io.study.deneb.controller.CommonResponse;
import io.study.deneb.model.post.Post;
import io.study.deneb.model.post.PostDto;
import io.study.deneb.repo.post.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.hasText;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public CommonResponse<PostDto> write(@RequestBody WriteRequest writeRequest) {
        // TODO: 유효성 예외
        checkArgument(hasText(writeRequest.title()), "title must be provided");
        checkArgument(hasText(writeRequest.content()), "content must be provided");

        Post post = new Post(writeRequest);

        return CommonResponse.ok(
                new PostDto(
                        postRepository.save(post))
        );
    }

    @GetMapping(path = "{id}")
    public CommonResponse<PostDto> findById(@PathVariable Long id) {
        // TODO: 유효성 예외
        checkArgument(id != null, "post id must be provided");


        PostDto postDto = postRepository.findById(id)
                .map(PostDto::new)
                .orElse(null);

        // TODO: NotFoundException
        if (postDto == null) {
            throw new RuntimeException(
                    String.format("post not found request id : %d", id));
        }

        return CommonResponse.ok(postDto);
    }

}