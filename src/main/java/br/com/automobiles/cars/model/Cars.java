package br.com.automobiles.cars.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Cars {
	   
	    private BigDecimal price;
	    private Number year;
	    private String codeFipe;
	    
	    @ManyToOne
	    private Brand brand;
	    @ManyToOne
	    private Model model;
	    
	    
	  
	    
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public Brand getBrand() {
			return brand;
		}
		public void setBrand(Brand brand) {
			this.brand = brand;
		}
		public Model getModel() {
			return model;
		}
		public void setModel(Model model) {
			this.model = model;
		}
		public Number getYear() {
			return year;
		}
		public void setYear(Number year) {
			this.year = year;
		}
		public String getCodeFipe() {
			return codeFipe;
		}
		public void setCodeFipe(String codeFipe) {
			this.codeFipe = codeFipe;
		}

	
}
