package com.example.jBCrypt.Controller;

import com.example.jBCrypt.Interfaces.PostRepository;
import com.example.jBCrypt.Interfaces.UserRepository;
import com.example.jBCrypt.Model.UserModel;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;

@Controller
public class ApplicationController {
    final UserRepository userrepository;
    final PostRepository postrepository;

    public ApplicationController(UserRepository userrepository, PostRepository postrepository) {
        this.userrepository = userrepository;
        this.postrepository = postrepository;
    }

//    @GetMapping("/loginuser")
//    public String homepagelogin(Principal user,Model m)  {
//        if (user != null){
//            String username = user.getName();
//            UserModel newUser = userrepository.findByUsername(username);
//            String name=newUser.username;
//            m.addAttribute("name", name);
//        }
//        return "indexlogin";
//    }
//

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signUpUser(Model m, String username, String password) throws Exception {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        UserModel newuserUser = new UserModel(username, hashed);
        userrepository.save(newuserUser);
        return new RedirectView("/login");
    }

    @PostMapping("/login")
    public RedirectView logInUser(String username, String password) throws IllegalArgumentException {
        UserModel userFromDb = userrepository.findByUsername(username);
        if ((userFromDb == null) || (!BCrypt.checkpw(password, userFromDb.getPassword()))) {
            return new RedirectView("/login");
        }
        return new RedirectView("/loginuser");
    }

}