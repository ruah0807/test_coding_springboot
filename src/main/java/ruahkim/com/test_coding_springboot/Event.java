package ruahkim.com.test_coding_springboot;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "글제목")
    public String name;

    @Column(name = "날짜")
    public Date date;

}
