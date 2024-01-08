package test.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import test.aqa.addressbook.model.ContactData;
import test.aqa.addressbook.model.GroupData;

public class ContactHelper extends HelperBase {
   public ContactHelper(WebDriver wd) {
      super(wd);
   }
   public void initContactCreation() {
      click(By.linkText("add new"));
   }
   public void selectContact(int index) {
      wd.findElements(By.name("selected[]")).get(index).click();
   }
   public void initContactModification(int index) {
      wd.findElement(By.cssSelector(("a[href='edit.php?id=" + index + "']"))).click();
   }
   public void createContact (ContactData contact){
      initContactCreation();
      fillContactForm(contact, true);
      submitContactCreation();
      returnToHomePage();
   }
   public void fillContactForm(ContactData contactData, boolean creation) {
      type(By.name("firstname"), contactData.getFirstName());
      type(By.name("lastname"), contactData.getLastName());
      type(By.name("address"), contactData.getAddress());

      if(creation){
         new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else{
         Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
   }

   public void submitContactCreation() {
      click(By.name("submit"));
   }
   public void submitContactModification() {
      click(By.name("update"));
   }
   public boolean isThereAContact() {
      return isElementPresent(By.name("selected[]"));
   }
   public int getContactCount(){
      return wd.findElements(By.name("selected[]")).size();
   };
   public void returnToHomePage() {

      click(By.linkText("home page"));
   }
}
