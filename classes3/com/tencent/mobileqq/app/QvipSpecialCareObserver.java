package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QvipSpecialCareObserver
  implements BusinessObserver
{
  public QvipSpecialCareObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      a(paramObject);
      return;
    }
    b(paramObject);
  }
  
  public void a(Object paramObject) {}
  
  public void b(Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QvipSpecialCareObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */