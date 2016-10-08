package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopTopicMgr$PlusProgressRunable
  implements Runnable
{
  TroopChatPie a;
  
  public TroopTopicMgr$PlusProgressRunable(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramTroopChatPie;
  }
  
  public void run()
  {
    this.a.aW();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopTopicMgr$PlusProgressRunable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */