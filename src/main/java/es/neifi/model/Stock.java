/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.neifi.model;

import es.neifi.model.Article;
import es.neifi.model.Components;

/**
 *
 * @author neifi
 */
public class Stock {

    public enum MovType {
        I, O
    }

    private int id;
    private int warehouse_id;
    private MovType movType;
    private int article_id;
    private int comp_id;
    private int qty;
    private int positionX;
    private int positionY;
    private int positionZ;

    public Stock() {
        
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getComp_id() {
        return comp_id;
    }

    public void setComp_id(int comp_id) {
        this.comp_id = comp_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MovType getMovType() {
        return movType;
    }

    public void setMovType(MovType movType) {
        this.movType = movType;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(int positionZ) {
        this.positionZ = positionZ;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }
    
    public int getQty(Components comp){
        
        return 0;
    }
    
      public int getQty(Article art){
        
        return 0;
    }
    
}
