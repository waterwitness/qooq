package com.tencent.mobileqq.qipc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QIPCClientModuleFactory
{
  public QIPCClientModuleFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static QIPCModule a(String paramString)
  {
    if ("QIPCClientModuleCore".equals(paramString)) {
      return new QIPCClientModuleCore();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qipc\QIPCClientModuleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */