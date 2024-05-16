package ruahkim.com.test_coding_springboot.item;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    @Column(name = "이름")
    private String displayName;
    @Column(name = "아이디")
    private String username;
    @Column(name = "비밀번호")
    private String password;

}
