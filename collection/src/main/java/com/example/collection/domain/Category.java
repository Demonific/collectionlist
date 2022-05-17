package com.example.collection.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Annotaatiot
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	private String categoryName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Collectible> collectibles;
	// Constructorit, Setterit, Getterit ja toString
	public Category() {
		super();
		this.categoryId = null;
		this.categoryName = null;
		this.collectibles = null;
	}
	public Category(Long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.collectibles = null;
	}
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
		this.collectibles = null;
	}
	
	public Category(Long categoryId, String categoryName, List<Collectible> collectibles) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.collectibles = collectibles;
	}
	
	public List<Collectible> getCollectibles() {
		return collectibles;
	}
	public void setCollectibles(List<Collectible> collectibles) {
		this.collectibles = collectibles;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
}
