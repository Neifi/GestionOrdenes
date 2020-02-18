/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.neifi.model;

import es.neifi.model.Order;

/**
 *
 * @author neifi
 */
public class Provider {
    
    private int id;
    private String cif;
    private double price;
    
    public Provider(){
    
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void sendOrder(Order order){
        
    }
    
    
    
}
