import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.locks.ReentrantLock;

public class pqi
  implements Runnable
{
  public pqi(ApolloRenderDriver paramApolloRenderDriver, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */