package lemsolaris.auth;

import lemsolaris.repositories.AuthRepository;
import lombok.SneakyThrows;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {

    final AuthRepository authRepository;

    @Autowired
    public AuthController(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }


    @SneakyThrows
    @PostMapping("/register")
    public void register(Map<String, String> model){
        User user = new User();
        user.setLogin(model.get("login"));
        user.setPassword(model.get("password"));
        authRepository.save(user);
    }

    @PostMapping("/login")
    public void login(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password){

        if(authRepository.findUserByLoginAndPassword(login, password) == null){
//            return fail;
        }else {
//            return success;
        }
    }

}
