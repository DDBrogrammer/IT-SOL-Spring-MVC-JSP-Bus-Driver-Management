package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestSpring {
    @RequestMapping("/home")
    public String getHomePage(ModelMap model){
        model.addAttribute("message", "World");
      return "resources/views/index";
    }
}
