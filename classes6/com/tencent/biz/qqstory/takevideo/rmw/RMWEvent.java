package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RMWEvent
{
  public final Message a;
  
  public RMWEvent(Message paramMessage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramMessage;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */