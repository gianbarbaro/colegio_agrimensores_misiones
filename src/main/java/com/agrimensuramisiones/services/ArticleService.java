
package com.agrimensuramisiones.services;

import com.agrimensuramisiones.entities.Article;
import com.agrimensuramisiones.repositories.ArticleRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Transactional(rollbackFor = {Exception.class})
    public Article create(String title, String content) throws Exception {
        
        Article article = new Article();
        
        article.setTitle(title);
        
        article.setContent(content);
        article.setShort_content(content.substring(0, 255) + "...");
        
        article.setCreated_at(new Date());
        article.setUpdated_at(null);
        article.setVisible(true);
        
        return articleRepository.save(article);
    }
    
    @Transactional(rollbackFor = {Exception.class})
    public void modify(String id, String title, String content) throws Exception {
        
        Optional<Article> respuesta = articleRepository.findById(id);
        
        if (respuesta.isPresent()) {
            
            Article article = respuesta.get();
            
            article.setTitle(title);
            article.setContent(content);
            article.setUpdated_at(new Date());
            
            articleRepository.save(article);
        } else {
            throw new Exception("El articulo no fue encontrado");
        }
    }
    
    @Transactional(readOnly = true)
    public Article findById(String id) throws Exception {
        Optional<Article> respuesta = articleRepository.findById(id);
        if (respuesta.isPresent()) {
            return respuesta.get();
        } else {
            throw new Exception("El articulo no fue encontrado");
        }
    }
    
    @Transactional(readOnly = true)
    public List<Article> articleList() {
        return articleRepository.findAll();
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Article enable(String id) throws Exception {
        Optional<Article> respuesta = articleRepository.findById(id);
        if (respuesta.isPresent()) {
            Article article = respuesta.get();
            article.setVisible(true);
            return articleRepository.save(article);
        } else {
            throw new Exception("El articulo no fue encontrado");
        }
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Article disable(String id) throws Exception {
        Optional<Article> respuesta = articleRepository.findById(id);
        if (respuesta.isPresent()) {
            Article article = respuesta.get();
            article.setVisible(false);
            return articleRepository.save(article);
        } else {
            throw new Exception("El articulo no fue encontrado");
        }
    }
    
}
