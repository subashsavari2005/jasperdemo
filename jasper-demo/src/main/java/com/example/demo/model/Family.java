package com.example.demo.model;

public class Family {

	private int id;

	private String fName;

	private String lName;

	private String street;

	private String city;

	public Family(int id, String fName, String lName, String street, String city) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.street = street;
		this.city = city;
	}

	public Family() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
