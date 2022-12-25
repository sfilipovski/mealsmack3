package mk.app.mealsmack.data;

import mk.app.mealsmack.model.Admin;
import mk.app.mealsmack.model.Restaurant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Restaurant> restaurants = new ArrayList<>();
    public static List<Admin> admins;
    @PostConstruct
    public void init() {
        admins = new ArrayList<>();
        admins.add(new Admin("admin1","admin"));
        admins.add(new Admin("admin2","admin"));
    }
}
