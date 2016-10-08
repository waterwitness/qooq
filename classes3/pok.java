import QQService.EVIPSPEC;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

public class pok
  implements Comparator
{
  private pok()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(BuddyListItem paramBuddyListItem1, BuddyListItem paramBuddyListItem2)
  {
    paramBuddyListItem1 = (Friends)paramBuddyListItem1.a;
    paramBuddyListItem2 = (Friends)paramBuddyListItem2.a;
    int i = a(paramBuddyListItem1);
    int j = a(paramBuddyListItem2);
    if (i == j) {
      return ContactSorter.a(paramBuddyListItem1.mComparePartInt, paramBuddyListItem1.mCompareSpell, paramBuddyListItem2.mComparePartInt, paramBuddyListItem2.mCompareSpell);
    }
    return i - j;
  }
  
  public int a(Friends paramFriends)
  {
    int k = ContactUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    int j;
    label28:
    int i;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      if (!paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label104;
      }
      i = 4096;
    }
    for (;;)
    {
      switch (k)
      {
      case 5: 
      case 6: 
      default: 
        return j | i | (int)paramFriends.getLastLoginType();
        j = 131072;
        break label28;
        label104:
        if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
          i = 8192;
        } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
          i = 12288;
        } else {
          i = 16384;
        }
        break;
      }
    }
    return j | i | 0x1;
    return j | i | 0x2;
    return j | i | 0x3;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */