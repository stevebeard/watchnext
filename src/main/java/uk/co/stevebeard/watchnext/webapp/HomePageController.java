package uk.co.stevebeard.watchnext.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    Environment environment;

    private RestTemplate restTemplate;

    HomePageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate; }

    @GetMapping("/")
    public String home(Model model) {
        List<Item> items = restTemplate.exchange("http://localhost:8080/api/items",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Item>>() {}).getBody();
        model.addAttribute("allItems", items);
        return "home";
    }

}
