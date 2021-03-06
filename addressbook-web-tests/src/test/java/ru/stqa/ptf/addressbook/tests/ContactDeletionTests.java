package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().homePage();
        if ((app.db().contacts().size() ==0)) {
            app.contact().create(new ContactData().withFirstname("Diana").withLastname("Familiya").
                    withAddress("Toronto").withMobilePhone("+16478505661").withEmail("testoviy@gmail.com"));
        }
    }

    @Test
    public void testContactDeletion(){
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size() -1);
        assertThat(after, equalTo(before.withOut(deletedContact)));
        verifyGroupListInUI();
    }


}
