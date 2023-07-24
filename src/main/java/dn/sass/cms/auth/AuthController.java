package dn.sass.cms.auth;

import dn.sass.cms.user.dto.UserDto;
import dn.sass.cms.user.model.User;
import dn.sass.cms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(
            @Valid @ModelAttribute("user") UserDto userDto,
            BindingResult result,
            Model model
    ) {
        User existsUser = userService.getUserByEmail(userDto.getEmail());

        if (null != existsUser) {
            result.rejectValue("email", null, "User already registered");
        }

        if(result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/registration?success";
    }
}
