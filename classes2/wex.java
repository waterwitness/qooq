import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.URLInterceptManager;

public class wex
  implements Runnable
{
  public wex(URLInterceptManager paramURLInterceptManager, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasURLInterceptManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */