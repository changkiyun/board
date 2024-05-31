package hello.board.controller;

import hello.board.model.request.CommentWriteRequest;
import hello.board.model.response.CommentResponse;
import hello.board.service.CommentService;
import lombok.RequiredArgsConstructor;
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
    public void commentEdit() {

    }
}
