//package simple.software.learn.springsecuritydemo;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import simple.software.learn.springsecuritydemo.service.TokenService;
//
//@RestController
//@RequestMapping(path = "/api/auth")
//public record AuthController(TokenService tokenService) {
//
//    @PostMapping(path = "/token")
//    public String token(Authentication authentication) {
//        return tokenService.generateToken(authentication);
//    }
//
//}
