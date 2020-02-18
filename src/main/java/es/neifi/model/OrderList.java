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
public class OrderList {
    
    private Order order;
    private String order_id;
    private String articleId;
    private int orderList_id;
    private ArrayList article;
    private int qty;
    private int servedUnits;
    private int price;
    private String status;
    private double totalLinePrice;
    private double totalOrderPrice;
   
    public OrderList() {
    	
    }
    public OrderList(String order_id,String articleId, String quantity, int price,String status,String servedUnits) {
        
        this.order_id = order_id;
        this.articleId = articleId;
        this.qty = Integer.parseInt(quantity);
        this.servedUnits = Integer.parseInt(servedUnits);
        this.price = price;
        this.totalLinePrice = this.qty*this.price;
        this.status = status;
        
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getServedUnits() {
        return servedUnits;
    }

    public void setServedUnits(int servedUnits) {
        this.servedUnits = servedUnits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public OrderList getOrderList(){
        
        return new OrderList();
    }

    public ArrayList getArticle() {
        return article;
    }

    public void setArticle(ArrayList article_id) {
        this.article = article_id;
    }

    public int getOrderList_id() {
        return orderList_id;
    }

    public void setOrderList_id(int orderList_id) {
        
        this.orderList_id = orderList_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalLinePrice() {
        return totalLinePrice;
    }
    
    private void SendOF() {

    }

    private boolean checkStock() {

        return false;
    }
    public String getArticleId() {
		return articleId;
	}
  
    
    
    
    
   
    @Override
    public String toString() {
        return "OrderList{" + ",\norderList_id = " + orderList_id +",\nqty = " + qty + ",\nservedUnits = " + servedUnits + ",\nprice = " + price + "\ntotal price = "+totalLinePrice +",\nstatus = " + status +"\n\n";
    }
    
    
    
}
