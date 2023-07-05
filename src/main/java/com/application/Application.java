package com.application;

import com.application.controller.ArticleController;
import com.application.model.Article;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ArticleController articleController = new ArticleController();

        Article article1 = new Article( "byke2000", "Electrical byke for sporty people", 3823.54D, "this is a picture".getBytes(), 12);
        Article article2 = new Article( "byke4650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 3);
        Article article3 = new Article( "byke7650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 2);

        articleController.createArticle(article1);
        articleController.createArticle(article2);
        articleController.createArticle(article3);

        for (Article article: articleController.getAllArticles()){
            System.out.println(article);
        }
        System.out.println("---------------------------------------------------------------------");

        articleController.deleteArticleById(2);
        for (Article article: articleController.getAllArticles()){
            System.out.println(article);
        }
        System.out.println("---------------------------------------------------------------------");

        Article article4 = new Article( "byke1650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 12);
        articleController.createArticle(article4);

        for (Article article: articleController.getAllArticles()){
            System.out.println(article);
        }
        System.out.println("---------------------------------------------------------------------");

        List<Article> filteredArticles = articleController.getAllArticlesWithLowStock(100);

        for (Article article: filteredArticles){
            System.out.println(article);
        }

    }
}
