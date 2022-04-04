package com.example.jBCrypt.Controller;

import com.example.jBCrypt.Interfaces.UserRepository;
import com.example.jBCrypt.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class GeneralController {
    @Autowired
    UserRepository applicationuserRepository;

    @GetMapping("/loginuser")
    public String MainPage(Principal p, Model m){
        if (p != null){
            String username = p.getName();
            UserModel newUser = (UserModel) applicationuserRepository.findByUsername(username);
            m.addAttribute("newUser", newUser);
        }
        return "indexlogin";
    }

}
