
package com.agrimensuramisiones.controller;

import com.agrimensuramisiones.entities.Article;
import com.agrimensuramisiones.entities.User;
import com.agrimensuramisiones.services.ArticleService;
import com.agrimensuramisiones.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ArticleService articleService;
    
    @GetMapping("/")
    public String index(ModelMap model) {
        
        List<User> partnersList = userService.userPartnerList();
        model.put("partners", partnersList);
        
        List<User> authoritiesList = userService.userAuthorityList();
        model.put("authorities", authoritiesList);
        
        List<Article> articleList = articleService.articleList();
        model.put("articles", articleList);
        
        return "index.html";
    }
    
    @GetMapping("/login")
    public String login(ModelMap model, @RequestParam(required = false) String error, @RequestParam(required = false) String logout) throws Exception {
        if (error != null) {
            model.put("error", "Correo electrónico y/o clave incorrecta");
        }
        if (logout != null) {
            model.put("logout", "Has cerrado sesión correctamente");
        }
        return "login.html";
    }
    
}
