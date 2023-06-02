
package com.agrimensuramisiones.controller;

import com.agrimensuramisiones.enums.Cities;
import com.agrimensuramisiones.enums.Gender;
import com.agrimensuramisiones.services.UsuarioService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;
    
    @PostMapping("/sign-up")
    public String saveUser(RedirectAttributes attr, ModelMap model, @RequestParam String first_name, @RequestParam String last_name, @RequestParam String addres, @RequestParam Integer dni, @RequestParam Integer cuit, @RequestParam Gender gender, @RequestParam String email, @RequestParam Date birth_date, @RequestParam Cities city, @RequestParam Integer phone, @RequestParam String password, @RequestParam String repeatedPassword) {

        try {
            usuarioService.createUser(first_name, last_name, addres, dni, cuit, gender, email, birth_date, city, phone, password, repeatedPassword);
            attr.addFlashAttribute("success", "Se ha registrado el usuario exitosamente");
            return "redirect:/login";
        } catch (Exception e) {
            attr.addFlashAttribute("error", e.getMessage());
            model.put("error", e.getMessage());
            return "redirect:/sign-up";
        }
    }
    
}
