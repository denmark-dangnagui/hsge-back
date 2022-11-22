package hsge.hsgeback.controller;

import hsge.hsgeback.dto.LocationDto;
import hsge.hsgeback.entity.User;
import hsge.hsgeback.repository.UserRepository;
import hsge.hsgeback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private final UserService userService;


    @PostMapping
    public void saveLocation(@RequestBody LocationDto locationDto){
        userService.changeLocation(locationDto);
    }



}
