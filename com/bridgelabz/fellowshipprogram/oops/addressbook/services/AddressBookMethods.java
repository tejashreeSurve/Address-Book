package com.bridgelabz.fellowshipprogram.oops.addressbook.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.bridgelabz.fellowshipprogram.oops.addressbook.model.Address;
import com.bridgelabz.fellowshipprogram.oops.addressbook.model.Person;
import com.bridgelabz.fellowshipprogram.oops.addressbook.utility.Utility;

public class AddressBookMethods {
	static Scanner scanner = new Scanner(System.in);
	Utility utility = new Utility();
	boolean status;

	/**
	 * Purpose: This method add new Person details in Person list
	 */
	public ArrayList<Person> createNewBook(ArrayList<Person> listOfPersons) {
		System.out.println("Enter firstName\n");
		String pname = scanner.next();
		System.out.println("Enter LastName\n");
		String plname = scanner.next();
		System.out.println("Enter city\n");
		String city = scanner.next();
		System.out.println("Enter zip\n");
		int zip = scanner.nextInt();
		System.out.println("Enter state\n");
		String state = scanner.next();
		System.out.println("Enter phoneNumber\n");
		String phoneNumber = scanner.next();
		status = Utility.phoneNumberValidation(phoneNumber);
		if (status == true) {
			listOfPersons.add(new Person(pname, plname, new Address(city, state, zip), phoneNumber));
			System.out.println("person records is sussfully add\n");
		} else
			System.out.println("Please enter Valide Phone-Number\n");

		return listOfPersons;
	}

	/**
	 * Purpose: This method edit Person details
	 */
	public ArrayList<Person> editNewbook(ArrayList<Person> listOfPersons) {
		boolean found = false;
		System.out.println("Enter FirstName \n");
		String fnameToSearch = scanner.next();
		System.out.println("Enter LastName\n");
		String lnameToSearch = scanner.next();
		for (int i = 0; i < listOfPersons.size(); i++) {
			if ((fnameToSearch == (listOfPersons.get(i).getFname()))
					&& (lnameToSearch == (listOfPersons.get(i).getLname()))) {
				found = true;
				System.out.println("----editOption-----\n");
				System.out.println("1.to edit city\n");
				System.out.println("2.to edit state\n");
				System.out.println("3.to edit zip\n");
				System.out.println("4.to edit phone number\n");
				System.out.println("5.exit\n");
				System.out.println("enter option\n");
				int optionEdit = scanner.nextInt();
				while (optionEdit != 5) {
					switch (optionEdit) {
					case 1:
						System.out.println("Enter edited info for city\n");
						String newCity = scanner.next();
						listOfPersons.get(i).getAddobj().setCity(newCity);
						System.out.println("City is SuccessFully Edited\n");
						break;
					case 2:
						System.out.println("Enter edited info for state\n");
						String newState = scanner.next();
						listOfPersons.get(i).getAddobj().setState(newState);
						System.out.println("State is SuccessFully Edited\n");
						break;
					case 3:
						System.out.println("Enter edited info for zip\n");
						int newZip = scanner.nextInt();
						listOfPersons.get(i).getAddobj().setZip(newZip);
						System.out.println("zip is SuccessFully Edited\n");
						break;
					case 4:
						System.out.println("Enter edited info for phoneNumber\n");
						String newPhone = scanner.next();
						status = Utility.phoneNumberValidation(newPhone);
						if (status == true) {
							listOfPersons.get(i).setPhoneNumber(newPhone);
							System.out.println("Phone number  is SuccessFully Edited\n");
						} else
							System.out.println("Please enter Valide Phone-Number\n");

						break;
					case 5:
						System.out.println("thanku for using edited option\n");
						break;
					default:
						System.out.println("Please Enter Validate option\n");
						break;
					}
				}
			}
		}
		if (found == false)
			System.out.println("enter firstName and lastname is not present\n");

		return listOfPersons;
	}

	/**
	 * Purpose: This method sort Person List by Person name
	 */
	public ArrayList<Person> sortByName(ArrayList<Person> listOfPersons) {
		ArrayList<Person> sortedListByName = new ArrayList<Person>();
		String[] lnamearray = new String[listOfPersons.size()];
		for (int i = 0; i < listOfPersons.size(); i++) {
			lnamearray[i] = listOfPersons.get(i).getLname();
		}
		lnamearray = Utility.bubblesortForStringArray(lnamearray);
		for (int i = 0; i < lnamearray.length; i++) {
			for (int j = 0; j < listOfPersons.size(); j++) {
				if ((listOfPersons.get(j).getLname()).equals(lnamearray[i])) {
					sortedListByName.add(listOfPersons.get(j));
				}
			}
		}
		return sortedListByName;
	}

	/**
	 * Purpose: This method sort Person List by Person state Zip number
	 */
	public ArrayList<Person> sortByZip(ArrayList<Person> listOfPersons) {
		ArrayList<Person> sortedListByZip = new ArrayList<Person>();
		int[] ziparray = new int[listOfPersons.size()];
		for (int i = 0; i < listOfPersons.size(); i++) {
			ziparray[i] = listOfPersons.get(i).getAddobj().getZip();
		}
		ziparray = Utility.bubblesort(ziparray);
		for (int i = 0; i < ziparray.length; i++) {
			for (int j = 0; j < listOfPersons.size(); j++) {
				if ((listOfPersons.get(j).getAddobj().getZip()) == ziparray[i]) {
					sortedListByZip.add(listOfPersons.get(j));
				}
			}
		}
		return sortedListByZip;
	}

	/**
	 * Purpose: This method delet Person form Address book
	 */
	public ArrayList<Person> deletePerson(ArrayList<Person> listOfPersons) {
		boolean foundRecords = false;
		System.out.println("Enter FirstName\n");
		String deletfName = scanner.next();
		System.out.println("Enter lastName\n");
		String deletlname = scanner.next();
		for (int i = 0; i < listOfPersons.size(); i++) {
			if (((listOfPersons.get(i).getFname()).equals(deletfName))
					&& ((listOfPersons.get(i).getLname()).equals(deletlname))) {
				foundRecords = true;
				listOfPersons.remove(i);
			}
		}
		if (foundRecords == false) {
			System.out.println("Enter firstName And lastName is not present\n");
		} else {
			System.out.println("person Records is Successfully deleted\n");
		}
		return listOfPersons;
	}

	/**
	 * Purpose: This method sort Person by Person name and print Details
	 */
	public void printBySortedName(ArrayList<Person> sortedList) {
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.println(i + 1 + "Person FName\t\tPerson LName\t\tPerson Address\t\tPerson PhoneNUmber\n");
			System.out.println(sortedList.get(i).getLname() + "\t\t" + sortedList.get(i).getFname() + "\t\t"
					+ sortedList.get(i).getAddobj().getCity() + "," + sortedList.get(i).getAddobj().getZip() + ","
					+ sortedList.get(i).getAddobj().getState() + "\t\t" + sortedList.get(i).getPhoneNumber());
		}
	}

	/**
	 * Purpose: This method sort Person by Person state zip number and print Details
	 */
	public void printBySortedPersonZip(ArrayList<Person> sortedList) {
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.println(i + 1 + "Person FName\t\tPerson LName\t\tPerson Address\t\tPerson PhoneNUmber\n");
			System.out.println(sortedList.get(i).getLname() + "\t\t" + sortedList.get(i).getFname() + "\t\t"
					+ sortedList.get(i).getAddobj().getCity() + "," + sortedList.get(i).getAddobj().getZip() + ","
					+ sortedList.get(i).getAddobj().getState() + "\t\t" + sortedList.get(i).getPhoneNumber());
		}
	}

}
