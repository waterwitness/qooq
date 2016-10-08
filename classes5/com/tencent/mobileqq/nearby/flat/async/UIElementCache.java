package com.tencent.mobileqq.nearby.flat.async;

import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UIElementCache
  extends MQLruCache
{
  static int a = 60;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    int i = StatisticConstants.a();
    if (i == 0) {
      a = 30;
    }
    do
    {
      return;
      if (i == 1)
      {
        a = 45;
        return;
      }
    } while (i != 2);
  }
  
  public UIElementCache()
  {
    super(a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\async\UIElementCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */