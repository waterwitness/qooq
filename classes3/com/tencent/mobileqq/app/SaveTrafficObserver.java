package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class SaveTrafficObserver
  implements BusinessObserver
{
  private static final String a = "SaveTrafficObserver";
  
  public SaveTrafficObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficObserver", 2, "onUpdate type:" + paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SaveTrafficObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */