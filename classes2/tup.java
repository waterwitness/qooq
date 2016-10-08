import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.precover.PrecoverReporter;

public class tup
  implements Runnable
{
  public tup(PrecoverManager paramPrecoverManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PrecoverManager.a(this.a).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */