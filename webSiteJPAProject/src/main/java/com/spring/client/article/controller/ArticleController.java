package com.spring.client.article.controller;


import com.spring.client.article.domain.Article;
import com.spring.client.article.service.ArticleService;
import com.spring.common.dto.PageRequestDTO;
import com.spring.common.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article/*")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/ArticleList")
    public String ArticleList(Article article, PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<Article> articleList = articleService.list(pageRequestDTO);
        model.addAttribute("articleList", articleList);
        return "client/article/articleList";
    }

}
