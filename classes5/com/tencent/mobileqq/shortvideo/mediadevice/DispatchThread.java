package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.Queue;

public class DispatchThread
  extends Thread
{
  private static final long jdField_a_of_type_Long = 256L;
  private static final String jdField_a_of_type_JavaLangString = "DispatchThread";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final Queue jdField_a_of_type_JavaUtilQueue;
  
  public DispatchThread(HandlerThread paramHandlerThread)
  {
    super("Camera Job Dispatch Thread");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidOsHandlerThread = paramHandlerThread;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramHandlerThread.getLooper());
  }
  
  private boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangBoolean)
    {
      boolean bool = this.jdField_a_of_type_JavaLangBoolean.booleanValue();
      return bool;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangBoolean)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      this.jdField_a_of_type_JavaUtilQueue.notifyAll();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (a()) {
      throw new IllegalStateException("Trying to run job on interrupted dispatcher thread");
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.size() == 256L) {
        throw new RuntimeException("Camera master thread job queue full");
      }
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramRunnable);
    this.jdField_a_of_type_JavaUtilQueue.notifyAll();
  }
  
  public void a(Runnable paramRunnable, Object paramObject, long paramLong, String paramString)
  {
    String str = "Timeout waiting " + paramLong + "ms for " + paramString;
    long l;
    try
    {
      l = SystemClock.uptimeMillis();
      l += paramLong;
      try
      {
        a(paramRunnable);
        paramObject.wait(paramLong);
        if (SystemClock.uptimeMillis() <= l) {
          break label98;
        }
        throw new IllegalStateException(str);
      }
      catch (InterruptedException paramRunnable)
      {
        if (SystemClock.uptimeMillis() <= l) {
          break label98;
        }
      }
      throw new IllegalStateException(str);
    }
    finally {}
    label98:
    if (QLog.isColorLevel()) {
      QLog.i("DispatchThread", 2, "[runJobSync] " + paramString + " cost " + (SystemClock.uptimeMillis() - l + paramLong));
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 35	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   11: invokeinterface 82 1 0
    //   16: ifne +37 -> 53
    //   19: aload_0
    //   20: invokespecial 71	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:a	()Z
    //   23: istore_3
    //   24: iload_3
    //   25: ifne +28 -> 53
    //   28: aload_0
    //   29: getfield 35	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   32: invokevirtual 140	java/lang/Object:wait	()V
    //   35: goto -28 -> 7
    //   38: astore_2
    //   39: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 11
    //   47: iconst_2
    //   48: ldc -114
    //   50: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 35	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   57: invokeinterface 146 1 0
    //   62: checkcast 148	java/lang/Runnable
    //   65: astore_2
    //   66: aload_1
    //   67: monitorexit
    //   68: aload_2
    //   69: ifnonnull +24 -> 93
    //   72: aload_0
    //   73: invokespecial 71	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:a	()Z
    //   76: ifeq -76 -> 0
    //   79: aload_0
    //   80: getfield 45	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   83: invokevirtual 151	android/os/HandlerThread:quit	()Z
    //   86: pop
    //   87: return
    //   88: astore_2
    //   89: aload_1
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    //   93: aload_2
    //   94: invokeinterface 153 1 0
    //   99: aload_0
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 58	com/tencent/mobileqq/shortvideo/mediadevice/DispatchThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   105: new 155	urv
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 158	urv:<init>	(Lcom/tencent/mobileqq/shortvideo/mediadevice/DispatchThread;)V
    //   113: invokevirtual 162	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   116: pop
    //   117: aload_0
    //   118: invokevirtual 140	java/lang/Object:wait	()V
    //   121: aload_0
    //   122: monitorexit
    //   123: goto -123 -> 0
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: goto -11 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	DispatchThread
    //   4	86	1	localQueue	Queue
    //   126	4	1	localObject1	Object
    //   131	1	1	localInterruptedException1	InterruptedException
    //   38	1	2	localInterruptedException2	InterruptedException
    //   65	4	2	localRunnable	Runnable
    //   88	6	2	localObject2	Object
    //   23	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   28	35	38	java/lang/InterruptedException
    //   7	24	88	finally
    //   28	35	88	finally
    //   39	53	88	finally
    //   53	68	88	finally
    //   89	91	88	finally
    //   101	117	126	finally
    //   117	121	126	finally
    //   121	123	126	finally
    //   127	129	126	finally
    //   117	121	131	java/lang/InterruptedException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\DispatchThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */