import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qna
  implements Runnable
{
  public qna(DataLineMsgProxy paramDataLineMsgProxy, String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a.a(String.valueOf(0), 0, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ArrayOfJavaLangString, 2, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */