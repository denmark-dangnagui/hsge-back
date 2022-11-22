package hsge.hsgeback.dto;

import hsge.hsgeback.entity.Gender;
import lombok.Data;

@Data
public class DetailDto {

    private String nickname;

    private String userName;

    private String latitude;

    private String longtitude;

    private String profile;

    private String petName;

    private Gender gender;

    private String description;

    private Boolean neutralization;

    private String picture;

    private String breed;

}
