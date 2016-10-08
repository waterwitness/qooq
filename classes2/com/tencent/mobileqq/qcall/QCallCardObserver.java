package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QCallCardObserver
  implements BusinessObserver
{
  public QCallCardObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, paramObject);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\QCallCardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */