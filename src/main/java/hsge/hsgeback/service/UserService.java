package hsge.hsgeback.service;

import hsge.hsgeback.dto.LocationDto;
import hsge.hsgeback.entity.User;
import hsge.hsgeback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    public void changeLocation(LocationDto locationDto) {
        User user = userRepository.findById(1L).orElseThrow();
        validateLocation(locationDto);
        user.setLatitude(locationDto.getLatitude());
        user.setLongtitude(locationDto.getLongtitude());
        userRepository.save(user);
    }

    /**
     * 위도 경도는 0에서 250사이여만 통과가능@param locationDto
     */
    private void validateLocation(LocationDto locationDto) {
        int tempLatitude = Integer.parseInt(locationDto.getLatitude());
        int tempLongtitude = Integer.parseInt(locationDto.getLongtitude());
        if (tempLatitude > 250 || tempLatitude < 0 || tempLongtitude > 250 || tempLongtitude < 0){
            throw new IllegalStateException("범위에 해당하지 않읍니다.");
        }
    }
}
