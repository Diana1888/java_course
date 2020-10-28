package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().homePage();
        if ((app.contact().list().size() ==0)) {
            app.contact().createContact(new ContactData("Diana", "Familiya", "Toronto", "+16478885551", "testoviy@gmail.com", "test1"));
        }
    }

    @Test (enabled = false)
    public void testContactDeletion(){
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }


}
