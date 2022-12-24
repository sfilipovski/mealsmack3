package mk.app.mealsmack.data;

import mk.app.mealsmack.model.Restaurant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Restaurant> restaurants = new ArrayList<>();

    @PostConstruct
    public void init() {
        int i = 0;
    }
}
