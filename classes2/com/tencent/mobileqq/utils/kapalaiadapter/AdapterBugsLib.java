package com.tencent.mobileqq.utils.kapalaiadapter;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AdapterBugsLib
{
  public AdapterBugsLib()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (DeviceInfoUtil2.a()) {
      try
      {
        Class localClass = Class.forName("meizu.splitmode.FlymeSplitModeManager");
        paramActivity = localClass.getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramActivity });
        boolean bool = ((Boolean)localClass.getMethod("isSplitMode", new Class[0]).invoke(paramActivity, new Object[0])).booleanValue();
        return bool;
      }
      catch (IllegalAccessException paramActivity)
      {
        paramActivity.printStackTrace();
        return false;
      }
      catch (IllegalArgumentException paramActivity)
      {
        paramActivity.printStackTrace();
        return false;
      }
      catch (InvocationTargetException paramActivity)
      {
        paramActivity.printStackTrace();
        return false;
      }
      catch (NoSuchMethodException paramActivity)
      {
        paramActivity.printStackTrace();
        return false;
      }
      catch (ClassNotFoundException paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\kapalaiadapter\AdapterBugsLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */