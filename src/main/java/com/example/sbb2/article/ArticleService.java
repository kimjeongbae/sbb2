package com.example.sbb2.article;

import com.example.sbb2.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    public List<Article> getList() {
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isEmpty()) {
            return null;
        }
        return article.get();
    }



    public void create (String subject, String content, User author){
        Article a = new Article();
        a.setSubject(subject);
        a.setContent(content);
        a.setAuthor(author);
        a.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(a);
    }

    public void modify(Article article, String subject, String content) {
        article.setSubject(subject);
        article.setContent(content);
        article.setModifyDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }

    public void delete(Article article) {
        this.articleRepository.delete(article);
    }
}
