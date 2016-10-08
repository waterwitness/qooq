package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;

public class ArkAppHandler
  extends BusinessHandler
{
  public static final String a = "ArkApp.BusinessHandler";
  private static final int[] a = { 95 };
  private static final String b = "ArkAppSvc.Echo";
  private static final String c = "SendTime";
  private static final String d = "IsGenericCmd";
  private static final String e = "NotifyType";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArkAppHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      paramToServiceMsg = new String((byte[])paramObject, "UTF-8");
      paramFromServiceMsg = paramToServiceMsg;
      if (paramToServiceMsg == null) {
        paramFromServiceMsg = "";
      }
      return paramFromServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        ArkAppCenter.c("ArkApp.BusinessHandler", String.format("onReceive_AppMsg, fail convert data to string", new Object[0]));
        paramToServiceMsg = null;
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    paramBusinessObserver = super.a(paramString, paramBusinessObserver);
    paramBusinessObserver.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
    paramBusinessObserver.addAttribute("IsGenericCmd", Boolean.valueOf(paramBoolean));
    paramBusinessObserver.addAttribute("NotifyType", Integer.valueOf(paramInt2));
    paramBusinessObserver.putWupBuffer(paramArrayOfByte);
    if (paramInt1 > 0) {
      paramBusinessObserver.setTimeout(paramInt1);
    }
    if (!Cmd2HandlerMap.a().containsKey(paramString)) {
      Cmd2HandlerMap.a(paramString, a);
    }
    super.b(paramBusinessObserver);
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramToServiceMsg = (Proto.EchoRsp)new Proto.EchoRsp().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          return null;
        }
        if (paramToServiceMsg.msg.has())
        {
          paramToServiceMsg = paramToServiceMsg.msg.get();
          paramFromServiceMsg = paramToServiceMsg;
          if (paramToServiceMsg == null) {
            paramFromServiceMsg = "";
          }
          return paramFromServiceMsg;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        return null;
      }
      paramToServiceMsg = null;
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    long l1 = ((Long)paramToServiceMsg.getAttribute("SendTime")).longValue();
    long l2 = System.currentTimeMillis();
    boolean bool2 = ((Boolean)paramToServiceMsg.getAttribute("IsGenericCmd")).booleanValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("NotifyType")).intValue();
    String str = paramFromServiceMsg.getServiceCmd();
    ArkAppCenter.c("ArkApp.BusinessHandler", String.format("onReceive, cmd=%s, app-msg=%s, suc=%s, delay=%d, ", new Object[] { str, Boolean.toString(bool2), Boolean.toString(bool1), Long.valueOf(l2 - l1) }));
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool1)
    {
      if (!bool2) {
        break label147;
      }
      localObject1 = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (localObject1 != null)
    {
      super.a(paramToServiceMsg, i, true, localObject1);
      return;
      label147:
      localObject1 = localObject2;
      if (str.equalsIgnoreCase("ArkAppSvc.Echo")) {
        localObject1 = b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    super.a(paramToServiceMsg, i, false, null);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBusinessObserver == null)) {
      return false;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    try
    {
      paramString2 = str.getBytes("UTF-8");
      a(paramString1, true, paramString2, paramInt1, paramInt2, paramBusinessObserver);
      return true;
    }
    catch (Exception paramString2)
    {
      ArkAppCenter.c("ArkApp.BusinessHandler", String.format("sendAppMsg, fail convert content to bytes array, cmd=%s, content=%s", new Object[] { paramString1, str }));
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */