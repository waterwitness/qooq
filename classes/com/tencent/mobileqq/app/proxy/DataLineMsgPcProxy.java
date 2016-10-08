package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DataLineMsgPcProxy
  extends DataLineMsgProxy
{
  public DataLineMsgPcProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = DataLineMsgRecord.tableName(0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\DataLineMsgPcProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */