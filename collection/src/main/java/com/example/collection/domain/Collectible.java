package com.example.collection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Collectible {
	// item, desc, amount
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	private String collectibleName;
	private String description;
	private int amount;
	public Collectible() {
		super();
		this.id = 0L;
		this.collectibleName = null;
		this.description = null;
		this.amount = 0;
		this.category = null;
	}
	public Collectible(String collectible, String description, int amount) {
		super();
		this.id = 0L;
		this.collectibleName = collectible;
		this.description = description;
		this.amount = amount;
		this.category = null;
	}
	public Collectible(Long id, String collectible, String description, int amount) {
		super();
		this.id = id;
		this.collectibleName = collectible;
		this.description = description;
		this.amount = amount;
		this.category = null;
	}
	
	public Collectible(Category category, String collectible, String description, int amount) {
		super();
		this.category = category;
		this.collectibleName = collectible;
		this.description = description;
		this.amount = amount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCollectibleName() {
		return collectibleName;
	}
	public void setCollectibleName(String collectibleName) {
		this.collectibleName = collectibleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", collectibleName=" + collectibleName + ", description=" + description + ", amount=" + amount + ", category" + category 
				+ "]";
	}	

}

