package boardsubin.subinboard.controller;


import org.springframework.stereotype.Controller;

@Controller("/")
public class HomeController {
    public String home(){
        return "redirect:/board/list";
    }
}
