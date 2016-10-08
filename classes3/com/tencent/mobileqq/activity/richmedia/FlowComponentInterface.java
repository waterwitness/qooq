package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;

public abstract interface FlowComponentInterface
{
  public static final int a = 0;
  public static final String a = "from_type";
  public static final int b = 1;
  public static final String b = "clip_strategy";
  public static final int c = 0;
  public static final String c = "enable_front";
  public static final int d = 1;
  public static final String d = "enable_local_video";
  public static final String e = "enable_edit_video";
  public static final String f = "is_qzone_vip";
  public static final String g = "set_sdcard_min_size";
  public static final String h = "set_user_callback";
  public static final String i = "short_video_refer";
  public static final String j = "enable_big_video";
  
  public abstract String a();
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Activity paramActivity, Intent paramIntent);
  
  public abstract void a(String paramString);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\FlowComponentInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */