package hsge.hsgeback.service;

import antlr.StringUtils;
import hsge.hsgeback.entity.PetImg;
import hsge.hsgeback.repository.PetImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PetImgService {
    @Value("${petImgLocation}")
    private String petImgLocation;

    private final PetImgRepository petImgRepository;

    private final FileService fileService;

    public void savePetImage(PetImg petImg, MultipartFile petImgFile) throws Exception{
        String oriImgName = petImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        imgName = fileService.uploadImg(petImgLocation, oriImgName,petImgFile.getBytes());
        imgUrl = "/images/pet" + imgName;

        petImg.updatePetImg(oriImgName, imgName, imgUrl);
        petImgRepository.save(petImg);
    }

}
