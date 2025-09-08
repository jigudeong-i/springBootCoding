package com.spring.client.article.repository;

import com.spring.client.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public class ArticleRepository extends JpaRepository<Article, Long> {

}
