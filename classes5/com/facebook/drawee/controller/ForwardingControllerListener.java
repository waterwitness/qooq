package com.facebook.drawee.controller;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ForwardingControllerListener<INFO>
  implements ControllerListener<INFO>
{
  private static final String TAG = "FdingControllerListener";
  private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);
  
  public static <INFO> ForwardingControllerListener<INFO> create()
  {
    return new ForwardingControllerListener();
  }
  
  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener);
    return localForwardingControllerListener;
  }
  
  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener1);
    localForwardingControllerListener.addListener(paramControllerListener2);
    return localForwardingControllerListener;
  }
  
  private void onException(String paramString, Throwable paramThrowable)
  {
    try
    {
      Log.e("FdingControllerListener", paramString, paramThrowable);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void addListener(ControllerListener<? super INFO> paramControllerListener)
  {
    try
    {
      this.mListeners.add(paramControllerListener);
      return;
    }
    finally
    {
      paramControllerListener = finally;
      throw paramControllerListener;
    }
  }
  
  public void clearListeners()
  {
    try
    {
      this.mListeners.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void onFailure(String paramString, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/facebook/drawee/controller/ForwardingControllerListener:mListeners	Ljava/util/List;
    //   6: invokeinterface 69 1 0
    //   11: istore 5
    //   13: iconst_0
    //   14: istore 4
    //   16: iload 4
    //   18: iload 5
    //   20: if_icmplt +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 26	com/facebook/drawee/controller/ForwardingControllerListener:mListeners	Ljava/util/List;
    //   30: iload 4
    //   32: invokeinterface 73 2 0
    //   37: checkcast 7	com/facebook/drawee/controller/ControllerListener
    //   40: astore_3
    //   41: aload_3
    //   42: aload_1
    //   43: aload_2
    //   44: invokeinterface 75 3 0
    //   49: iload 4
    //   51: iconst_1
    //   52: iadd
    //   53: istore 4
    //   55: goto -39 -> 16
    //   58: astore_3
    //   59: aload_0
    //   60: ldc 77
    //   62: aload_3
    //   63: invokespecial 79	com/facebook/drawee/controller/ForwardingControllerListener:onException	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: goto -17 -> 49
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ForwardingControllerListener
    //   0	74	1	paramString	String
    //   0	74	2	paramThrowable	Throwable
    //   40	2	3	localControllerListener	ControllerListener
    //   58	5	3	localException	Exception
    //   14	40	4	i	int
    //   11	10	5	j	int
    // Exception table:
    //   from	to	target	type
    //   41	49	58	java/lang/Exception
    //   2	13	69	finally
    //   26	41	69	finally
    //   41	49	69	finally
    //   59	66	69	finally
  }
  
  /* Error */
  public void onFinalImageSet(String paramString, @Nullable INFO paramINFO, @Nullable android.graphics.drawable.Animatable paramAnimatable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/facebook/drawee/controller/ForwardingControllerListener:mListeners	Ljava/util/List;
    //   6: invokeinterface 69 1 0
    //   11: istore 6
    //   13: iconst_0
    //   14: istore 5
    //   16: iload 5
    //   18: iload 6
    //   20: if_icmplt +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 26	com/facebook/drawee/controller/ForwardingControllerListener:mListeners	Ljava/util/List;
    //   30: iload 5
    //   32: invokeinterface 73 2 0
    //   37: checkcast 7	com/facebook/drawee/controller/ControllerListener
    //   40: astore 4
    //   42: aload 4
    //   44: aload_1
    //   45: aload_2
    //   46: aload_3
    //   47: invokeinterface 84 4 0
    //   52: iload 5
    //   54: iconst_1
    //   55: iadd
    //   56: istore 5
    //   58: goto -42 -> 16
    //   61: astore 4
    //   63: aload_0
    //   64: ldc 86
    //   66: aload 4
    //   68: invokespecial 79	com/facebook/drawee/controller/ForwardingControllerListener:onException	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: goto -19 -> 52
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ForwardingControllerListener
    //   0	79	1	paramString	String
    //   0	79	2	paramINFO	INFO
    //   0	79	3	paramAnimatable	android.graphics.drawable.Animatable
    //   40	3	4	localControllerListener	ControllerListener
    //   61	6	4	localException	Exception
    //   14	43	5	i	int
    //   11	10	6	j	int
    // Exception table:
    //   from	to	target	type
    //   42	52	61	java/lang/Exception
    //   2	13	74	finally
    //   26	42	74	finally
    //   42	52	74	finally
    //   63	71	74	finally
  }
  
  public void onIntermediateImageFailed(String paramString, Throwable paramThrowable)
  {
    int j = this.mListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
      try
      {
        localControllerListener.onIntermediateImageFailed(paramString, paramThrowable);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onIntermediateImageFailed", localException);
        }
      }
    }
  }
  
  public void onIntermediateImageSet(String paramString, @Nullable INFO paramINFO)
  {
    int j = this.mListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(i);
      try
      {
        localControllerListener.onIntermediateImageSet(paramString, paramINFO);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onIntermediateImageSet", localException);
        }
      }
    }
  }
  
  /* Error */
  public void onRelease(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/facebook/drawee/controller/ForwardingControllerListener:mListeners	Ljava/util/List;
    //   6: invokeinterface 69 1 0
    //   11: istore 4
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: iload 4
    //   18: if_icmplt +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 26	com/facebook/drawee/controller/ForwardingControllerListener:mListeners	Ljava/util/List;
    //   28: iload_3
    //   29: invokeinterface 73 2 0
    //   34: checkcast 7	com/facebook/drawee/controller/ControllerListener
    //   37: astore_2
    //   38: aload_2
    //   39: aload_1
    //   40: invokeinterface 104 2 0
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: istore_3
    //   49: goto -34 -> 15
    //   52: astore_2
    //   53: aload_0
    //   54: ldc 106
    //   56: aload_2
    //   57: invokespecial 79	com/facebook/drawee/controller/ForwardingControllerListener:onException	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: goto -15 -> 45
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ForwardingControllerListener
    //   0	68	1	paramString	String
    //   37	2	2	localControllerListener	ControllerListener
    //   52	5	2	localException	Exception
    //   14	35	3	i	int
    //   11	8	4	j	int
    // Exception table:
    //   from	to	target	type
    //   38	45	52	java/lang/Exception
    //   2	13	63	finally
    //   24	38	63	finally
    //   38	45	63	finally
    //   53	60	63	finally
  }
  
  /* Error */
  public void onSubmit(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/facebook/drawee/controller/ForwardingControllerListener:mListeners	Ljava/util/List;
    //   6: invokeinterface 69 1 0
    //   11: istore 5
    //   13: iconst_0
    //   14: istore 4
    //   16: iload 4
    //   18: iload 5
    //   20: if_icmplt +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 26	com/facebook/drawee/controller/ForwardingControllerListener:mListeners	Ljava/util/List;
    //   30: iload 4
    //   32: invokeinterface 73 2 0
    //   37: checkcast 7	com/facebook/drawee/controller/ControllerListener
    //   40: astore_3
    //   41: aload_3
    //   42: aload_1
    //   43: aload_2
    //   44: invokeinterface 109 3 0
    //   49: iload 4
    //   51: iconst_1
    //   52: iadd
    //   53: istore 4
    //   55: goto -39 -> 16
    //   58: astore_3
    //   59: aload_0
    //   60: ldc 111
    //   62: aload_3
    //   63: invokespecial 79	com/facebook/drawee/controller/ForwardingControllerListener:onException	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: goto -17 -> 49
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ForwardingControllerListener
    //   0	74	1	paramString	String
    //   0	74	2	paramObject	Object
    //   40	2	3	localControllerListener	ControllerListener
    //   58	5	3	localException	Exception
    //   14	40	4	i	int
    //   11	10	5	j	int
    // Exception table:
    //   from	to	target	type
    //   41	49	58	java/lang/Exception
    //   2	13	69	finally
    //   26	41	69	finally
    //   41	49	69	finally
    //   59	66	69	finally
  }
  
  public void removeListener(ControllerListener<? super INFO> paramControllerListener)
  {
    try
    {
      this.mListeners.remove(paramControllerListener);
      return;
    }
    finally
    {
      paramControllerListener = finally;
      throw paramControllerListener;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\controller\ForwardingControllerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */