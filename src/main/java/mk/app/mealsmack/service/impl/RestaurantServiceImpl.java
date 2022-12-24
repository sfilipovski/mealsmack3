package mk.app.mealsmack.service.impl;

import mk.app.mealsmack.model.Restaurant;
import mk.app.mealsmack.repository.RestaurantRepository;
import mk.app.mealsmack.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public void save(String name, String municipality, String lon, String lat, List<String> cuisine, String amenity) {
         restaurantRepository.save(name, municipality, lon, lat, cuisine, amenity);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }
}
