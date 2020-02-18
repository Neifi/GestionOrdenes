/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.neifi.model;

/**
 *
 * @author neifi
 */
public class warehouse {
    private int id;
    private int[][][] position;
    
    public warehouse(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[][][] getPosition() {
        return position;
    }

    public void setPosition(int[][][] position) {
        this.position = position;
    }
    
    
}
