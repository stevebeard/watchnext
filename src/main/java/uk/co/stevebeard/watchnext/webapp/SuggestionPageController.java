package uk.co.stevebeard.watchnext.webapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class SuggestionPageController {

    private RestTemplate restTemplate;

    SuggestionPageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate; }

    @GetMapping("/suggestion")
    public String suggestion(Model model) {
        Item item = restTemplate.getForObject("http://localhost:8080/api/items/random", Item.class);
        model.addAttribute("item", item);
        return "suggestion";
    }

    @PostMapping("/selection")
    public String confirmSelection(Model model, HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id").trim());
        Item item = restTemplate.getForObject("http://localhost:8080/api/items/" + id, Item.class);
        log.info("Deleting entry: " + item);
        restTemplate.delete("http://localhost:8080/api/items/" + id);
        model.addAttribute("item", item);
        return "selection";
    }

}
