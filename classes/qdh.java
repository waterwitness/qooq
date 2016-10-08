import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ThreadFactory;

public class qdh
  implements ThreadFactory
{
  public int a;
  public String a;
  
  public qdh(String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, this.jdField_a_of_type_JavaLangString);
    if (ThreadOptimizer.a().c())
    {
      paramRunnable.setPriority(1);
      return paramRunnable;
    }
    paramRunnable.setPriority(this.jdField_a_of_type_Int);
    return paramRunnable;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */