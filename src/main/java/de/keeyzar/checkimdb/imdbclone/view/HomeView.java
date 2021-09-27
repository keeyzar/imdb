package de.keeyzar.checkimdb.imdbclone.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeView {
    @GetMapping("/")
    public String homeView(){
        return "index";
    }
}
