package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

  @Test (enabled = false)
  public void testContactCreation()  {
    app.contact().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("Diana", "Familiya", "Toronto", "+16478885551", "testoviy@gmail.com", "test1");
    app.contact().createContact(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);



  }

}
