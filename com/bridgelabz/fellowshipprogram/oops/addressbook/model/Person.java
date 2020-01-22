package com.bridgelabz.fellowshipprogram.oops.addressbook.model;

public class Person {
String lname;
String fname;
Address addobj;
String phoneNumber;
public Person(String fname, String lname, Address addobj, String phoneNumber) {
	
	this.lname = lname;
	this.fname = fname;
	this.addobj = addobj;
	this.phoneNumber = phoneNumber;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public Address getAddobj() {
	return addobj;
}
public void setAddobj(Address addobj) {
	this.addobj = addobj;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
}
