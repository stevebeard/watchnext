package uk.co.stevebeard.watchnext.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/addItem")
@Controller
public class AddItemPageController {

    private RestTemplate restTemplate;

    AddItemPageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String get() {
        return "addItem";
    }

    @PostMapping
    public ModelAndView post(HttpServletRequest request) {
        String name = request.getParameter("name").trim();
        Item item = new Item(name);
        restTemplate.postForEntity("http://localhost:8080/api/items",
                item, Item.class);
        // redirect to watch list page
        return new ModelAndView("redirect:/");
    }

}
