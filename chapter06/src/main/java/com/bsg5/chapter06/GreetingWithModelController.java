package com.bsg5.chapter06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GreetingWithModelController {

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable(name="name") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    // ModelMap example
//    public String greeting(ModelMap map) {
//        map.addAttribute("helloWorld");
//        map.addAttribute("threadbareLoaf");
//        return "greeting";
//    }

    // ModelAndView example
//    public ModelAndView greeting() {
//        Map<String, String> model = new HashMap<>();
//        model.put("helloWorld", "helloWorld");
//        model.put("threadbareLoaf", "threadbareLoaf");
//        return new ModelAndView("greeting", model);
//    }

}
