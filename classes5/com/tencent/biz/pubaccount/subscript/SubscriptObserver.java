package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class SubscriptObserver
  implements BusinessObserver
{
  public static final int a = 1;
  protected static final String a = SubscriptObserver.class.getSimpleName();
  public static final int b = 2;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (paramObject != null) {
        try
        {
          a(paramBoolean, (ArrayList)paramObject);
          return;
        }
        catch (Exception paramObject)
        {
          return;
        }
      }
      a(false, new ArrayList(0));
      return;
    }
    if (paramObject != null) {
      try
      {
        a(paramBoolean, (ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        return;
      }
    }
    a(false, new ArrayList(0));
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */