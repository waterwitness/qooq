package com.tencent.biz.pubaccount.reactnative.module;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ReactBaseModule
  extends ReactContextBaseJavaModule
{
  private Activity mActivity;
  
  public ReactBaseModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReactBaseModule(ReactApplicationContext paramReactApplicationContext, Activity paramActivity)
  {
    super(paramReactApplicationContext);
    this.mActivity = paramActivity;
  }
  
  public void doRefreshContext(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\reactnative\module\ReactBaseModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */