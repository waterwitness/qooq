package com.facebook.stetho.common.android;

import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

public final class HandlerUtil
{
  public static boolean checkThreadAccess(Handler paramHandler)
  {
    return Looper.myLooper() == paramHandler.getLooper();
  }
  
  public static <V> V postAndWait(Handler paramHandler, UncheckedCallable<V> paramUncheckedCallable)
  {
    if (checkThreadAccess(paramHandler)) {
      try
      {
        paramHandler = paramUncheckedCallable.call();
        return paramHandler;
      }
      catch (Exception paramHandler)
      {
        throw new RuntimeException(paramHandler);
      }
    }
    (V)new WaitableRunnable()
    {
      protected V onRun()
      {
        return (V)HandlerUtil.this.call();
      }
    }.invoke(paramHandler);
  }
  
  public static void postAndWait(Handler paramHandler, Runnable paramRunnable)
  {
    if (checkThreadAccess(paramHandler)) {
      try
      {
        paramRunnable.run();
        return;
      }
      catch (RuntimeException paramHandler)
      {
        throw new RuntimeException(paramHandler);
      }
    }
    new WaitableRunnable()
    {
      protected Void onRun()
      {
        HandlerUtil.this.run();
        return null;
      }
    }.invoke(paramHandler);
  }
  
  public static void verifyThreadAccess(Handler paramHandler)
  {
    Util.throwIfNot(checkThreadAccess(paramHandler));
  }
  
  private static abstract class WaitableRunnable<V>
    implements Runnable
  {
    private Exception mException;
    private boolean mIsDone;
    private V mValue;
    
    /* Error */
    private void join()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 27	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mIsDone	Z
      //   6: ifeq +6 -> 12
      //   9: aload_0
      //   10: monitorexit
      //   11: return
      //   12: aload_0
      //   13: invokevirtual 30	java/lang/Object:wait	()V
      //   16: goto -14 -> 2
      //   19: astore_1
      //   20: goto -18 -> 2
      //   23: astore_1
      //   24: aload_0
      //   25: monitorexit
      //   26: aload_1
      //   27: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	28	0	this	WaitableRunnable
      //   19	1	1	localInterruptedException	InterruptedException
      //   23	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   12	16	19	java/lang/InterruptedException
      //   2	11	23	finally
      //   12	16	23	finally
      //   24	26	23	finally
    }
    
    public V invoke(Handler paramHandler)
    {
      if (!paramHandler.post(this)) {
        throw new RuntimeException("Handler.post() returned false");
      }
      join();
      if (this.mException != null) {
        throw new RuntimeException(this.mException);
      }
      return (V)this.mValue;
    }
    
    protected abstract V onRun();
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_0
      //   2: invokevirtual 63	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:onRun	()Ljava/lang/Object;
      //   5: putfield 54	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mValue	Ljava/lang/Object;
      //   8: aload_0
      //   9: aconst_null
      //   10: putfield 49	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mException	Ljava/lang/Exception;
      //   13: aload_0
      //   14: monitorenter
      //   15: aload_0
      //   16: iconst_1
      //   17: putfield 27	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mIsDone	Z
      //   20: aload_0
      //   21: invokevirtual 66	java/lang/Object:notifyAll	()V
      //   24: aload_0
      //   25: monitorexit
      //   26: return
      //   27: astore_1
      //   28: aload_0
      //   29: aconst_null
      //   30: putfield 54	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mValue	Ljava/lang/Object;
      //   33: aload_0
      //   34: aload_1
      //   35: putfield 49	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mException	Ljava/lang/Exception;
      //   38: aload_0
      //   39: monitorenter
      //   40: aload_0
      //   41: iconst_1
      //   42: putfield 27	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mIsDone	Z
      //   45: aload_0
      //   46: invokevirtual 66	java/lang/Object:notifyAll	()V
      //   49: aload_0
      //   50: monitorexit
      //   51: return
      //   52: astore_1
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_1
      //   56: athrow
      //   57: astore_1
      //   58: aload_0
      //   59: monitorenter
      //   60: aload_0
      //   61: iconst_1
      //   62: putfield 27	com/facebook/stetho/common/android/HandlerUtil$WaitableRunnable:mIsDone	Z
      //   65: aload_0
      //   66: invokevirtual 66	java/lang/Object:notifyAll	()V
      //   69: aload_0
      //   70: monitorexit
      //   71: aload_1
      //   72: athrow
      //   73: astore_1
      //   74: aload_0
      //   75: monitorexit
      //   76: aload_1
      //   77: athrow
      //   78: astore_1
      //   79: aload_0
      //   80: monitorexit
      //   81: aload_1
      //   82: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	WaitableRunnable
      //   27	8	1	localException	Exception
      //   52	4	1	localObject1	Object
      //   57	15	1	localObject2	Object
      //   73	4	1	localObject3	Object
      //   78	4	1	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   0	13	27	java/lang/Exception
      //   40	51	52	finally
      //   53	55	52	finally
      //   0	13	57	finally
      //   28	38	57	finally
      //   60	71	73	finally
      //   74	76	73	finally
      //   15	26	78	finally
      //   79	81	78	finally
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\HandlerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */