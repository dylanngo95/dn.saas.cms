package dn.sass.cms.customer;

import dn.sass.cms.config.MyUserDetails;
import dn.sass.cms.user.dto.UserDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public String customer(Model model) {
        MyUserDetails userAuth = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDto user = new UserDto();
        user.setUsername(userAuth.getUsername());
        model.addAttribute("user", user);
        return "customer";
    }
}
