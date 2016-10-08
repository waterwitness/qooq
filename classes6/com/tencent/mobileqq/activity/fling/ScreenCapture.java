package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import okv;

public class ScreenCapture
{
  public static final String SNAP_CACHE_FILE = "snap_cache";
  public static final String SNAP_CACHE_FILE_SUCCESS_KEY = "snap_cache_file_success_key";
  private static final String a = ScreenCapture.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void captureViewToFile(String paramString, View paramView)
  {
    if ((paramString == null) || (paramView == null)) {
      return;
    }
    QLog.i("sethmao", 4, "path is " + paramString);
    new okv(paramView).execute(new String[] { paramString });
  }
  
  public static boolean clearSnapCacheFile(Context paramContext)
  {
    return deleteDir(new File(getSnapDir(paramContext)));
  }
  
  public static boolean deleteDir(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          if (!deleteDir(new File(paramFile, arrayOfString[i]))) {
            return false;
          }
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static String getSnapDir(Context paramContext)
  {
    return paramContext.getFilesDir() + "/" + "snap";
  }
  
  public static String getSnapPath(Context paramContext, int paramInt)
  {
    return paramContext.getFilesDir() + "/" + "snap/" + paramInt;
  }
  
  public static boolean hasSnapFile(Context paramContext)
  {
    return paramContext.getSharedPreferences("snap_cache", 0).getBoolean("snap_cache_file_success_key", false);
  }
  
  public static void setSnapFile(Context paramContext, boolean paramBoolean)
  {
    boolean bool = paramContext.getSharedPreferences("snap_cache", 0).edit().putBoolean("snap_cache_file_success_key", paramBoolean).commit();
    QLog.i("sethmao", 4, "captured is " + paramBoolean + ", success is " + bool + ", has snap file is " + hasSnapFile(paramContext));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\fling\ScreenCapture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */