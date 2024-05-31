package hello.board.model.response;

import hello.board.entity.Board;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class BoardResponseWithComment {
    private Long boardId;
    private String boardTitle;
    private String boardBody;
    private List<CommentResponse> comments = new ArrayList<>();

    public static BoardResponseWithComment changeResponse(Board board) {
        return new BoardResponseWithComment(
                board.getBoardId(),
                board.getBoardTitle(),
                board.getBoardBody(),
                board.getComments().stream().map(CommentResponse::changeResponse).collect(Collectors.toList())
        );
    }
}
