package hello.board.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;
}
