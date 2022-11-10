package hsge.hsgeback.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Moim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String location;

    private String content;

    private int people;

    @ManyToOne
    private User user;

    @Builder
    public Moim(String title, String location, String content, int people) {
        this.title = title;
        this.location = location;
        this.content = content;
        this.people = people;
    }
}
