package com.tencent.mobileqq.activity.fling;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class FlingAllowProvider
{
  private static List a = new ArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean contain(String paramString)
  {
    return a.contains(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\fling\FlingAllowProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */