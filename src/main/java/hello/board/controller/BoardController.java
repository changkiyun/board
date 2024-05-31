package hello.board.controller;

import hello.board.model.request.BoardWriteRequest;
import hello.board.model.response.BoardResponse;
import hello.board.model.response.BoardResponseWithComment;
import hello.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public BoardResponse boardWrite(@RequestBody BoardWriteRequest boardWriteRequest) {
        return boardService.boardWrite(boardWriteRequest);
    }

    @PutMapping
    public BoardResponse boardEdit(@RequestParam Long boardId, String boardBody) {
        return boardService.boardEdit(boardId, boardBody);
    }

    @DeleteMapping
    public ResponseEntity<String> boardDelete(@RequestParam Long boardId) {
        boardService.boardDelete(boardId);
        return new ResponseEntity<>(boardId + "번 게시물이 삭제되었습니다.", HttpStatus.OK);
    }

    @GetMapping
    public BoardResponse boardGet(@RequestParam Long boardId) {
        return boardService.boardGet(boardId);
    }

    @GetMapping("/comment")
    public BoardResponseWithComment boardGetWithComment(@RequestParam Long boardId) {
        return boardService.boardGetWithComment(boardId);
    }

    @GetMapping("/list")
    public Page<BoardResponse> boardListGet(Pageable pageable) {
        return boardService.boardListGet(pageable);
    }

}
