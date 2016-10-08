package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class GifSoLoader
{
  static final String a = "use_new_gif_so";
  public static final String b = GifSoLoader.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = paramContext.getFilesDir();
    } while (paramContext == null);
    return paramContext.getParent() + "/lib/";
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && ((paramString.contains("NativeGifFactory")) || (paramString.contains("NativeGifIndex8")) || (paramString.contains("libkIndexGif")) || (paramString.contains("libskia"))))
    {
      BaseApplicationImpl.a().getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, String.format("Crash in libkIndexGif support library at %s process!", new Object[] { BaseApplicationImpl.getMobileQQ().getProcessName() }));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\util\GifSoLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */