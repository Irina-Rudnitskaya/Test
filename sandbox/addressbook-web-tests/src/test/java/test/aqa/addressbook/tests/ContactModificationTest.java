package test.aqa.addressbook.tests;

import org.testng.annotations.Test;
import test.aqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

   @Test
   public void testContactModification() throws Exception {
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("Irina", null, "test_address", null), false);
      app.getContactHelper().submitContactModification();
      app.getNavigationHelper().goToHomePage();
   }

}

