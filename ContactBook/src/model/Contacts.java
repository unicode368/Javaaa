package model;

public class Contacts {
    private String homePhone;
    private String mobilePhone;
    private String mobilePhone2;
    private String email;
    private String skype;

    Contacts(String homePhone, String mobilePhone,
                    String mobilePhone2, String email, String skype) {
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.mobilePhone2 = mobilePhone2;
        this.email = email;
        this.skype = skype;
    }

    public String[] getContacts() {
        return new String[]{homePhone,
                mobilePhone,
                mobilePhone2,
                email,
                skype};
    }
}
