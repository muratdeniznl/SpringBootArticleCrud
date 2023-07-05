package com.application.repositories;

import com.application.model.Article;
import com.application.model.Sequence;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository{

    private List<Article> articles = new ArrayList<>();

    public ArticleRepositoryImpl() {
        Article article1 = new Article( "byke2000", "Electrical byke for sporty people", 3823.54D, "this is a picture".getBytes(), 12);
        article1.setId(Sequence.getNextSequence());
        Article article2 = new Article( "byke4650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 3);
        article2.setId(Sequence.getNextSequence());
        Article article3 = new Article( "byke7650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 2);
        article3.setId(Sequence.getNextSequence());
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);

        Article article4 = new Article( "byke47650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 32);
        save(article4);




    }

    @Override
    public List<Article> findAll(){
        return articles;
    }

    @Override
    public Article findById( long id){

        for( Article article: articles){
            if( article.getId() == id){
                return article;
            }
        }

        return null;
    }

    @Override
    public Article save( Article article){

        long id = Sequence.getNextSequence();
        article.setId(id);
        articles.add(article);

        return article;
    }

    @Override
    public void remove( long id){

        List<Article> newArticles = new ArrayList<>();

        for( Article article: articles){

            if( article.getId() != id){
                newArticles.add(article);
            }
        }

        articles = newArticles;
    }

}
