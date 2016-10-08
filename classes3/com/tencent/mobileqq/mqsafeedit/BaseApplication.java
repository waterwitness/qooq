package com.tencent.mobileqq.mqsafeedit;

import android.app.Application;
import android.content.Context;

public abstract class BaseApplication
  extends Application
{
  public static int appnewmsgicon = 0;
  static Context context;
  public static int defaultNotifSoundResourceId = 0;
  public static int qqlaunchicon = 0;
  
  public static Context getContext()
  {
    return context;
  }
  
  public static int getDefaultNotifSoundResourceId()
  {
    return defaultNotifSoundResourceId;
  }
  
  public static int getQQLaunchIcon()
  {
    return qqlaunchicon;
  }
  
  public static int getQQNewMsgIcon()
  {
    return appnewmsgicon;
  }
  
  public void callSystemSuperCreate()
  {
    super.onCreate();
    context = this;
  }
  
  public void onCreate()
  {
    if (context == null) {
      callSystemSuperCreate();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\mqsafeedit\BaseApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */