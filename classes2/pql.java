import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantLock;

public class pql
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public pql(String paramString, ReentrantLock paramReentrantLock, ApolloEngine paramApolloEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = paramReentrantLock;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloEngine);
  }
  
  public void run()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      ApolloEngine localApolloEngine = (ApolloEngine)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localApolloEngine != null) {
        localApolloEngine.b(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */