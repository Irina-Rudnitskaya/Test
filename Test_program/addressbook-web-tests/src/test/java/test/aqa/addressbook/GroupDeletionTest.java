package test.aqa.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{
  @Test
   public void testGroupDeletion () {
     goToCroupPage();
     selectGroup();
     deleteSelectedGroup();
     returnToGroupPage();
  }

}
