package hello.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private String boardTitle;
    private String boardBody;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();
}
