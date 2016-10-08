import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class wdk
  extends ThreadPoolExecutor
{
  private static int a = 0;
  public static final String a = "InfiniteTaskThread_";
  
  public wdk(int paramInt, long paramLong)
  {
    super(paramInt, Integer.MAX_VALUE, paramLong, TimeUnit.SECONDS, new LinkedBlockingQueue(), new wdl(), new ThreadPoolExecutor.CallerRunsPolicy());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */