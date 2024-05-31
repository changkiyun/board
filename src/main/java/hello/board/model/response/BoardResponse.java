package hello.board.model.response;

import hello.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardResponse {
    private Long boardId;
    private String boardTitle;
    private String boardBody;

    public static BoardResponse changeResponse(Board board) {
        return new BoardResponse(board.getBoardId(), board.getBoardTitle(), board.getBoardBody());
    }
}
