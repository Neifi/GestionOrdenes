/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.neifi.model;

import es.neifi.model.Article;
import java.awt.Component;

/**
 *
 * @author neifi
 */
public class Checking {

    private Component component;
    private Article article;

    public Checking() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public void putComponent(Component comp) {

    }

    public void putArticle(Article art) {

    }
}
