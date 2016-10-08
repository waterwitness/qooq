package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public abstract class FlingHandler
{
  public WeakReference a;
  
  public FlingHandler(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramActivity);
  }
  
  int a()
  {
    Activity localActivity = (Activity)this.a.get();
    if (localActivity != null) {
      return localActivity.getIntent().getIntExtra("fling_code_key", 0);
    }
    return 0;
  }
  
  protected abstract void a();
  
  protected abstract boolean a();
  
  protected abstract void b();
  
  boolean b()
  {
    return a() != 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onStart()
  {
    a();
  }
  
  public void onStop()
  {
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\fling\FlingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */