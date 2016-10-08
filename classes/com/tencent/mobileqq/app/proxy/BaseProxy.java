package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseProxy
{
  protected QQAppInterface a;
  public ProxyManager a;
  
  public BaseProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = paramProxyManager;
  }
  
  protected abstract void a();
  
  protected abstract void b();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\BaseProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */