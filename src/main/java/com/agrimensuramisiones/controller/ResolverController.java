
package com.agrimensuramisiones.controller;

import com.agrimensuramisiones.entities.Usuario;
import com.agrimensuramisiones.enums.Rol;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resolver")
public class ResolverController {
    
    @GetMapping
    public String resolver(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usersession");
        
        if (usuario.getRol().equals(Rol.ADMIN)) return "redirect:/";
        if (usuario.getRol().equals(Rol.AUTHORITY)) return "redirect:/";
        if (usuario.getRol().equals(Rol.PARTNER)) return "redirect:/";
        
        return "redirect:/logout";
    }
    
}
