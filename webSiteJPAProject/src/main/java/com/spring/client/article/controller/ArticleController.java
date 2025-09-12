package com.spring.client.article.controller;

import com.spring.client.article.domain.Article;
import com.spring.client.article.service.ArticleService;
import com.spring.client.article.service.ArticleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article/*")
@RequiredArgsConstructor
public class ArticleController {
    /* 생성자로 의존성 주입을 하며 final 키워드가 붙은 필드에 대해 생성자를 만들어준다.
     * 스프링 개발팀에서 생성자 주입을 사용할 것을 권장하는 이유는
     * 한번 의존성 주입을 받은 객체는 프로그램이 끝날 때까지 변하지 않는 특징을
     * 가지므로 불변성을 표시해주는 것이 좋기 때문이다. -> 객체의 불변성(Immutability) 보장
     * */
    private final ArticleService articleService;

    @GetMapping("/articleList")
    public String articleList(Article article, Model model) {
        List<Article> articleList = articleService.articleList(article);
        model.addAttribute("articleList", articleList);
        return "client/article/articleList";
    }

    @GetMapping("/insertForm")
    public String insertForm(Article article) {
        return "client/article/insertForm";
    }

    @PostMapping("/articleInsert")
    public String articleInsert(Article article) {
        articleService.articleInsert(article);
        return "redirect:/article/articleList";
    }

    @GetMapping("/{no}")
    public String articleDetail(@PathVariable Long no, Article article, Model model) {
        article.setNo(no);
        Article detail = articleService.articleDetail(article);
        model.addAttribute("detail", detail);

        String newLine = System.getProperty("line.separator").toString();
        model.addAttribute("newLine", newLine);

        return "client/article/articleDetail";
    }

    @PostMapping("/updateForm")
    public String updateForm(Article article, Model model) {
        Article updateData = articleService.updateForm(article);
        model.addAttribute("updateData", updateData);
        return "client/article/updateForm";
    }

    @PostMapping("/articleUpdate")
    public String articleUpdate(Article article) {
        articleService.articleUpdate(article);
        return "redirect:/article/"+article.getNo();
    }

    @PostMapping("/articleDelete")
    public String articleDelete(Article article) {
        articleService.articleDelete(article);
        return "redirect:/article/articleList";
    }
}