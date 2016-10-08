package com.tencent.image;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;

public class AudioUtils
{
  public static void abandonAudioFoucus()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (localBaseApplication != null) {
        ((AudioManager)localBaseApplication.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
  }
  
  public static void requesetAudioFoucus()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (localBaseApplication != null) {
        ((AudioManager)localBaseApplication.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\AudioUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */