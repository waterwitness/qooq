package com.hiar.sdk.core;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class HiarqLog
{
  public HiarqLog()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void callback(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HIARQ", 2, "msg:" + paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\core\HiarqLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */