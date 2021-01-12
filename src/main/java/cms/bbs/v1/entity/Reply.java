package cms.bbs.v1.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;

import javax.jdo.annotations.Join;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
@Table(name = "tbl_reply")
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne
    @JoinColumn(name = "board_bno")
    private Board board;

}
