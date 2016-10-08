package com.tencent.mobileqq.trick;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashSet;
import java.util.Set;

public class ClassNameHelper
{
  private static Set a;
  
  public ClassNameHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Set a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = new HashSet();
        a.add("com.android.settings.SubSettings");
        a.add("com.android.settings.applications.ManageApplicationsActivity");
      }
      return a;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\trick\ClassNameHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */