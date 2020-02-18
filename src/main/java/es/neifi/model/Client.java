/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.neifi.model;

import java.io.ObjectInputStream;
import java.sql.*;

/**
 *
 * @author neifi
 */
public class Client {

    private String id;
    private String businessName;
    private String country;
    private String postalAdress;
    private String zipCode;
    private String email;
    private String phoneNumber;
    private String iban;
    private String isDefaulter;
    private Order order;

    public Client() {

    }
    
    public Client(String id) {
    	this.id = id;
    }

	public Client(String id, String businessName, String country, String postalAdress, String zipCode, String email,
			String phoneNumber, String iban, String isDefaulter) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.country = country;
		this.postalAdress = postalAdress;
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.iban = iban;
		this.isDefaulter = isDefaulter;
	}

	public Client(String id, String businessName, String country, String postalAdress, String zipCode, String email,
			String phoneNumber, String iban, String isDefaulter, Order order) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.country = country;
		this.postalAdress = postalAdress;
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.iban = iban;
		this.isDefaulter = isDefaulter;
		this.order = order;
	}

	
	public Client(String id, String businessName, String country, String postalAdress, String zipCode, String email,
			String phoneNumber, String iban) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.country = country;
		this.postalAdress = postalAdress;
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.iban = iban;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalAdress() {
		return postalAdress;
	}

	public void setPostalAdress(String postalAdress) {
		this.postalAdress = postalAdress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(String isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", businessName=" + businessName + ", country=" + country + ", postalAdress="
				+ postalAdress + ", zipCode=" + zipCode + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", iban=" + iban + ", isDefaulter=" + isDefaulter + ", order=" + order + "]";
	}
    
    
	
	
   
    
}
