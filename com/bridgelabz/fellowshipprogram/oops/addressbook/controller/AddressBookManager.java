package com.bridgelabz.fellowshipprogram.oops.addressbook.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bridgelabz.fellowshipprogram.oops.addressbook.model.Address;
import com.bridgelabz.fellowshipprogram.oops.addressbook.model.AddressBook;
import com.bridgelabz.fellowshipprogram.oops.addressbook.model.AddressBookList;
import com.bridgelabz.fellowshipprogram.oops.addressbook.model.Person;
import com.bridgelabz.fellowshipprogram.oops.addressbook.services.AddressBookMethods;
import com.bridgelabz.fellowshipprogram.oops.addressbook.utility.Utility;
import com.bridgelabz.fellowshipprogram.oops.addressbook.repository.JsonOperation;

public class AddressBookManager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Utility utility = new Utility();
		AddressBookMethods manager = new AddressBookMethods();
		Map<Integer, ArrayList<Person>> map = new HashMap<Integer, ArrayList<Person>>();
		ArrayList<Person> sortedList = new ArrayList<Person>();
		ArrayList<AddressBook> list = new ArrayList<AddressBook>();
		ArrayList<Person> listOfPersons = new ArrayList<Person>();
		JsonOperation operation = new JsonOperation();
		int option = 0;
		String filepath;
		// Operation of Address book System
		while (option != 5) {
			System.out.println("-----------Welcome to Address Library----------\n");
			System.out.println("-------Option for ListOfAddress------\n");
			System.out.println("1.Create New AddressBook\n");
			System.out.println("2.Open Address Book\n");
			System.out.println("3.Save Address Book\n");
			System.out.println("4.Save As Address Book\n");
			System.out.println("5.Close Address Book Library\n");
			System.out.println("Enter Option\n");
			option = utility.integerValue();
			switch (option) {
			case 1:
				System.out.println("-----Wel-come for addresss book creation-----\n");
				System.out.println("Enter id of Address-Book\n");
				int id = scanner.nextInt();
				System.out.println("Enter the name of address book\n");
				String name = scanner.next();
				Address add;
				list.add(new AddressBook(id, name, listOfPersons));
				AddressBookList listOfAddress = new AddressBookList();
				listOfAddress.setListOfAddress(list);
				map.put(id, listOfPersons);
				int optionnew = 0;
				// new created Address book option
				while (optionnew != 6) {
					System.out.println("-----Address Book option-------");
					System.out.println("1.Add person\n");
					System.out.println("2.Edit person Detail\n");
					System.out.println("3.Print by sortedLastName\n");
					System.out.println("4.Print by SortedZip\n");
					System.out.println("5.Delet Person\n");
					System.out.println("6.Close Address Book\n");
					System.out.println("Enter Option\n");
					optionnew = scanner.nextInt();
					switch (optionnew) {
					case 1:
						System.out.println("Welcome to Added person\n");
						listOfPersons = manager.createNewBook(listOfPersons);
						break;
					case 2:
						System.out.println("Welcom to Edit");
						listOfPersons = manager.editNewbook(listOfPersons);
						break;
					case 3:
						System.out.println("Welcome to sortBy LastName\n");
						sortedList = manager.sortByName(listOfPersons);
						manager.printBySortedName(sortedList);
						filepath = "/home/admin1/Desktop/BridgeLabzPrograms/AddressBookManagement/src/listOFSortedPersonByName.json";
						operation.toWriteIntoFile(filepath, sortedList);
						System.out.println("Person Data is Successfully Saved");
						break;
					case 4:
						System.out.println("Welcome to sortBy Zip\n");
						sortedList = manager.sortByZip(listOfPersons);
						manager.printBySortedPersonZip(sortedList);
						filepath = "/home/admin1/Desktop/BridgeLabzPrograms/AddressBookManagement/src/listOfSortedPersonByZip.json";
						operation.toWriteIntoFile(filepath, sortedList);
						System.out.println("Person Data is Successfully Saved");
						break;
					case 5:
						System.out.println("Welcome to DeletePerson\n");
						listOfPersons = manager.deletePerson(listOfPersons);
						break;
					case 6:
						System.out.println("So AddressBookID:" + id + "AddressBookName:" + name + "is been Closed\n");
						break;
					default:
						System.out.println("please enter validate option\n");
						break;
					}
				}
				break;
			case 2:
				System.out.println("-----Wel-come for addresss book opening-----\n");
				System.out.println("Enter the Address Book id to open\n");
				int bookid = scanner.nextInt();
				ArrayList<Person> listInMap;
				if (map.containsKey(bookid)) {
					listInMap = map.get(bookid);
					int optionopen = 0;
					// opening specific address book
					while (optionopen != 6) {
						System.out.println("-----Address Book option-------");
						System.out.println("1.Add person\n");
						System.out.println("2.Edit person Detail\n");
						System.out.println("3.Print by sortedLastName\n");
						System.out.println("4.Print by SortedZip\n");
						System.out.println("5.Delet Person\n");
						System.out.println("6.Close Address Book\n");
						System.out.println("Enter Option\n");
						optionopen = scanner.nextInt();
						switch (optionopen) {
						case 1:
							System.out.println("Welcome to Added person\n");
							listOfPersons = manager.createNewBook(listInMap);
							break;
						case 2:
							System.out.println("Welcom to Edit");
							listOfPersons = manager.editNewbook(listInMap);
							break;
						case 3:
							System.out.println("Welcome to sortBy LastName\n");
							sortedList = manager.sortByName(listInMap);
							manager.printBySortedName(sortedList);
							filepath = "/home/admin1/Desktop/BridgeLabzPrograms/AddressBookManagement/src/listOFSortedPersonByName.json";
							operation.toWriteIntoFile(filepath, sortedList);
							System.out.println("Person Data is Successfully Saved");
							break;
						case 4:
							System.out.println("Welcome to sortBy Zip\n");
							sortedList = manager.sortByZip(listInMap);
							manager.printBySortedPersonZip(sortedList);
							filepath = "/home/admin1/Desktop/BridgeLabzPrograms/AddressBookManagement/src/listOfSortedPersonByZip.json";
							operation.toWriteIntoFile(filepath, sortedList);
							System.out.println("Person Data is Successfully Saved");
							break;
						case 5:
							System.out.println("Welcome to DeletePerson\n");
							listOfPersons = manager.deletePerson(listInMap);
							break;
						case 6:
							System.out.println("So Address BookID:" + bookid);
							break;
						default:
							System.out.println("please enter validate option\n");
							break;
						}
					}
				} else {
					System.out.println("Such Address Book with" + bookid + "is not present \n");
				}
				break;
			case 3:
				// save address book data
				System.out.println("---------Save---------\n");
				filepath = "/home/admin1/Desktop/BridgeLabzPrograms/AddressBookManagement/src/SaveFileOfPerson.json";
				System.out.println("1.Save Specific Address-Book\n");
				System.out.println("2.Save Entire Address-Book System\n");
				int choise = utility.integerValue();
				ArrayList<Person> listToPrint;
				switch (choise) {
				case 1:
					System.out.println("Enter Address-Book id\n");
					int Id = utility.integerValue();
					if (!map.containsKey(Id))
						System.out.println("No such Address-Book found");
					listToPrint = map.get(Id);
					operation.toWriteIntoFile(filepath, listToPrint);
					System.out.println("Records of Address-Book is Save Successfully");
					break;
				case 2:
					operation.toWriteIntoFile(filepath, list);
					System.out.println("Records of Address-Book is Save Successfully");
					break;
				}

				break;
			case 4:
				// save as address book
				System.out.println("-------welcome to save as file-----\n");
				System.out.println("enter the name of file\n");
				String fileName = scanner.next();
				String file = "/home/admin1/Desktop/BridgeLabzPrograms/AddressBookManagement/src/" + fileName + ".json";
				operation.toWriteIntoFile(file, list);
				System.out.println("You Data is Successfully Save");
				break;

			case 5:
				System.out.println("------Thank u for operating r libaray-------");
				break;
			default:
				System.out.println("Please Enter Valide Option\n");
				break;
			}
		}
		scanner.close();
	}
}
