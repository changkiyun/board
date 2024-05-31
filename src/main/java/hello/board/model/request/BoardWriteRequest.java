package hello.board.model.request;

import lombok.Data;

@Data
public class BoardWriteRequest {
    private String boardTitle;
    private String boardBody;
}
