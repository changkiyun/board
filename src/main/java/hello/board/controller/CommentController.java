package hello.board.controller;

import hello.board.model.request.CommentWriteRequest;
import hello.board.model.response.CommentResponse;
import hello.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentResponse commentWrite(@RequestBody CommentWriteRequest commentWriteRequest) {
        return commentService.commentWrite(commentWriteRequest);
    }

    @PutMapping
    public CommentResponse commentEdit(@RequestParam Long commentId, String commentBody) {
        return commentService.commentEdit(commentId, commentBody);
    }

    @DeleteMapping
    public ResponseEntity<String> commentDelete(@RequestParam Long commentId) {
        commentService.commentDelete(commentId);
        return new ResponseEntity<>(commentId + "번 댓글이 삭제되었습니다.", HttpStatus.OK);
    }
}
