package mk.app.mealsmack.service.impl;

import mk.app.mealsmack.model.Admin;
import mk.app.mealsmack.model.exception.InvalidArgumentsException;
import mk.app.mealsmack.model.exception.InvalidUserCredentialsException;
import mk.app.mealsmack.repository.AdminRepository;
import mk.app.mealsmack.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()) throw new InvalidArgumentsException();
        return adminRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
