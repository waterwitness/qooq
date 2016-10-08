package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Map;

public class TroopView$MyFriendListObserver
  extends FriendListObserver
{
  protected TroopView$MyFriendListObserver(TroopView paramTroopView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    this.a.a();
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\troop\TroopView$MyFriendListObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */