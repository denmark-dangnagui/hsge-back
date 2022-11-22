package hsge.hsgeback;

import hsge.hsgeback.entity.User;
import hsge.hsgeback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class TestData {

    private final UserRepository userRepository;

    @PostConstruct
    void init() {

        User user = new User();
        user.setName("태민");
        userRepository.save(user);
    }
}
