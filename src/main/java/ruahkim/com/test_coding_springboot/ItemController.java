package ruahkim.com.test_coding_springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
//      클래스 Rest API 에러 내주는 handler
//    @ExceptionHandler(Exception.class)
//    public void handler(){
//        return ResponseEntity.status().body;
//    }
}
