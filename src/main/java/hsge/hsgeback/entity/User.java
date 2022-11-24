package hsge.hsgeback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String name;

    private String password;

    private String latitude;

    private String longtitude;

    private Role role;

    private String profilePath;

    private String po; // ㄱㅏ짜

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Pet> pet = new ArrayList<>();

    @Builder
    public User(String email, String nickname, String name, String password) {
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.password = password;
    }
}
