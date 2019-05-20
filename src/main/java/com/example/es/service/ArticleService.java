package com.example.es.service;

import com.example.es.model.Article;
import com.example.es.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService implements IArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Optional<Article> findOne(String id) {
        return articleRepository.findById(id);
    }

    @Override
    public Page<Article> findAll(Pageable pageAble) {
        return articleRepository.findAll(pageAble);
    }

    @Override
    public Page<Article> findByAuthorName(String name, Pageable pageable) {
        return articleRepository.findByAuthorsName(name, pageable);
    }

    @Override
    public Page<Article> findByAuthorNameUsingCustomQuery(String name, Pageable pageable) {
        return articleRepository.findByAuthorsNameUsingCustomQuery(name, pageable);
    }

    @Override
    public Page<Article> findByFilteredTagQuery(String tag, Pageable pageable) {
        return articleRepository.findByFilteredTagQuery(tag, pageable);
    }

    @Override
    public Page<Article> findByAuthorsNameAndFilteredTagQuery(String name, String tag, Pageable pageable) {
        return articleRepository.findByAuthorsNameAndFilteredTagQuery(name, tag, pageable);
    }

    @Override
    public long count() {
        return articleRepository.count();
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }
}
