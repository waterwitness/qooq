package com.tencent.open.agent;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class FriendChooser$MyComparator
  implements Comparator
{
  protected FriendChooser$MyComparator(FriendChooser paramFriendChooser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return paramFriend1.g.compareToIgnoreCase(paramFriend2.g);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\FriendChooser$MyComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */