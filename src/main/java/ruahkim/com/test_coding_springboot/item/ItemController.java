package ruahkim.com.test_coding_springboot.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {

        itemService.showList(model);

        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price) {

        itemService.saveItem(title,price);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detailProduct(@PathVariable Long id, Model model)  {

      itemService.showDetail(id,model);
            return "detail.html";
    }

    @GetMapping("/update/{id}")
    String updateProduct(@PathVariable Long id, Model model){
        itemService.showDetail(id, model);
        return "update.html";
    }

    @PostMapping("/update/{id}")
    String update(@PathVariable Long id, Item updateItem){
        itemService.update(id, updateItem);
        return "redirect:/list";
    }
    @GetMapping("/test1")
    String test1(@RequestParam String name, @RequestParam Integer age){
        System.out.println(name+age);
        return "redirect:/list";
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<?> delete(@RequestParam("id") Long id){
        System.out.println(id);
        itemService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
//      클래스 Rest API 에러 내주는 handler
//    @ExceptionHandler(Exception.class)
//    public void handler(){
//        return ResponseEntity.status().body;
//    }

  

}
