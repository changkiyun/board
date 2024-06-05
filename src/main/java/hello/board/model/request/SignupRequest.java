package hello.board.model.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String memberName;
    private String loginId;
    private String loginPassword;
}
