package hello.board.service;

import hello.board.entity.Board;
import hello.board.entity.Comment;
import hello.board.exception.NotFoundIdException;
import hello.board.model.request.BoardWriteRequest;
import hello.board.model.response.BoardResponse;
import hello.board.model.response.BoardResponseWithComment;
import hello.board.model.response.CommentResponse;
import hello.board.repository.BoardRepository;
import hello.board.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public BoardResponse boardWrite(BoardWriteRequest boardWriteRequest) {
        Board board = new Board();
        board.setBoardBody(boardWriteRequest.getBoardBody());
        board.setBoardTitle(boardWriteRequest.getBoardTitle());

        Board saved = boardRepository.save(board);

        //빌더패턴 사용
        return BoardResponse.builder()
                .boardId(saved.getBoardId())
                .boardBody(saved.getBoardBody())
                .boardTitle(saved.getBoardTitle())
                .build();
    }

    //Todo: 삭제 후 재 등록시 ID가 삭제된 게시글 다음 번호로 생성 됨
    public BoardResponse boardEdit(Long boardId, String boardBody) {
        return boardRepository.findById(boardId)
                .map(board -> {
                    board.setBoardBody(boardBody);
                    return board;
                })
                .map(BoardResponse::changeResponse)
                .orElseThrow(() -> new NotFoundIdException("존재하지 않은 게시글 ID 입니다."));
    }

    public void boardDelete(Long boardId) {
        if (!boardRepository.existsById(boardId)) {
            throw new NotFoundIdException("존재하지 않는 게시글 ID입니다.");
        }
        boardRepository.deleteById(boardId);
    }

    public BoardResponse boardGet(Long boardId) {
        return boardRepository.findById(boardId)
                .map(BoardResponse::changeResponse)
                .orElseThrow(() -> new NotFoundIdException("존재하지 않은 게시글 ID 입니다."));
    }

    public BoardResponseWithComment boardGetWithComment(Long boardId) {
        return boardRepository.findById(boardId)
                .map(BoardResponseWithComment::changeResponse)
                .orElseThrow(() -> new NotFoundIdException("존재하지 않은 게시글 ID 입니다."));
    }

    public Page<BoardResponse> boardListGet(Pageable pageable) {
        return boardRepository.findAll(pageable)
                .map(BoardResponse::changeResponse);
    }
}
