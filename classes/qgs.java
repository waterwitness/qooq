import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.BlockingQueue;

public class qgs
  extends qhi
{
  private static final int a = 3;
  private static final int b = 9;
  private static final int c = 1;
  
  public qgs(BlockingQueue paramBlockingQueue, qdh paramqdh)
  {
    super(3, 9, 1L, paramBlockingQueue, paramqdh);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    ThreadRegulator.a().b();
    super.beforeExecute(paramThread, paramRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */