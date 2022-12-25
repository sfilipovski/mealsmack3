package mk.app.mealsmack.controller;

import mk.app.mealsmack.model.Admin;
import mk.app.mealsmack.model.exception.InvalidUserCredentialsException;
import mk.app.mealsmack.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private  final AdminService adminService;

    public LoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping
    public String tryLogin(Model model , HttpServletRequest request){
        Admin admin = null;
        try{
            admin = adminService.login(request.getParameter("username"),request.getParameter("password"));
            request.getSession().setAttribute("admin", admin);
            return "redirect:/home";
        }
        catch(InvalidUserCredentialsException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }


}

