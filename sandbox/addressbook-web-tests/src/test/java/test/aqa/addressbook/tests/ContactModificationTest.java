package test.aqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.aqa.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTest extends TestBase {

   @Test
   public void testContactModification() throws Exception {
      if(! app.getContactHelper().isThereAContact()){
         app.getContactHelper().createContact(new ContactData("test1",null,null, "Test group"));
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size()-1);
      app.getContactHelper().initContactModification(before.size()-1);
      app.getContactHelper().fillContactForm(new ContactData("Irina", null, "test_address", null), false);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());
   }

}

