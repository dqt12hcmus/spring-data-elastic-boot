package com.example.es.service;

import com.example.es.config.Config;
import com.example.es.model.Article;
import com.example.es.model.Author;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest()
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Test
    void save() {
        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author("author1"));
        authorList.add(new Author("author2"));

        Article article1 = new Article();
        article1.setId("1");
        article1.setAuthors(authorList);
        article1.setTitle("Title1-new");
        articleService.save(article1);

        Article article2 = new Article();
        article2.setId("2");
        article2.setAuthors(authorList);
        article2.setTitle("Title2");
        articleService.save(article2);

        Article article3 = new Article();
        article3.setId("3");
        article3.setAuthors(authorList);
        article3.setTitle("Title3");
        articleService.save(article3);

        Article article4 = new Article();
        article4.setId("5");
        article4.setAuthors(authorList);
        article4.setTitle("Title4");
        articleService.save(article4);
    }
    @Test
    void findOne(){
        Optional<Article> article = articleService.findOne("5");
        if(article.isPresent()){
            System.out.println(article.get().getTitle());
        }else{
            System.out.println("No such document");
        }
    }
    @Test
    void findAll(){
        Iterable<Article> articles = articleService.findAll();
        articles.forEach(System.out::println);
    }
}