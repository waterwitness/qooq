package com.tencent.biz.common.util;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class OpenIdObserver
  extends MessageObserver
{
  public static final int a = 1;
  
  public OpenIdObserver()
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
    QLog.d("openid", 2, "isSuccess=" + paramBoolean + ",data=" + paramObject);
    a(paramBoolean, (OpenID)paramObject);
  }
  
  protected void a(boolean paramBoolean, OpenID paramOpenID) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\util\OpenIdObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */