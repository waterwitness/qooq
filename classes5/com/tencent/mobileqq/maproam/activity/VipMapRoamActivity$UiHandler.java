package com.tencent.mobileqq.maproam.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class VipMapRoamActivity$UiHandler
  extends Handler
{
  private WeakReference a;
  
  public VipMapRoamActivity$UiHandler(VipMapRoamActivity paramVipMapRoamActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramVipMapRoamActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    VipMapRoamActivity localVipMapRoamActivity = (VipMapRoamActivity)this.a.get();
    if (localVipMapRoamActivity == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 100: 
        localVipMapRoamActivity.a.H();
      }
    } while (paramMessage.arg1 != 200);
    VipMapRoamActivity.a(localVipMapRoamActivity, 1, 2131368597);
    return;
    localVipMapRoamActivity.a.H();
    VipMapRoamActivity.a(localVipMapRoamActivity, 1, localVipMapRoamActivity.getString(2131369008));
    return;
    VipMapRoamActivity.a(localVipMapRoamActivity, (SosoInterface.SosoLbsInfo)paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\maproam\activity\VipMapRoamActivity$UiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */