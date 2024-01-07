package test.aqa.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.aqa.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.Browser.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

   public final ApplicationManager app = new ApplicationManager(CHROME.browserName());

   @BeforeMethod(alwaysRun = true)
   public void setUp() throws Exception {
      app.init();
   }

   @AfterMethod(alwaysRun = true)
   public void tearDown() throws Exception {
      app.stop();
   }

}
