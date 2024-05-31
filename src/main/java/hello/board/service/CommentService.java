package hello.board.service;

import hello.board.entity.Board;
import hello.board.entity.Comment;
import hello.board.exception.NotFoundIdException;
import hello.board.model.request.CommentWriteRequest;
import hello.board.model.response.CommentResponse;
import hello.board.repository.BoardRepository;
import hello.board.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public CommentResponse commentWrite(CommentWriteRequest commentWriteRequest) {
        Comment comment = new Comment();
        Board findBoard = boardRepository.findById(commentWriteRequest.getBoardId())
                .orElseThrow(() -> new NotFoundIdException("없는 ID입니다."));
        comment.setBoard(findBoard);
        comment.setCommentBody(commentWriteRequest.getCommentBody());

        Comment saved = commentRepository.save(comment);

        return CommentResponse.builder()
                .boardId(findBoard.getBoardId())
                .commentId(saved.getCommentId())
                .commentBody(saved.getCommentBody())
                .build();
    }

    public CommentResponse commentEdit(Long commentId, String commentBody) {
        return commentRepository.findById(commentId)
                .map(comment -> {
                    comment.setCommentBody(commentBody);
                    return comment;
                })
                .map(CommentResponse::changeResponse)
                .orElseThrow(() -> new NotFoundIdException(("ID와 일치하는 댓글을 찾을 수 없습니다.")));
    }

    public void commentDelete(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new NotFoundIdException("ID와 일치하는 댓글을 찾을 수 없습니다.");
        }
        commentRepository.deleteById(commentId);
    }

}
