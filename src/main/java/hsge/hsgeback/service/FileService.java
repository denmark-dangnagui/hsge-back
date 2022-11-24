package hsge.hsgeback.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

    public String uploadImg(String uploadPath, String originalFileName, byte[] fileData) throws Exception{
        UUID uuid = UUID.randomUUID();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String savedImgName = uuid.toString() + extension;
        String fileUploadFulllUrl = uploadPath + "/" +savedImgName;
        FileOutputStream fos = new FileOutputStream(fileUploadFulllUrl);
        fos.write(fileData);
        fos.close();
        return savedImgName;
    }

}
