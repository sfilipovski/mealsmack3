package mk.app.mealsmack.repository;

import mk.app.mealsmack.model.Restaurant;
import mk.app.mealsmack.data.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepository {

    public void save(String name, String municipality, String lon, String lat, List<String> cuisine, String amenity){
        DataHolder.restaurants.add(new Restaurant(name, municipality, lon, lat, cuisine, amenity));
    }

    public List<Restaurant> findAll(){
        return DataHolder.restaurants;
    }

    public Optional<Restaurant> findById(Long id){
        return DataHolder.restaurants.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
