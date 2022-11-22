package hsge.hsgeback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Chatroom extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

}
