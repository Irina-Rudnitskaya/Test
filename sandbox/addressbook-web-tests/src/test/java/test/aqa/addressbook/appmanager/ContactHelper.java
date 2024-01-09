package test.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import test.aqa.addressbook.model.ContactData;
import test.aqa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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
   public List<ContactData> getContactList() {
      List<ContactData> contacts = new ArrayList<ContactData>();
      List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
      for (WebElement element: elements){
         List<WebElement> data = element.findElements(By.tagName("td"));
         int id = Integer.parseInt(data.get(0).findElement(By.tagName("input")).getAttribute("value"));
         String lastName = data.get(1).getText();
         String firstName = data.get(2).getText();
         String address = data.get(3).getText();
         ContactData contact = new ContactData(firstName, lastName,address,null);
         contacts.add(contact);
      }
      return contacts;
   };
}
