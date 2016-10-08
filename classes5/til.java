import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class til
  implements Runnable
{
  public static final long a = 0L;
  public static final long b = 60000L;
  public int a;
  public String a;
  public int b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public til()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.f = System.currentTimeMillis();
      ThreadManager.a(new tim(this), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\til.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */