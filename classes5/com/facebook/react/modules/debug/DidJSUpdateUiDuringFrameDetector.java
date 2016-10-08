package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LongArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;

public class DidJSUpdateUiDuringFrameDetector
  implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener
{
  private final LongArray mTransitionToBusyEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mTransitionToIdleEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mViewHierarchyUpdateEnqueuedEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mViewHierarchyUpdateFinishedEvents = LongArray.createWithInitialCapacity(20);
  private volatile boolean mWasIdleAtEndOfLastFrame = true;
  
  private static void cleanUp(LongArray paramLongArray, long paramLong)
  {
    int m = paramLongArray.size();
    int i = 0;
    int j = 0;
    while (j < m)
    {
      int k = i;
      if (paramLongArray.get(j) < paramLong) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    if (i > 0)
    {
      j = 0;
      while (j < m - i)
      {
        paramLongArray.set(j, paramLongArray.get(j + i));
        j += 1;
      }
      paramLongArray.dropTail(i);
    }
  }
  
  private boolean didEndFrameIdle(long paramLong1, long paramLong2)
  {
    long l = getLastEventBetweenTimestamps(this.mTransitionToIdleEvents, paramLong1, paramLong2);
    paramLong1 = getLastEventBetweenTimestamps(this.mTransitionToBusyEvents, paramLong1, paramLong2);
    if ((l == -1L) && (paramLong1 == -1L)) {
      return this.mWasIdleAtEndOfLastFrame;
    }
    return l > paramLong1;
  }
  
  private static long getLastEventBetweenTimestamps(LongArray paramLongArray, long paramLong1, long paramLong2)
  {
    long l1 = -1L;
    int i = 0;
    if (i < paramLongArray.size())
    {
      long l3 = paramLongArray.get(i);
      long l2;
      if ((l3 >= paramLong1) && (l3 < paramLong2)) {
        l2 = l3;
      }
      do
      {
        i += 1;
        l1 = l2;
        break;
        l2 = l1;
      } while (l3 < paramLong2);
    }
    return l1;
  }
  
  private static boolean hasEventBetweenTimestamps(LongArray paramLongArray, long paramLong1, long paramLong2)
  {
    int i = 0;
    while (i < paramLongArray.size())
    {
      long l = paramLongArray.get(i);
      if ((l >= paramLong1) && (l < paramLong2)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  /* Error */
  public boolean getDidJSHitFrameAndCleanup(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:mViewHierarchyUpdateFinishedEvents	Lcom/facebook/react/common/LongArray;
    //   6: lload_1
    //   7: lload_3
    //   8: invokestatic 67	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:hasEventBetweenTimestamps	(Lcom/facebook/react/common/LongArray;JJ)Z
    //   11: istore 6
    //   13: aload_0
    //   14: lload_1
    //   15: lload_3
    //   16: invokespecial 69	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:didEndFrameIdle	(JJ)Z
    //   19: istore 7
    //   21: iload 6
    //   23: ifeq +49 -> 72
    //   26: iconst_1
    //   27: istore 6
    //   29: aload_0
    //   30: getfield 27	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:mTransitionToIdleEvents	Lcom/facebook/react/common/LongArray;
    //   33: lload_3
    //   34: invokestatic 71	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:cleanUp	(Lcom/facebook/react/common/LongArray;J)V
    //   37: aload_0
    //   38: getfield 29	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:mTransitionToBusyEvents	Lcom/facebook/react/common/LongArray;
    //   41: lload_3
    //   42: invokestatic 71	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:cleanUp	(Lcom/facebook/react/common/LongArray;J)V
    //   45: aload_0
    //   46: getfield 31	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:mViewHierarchyUpdateEnqueuedEvents	Lcom/facebook/react/common/LongArray;
    //   49: lload_3
    //   50: invokestatic 71	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:cleanUp	(Lcom/facebook/react/common/LongArray;J)V
    //   53: aload_0
    //   54: getfield 33	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:mViewHierarchyUpdateFinishedEvents	Lcom/facebook/react/common/LongArray;
    //   57: lload_3
    //   58: invokestatic 71	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:cleanUp	(Lcom/facebook/react/common/LongArray;J)V
    //   61: aload_0
    //   62: iload 7
    //   64: putfield 35	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:mWasIdleAtEndOfLastFrame	Z
    //   67: aload_0
    //   68: monitorexit
    //   69: iload 6
    //   71: ireturn
    //   72: iload 7
    //   74: ifeq +25 -> 99
    //   77: aload_0
    //   78: getfield 31	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:mViewHierarchyUpdateEnqueuedEvents	Lcom/facebook/react/common/LongArray;
    //   81: lload_1
    //   82: lload_3
    //   83: invokestatic 67	com/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector:hasEventBetweenTimestamps	(Lcom/facebook/react/common/LongArray;JJ)Z
    //   86: istore 6
    //   88: iload 6
    //   90: ifne +9 -> 99
    //   93: iconst_1
    //   94: istore 6
    //   96: goto -67 -> 29
    //   99: iconst_0
    //   100: istore 6
    //   102: goto -6 -> 96
    //   105: astore 5
    //   107: aload_0
    //   108: monitorexit
    //   109: aload 5
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	DidJSUpdateUiDuringFrameDetector
    //   0	112	1	paramLong1	long
    //   0	112	3	paramLong2	long
    //   105	5	5	localObject	Object
    //   11	90	6	bool1	boolean
    //   19	54	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	105	finally
    //   29	67	105	finally
    //   77	88	105	finally
  }
  
  public void onTransitionToBridgeBusy()
  {
    try
    {
      this.mTransitionToBusyEvents.add(System.nanoTime());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onTransitionToBridgeIdle()
  {
    try
    {
      this.mTransitionToIdleEvents.add(System.nanoTime());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onViewHierarchyUpdateEnqueued()
  {
    try
    {
      this.mViewHierarchyUpdateEnqueuedEvents.add(System.nanoTime());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onViewHierarchyUpdateFinished()
  {
    try
    {
      this.mViewHierarchyUpdateFinishedEvents.add(System.nanoTime());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\debug\DidJSUpdateUiDuringFrameDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */