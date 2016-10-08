package com.tencent.devicelib;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class DeviceLib
{
  public DeviceLib()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, TextView paramTextView)
  {
    if ((paramContext == null) || (paramTextView == null)) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.textSelectHandleUseable.name(), String.valueOf(-1));
      } while (((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("-1"))) && ((!a()) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals("0")))));
      try
      {
        localObject = TextView.class.getDeclaredField("mTextSelectHandleRes");
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(paramTextView, Integer.valueOf(((Integer)((Field)localObject).get(new TextView(paramContext))).intValue()));
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isDevelopLevel());
    paramContext.printStackTrace();
  }
  
  public static boolean a()
  {
    try
    {
      String str = Build.MODEL;
      if (str != null)
      {
        if (str.length() == 0) {
          return false;
        }
        str = str.toUpperCase().trim();
        if ((!str.startsWith("SH-")) && (!str.startsWith("SHL")) && (!str.startsWith("SBM")))
        {
          boolean bool = str.endsWith("SH");
          if (!bool) {}
        }
        else
        {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\devicelib\DeviceLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */