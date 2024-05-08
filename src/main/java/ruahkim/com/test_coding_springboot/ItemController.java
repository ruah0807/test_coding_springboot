package ruahkim.com.test_coding_springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {

        List<Item> result = itemRepository.findAll();

        model.addAttribute("items", result);

//        var object = new Age();
//
//        object.한살더하기(100);
//        System.out.println(object);
//
//        object.나이설정(200);
//        System.out.println(object);


        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@ModelAttribute Item item) {
        System.out.println(item);
        itemRepository.save(item);


//        Item addItem = new Item();
//        addItem.setTitle(title);
//        addItem.setPrice(price);
//        itemRepository.save(addItem);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detailProduct(@PathVariable Long id, Model model){

        Optional<Item> result = itemRepository.findById(id);
//                Optional: 데이터가 있을 수도 없을 수도 있음.
        if(result.isPresent()) {
            Item item = result.get();
            model.addAttribute("item", item);
            System.out.println("item : " + item);
            return "detail.html";
        }else {
            return"redirect:/list";
        }
    }


}
