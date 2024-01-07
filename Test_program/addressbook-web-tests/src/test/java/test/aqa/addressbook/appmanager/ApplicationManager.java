package test.aqa.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.openqa.selenium.remote.Browser.*;

public class ApplicationManager {
   private final String browser;
   public WebDriver wd;
   private NavigationHelper navigationHelper;
   private SessionHelper sessionHelper;
   private GroupHelper groupHelper;

   public ApplicationManager(String browser) {
      this.browser = browser;
   }


   public void init() {
      if (browser.equals(CHROME.browserName())){
         System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
         wd = new ChromeDriver();
      } else if (browser.equals(FIREFOX.browserName())) {
         wd = new FirefoxDriver();
      } else if (browser.equals(EDGE.browserName())) {
         wd = new EdgeDriver();
      }

      wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      wd.get("http://localhost/addressbook/group.php");
      groupHelper = new GroupHelper(wd);
      navigationHelper = new NavigationHelper(wd);
      sessionHelper = new SessionHelper(wd);
      sessionHelper.login("admin", "secret");
   }

   public void stop() {
      wd.quit();
   }

   public GroupHelper getGroupHelper() {
      return groupHelper;
   }

   public NavigationHelper getNavigationHelper() {
      return navigationHelper;
   }
}
