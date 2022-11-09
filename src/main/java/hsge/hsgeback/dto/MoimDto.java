package hsge.hsgeback.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MoimDto {
    private String title;

    private String location;

    private String content;

    private int people;

    @Builder
    public MoimDto(String title, String location, String content, int people) {
        this.title = title;
        this.location = location;
        this.content = content;
        this.people = people;
    }
}
