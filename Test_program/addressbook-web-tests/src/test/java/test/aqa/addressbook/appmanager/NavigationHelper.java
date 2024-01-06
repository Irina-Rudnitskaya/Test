package test.aqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
   private WebDriver wd;

   public NavigationHelper(WebDriver wd) {
      this.wd = wd;
   }

   public void goToCroupPage() {
     wd.findElement(By.linkText("groups")).click();
   }
}
