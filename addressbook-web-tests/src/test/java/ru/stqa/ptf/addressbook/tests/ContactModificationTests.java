package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().homePage();
        if (app.contact().list().size() ==0) {
            app.contact().createContact(new ContactData("Diana", "Familiya", "Toronto", "+16478885551", "testoviy@gmail.com", "test1"));
        }
    }


    @Test(enabled = false)
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "Diana", "Familiya", "Toronto", "+16478885551", "testoviy@gmail.com", "test1");
        app.contact().modifyContact(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
