package ruahkim.com.test_coding_springboot.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void SignUpMember(String username, String password, String displayName){
        var hashingPw = new BCryptPasswordEncoder().encode(password);
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(hashingPw);
        member.setDisplayName(displayName);
        log.info(member);
        memberRepository.save(member);
    }

}
