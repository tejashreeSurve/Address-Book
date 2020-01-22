package com.bridgelabz.fellowshipprogram.oops.addressbook.model;

import java.util.List;

public class AddressBookList {
	public int id;
public  List<AddressBook> listOfAddress;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public List<AddressBook> getListOfAddress() {
	return listOfAddress;
}

public void setListOfAddress(List<AddressBook> listOfAddress) {
	this.listOfAddress = listOfAddress;
}

}
