package com.tencent.mobileqq.ark;

import android.os.Handler;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DispatchTask$BlockingRunnable
  implements Runnable
{
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public DispatchTask$BlockingRunnable(Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public boolean a(Handler paramHandler)
  {
    try
    {
      if (!paramHandler.post(this)) {
        return false;
      }
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException paramHandler)
        {
          Log.d("ark.DispatchTask", "DispatchTask.exception: " + paramHandler.getLocalizedMessage());
        }
      }
    }
    finally {}
    return true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mobileqq/ark/DispatchTask$BlockingRunnable:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   4: invokeinterface 63 1 0
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 33	com/tencent/mobileqq/ark/DispatchTask$BlockingRunnable:jdField_a_of_type_Boolean	Z
    //   16: aload_0
    //   17: invokevirtual 66	java/lang/Object:notifyAll	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorenter
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 33	com/tencent/mobileqq/ark/DispatchTask$BlockingRunnable:jdField_a_of_type_Boolean	Z
    //   36: aload_0
    //   37: invokevirtual 66	java/lang/Object:notifyAll	()V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	BlockingRunnable
    //   23	4	1	localObject1	Object
    //   28	15	1	localObject2	Object
    //   44	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	22	23	finally
    //   24	26	23	finally
    //   0	9	28	finally
    //   31	42	44	finally
    //   45	47	44	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\DispatchTask$BlockingRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */