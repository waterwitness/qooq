package com.tencent.open.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OpensdkPreference
{
  protected static final String a = "sdk_preference";
  
  public OpensdkPreference()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "sdk_preference";
    }
    return paramContext.getSharedPreferences(str, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\settings\OpensdkPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */