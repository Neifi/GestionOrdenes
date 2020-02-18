/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.neifi.model;

import java.util.ArrayList;

/**
 *
 * @author neifi
 */
public class Order {

    public enum Status {
        RECIVED, IN_PROCESS, CANCELED, SENDED, INCIDENCE, FINISHED
    }

    private String client_id;
    private String order_id;
    private ArrayList<OrderList> articles;
    private String status;
    private int qty;
    private double totalPrice;
    public Order() {

    }

    public Order(String orderId, String client_id, ArrayList<OrderList> articles, double totalOrderPrice, String status) {
        this.client_id = client_id;
        this.articles = articles;
        this.totalPrice = totalOrderPrice;
        this.status = status;
        this.order_id = orderId;
    }

   
    
    public Order(String client_id, String orderId, String status) {
    	this.client_id = client_id;
        this.articles = articles;
        this.status = status;
        this.order_id = orderId;
	}

	public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public ArrayList<OrderList> getArticles() {
        
        return articles;
    }

    public void setArticles(ArrayList<OrderList> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public boolean isDefaulter(int client_id) {
        return false;
    }

    
    public String toString() {
        return "Order{" + " \nclient_id=" + client_id + ",\norder_id=" + order_id + ",\nstatus=" + status + ",\ntotalPrice=" + totalPrice + "\n";
    }
    
   
    

  

}
