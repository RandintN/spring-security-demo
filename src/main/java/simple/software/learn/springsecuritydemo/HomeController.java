package simple.software.learn.springsecuritydemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(path = "/")
    public String home() {
        System.out.print("Chamou o endpoint");
        return "Hello ";
    }
}
