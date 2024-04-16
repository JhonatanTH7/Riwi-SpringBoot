package com.riwi.HelloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

// Indica que la clase sera un controlador
@Controller
// Crea la ruta base del controlador
@RequestMapping("/controller")
public class HelloWorld {

    // Crea una ruta especifica para el metodo
    @GetMapping("/helloworld")
    // Nos permite responder en el navegador
    @ResponseBody
    public String showMessage() {
        return "Hello World";
    }

    @GetMapping("/sum")
    @ResponseBody
    public int sum() {
        return 2 + 2;
    }
}
