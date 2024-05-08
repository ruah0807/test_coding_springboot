package ruahkim.com.test_coding_springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
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

//      클래스 Rest API 에러 내주는 handler
//    @ExceptionHandler(Exception.class)
//    public void handler(){
//        return ResponseEntity.status().body;
//    }
}
