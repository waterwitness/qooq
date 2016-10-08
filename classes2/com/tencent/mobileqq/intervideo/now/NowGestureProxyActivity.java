package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class NowGestureProxyActivity
  extends ContainerActivity
{
  private AppRuntime a;
  
  public NowGestureProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void c()
  {
    this.a = ((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    Foreground.updateRuntimeState(this.a);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    Foreground.onPause(this.a);
    super.onPause();
  }
  
  protected void onResume()
  {
    Foreground.onResume(this.a);
    super.onResume();
  }
  
  protected void onStart()
  {
    Foreground.onStart(this.a);
    super.onStart();
  }
  
  protected void onStop()
  {
    Foreground.onStop(this.a);
    super.onStop();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\NowGestureProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */