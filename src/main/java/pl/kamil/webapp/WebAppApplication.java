package pl.kamil.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@SpringBootApplication
public class WebAppApplication {
	
    @RequestMapping("/")
    String home() {
        return "home";
    }

    @RequestMapping(method = GET, value = "/rest/author")
    @ResponseBody
    String author() {
        return "kamil";
    }

    @RequestMapping("/goodbye")
    public String bye(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "goodbye";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }


	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

}
