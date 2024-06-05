package hello.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String memberName;
    private String loginId;
    private String loginPassword;

    @OneToMany(mappedBy = "member")
    private List<Member> boards = new ArrayList<>();

    @OneToMany(mappedBy = "comment")
    private List<Comment> comments = new ArrayList<>();
}
