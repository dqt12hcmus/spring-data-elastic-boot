package com.example.es.controller;

import com.example.es.model.Article;
import com.example.es.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OverviewController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/blog/article")
    public Page<Article> index(Pageable pageable) {
        return articleService.findAll(pageable);
    }

}
