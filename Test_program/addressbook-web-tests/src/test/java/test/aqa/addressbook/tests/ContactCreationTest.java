package test.aqa.addressbook.tests;
import org.testng.annotations.*;
import test.aqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

   @Test
   public void testGroupCreation() throws Exception {
      app.getContactHelper().initContactCreation();
      app.getContactHelper().fillContactForm(new ContactData("Irina", "Test", "test_address", "Test group"),true);
      app.getContactHelper().submitContactCreation();
      app.getNavigationHelper().goToHomePage();
   }

}

