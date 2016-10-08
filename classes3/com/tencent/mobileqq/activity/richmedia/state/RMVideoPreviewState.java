package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RMVideoPreviewState
  extends RMVideoState
{
  public RMVideoPreviewState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.a != null) {
      localRMVideoStateMgr.a.d();
    }
  }
  
  public void b()
  {
    RMVideoStateMgr.a().a(2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\state\RMVideoPreviewState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */