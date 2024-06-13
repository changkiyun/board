package hello.board.model.request;

import lombok.Data;

//test
@Data
public class SignupRequest {
    private String memberName;
    private String loginId;
    private String loginPassword;
}
