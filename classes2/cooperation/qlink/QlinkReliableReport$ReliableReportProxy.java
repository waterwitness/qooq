package cooperation.qlink;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QlinkReliableReport$ReliableReportProxy
  extends BaseProxy
{
  public QlinkReliableReport$ReliableReportProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    QlinkReliableReport.a().c();
  }
  
  protected void b()
  {
    QlinkReliableReport.a().d();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlinkReliableReport$ReliableReportProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */