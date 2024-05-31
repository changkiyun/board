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
import org.springframework.stereotype.Service;

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



}
