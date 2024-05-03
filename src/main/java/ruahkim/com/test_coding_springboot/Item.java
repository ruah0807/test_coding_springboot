package ruahkim.com.test_coding_springboot;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "글제목")
    public String title;
    @Column(name = "가격")
    public Integer price;
}
