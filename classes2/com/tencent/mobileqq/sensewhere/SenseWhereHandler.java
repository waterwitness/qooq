package com.tencent.mobileqq.sensewhere;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SenseWhereHandler
  extends BusinessHandler
{
  public static final String a = "IndoorLocation.IndoorLocationProxy";
  public static final String b = "SenseWhere";
  protected Set a;
  
  public SenseWhereHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    if (QLog.isDevelopLevel()) {
      QLog.i("SenseWhere", 4, "handleGetSwResponse isSuccess: " + bool + " resp code: " + paramFromServiceMsg.getResultCode());
    }
    if (paramObject != null) {}
    for (paramToServiceMsg = (byte[])paramObject;; paramToServiceMsg = null)
    {
      ((SenseWhereManager)this.b.getManager(125)).a(paramToServiceMsg);
      paramFromServiceMsg = new HashMap();
      if (paramToServiceMsg == null) {}
      for (int i = 0;; i = paramToServiceMsg.length)
      {
        paramFromServiceMsg.put("dataLength", String.valueOf(i));
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.b.f(), "actSwHandleGetResponse", true, 0L, 0L, paramFromServiceMsg, "");
        return;
      }
    }
  }
  
  protected Class a()
  {
    return SenseWhereObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramToServiceMsg == null)) {}
    while (!"IndoorLocation.IndoorLocationProxy".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("SenseWhere", 4, "postSWData2Server req is null.");
      }
      return;
    }
    Object localObject = a("IndoorLocation.IndoorLocationProxy");
    ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.i("SenseWhere", 4, "postSWData2Server");
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("dataLength", String.valueOf(paramArrayOfByte.length));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.b.f(), "actSwPostData2Server", true, 0L, 0L, (HashMap)localObject, "");
  }
  
  protected boolean a(String paramString)
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("IndoorLocation.IndoorLocationProxy");
    }
    return this.a.contains(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\sensewhere\SenseWhereHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */