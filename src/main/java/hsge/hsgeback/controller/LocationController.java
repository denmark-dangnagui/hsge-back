package hsge.hsgeback.controller;

import hsge.hsgeback.dto.LocationDto;
import hsge.hsgeback.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private final UserService userService;

    @PostMapping
    public void saveLocation(@RequestBody LocationDto locationDto){
        log.info("locationDto: {}", locationDto);
        userService.changeLocation(locationDto);
    }
}
