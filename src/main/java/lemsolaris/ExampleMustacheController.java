package lemsolaris;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ExampleMustacheController {
    @GetMapping("/example")
    public ModelAndView foo(Map<String, Object> model) {
        return new ModelAndView("example", model);
    }
}
