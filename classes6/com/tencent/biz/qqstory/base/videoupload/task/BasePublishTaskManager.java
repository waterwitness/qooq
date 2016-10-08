package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BasePublishTaskManager
  extends BaseManger
  implements OnPublishTaskListener
{
  public static final String b = "Q.qqstory.publish:BasePublishTaskManager";
  public BasePublishTask a;
  public ArrayList a;
  public ArrayList b;
  
  public BasePublishTaskManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
  }
  
  private void a(ErrorMessage paramErrorMessage)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseTaskInfo localBaseTaskInfo = (BaseTaskInfo)localIterator.next();
        localBaseTaskInfo.jdField_a_of_type_Int = 6;
        localBaseTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
        localBaseTaskInfo.b += 1;
        this.b.add(localBaseTaskInfo);
        a(localBaseTaskInfo);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    finally {}
  }
  
  protected abstract BasePublishTask a(BaseTaskInfo paramBaseTaskInfo);
  
  /* Error */
  protected BaseTaskInfo a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTaskManager:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 70	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTaskManager:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   13: getfield 75	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	BasePublishTaskManager
    //   16	7	1	localBaseTaskInfo	BaseTaskInfo
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b());
    localArrayList.addAll(c());
    BaseTaskInfo localBaseTaskInfo = a();
    if (localBaseTaskInfo != null) {
      localArrayList.add(localBaseTaskInfo);
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(BasePublishTask paramBasePublishTask, int paramInt1, int paramInt2) {}
  
  public final void a(BasePublishTask paramBasePublishTask, ErrorMessage paramErrorMessage)
  {
    if (paramBasePublishTask == null)
    {
      SLog.e("Q.qqstory.publish:BasePublishTaskManager", "running publish task is null, when finish publish");
      return;
    }
    BaseTaskInfo localBaseTaskInfo = paramBasePublishTask.a();
    paramBasePublishTask.a().jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((localBaseTaskInfo.jdField_a_of_type_Int == 6) || (localBaseTaskInfo.jdField_a_of_type_Int == 5) || (localBaseTaskInfo.jdField_a_of_type_Int == 3) || (localBaseTaskInfo.jdField_a_of_type_Int == 7))
    {
      SLog.c("Q.qqstory.publish:BasePublishTaskManager", "finish task:" + paramBasePublishTask);
      if (localBaseTaskInfo.jdField_a_of_type_Int != 5) {
        SLog.d("Q.qqstory.publish:BasePublishTaskManager", "task fail:" + paramBasePublishTask);
      }
      if (paramErrorMessage.errorCode != 10406) {
        break label146;
      }
      d();
      a(paramErrorMessage);
    }
    for (;;)
    {
      b(localBaseTaskInfo, paramErrorMessage);
      a(localBaseTaskInfo);
      return;
      label146:
      d();
      e();
    }
  }
  
  protected abstract void a(BaseTaskInfo paramBaseTaskInfo);
  
  protected abstract void a(BaseTaskInfo paramBaseTaskInfo, ErrorMessage paramErrorMessage);
  
  public void a(List paramList)
  {
    try
    {
      this.b.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  protected ArrayList b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.b);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b()
  {
    super.b();
    c();
  }
  
  /* Error */
  protected void b(BaseTaskInfo paramBaseTaskInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTaskManager:b	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 146	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield 28	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTaskManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   15: aload_1
    //   16: invokevirtual 149	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   19: ifeq +13 -> 32
    //   22: ldc 10
    //   24: ldc -105
    //   26: invokestatic 121	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 28	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTaskManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: aload_1
    //   37: invokevirtual 60	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   40: pop
    //   41: goto -12 -> 29
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	BasePublishTaskManager
    //   0	49	1	paramBaseTaskInfo	BaseTaskInfo
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   32	41	44	finally
  }
  
  protected void b(BaseTaskInfo paramBaseTaskInfo, ErrorMessage paramErrorMessage)
  {
    if (a())
    {
      SLog.c("Q.qqstory.publish:BasePublishTaskManager", "manager had stopped");
      return;
    }
    try
    {
      paramBaseTaskInfo.b += 1;
      this.b.add(paramBaseTaskInfo);
      a(paramBaseTaskInfo, paramErrorMessage);
      return;
    }
    finally {}
  }
  
  protected ArrayList c()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void c(BaseTaskInfo paramBaseTaskInfo)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramBaseTaskInfo);
      this.b.remove(paramBaseTaskInfo);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a() == paramBaseTaskInfo)) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a();
      }
      return;
    }
    finally
    {
      paramBaseTaskInfo = finally;
      throw paramBaseTaskInfo;
    }
  }
  
  protected void d()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void e()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null)
        {
          SLog.c("Q.qqstory.publish:BasePublishTaskManager", "task waiting list size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
          return;
        }
        if (a())
        {
          SLog.c("Q.qqstory.publish:BasePublishTaskManager", "manager had stopped");
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label137;
        }
      }
      finally {}
      BaseTaskInfo localBaseTaskInfo = (BaseTaskInfo)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask = a(localBaseTaskInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a(this);
      SLog.c("Q.qqstory.publish:BasePublishTaskManager", "start publish task:" + localBaseTaskInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.run();
      continue;
      label137:
      SLog.c("Q.qqstory.publish:BasePublishTaskManager", "--- no feeds need to post");
    }
  }
  
  protected void f()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\task\BasePublishTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */