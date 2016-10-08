package com.tencent.mobileqq.shortvideo.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class LocalConfig
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static final String jdField_a_of_type_JavaLangString = "QQ_short_video_setting";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = VideoEnvironment.a();
  }
  
  private static SharedPreferences a()
  {
    if (a == null) {
      throw new RuntimeException("mContext is null, please call init()");
    }
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return a.getSharedPreferences("QQ_short_video_setting", i);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a().getBoolean(paramString, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\common\LocalConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */