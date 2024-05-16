package ruahkim.com.test_coding_springboot.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/sign-up")
    String signup(){
        return "sign-up.html";
    }


    @PostMapping("/save-member")
    String hashing(String username, String password, String displayName){
        memberService.SignUpMember(username,password, displayName);

        return "redirect:/list";
    }
}
