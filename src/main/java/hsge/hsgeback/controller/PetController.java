package hsge.hsgeback.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class PetController {


    @Value("${petImgLocation}")
    private String petImgLocation;



    @PostMapping
    public void postImg(MultipartFile imgFile, String name) throws IOException {
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + imgFile.getOriginalFilename();
        File saveFile = new File(petImgLocation,fileName);
        imgFile.transferTo(saveFile);
        log.info(name);
    }
}