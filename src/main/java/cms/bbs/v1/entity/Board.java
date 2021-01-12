package cms.bbs.v1.entity;
import lombok.*;

import javax.jdo.annotations.Join;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
@Table(name = "tbl_board")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)  //명시적으로 lazy 로딩 지정
    @JoinColumn(name = "writer_email")
    private Member writer; //연관관계 설정

    @OneToMany(mappedBy = "board")
    private List<Reply> replyList = new ArrayList<>();


}
