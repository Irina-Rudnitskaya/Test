package test.aqa.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import test.aqa.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {

   @Test
   public void testContactCreation() throws Exception {
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().initContactCreation();
      app.getContactHelper().fillContactForm(new ContactData("Irina", "Test", "test_address", "Test group"),true);
      app.getContactHelper().submitContactCreation();
      app.getContactHelper().returnToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size()+1);
   }

}

