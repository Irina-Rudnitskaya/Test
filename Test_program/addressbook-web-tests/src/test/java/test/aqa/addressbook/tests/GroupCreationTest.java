package test.aqa.addressbook.tests;

import org.testng.annotations.*;
import test.aqa.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goToCroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Test group", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
