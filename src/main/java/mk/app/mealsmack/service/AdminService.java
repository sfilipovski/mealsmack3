package mk.app.mealsmack.service;


import mk.app.mealsmack.model.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
