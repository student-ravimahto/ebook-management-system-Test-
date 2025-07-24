package com.entity;


public class User {
	private int Id;
	private String Name;
	private String Email;
	private String Password;
	private String PhNo;
	private String Address;
	private String Landmark;
	private String City;
	private String State;
	private String Pincode;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhNo() {
		return PhNo;
	}
	public void setPhNo(String phNo) {
		PhNo = phNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getLandmark() {
		return Landmark;
	}
	public void setLandmark(String landmark) {
		Landmark = landmark;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Password=" + Password + ", PhNo=" + PhNo
				+ ", Address=" + Address + ", Landmark=" + Landmark + ", City=" + City + ", State=" + State
				+ ", Pincode=" + Pincode + "]";
	}
	

	
	
}
