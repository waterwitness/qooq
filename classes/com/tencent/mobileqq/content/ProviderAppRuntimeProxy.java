package com.tencent.mobileqq.content;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppRuntime;

public class ProviderAppRuntimeProxy
{
  public ProviderAppRuntimeProxy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  SQLiteDatabase a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAppRuntime != null)
    {
      localObject1 = localObject2;
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        paramAppRuntime = (QQAppInterface)paramAppRuntime;
        if (!paramBoolean) {
          break label41;
        }
        localObject1 = paramAppRuntime.b(paramString);
      }
    }
    return (SQLiteDatabase)localObject1;
    label41:
    return paramAppRuntime.a(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\content\ProviderAppRuntimeProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */