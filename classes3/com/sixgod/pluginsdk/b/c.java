package com.sixgod.pluginsdk.b;

import android.util.Log;

public final class c
{
  public static boolean a()
  {
    boolean bool2 = false;
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < arrayOfStackTraceElement.length)
      {
        if (arrayOfStackTraceElement[i] != null)
        {
          String str = arrayOfStackTraceElement[i].getClassName();
          Log.i("qiqili", "shouldGetHostPkgName className = " + str + " methodName = " + arrayOfStackTraceElement[i].getMethodName());
          if ((str.equals("android.app.PendingIntent")) || (str.startsWith("android.widget.Toast")) || (str.startsWith("android.view.inputmethod.InputMethodManager"))) {
            bool1 = true;
          }
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */