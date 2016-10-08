package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class TraceUtil
{
  private static final boolean a = ScanTorchActivity.b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TraceUtil", 4, "TraceUtil------>:" + paramString + ":" + System.currentTimeMillis());
    }
  }
  
  public static void b(String paramString)
  {
    if ((a) && (QLog.isColorLevel())) {
      QLog.d("AR_PERFORMANCE", 2, paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\TraceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */