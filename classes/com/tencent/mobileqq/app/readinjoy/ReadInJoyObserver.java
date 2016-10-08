package com.tencent.mobileqq.app.readinjoy;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReadInJoyObserver
  implements BusinessObserver
{
  public ReadInJoyObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramObject == null);
      if (!paramBoolean) {
        break;
      }
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    a(true, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue());
    return;
    a(false, false, -1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\readinjoy\ReadInJoyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */