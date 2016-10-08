package com.tencent.mobileqq.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import vyt;

public class InfiniteTaskThreadPool
  extends ThreadPoolExecutor
{
  public static final int a = 3;
  public static final long a = 10L;
  private static InfiniteTaskThreadPool a;
  public static final String a = "InfiniteTaskThread_";
  private static int b;
  
  public InfiniteTaskThreadPool(int paramInt, long paramLong)
  {
    super(paramInt, Integer.MAX_VALUE, paramLong, TimeUnit.SECONDS, new LinkedBlockingQueue(), new vyt(), new ThreadPoolExecutor.CallerRunsPolicy());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final InfiniteTaskThreadPool a()
  {
    if (a == null) {
      a = new InfiniteTaskThreadPool(3, 10L);
    }
    return a;
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      super.execute(paramRunnable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\InfiniteTaskThreadPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */