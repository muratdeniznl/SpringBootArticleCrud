package com.application.service;

import com.application.model.Article;

import java.util.List;

public class ArticleServiceTest {

    static ArticleService articleService = new ArticleServiceImpl();

    private static void stockTest(int minimumStock, int expectedNbrOfArticles){

        List<Article> test = articleService.articleStock(minimumStock);

        if( test.size() == expectedNbrOfArticles){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }

    public static void main(String[] args) {


        Article article1 = new Article( "byke2000", "Electrical byke for sporty people", 3823.54D, "this is a picture".getBytes(), 12);
        Article article2 = new Article( "byke4650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 3);
        Article article3 = new Article( "byke7650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 7);

        articleService.save(article1);
        articleService.save(article2);
        articleService.save(article3);

        // 12 3 7


        stockTest(5, 1);
        stockTest(1, 0);
        stockTest(100, 3);
        stockTest(11, 2);

    }
}
