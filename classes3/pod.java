import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public final class pod
  implements Comparator
{
  public pod()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(BuddyListItem paramBuddyListItem1, BuddyListItem paramBuddyListItem2)
  {
    int j = 0;
    int i;
    if ((paramBuddyListItem1.a instanceof TroopInfo))
    {
      i = ((TroopInfo)paramBuddyListItem1.a).mComparePartInt;
      paramBuddyListItem1 = ((TroopInfo)paramBuddyListItem1.a).mCompareSpell;
    }
    for (;;)
    {
      if ((paramBuddyListItem2.a instanceof TroopInfo))
      {
        j = ((TroopInfo)paramBuddyListItem2.a).mComparePartInt;
        paramBuddyListItem2 = ((TroopInfo)paramBuddyListItem2.a).mCompareSpell;
      }
      for (;;)
      {
        return ContactSorter.a(i, paramBuddyListItem1, j, paramBuddyListItem2);
        if (!(paramBuddyListItem1.a instanceof DiscussionInfo)) {
          break label154;
        }
        i = ((DiscussionInfo)paramBuddyListItem1.a).mComparePartInt;
        paramBuddyListItem1 = ((DiscussionInfo)paramBuddyListItem1.a).mCompareSpell;
        break;
        if ((paramBuddyListItem2.a instanceof DiscussionInfo))
        {
          j = ((DiscussionInfo)paramBuddyListItem2.a).mComparePartInt;
          paramBuddyListItem2 = ((DiscussionInfo)paramBuddyListItem2.a).mCompareSpell;
        }
        else
        {
          paramBuddyListItem2 = "-";
        }
      }
      label154:
      paramBuddyListItem1 = "-";
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */