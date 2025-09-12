package com.spring.client.article.service;

import com.spring.client.article.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<Article> articleList(Article article);
    void articleInsert(Article article);     // HitUpdate를 한 이유는 조회수까지 같이 올라가야해서
    Article articleDetail(Article article);
    Article updateForm(Article article);
    void articleUpdate(Article article);
    void articleDelete(Article article);
}
