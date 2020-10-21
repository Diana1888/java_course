package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){
        app.getContactHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Diana", "Familiya", "Toronto", "+16478885551", "testoviy@gmail.com", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().editContactform();
        app.getContactHelper().fillContactForm(new ContactData("Diana", "Familiya", "Toronto", "+16478885551", "testoviy@gmail.com", null), false);
        app.getContactHelper().updateContactForm();
        app.getContactHelper().goToHomePage();
    }
}
