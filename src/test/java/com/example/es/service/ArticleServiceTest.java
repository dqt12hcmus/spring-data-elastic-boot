package com.example.es.service;

import com.example.es.config.Config;
import com.example.es.model.Article;
import com.example.es.model.Author;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
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
    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Article.class);
        esTemplate.createIndex(Article.class);
        esTemplate.putMapping(Article.class);
        esTemplate.refresh(Article.class);
    }
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

    }
    @Test
    void delete(){
        Article article = new Article();
        article.setId("5");
        articleService.delete(article);
    }
    @Test
    void findByName(){
        String name = "author1";
        Page<Article> pageOneWithTwoRecords = articleService.findByAuthorName(name, PageRequest.of(0, 2));
        Page<Article> pageTwoWithTwoRecords = articleService.findByAuthorName(name, PageRequest.of(1, 2));
    }

}