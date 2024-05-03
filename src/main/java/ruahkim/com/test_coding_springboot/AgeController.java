package ruahkim.com.test_coding_springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgeController {

    private Integer age;
    @GetMapping("/age")
    String age(){
        Age object = new Age();
        object.setAge(12);
        return "/age.html";
    }

}
