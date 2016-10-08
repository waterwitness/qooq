package com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.qphone.base.util.QLog;

public class FlowCameraPtvActivity2
  extends FlowCameraActivity2
{
  public FlowCameraPtvActivity2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "onCreateView");
    }
    if (!CameraAbility.a()) {}
  }
  
  boolean b()
  {
    return true;
  }
  
  public void i()
  {
    super.i();
  }
  
  void o()
  {
    super.o();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = false;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\FlowCameraPtvActivity2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */