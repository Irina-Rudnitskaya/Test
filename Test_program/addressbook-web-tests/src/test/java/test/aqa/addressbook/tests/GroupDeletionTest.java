package test.aqa.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{
  @Test
   public void testGroupDeletion () {
     app.getNavigationHelper().goToCroupPage();
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().deleteSelectedGroup();
     app.getGroupHelper().returnToGroupPage();
  }

}
