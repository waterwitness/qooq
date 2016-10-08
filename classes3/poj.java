import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;
import java.util.ArrayList;
import java.util.List;

public class poj
  implements Runnable
{
  public poj(BuddyListAdapter paramBuddyListAdapter, int paramInt, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    OlympicTorchManager localOlympicTorchManager = ((OlympicManager)BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter).getManager(166)).a();
    if (localOlympicTorchManager.b(this.jdField_a_of_type_Int)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        BuddyListItem localBuddyListItem = (BuddyListItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localBuddyListItem instanceof BuddyListFriends)) {
          localArrayList.add(((Friends)((BuddyListFriends)localBuddyListItem).a).uin);
        }
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    localOlympicTorchManager.a(localArrayList, this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\poj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */