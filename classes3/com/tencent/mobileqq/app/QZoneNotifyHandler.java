package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class QZoneNotifyHandler
  extends BusinessHandler
{
  public static final int a = 1;
  
  QZoneNotifyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Class a()
  {
    return QZoneNotifyObserver.class;
  }
  
  public void a()
  {
    a(a("QzoneService.GetNewAndUnread"));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QzoneService.GetNewAndUnread".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramObject == null) {
        a(1, false, null);
      }
    }
    else {
      return;
    }
    a(1, true, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QZoneNotifyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */