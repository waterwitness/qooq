package com.tencent.mobileqq.troop.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RadarMembersView$WorkHandler
  extends Handler
{
  public RadarMembersView$WorkHandler(RadarMembersView paramRadarMembersView, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message arg1)
  {
    double d = ((Double)???.obj).doubleValue();
    synchronized (this.a.a)
    {
      this.a.a(d);
      this.a.postInvalidate();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\RadarMembersView$WorkHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */