package com.yc.bean;

import java.util.Date;

public class House {
/**
  ID          int primary key auto_increment,                
  USER_ID     int,                
  TYPE_ID     int,                 
  TITLE       NVARCHAR(50),          
  DESCRIPTION text,     
  PRICE       double,                
  PUBDATE     DATE,                  
  floorage    int,   --面积              
  contact     VARCHAR(100),--联系方式        
  STREET_ID   int   
	 */
	private Integer id;
	private User user;
	private HouseType type;
	private Street street;
	private String title;
	private String description;
	private Double price;
	private String pubDate;
	private Integer floorage;
	private String contact;
	



	private Double minPrice;
	private Double maxPrice;
	private Integer minfloorage;
	private Integer maxfloorage;
	

	private String orderby;
	private String orderway;
	
	private Integer start;

	
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getOrderway() {
		return orderway;
	}

	public void setOrderway(String orderway) {
		this.orderway = orderway;
	}

	

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getMinfloorage() {
		return minfloorage;
	}

	public void setMinfloorage(Integer minfloorage) {
		this.minfloorage = minfloorage;
	}

	public Integer getMaxfloorage() {
		return maxfloorage;
	}

	public void setMaxfloorage(Integer maxfloorage) {
		this.maxfloorage = maxfloorage;
	}

	public House() {
		super();
	}


	
	/*public House(Integer userId, Integer typeId, Integer streetId,
			String title, Double price) {
		super();
		this.userId = userId;
		this.typeId = typeId;
		this.streetId = streetId;
		this.title = title;
		this.price = price;
	}*/

	public House(User user, HouseType type, Street street, String title,
			Double price) {
		super();
		this.user = user;
		this.type = type;
		this.street = street;
		this.title = title;
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HouseType getType() {
		return type;
	}

	public void setType(HouseType type) {
		this.type = type;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	/*minmal constructor*/
	/*public House(Integer userId, Integer typeId, Integer streetId,
			String title, String description, Double price, Date pubDate,
			Integer floorage, String contact) {
		super();
		this.userId = userId;
		this.typeId = typeId;
		this.streetId = streetId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubDate = pubDate;
		this.floorage = floorage;
		this.contact = contact;
	}
	*/

	public House(User user, HouseType type, Street street, String title,
			String description, Double price, String pubDate, Integer floorage,
			String contact) {
		super();
		this.user = user;
		this.type = type;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubDate = pubDate;
		this.floorage = floorage;
		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public Integer getFloorage() {
		return floorage;
	}

	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", user=" + user + ", type=" + type
				+ ", street=" + street + ", title=" + title + ", description="
				+ description + ", price=" + price + ", pubDate=" + pubDate
				+ ", floorage=" + floorage + ", contact=" + contact + "]";
	}

	
	

	
	
	
}
