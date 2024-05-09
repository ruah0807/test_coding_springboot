package ruahkim.com.test_coding_springboot;

import jakarta.persistence.*;
import lombok.*;


@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "제품명")
    private String title;
    @Column(name = "가격")
    private Integer price;


    public void change(String title, Integer price){
        this.title = title;
        this.price = price;
    }
}
