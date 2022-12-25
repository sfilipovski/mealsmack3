package mk.app.mealsmack.service;

import mk.app.mealsmack.data.DataHolder;
import mk.app.mealsmack.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RestaurantService {
     void save(String name, String municipality, String lon, String lat, List<String> cuisine, String amenity);
     List<Restaurant> findAll();
     Optional<Restaurant> findById(Long id);
     List<Restaurant> filterRestaurants(String name, String amenity, String cuisine);
     Set<String> getCuisines();
     void delete(Long id);
}
