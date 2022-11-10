package hsge.hsgeback.entity;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String name;

    private String password;


    @OneToMany(mappedBy = "user")
    private List<Moim> moims = new ArrayList<>();

    @Builder
    public User(String email, String nickname, String name, String password) {
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.password = password;
    }
}
