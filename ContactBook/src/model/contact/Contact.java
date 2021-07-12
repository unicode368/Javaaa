package model.contact;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contact {
    private FullName fullName;
    private String nickname;
    private String comment;
    private Group group;
    private Contacts contacts;
    private Address address;
    private String dateCreated;
    private String dateModified;
    private final DateTimeFormatter DATA_FORMAT_STRING = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final LocalDateTime NOW = LocalDateTime.now();

    public Contact(String nickname, String comment) {
        this.fullName = new FullName("", "", "");
        this.nickname = nickname;
        this.comment = comment;
        this.group = null;
        this.contacts = new Contacts("", "", "", "", "");
        this.address = new Address(0, "", "", "", 0);
        this.dateCreated = DATA_FORMAT_STRING.format(NOW);
        this.dateModified = dateCreated;
    }

    Contact(FullName fullName, String nickname, String comment,
                   Group group, Contacts contacts, Address address) {
        this.fullName = fullName;
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.contacts = contacts;
        this.address = address;
        this.dateCreated = DATA_FORMAT_STRING.format(NOW);
        this.dateModified = dateCreated;
    }

    public void defineContacts(String homePhone, String mobilePhone,
                                   String mobilePhone2, String email, String skype) {
        setContacts(new Contacts(homePhone, mobilePhone, mobilePhone2, email, skype));
    }

    public void defineAddress(int index, String city, String street,
                                   String houseNumber, int flatNumber) {
        setAddress(new Address(index, city, street, houseNumber, flatNumber));
    }

    public void defineFullName(String surname, String name,
                                   String patronimic) {
        FullName fullName = new FullName(surname, name, patronimic);
        setFullName(fullName);
    }

    public void defineGroup(String groupNumber) {
        switch (groupNumber) {
            case "1": setGroup(Group.FAMILY);
                break;
            case "2": setGroup(Group.WORK);
                break;
            case "3": setGroup(Group.FRIENDS);
                break;
        }
    }

    private void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    private void setGroup(Group group) {
        this.group = group;
    }

    private void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    private void setAddress(Address address) {
        this.address = address;
    }

    public String[] getAllInfo() {
        String[] info = new String[17];
        String[] fllName = fullName.getFullName();
        int i = 0;
        for (int j = 0; j < fllName.length; i++, j++) {
            info[i] = fllName[j];
        }
        info[i++] = nickname;
        info[i++] = comment;
        info[i++] = group.toString();
        String[] cntacts = contacts.getContacts();
        for (int j = 0; j < cntacts.length; i++, j++) {
            info[i] = cntacts[j];
        }
        String[] addr = address.getAddress();
        for (int j = 0; j < addr.length; i++, j++) {
            info[i] = addr[j];
        }
        info[i++] = dateCreated;
        info[i++] = dateModified;
        return info;
    }

    public String getNickname() {
        return nickname;
    }
}
