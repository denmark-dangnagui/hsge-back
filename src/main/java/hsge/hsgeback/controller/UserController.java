package hsge.hsgeback.controller;

import hsge.hsgeback.dto.SignUpDto;
import hsge.hsgeback.entity.User;
import hsge.hsgeback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public void signUp(@RequestBody SignUpDto signUpDto){
        User savedUser = User.builder()
                .name(signUpDto.getName())
                .nickname(signUpDto.getNickname())
                .email(signUpDto.getEmail())
                .password(signUpDto.getPassword())
                .build();
        userRepository.save(savedUser);
    }

    @GetMapping("/{userId}")
    public SignUpDto getOneUser(@PathVariable Long userId){
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        User user = optional.get();
        SignUpDto dto = SignUpDto.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .build();
        return dto;
    }

}
