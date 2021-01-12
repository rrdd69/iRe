package cms.bbs.v1.entity;


import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "tbl_member")
public class Member extends BaseEntity{

    @Id
    @Column(name = "email")
    private String email;

    private String password;

    private String name;

    @OneToMany(mappedBy = "writer")
    private List<Board> boardList = new ArrayList<>();
}
