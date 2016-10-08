package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import mqq.manager.Manager;

public class NetEngineFactory
  implements Manager
{
  public static final int a = 0;
  public INetEngine a;
  public INetEngine b;
  
  public NetEngineFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public INetEngine a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new OldHttpEngine(paramAppInterface.a(), false);
        }
        return this.a;
      }
      finally {}
    }
    return null;
  }
  
  public INetEngine a(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount)
  {
    if (this.b == null) {}
    try
    {
      paramIHttpCommunicatorFlowCount = new HttpCommunicator(paramIHttpCommunicatorFlowCount, 32);
      paramIHttpCommunicatorFlowCount.a();
      this.b = new OldHttpEngine(paramIHttpCommunicatorFlowCount, true);
      return this.b;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      ((OldHttpEngine)this.a).a();
    }
    if (this.b != null) {
      ((OldHttpEngine)this.b).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\NetEngineFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */