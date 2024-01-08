package test.aqa.addressbook.tests;

import org.testng.annotations.Test;
import test.aqa.addressbook.model.ContactData;
import test.aqa.addressbook.model.GroupData;

public class ContactModificationTest extends TestBase {

   @Test
   public void testContactModification() throws Exception {
      int before = app.getContactHelper().getContactCount();
      if(! app.getContactHelper().isThereAContact()){
         app.getContactHelper().createContact(new ContactData("test1",null,null, "Test group"));
      }
      app.getContactHelper().selectContact(before-1);
      app.getContactHelper().initContactModification(before-1);
      app.getContactHelper().fillContactForm(new ContactData("Irina", null, "test_address", null), false);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomePage();
   }

}

