package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MSFCodec
  implements INetTransportProvider.INetTransportCodec
{
  private String a;
  
  public MSFCodec(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public Object a(Object paramObject)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(this.a))) {
      return null;
    }
    Object localObject = "";
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    if (localAppRuntime != null) {
      localObject = localAppRuntime.getAccount();
    }
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, this.a);
    ((ToServiceMsg)localObject).putWupBuffer((byte[])paramObject);
    return localObject;
  }
  
  public Object b(Object paramObject)
  {
    return ((FromServiceMsg)paramObject).getWupBuffer();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\msfmqpsdkbridge\MSFCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */