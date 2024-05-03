package ruahkim.com.test_coding_springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventRepository eventRepository;

    @GetMapping("/event")
    String list(Model model) {

        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);

        return "/event.html";
    }
}
