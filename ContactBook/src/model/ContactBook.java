package model;

import model.contact.Contact;
import model.exceptions.InvalidLoginException;

import java.util.ArrayList;

public class ContactBook {
    ArrayList<Contact> peopleContacts;

    public ContactBook() {
        peopleContacts = new ArrayList<>();
    }

    public void addNewContact(String nickname, String comment,
                              String[] fullName, String[] contacts,
                              String[] address, String group) throws InvalidLoginException {
        Contact contact = new Contact(nickname, comment);
        contact.defineFullName(fullName[0], fullName[1], fullName[2]);
        contact.defineGroup(group);
        contact.defineContacts(contacts[0], contacts[1], contacts[2],
                contacts[3], contacts[4]);
        contact.defineAddress(Integer.parseInt(address[0]), address[1] , address[2],
                address[3], Integer.parseInt(address[4]));
        if (checkNicknameExistence(contact)) {
            throw new InvalidLoginException("invalid.nickname");
        }
        peopleContacts.add(contact);
    }

    public boolean checkNicknameExistence(Contact contact) {
        ArrayList<String> contactLogins = new ArrayList<>();

        for (int i = 0; i < peopleContacts.size(); i++) {
            contactLogins.add(peopleContacts.get(i).getNickname());
        }
        if (contactLogins.contains(contact.getNickname())) {
            return true;
        }
        return false;
    }

    public ArrayList<String[]> getAllContacts() {
        ArrayList<String[]> allContactsInfo = new ArrayList<>();
        for (Contact contact: peopleContacts) {
            allContactsInfo.add(contact.getAllInfo());
        }
        return allContactsInfo;
    }
}
