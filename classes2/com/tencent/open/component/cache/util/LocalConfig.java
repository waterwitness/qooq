package com.tencent.open.component.cache.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;

public class LocalConfig
{
  public static final String a = "OPENSDK_setting";
  protected static final String b = "preference";
  
  public LocalConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString, int paramInt, long paramLong)
  {
    return a(paramLong).getInt(paramString, paramInt);
  }
  
  public static SharedPreferences a()
  {
    int i = Build.VERSION.SDK_INT;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("OPENSDK_setting", i);
    }
  }
  
  public static SharedPreferences a(long paramLong)
  {
    if (paramLong == 0L) {
      return a();
    }
    String str = MD5Utils.b(String.valueOf(paramLong)) + "_" + "preference";
    return BaseApplication.getContext().getSharedPreferences(str, 0);
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramLong).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\component\cache\util\LocalConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */