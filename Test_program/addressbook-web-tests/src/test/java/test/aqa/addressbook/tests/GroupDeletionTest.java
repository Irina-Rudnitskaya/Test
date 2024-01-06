package test.aqa.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{
  @Test
   public void testGroupDeletion () {
     app.goToCroupPage();
     app.selectGroup();
     app.deleteSelectedGroup();
     app.returnToGroupPage();
  }

}
