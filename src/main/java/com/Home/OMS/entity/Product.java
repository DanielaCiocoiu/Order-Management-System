package com.Home.OMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long code;
	 
	    @Column(nullable = false, unique = true)
	    private String name;
	 
	    @Column(nullable = false)
	    private String description;

	    @Column(nullable = false)
	    private String category;
	    
	    @Column(nullable = false)
	    private int quantity;
	    
	    public Product() {
	    	
	    }

		public Product(String name, String description, String category, int quantity) {
			super();
			this.name = name;
			this.description = description;
			this.category = category;
			this.quantity = quantity;
		}

		public long getCode() {
			return code;
		}

		public void setCode(long code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((category == null) ? 0 : category.hashCode());
			result = prime * result + (int) (code ^ (code >>> 32));
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + quantity;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (category == null) {
				if (other.category != null)
					return false;
			} else if (!category.equals(other.category))
				return false;
			if (code != other.code)
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (quantity != other.quantity)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Product [code=" + code + ", name=" + name + ", description=" + description + ", category="
					+ category + ", quantity=" + quantity + "]";
		}
	    
		
		
}
