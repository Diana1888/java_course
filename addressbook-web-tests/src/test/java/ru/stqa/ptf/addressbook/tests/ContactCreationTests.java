package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Diana", "Familiya", "Toronto", "+16478885551", "testoviy@gmail.com"));
    app.getContactHelper().submitContactForm();
    app.getContactHelper().returnToHomePage();
  }

}
