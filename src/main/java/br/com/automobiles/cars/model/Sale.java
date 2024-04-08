package br.com.automobiles.cars.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Sale {

	private Date saleDate;
    private String saleTime;
    private Client client;  
	
	
     public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public String getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}