package org.ancit.examples.e4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {
	
	List<Contact> contacts = new ArrayList<Contact>();
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public Contact getContact(String name) {
		for (Contact contact : contacts) {
			if(contact.getName().equals(name)){
				return contact;
			}
		}
		return null;
	}

}
