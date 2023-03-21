package io.study.deneb.controller.user;

import io.study.deneb.controller.CommonResponse;
import io.study.deneb.controller.EmailValidator;
import io.study.deneb.model.user.User;
import io.study.deneb.repo.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.hasText;

@RestController
@RequestMapping("api/users")
public class UserController {


    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final EmailValidator emailValidator;
    private final UserRepository userRepository;

    public UserController(EmailValidator emailValidator,
                          UserRepository userRepository) {
        this.emailValidator = emailValidator;
        this.userRepository = userRepository;
    }

    @PostMapping
    public CommonResponse<User> join(@RequestBody JoinRequest joinRequest) {
        // TODO: 유효성 예외
        checkArgument(hasText(joinRequest.name()), "name must be not empty");
        checkArgument(emailValidator.test(joinRequest.email()), "invalid email format");

        User user = new User(joinRequest);

        return CommonResponse.ok(
                userRepository.save(user));
    }

    @GetMapping("{id}")
    public CommonResponse<User> findById(@PathVariable Long id) {
        // TODO: 유효성 예외
        checkArgument(id != null, "user id must be provided");

        User user = userRepository.findById(id).orElse(null);

        // TODO: NotFoundException
        if (user == null) {
            throw new RuntimeException(
                    String.format("user not found request id : %d", id));
        }

        return CommonResponse.ok(user);
    }

}
