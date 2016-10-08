import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.BlockingQueue;

public class qgx
  extends qhi
{
  public static final int a = 256;
  private static final int b = 5;
  private static final int c = 5;
  
  public qgx(BlockingQueue paramBlockingQueue, qdh paramqdh)
  {
    super(5, 256, 5L, paramBlockingQueue, paramqdh);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    ThreadRegulator.a().b();
    super.beforeExecute(paramThread, paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */