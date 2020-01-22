package com.bridgelabz.fellowshipprogram.oops.addressbook.model;

import java.util.List;

public class AddressBook {
	int IdOfAddressBook;
	String NameOfAddressBook;
	List<Person> list;

	public AddressBook(int idOfAddressBook, String nameOfAddressBook, List<Person> list) {

		IdOfAddressBook = idOfAddressBook;
		NameOfAddressBook = nameOfAddressBook;
		this.list = list;
	}

	public int getIdOfAddressBook() {
		return IdOfAddressBook;
	}

	public void setIdOfAddressBook(int idOfAddressBook) {
		IdOfAddressBook = idOfAddressBook;
	}

	public String getNameOfAddressBook() {
		return NameOfAddressBook;
	}

	public void setNameOfAddressBook(String nameOfAddressBook) {
		NameOfAddressBook = nameOfAddressBook;
	}

	public List<Person> getList() {
		return list;
	}

	public void setList(List<Person> list) {
		this.list = list;
	}

}
