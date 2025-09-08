package com.spring.client.article.controller;


import com.spring.client.article.domain.Article;
import com.spring.client.article.service.ArticleService;
import com.spring.common.dto.PageRequestDTO;
import com.spring.common.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/articleList")
    public String articleList(Article article, PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<Article> articleList = articleService.list(pageRequestDTO);
        model.addAttribute("articleList", articleList);
        return "client/article/articleList";
    }

    @GetMapping("/insertForm")
    public String insertForm(Article article){
        return "client/article/insertForm";
    }

    @PostMapping("/articleInsert")
    public String articleInsert(Article article){
        if(!article.getFile().isEmpty()){
            String uploadFileName = fileUtil.saveFile(article.getFile());
            article.setFilename(uploadFileName);
        }
        articleService.articleInsert(article);
        return "redirect:/article/articleList";
    }


    @GetMapping("/{no}")
    public String articleDetail(@PathVariable Long no, Article article, Model model){
        article.setNo(no);
        Article detail = articleService.articleDetail(article);
        model.addAttribute("detail", detail);

        String newLine = System.getProperty("line.separator").toString();
        model.addAttribute("newLine", newLine);
        return "client/article/articleDetail";
    }

    @PostMapping("/updateForm")
    public String updateForm(Article article, Model model){
        Article updateData = articleService.getArticle(article.getNo());
        model.addAttribute("updateData", updateData);
        return "client/article/articleForm";
    }

    @PostMapping("/articleUpdate")
    public String articleUpdate(Article article){
        Article updateData = articleService.getArticle(article.getNo());

        if(!article.getFile().isEmpty()){
            id(updateData.getFilename()!=null){
                fileUtil.deleteFile(updateData.getFilename());
            }
            String uploadFileName = fileUtil.saveFile(article.getFile());
            article.setFilename(uploadFileName);
        }
        articleService.articleUpdate(board);
        return "redirect:/article/"+article.getNo();
    }

    @PostMapping("/articleDelete")
    public String articleDelete(Article article){
        Article deleteData = articleService.getArticle(article.getNo());
        id(deleteData.getFilename()!=null){
            fileUtil.deleteFile(deleteData.getFilename());
        }
        articleService.articleDelete(article);
        return "redirect:/article/articleList";
    }

}
