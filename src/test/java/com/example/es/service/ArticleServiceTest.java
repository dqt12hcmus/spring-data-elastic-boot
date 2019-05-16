package com.example.es.service;

import com.example.es.model.Article;
import com.example.es.model.Author;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Test
    void save() {
        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author("author1"));
        authorList.add(new Author("author2"));
        Article article = new Article();
        article.setAuthors(authorList);
        articleService.save(article);
    }
}