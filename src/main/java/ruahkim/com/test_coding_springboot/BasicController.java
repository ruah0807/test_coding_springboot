package ruahkim.com.test_coding_springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    String ruah(){
        return "안녕하세요 루아입니다.";
    }

    @GetMapping("/url")
    @ResponseBody
    String ruahUrl(){
        return "루아유알엘";
    }

    @GetMapping("/mypage")
    String ruahmypage(){
        return "/index.html";
    }

}
