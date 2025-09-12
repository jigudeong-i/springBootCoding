package com.spring.client.article.service;

import com.spring.client.article.domain.Article;
import com.spring.client.article.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    @Override
    public List<Article> articleList(Article article) {
        return articleRepository.findAll();
    }

    @Override
    @Transactional
    public void articleInsert(Article article) {
        articleRepository.save(article);
    }
    /* IllegalArgumentException; 잘못된 인자(값)가 메서드에 전달되었을 때 발생 */
    @Override
    @Transactional
    public Article articleDetail(Article article) {
        Article data = articleRepository.findById(article.getNo())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        data.setHit(data.getHit() + 1);
        Article detail = articleRepository.save(data);
        return detail;
    }

    @Override
    public Article updateForm(Article article) {
        return articleRepository.findById(article.getNo())
                .orElseThrow(() -> new IllegalArgumentException("수정할 게시글이 존재하지 않습니다."));
    }

    @Override
    public void articleUpdate(Article article) {
        Article updateArticle = articleRepository.findById(article.getNo())
                .orElseThrow(() -> new IllegalArgumentException("수정할 게시글이 존재하지 않습니다."));

        updateArticle.setTitle(article.getTitle());
        updateArticle.setContent(article.getContent());
        articleRepository.save(updateArticle);
    }

    @Override
    public void articleDelete(Article article) {
        //articleRepository.deleteById(article.getNo());
        if (!articleRepository.existsById(article.getNo())) {
            throw new IllegalArgumentException("삭제할 게시글이 존재하지 않습니다.");
        }
        articleRepository.deleteById(article.getNo());
    }
}


