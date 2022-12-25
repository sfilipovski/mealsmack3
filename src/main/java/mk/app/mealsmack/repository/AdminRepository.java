package mk.app.mealsmack.repository;

import mk.app.mealsmack.data.DataHolder;
import mk.app.mealsmack.model.Admin;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdminRepository {
    public Optional<Admin> findByUsernameAndPassword(String username, String password){
        return DataHolder.admins.stream()
                .filter(a -> a.getUsername().equals(username) && a.getPassword().equals(password))
                .findFirst();
    }
}
