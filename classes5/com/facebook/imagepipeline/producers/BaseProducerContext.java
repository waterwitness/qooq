package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class BaseProducerContext
  implements ProducerContext
{
  @GuardedBy("this")
  private final List<ProducerContextCallbacks> mCallbacks;
  private final Object mCallerContext;
  private final String mId;
  private final ImageRequest mImageRequest;
  @GuardedBy("this")
  private boolean mIsCancelled;
  @GuardedBy("this")
  private boolean mIsIntermediateResultExpected;
  @GuardedBy("this")
  private boolean mIsPrefetch;
  private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
  @GuardedBy("this")
  private Priority mPriority;
  private final ProducerListener mProducerListener;
  
  public BaseProducerContext(ImageRequest paramImageRequest, String paramString, ProducerListener paramProducerListener, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, boolean paramBoolean1, boolean paramBoolean2, Priority paramPriority)
  {
    this.mImageRequest = paramImageRequest;
    this.mId = paramString;
    this.mProducerListener = paramProducerListener;
    this.mCallerContext = paramObject;
    this.mLowestPermittedRequestLevel = paramRequestLevel;
    this.mIsPrefetch = paramBoolean1;
    this.mPriority = paramPriority;
    this.mIsIntermediateResultExpected = paramBoolean2;
    this.mIsCancelled = false;
    this.mCallbacks = new ArrayList();
  }
  
  public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ProducerContextCallbacks)paramList.next()).onCancellationRequested();
      }
    }
  }
  
  public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ProducerContextCallbacks)paramList.next()).onIsIntermediateResultExpectedChanged();
      }
    }
  }
  
  public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ProducerContextCallbacks)paramList.next()).onIsPrefetchChanged();
      }
    }
  }
  
  public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ProducerContextCallbacks)paramList.next()).onPriorityChanged();
      }
    }
  }
  
  public void addCallbacks(ProducerContextCallbacks paramProducerContextCallbacks)
  {
    int i = 0;
    try
    {
      this.mCallbacks.add(paramProducerContextCallbacks);
      if (this.mIsCancelled) {
        i = 1;
      }
      if (i != 0) {
        paramProducerContextCallbacks.onCancellationRequested();
      }
      return;
    }
    finally {}
  }
  
  public void cancel()
  {
    callOnCancellationRequested(cancelNoCallbacks());
  }
  
  /* Error */
  @Nullable
  public List<ProducerContextCallbacks> cancelNoCallbacks()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/facebook/imagepipeline/producers/BaseProducerContext:mIsCancelled	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 51	com/facebook/imagepipeline/producers/BaseProducerContext:mIsCancelled	Z
    //   22: new 53	java/util/ArrayList
    //   25: dup
    //   26: aload_0
    //   27: getfield 56	com/facebook/imagepipeline/producers/BaseProducerContext:mCallbacks	Ljava/util/List;
    //   30: invokespecial 112	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   33: astore_1
    //   34: goto -21 -> 13
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	BaseProducerContext
    //   12	22	1	localObject1	Object
    //   37	4	1	localObject2	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   17	34	37	finally
  }
  
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  public ImageRequest getImageRequest()
  {
    return this.mImageRequest;
  }
  
  public ProducerListener getListener()
  {
    return this.mProducerListener;
  }
  
  public ImageRequest.RequestLevel getLowestPermittedRequestLevel()
  {
    return this.mLowestPermittedRequestLevel;
  }
  
  public Priority getPriority()
  {
    try
    {
      Priority localPriority = this.mPriority;
      return localPriority;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isCancelled()
  {
    try
    {
      boolean bool = this.mIsCancelled;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isIntermediateResultExpected()
  {
    try
    {
      boolean bool = this.mIsIntermediateResultExpected;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isPrefetch()
  {
    try
    {
      boolean bool = this.mIsPrefetch;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  @Nullable
  public List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/facebook/imagepipeline/producers/BaseProducerContext:mIsIntermediateResultExpected	Z
    //   6: istore_3
    //   7: iload_1
    //   8: iload_3
    //   9: if_icmpne +9 -> 18
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: areturn
    //   18: aload_0
    //   19: iload_1
    //   20: putfield 49	com/facebook/imagepipeline/producers/BaseProducerContext:mIsIntermediateResultExpected	Z
    //   23: new 53	java/util/ArrayList
    //   26: dup
    //   27: aload_0
    //   28: getfield 56	com/facebook/imagepipeline/producers/BaseProducerContext:mCallbacks	Ljava/util/List;
    //   31: invokespecial 112	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   34: astore_2
    //   35: goto -21 -> 14
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	BaseProducerContext
    //   0	43	1	paramBoolean	boolean
    //   13	22	2	localObject1	Object
    //   38	4	2	localObject2	Object
    //   6	4	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   18	35	38	finally
  }
  
  /* Error */
  @Nullable
  public List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/facebook/imagepipeline/producers/BaseProducerContext:mIsPrefetch	Z
    //   6: istore_3
    //   7: iload_1
    //   8: iload_3
    //   9: if_icmpne +9 -> 18
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: areturn
    //   18: aload_0
    //   19: iload_1
    //   20: putfield 45	com/facebook/imagepipeline/producers/BaseProducerContext:mIsPrefetch	Z
    //   23: new 53	java/util/ArrayList
    //   26: dup
    //   27: aload_0
    //   28: getfield 56	com/facebook/imagepipeline/producers/BaseProducerContext:mCallbacks	Ljava/util/List;
    //   31: invokespecial 112	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   34: astore_2
    //   35: goto -21 -> 14
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	BaseProducerContext
    //   0	43	1	paramBoolean	boolean
    //   13	22	2	localObject1	Object
    //   38	4	2	localObject2	Object
    //   6	4	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   18	35	38	finally
  }
  
  /* Error */
  @Nullable
  public List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority paramPriority)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/facebook/imagepipeline/producers/BaseProducerContext:mPriority	Lcom/facebook/imagepipeline/common/Priority;
    //   6: astore_2
    //   7: aload_1
    //   8: aload_2
    //   9: if_acmpne +9 -> 18
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 47	com/facebook/imagepipeline/producers/BaseProducerContext:mPriority	Lcom/facebook/imagepipeline/common/Priority;
    //   23: new 53	java/util/ArrayList
    //   26: dup
    //   27: aload_0
    //   28: getfield 56	com/facebook/imagepipeline/producers/BaseProducerContext:mCallbacks	Ljava/util/List;
    //   31: invokespecial 112	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   34: astore_1
    //   35: goto -21 -> 14
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	BaseProducerContext
    //   0	43	1	paramPriority	Priority
    //   6	3	2	localPriority	Priority
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   18	35	38	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\producers\BaseProducerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */