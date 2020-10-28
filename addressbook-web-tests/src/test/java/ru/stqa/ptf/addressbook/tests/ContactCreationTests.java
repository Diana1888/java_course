package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    app.contact().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Diana").withLastname("Familiya").
            withAddress("Toronto").withMobile("+16478505661").withEmail("testoviy@gmail.com");
    app.contact().createContact(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);

    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);



  }

}
