package hsge.hsgeback.dto;

// DTO - Data Transfer Object

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class SignUpDto {

    @Email
    private String email;

    private String nickname;

    private String name;

    @Size(min = 5, max = 10)
    private String password;

    @Builder
    public SignUpDto(String email, String nickname, String name, String password) {
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.password = password;
    }
}
