package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class AsyncStepExector
  implements Step.ErrorCallBack, Step.FinishCallBack
{
  public static final String a = "Q.qqstory.home.Repository.AsyncStepExector";
  public static final int b = 100;
  protected int a;
  protected Handler a;
  protected ErrorMessage a;
  protected StepExector.CompletedHandler a;
  public StepExector.ErrorHandler a;
  protected LinkedHashMap a;
  protected Vector a;
  protected boolean a;
  
  public AsyncStepExector()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = 0;
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 12
    //   4: ldc 60
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 36	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   16: invokevirtual 64	java/util/LinkedHashMap:size	()I
    //   19: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic 76	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 56	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_Int	I
    //   30: iconst_2
    //   31: if_icmpne +13 -> 44
    //   34: ldc 12
    //   36: ldc 78
    //   38: invokestatic 82	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: getfield 36	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   48: invokevirtual 86	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   51: invokeinterface 92 1 0
    //   56: astore_1
    //   57: aload_1
    //   58: invokeinterface 98 1 0
    //   63: ifeq -22 -> 41
    //   66: aload_1
    //   67: invokeinterface 102 1 0
    //   72: checkcast 104	java/util/Map$Entry
    //   75: invokeinterface 107 1 0
    //   80: checkcast 109	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/Step
    //   83: astore_2
    //   84: aload_2
    //   85: aload_0
    //   86: invokeinterface 112 2 0
    //   91: aload_2
    //   92: aload_0
    //   93: invokeinterface 115 2 0
    //   98: aload_2
    //   99: invokeinterface 117 1 0
    //   104: goto -47 -> 57
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	AsyncStepExector
    //   56	11	1	localIterator	Iterator
    //   107	4	1	localObject	Object
    //   83	16	2	localStep	Step
    // Exception table:
    //   from	to	target	type
    //   2	41	107	finally
    //   44	57	107	finally
    //   57	104	107	finally
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AsyncStepExector a(Step paramStep)
  {
    SLog.b("Q.qqstory.home.Repository.AsyncStepExector", "add Step:" + paramStep.getClass().getSimpleName());
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramStep.a(), paramStep);
    this.jdField_a_of_type_Int = 0;
    return this;
  }
  
  public AsyncStepExector a(StepExector.CompletedHandler paramCompletedHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$CompletedHandler = paramCompletedHandler;
    return this;
  }
  
  public AsyncStepExector a(StepExector.ErrorHandler paramErrorHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$ErrorHandler = paramErrorHandler;
    return this;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 56	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_Int	I
    //   7: aload_0
    //   8: getfield 54	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   11: new 156	isi
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 159	isi:<init>	(Lcom/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector;)V
    //   19: invokestatic 165	android/os/Message:obtain	(Landroid/os/Handler;Ljava/lang/Runnable;)Landroid/os/Message;
    //   22: astore_1
    //   23: aload_1
    //   24: bipush 100
    //   26: putfield 168	android/os/Message:what	I
    //   29: aload_0
    //   30: getfield 54	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   33: aload_1
    //   34: ldc2_w 169
    //   37: invokevirtual 174	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   40: pop
    //   41: aload_0
    //   42: getfield 41	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   45: invokevirtual 175	java/util/Vector:size	()I
    //   48: ifle +62 -> 110
    //   51: aload_0
    //   52: getfield 41	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   55: iconst_0
    //   56: invokevirtual 179	java/util/Vector:get	(I)Ljava/lang/Object;
    //   59: checkcast 109	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/Step
    //   62: astore_1
    //   63: ldc 12
    //   65: ldc -75
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_0
    //   74: getfield 41	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   77: invokevirtual 175	java/util/Vector:size	()I
    //   80: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aastore
    //   84: invokestatic 76	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_1
    //   88: aload_0
    //   89: invokeinterface 115 2 0
    //   94: aload_1
    //   95: aload_0
    //   96: invokeinterface 112 2 0
    //   101: aload_1
    //   102: invokeinterface 117 1 0
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: aload_0
    //   111: invokespecial 183	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/AsyncStepExector:c	()V
    //   114: goto -7 -> 107
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	AsyncStepExector
    //   22	80	1	localObject1	Object
    //   117	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	107	117	finally
    //   110	114	117	finally
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("Q.qqstory.home.Repository.AsyncStepExector", "occur error:%s", new Object[] { paramErrorMessage.getErrorMessage() });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    a(paramErrorMessage.extraMsg);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        SLog.e("Q.qqstory.home.Repository.AsyncStepExector", "occur error ! step key is null!!");
        return;
      }
      finally {}
      SLog.a("Q.qqstory.home.Repository.AsyncStepExector", "this %s have been finish", paramString);
      if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
      {
        SLog.d("Q.qqstory.home.Repository.AsyncStepExector", "remove premiss Step %s", new Object[] { paramString });
        this.jdField_a_of_type_JavaUtilVector.remove(0);
        if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
        {
          paramString = (Step)this.jdField_a_of_type_JavaUtilVector.get(0);
          SLog.d("Q.qqstory.home.Repository.AsyncStepExector", "it have premiss Step count=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size()) });
          paramString.a(this);
          paramString.a(this);
          paramString.b();
        }
        else
        {
          c();
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0)
        {
          SLog.b("Q.qqstory.home.Repository.AsyncStepExector", "all step have finish");
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$CompletedHandler != null)
          {
            this.jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
            if (this.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$ErrorHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
            } else {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$CompletedHandler.a();
            }
          }
        }
      }
    }
  }
  
  public AsyncStepExector b(Step paramStep)
  {
    this.jdField_a_of_type_JavaUtilVector.add(paramStep);
    return this;
  }
  
  public void b()
  {
    for (;;)
    {
      Step localStep;
      try
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        SLog.b("Q.qqstory.home.Repository.AsyncStepExector", "reset!");
        Object localObject1;
        if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
        {
          SLog.b("Q.qqstory.home.Repository.AsyncStepExector", "reset premissSteps");
          localObject1 = (Step)this.jdField_a_of_type_JavaUtilVector.get(0);
          if ((localObject1 instanceof PageLoaderStep))
          {
            ((PageLoaderStep)localObject1).c();
            this.jdField_a_of_type_JavaUtilVector.clear();
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localStep = (Step)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if (localStep == null) {
            continue;
          }
          if (!(localStep instanceof PageLoaderStep)) {
            break label207;
          }
          ((PageLoaderStep)localStep).c();
          continue;
        }
        if (!(localObject2 instanceof GetStoryDesHandlerStep)) {
          break label156;
        }
      }
      finally {}
      ((GetStoryDesHandlerStep)localObject2).c();
      continue;
      label156:
      if ((localObject2 instanceof GetFriendsStoryStep))
      {
        ((GetFriendsStoryStep)localObject2).c();
      }
      else if ((localObject2 instanceof ReportWatchVideoListStep))
      {
        ((ReportWatchVideoListStep)localObject2).c();
      }
      else if ((localObject2 instanceof GetHotTopicListStep))
      {
        ((GetHotTopicListStep)localObject2).c();
        continue;
        label207:
        if ((localStep instanceof GetStoryDesHandlerStep)) {
          ((GetStoryDesHandlerStep)localStep).c();
        } else if ((localStep instanceof GetFriendsStoryStep)) {
          ((GetFriendsStoryStep)localStep).c();
        } else if ((localStep instanceof ReportWatchVideoListStep)) {
          ((ReportWatchVideoListStep)localStep).c();
        } else if ((localStep instanceof GetHotTopicListStep)) {
          ((GetHotTopicListStep)localStep).c();
        }
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\AsyncStepExector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */