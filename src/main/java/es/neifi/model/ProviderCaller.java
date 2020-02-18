/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.neifi.model;

import es.neifi.model.Article;
import es.neifi.model.Components;
import java.util.List;

/**
 *
 * @author neifi
 */
public class ProviderCaller {

    private int provider_id;
    private List<Components> compList;
    private List<Article> artList;

    public ProviderCaller() {
    }
    
    private void call(int provider_id){
    
    }

    public List<Article> getArtList() {
        return artList;
    }

    public void setArtList(List<Article> artList) {
        this.artList = artList;
    }

    public List<Components> getCompList() {
        return compList;
    }

    public void setCompList(List<Components> compList) {
        this.compList = compList;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }
    
    
}
