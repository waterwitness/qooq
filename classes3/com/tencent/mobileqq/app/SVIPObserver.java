package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class SVIPObserver
  implements BusinessObserver
{
  private static final String a = "SVIPObserver";
  
  public SVIPObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 101: 
      do
      {
        return;
        if ((paramObject instanceof Integer))
        {
          a(((Integer)paramObject).intValue());
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SVIPObserver", 2, "NOTIFY_TYPE_SVIP_BUBBLE_CHANGE param error");
      return;
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SVIPObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */