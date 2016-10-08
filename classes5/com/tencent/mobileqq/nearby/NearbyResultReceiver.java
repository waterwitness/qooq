package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyResultReceiver
  extends ResultReceiver
{
  NearbyFakeActivity a;
  
  public NearbyResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NearbyFakeActivity paramNearbyFakeActivity)
  {
    this.a = paramNearbyFakeActivity;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onReceiveResult(paramInt, paramBundle);
      return;
      if (this.a != null) {
        this.a.a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */