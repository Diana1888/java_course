package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().homePage();
        if (app.db().contacts().size() ==0) {
            app.contact().create(new ContactData().withFirstname("Diana")
                    .withLastname("Familiya").withAddress("Toronto").withMobilePhone("+16478505661")
                    .withEmail("testoviy@gmail.com"));
        }
    }


    @Test
    public void testContactModification() {
        Contacts before =app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).withFirstname("Diana").withLastname("Familiya").
                withAddress("Toronto").withMobilePhone("+16478505661").withEmail("testoviy@gmail.com");
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
        verifyGroupListInUI();
    }


}
