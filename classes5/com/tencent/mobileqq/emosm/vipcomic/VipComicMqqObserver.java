package com.tencent.mobileqq.emosm.vipcomic;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VipComicMqqObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  
  public VipComicMqqObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      a(paramObject);
      return;
    }
    b(paramObject);
  }
  
  public void a(Object paramObject) {}
  
  public void b(Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\vipcomic\VipComicMqqObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */