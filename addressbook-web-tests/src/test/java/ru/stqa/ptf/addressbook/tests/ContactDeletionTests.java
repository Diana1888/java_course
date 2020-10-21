package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion(){
        app.getContactHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Diana", "Familiya", "Toronto", "+16478885551", "testoviy@gmail.com", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();

    }
}
