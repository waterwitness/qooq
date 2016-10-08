package com.tencent.tmdownloader.internal.c;

import com.tencent.tmassistant.common.jce.GetCallerSettingRequest;
import com.tencent.tmassistant.common.jce.GetCallerSettingResponse;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantbase.network.d;

public class a
  extends d
{
  protected static final String c = a.class.getSimpleName();
  protected b b = null;
  
  public void a(b paramb)
  {
    this.b = paramb;
  }
  
  protected void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    m.c(c, "enter");
    m.c(c, "onFinished errorCode: " + paramInt);
    if (paramArrayOfByte2 == null)
    {
      m.c(c, "onFinished response is null!");
      m.c(c, "exit");
      return;
    }
    paramArrayOfByte2 = com.tencent.tmassistant.common.a.a(paramArrayOfByte2);
    paramArrayOfByte1 = com.tencent.tmassistant.common.a.a(((Request)com.tencent.tmassistant.common.a.a(paramArrayOfByte1, Request.class)).body, GetCallerSettingRequest.class);
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.body != null))
    {
      paramArrayOfByte2 = com.tencent.tmassistant.common.a.a(paramArrayOfByte1, paramArrayOfByte2.body);
      if ((paramArrayOfByte2 != null) && (this.b != null) && (paramInt == 0) && ((paramArrayOfByte2 instanceof GetCallerSettingResponse)))
      {
        paramArrayOfByte2 = (GetCallerSettingResponse)paramArrayOfByte2;
        if (paramArrayOfByte2.ret != 0) {
          break label155;
        }
        this.b.a((GetCallerSettingRequest)paramArrayOfByte1, paramArrayOfByte2, true);
      }
    }
    for (;;)
    {
      m.c(c, "exit");
      return;
      label155:
      this.b.a((GetCallerSettingRequest)paramArrayOfByte1, paramArrayOfByte2, false);
    }
  }
  
  public void b()
  {
    super.a(com.tencent.tmassistant.common.a.a(com.tencent.tmassistant.common.a.b(new GetCallerSettingRequest())));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */