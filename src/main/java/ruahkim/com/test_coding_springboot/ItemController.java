package ruahkim.com.test_coding_springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {

        List<Item> result = itemRepository.findAll();

        model.addAttribute("items", result);

        var object = new Age();

        object.한살더하기(100);
        System.out.println(object);

        object.나이설정(200);
        System.out.println(object);



        return "list.html";
    }


}
