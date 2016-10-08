package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopReplyMsg
  extends TroopAtMsg
{
  public TroopReplyMsg(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramContext.getString(2131364637);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\msg\TroopReplyMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */