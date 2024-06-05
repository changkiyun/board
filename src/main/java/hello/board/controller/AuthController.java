package hello.board.controller;

import hello.board.model.request.SignupRequest;
import hello.board.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public void signup(@RequestBody SignupRequest signupRequest) {
        //
    }
}
