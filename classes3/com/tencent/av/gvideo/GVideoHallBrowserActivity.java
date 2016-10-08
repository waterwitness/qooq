package com.tencent.av.gvideo;

import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GVideoHallBrowserActivity
  extends QQBrowserActivity
{
  public GVideoHallBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    super.setBottomBarVisible(false);
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gvideo\GVideoHallBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */