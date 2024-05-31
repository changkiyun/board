package hello.board.model.request;

import lombok.Data;

@Data
public class CommentWriteRequest {
    private Long boardId;
    private String commentBody;
}
