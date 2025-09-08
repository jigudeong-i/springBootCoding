package com.spring.client.article.service;

import com.spring.client.article.domain.Article;
import com.spring.client.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl {
    public final ArticleRepository articleRepository;

    @Override
    public List<Article> articleList(Article article){
        List<Article> articleList = (List<Article>) articleRepository.findAll();
        return articleList;
    }

    @Override
    public void articleInsert(Article article){articleRepository.save(article);}
    

}
