package mk.app.mealsmack.controller;

import mk.app.mealsmack.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    private final RestaurantService restaurantService;

    public HomeController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("restaurants", restaurantService.findAll());
        return "home";
    }

    @GetMapping("/map/{id}")
    public String getMapping(@PathVariable Long id, Model model){
        if(restaurantService.findById(id).isPresent()){
            model.addAttribute("restaurant",restaurantService.findById(id).get());
            return "map";
        }
        return "redirect:/home";
    }
}
