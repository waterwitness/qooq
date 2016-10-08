package com.tencent.device.msg.data;

import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import kaq;
import kar;

public class DeviceCommonMsgProcessor
{
  public DeviceCommonMsgProcessor()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(kaq paramkaq1, kaq paramkaq2)
  {
    if ((paramkaq1 == null) || (paramkaq2 == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramkaq1.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramkaq1.b);
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramkaq2.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramkaq2.b);
    localStringBuilder.append("\"");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static void a(Session paramSession, boolean paramBoolean)
  {
    try
    {
      new kar(paramSession, paramBoolean).a();
      return;
    }
    catch (Throwable paramSession)
    {
      paramSession.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\msg\data\DeviceCommonMsgProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */