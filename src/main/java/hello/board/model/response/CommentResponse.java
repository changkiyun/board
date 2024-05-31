package hello.board.model.response;

import hello.board.entity.Comment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponse {
    private Long boardId;
    private Long commentId;
    private String commentBody;

    public static CommentResponse changeResponse (Comment comment) {
        return new CommentResponse(
                comment.getBoard().getBoardId(),
                comment.getCommentId(),
                comment.getCommentBody()
        );
    }
}
