package com.facebook.common.activitylistener;

import android.app.Activity;

public abstract interface ActivityListener
{
  public abstract void onActivityCreate(Activity paramActivity);
  
  public abstract void onDestroy(Activity paramActivity);
  
  public abstract void onPause(Activity paramActivity);
  
  public abstract void onResume(Activity paramActivity);
  
  public abstract void onStart(Activity paramActivity);
  
  public abstract void onStop(Activity paramActivity);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\activitylistener\ActivityListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */