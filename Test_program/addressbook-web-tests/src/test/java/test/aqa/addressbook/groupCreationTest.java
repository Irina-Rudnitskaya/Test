package test.aqa.addressbook;

import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    goToCroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Test group", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
