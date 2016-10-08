package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class ShieldListObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  
  public ShieldListObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int j = 0;
    int i;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramObject instanceof long[])) {
        paramObject = (long[])paramObject;
      }
      Object[] arrayOfObject;
      for (i = 0;; i = ((Integer)arrayOfObject[1]).intValue())
      {
        int k = paramObject.length;
        while (j < k)
        {
          localArrayList.add(Long.valueOf(paramObject[j]));
          j += 1;
        }
        arrayOfObject = (Object[])paramObject;
        paramObject = (long[])arrayOfObject[0];
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        a(paramBoolean);
        return;
      case 2: 
        a(paramBoolean, (List)paramObject);
        a(paramBoolean, (List)paramObject, i);
        return;
      case 3: 
        b(paramBoolean, (List)paramObject);
        b(paramBoolean, (List)paramObject, i);
        return;
      }
      a();
      return;
      paramObject = null;
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt) {}
  
  protected void b(boolean paramBoolean, List paramList) {}
  
  protected void b(boolean paramBoolean, List paramList, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ShieldListObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */