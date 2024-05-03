package ruahkim.com.test_coding_springboot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Age {

   private int age;


   public void 한살더하기(int age){
      this.age = age +1;
   }
   public void 나이설정(int a) {
      if(a>100 && a<0){
         this.age = a;
      }
   }
}
