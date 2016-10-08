package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobSegment;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import iij;
import iil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BasePublishTask
  implements Runnable
{
  public static final String a = "Q.qqstory.publish:BasePublishTask";
  public static final int b = 10000;
  public static final int c = 20;
  public static final int d = 90;
  public static final int e = 1000;
  public static final int f = 1;
  public int a;
  public BaseTaskInfo a;
  public OnPublishTaskListener a;
  public Stream a;
  public AtomicBoolean a;
  public boolean a;
  public int g;
  public int h;
  public int i;
  
  public BasePublishTask(BaseTaskInfo paramBaseTaskInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = 7;
    this.h = 100;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo = paramBaseTaskInfo;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener.a(this, paramInt1, paramInt2);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      SLog.c("Q.qqstory.publish:BasePublishTask", "stop task in send rich data:" + this);
      a(this.jdField_a_of_type_Int, new ErrorMessage());
      return;
    }
    Object localObject1 = a();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_JavaUtilList.size() == 0) && (localObject1 == null))
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(new ErrorMessage());
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (JobSegment)((Iterator)localObject1).next();
        this.jdField_a_of_type_ComTribeAsyncReactiveStream = this.jdField_a_of_type_ComTribeAsyncReactiveStream.map((StreamFunction)localObject2);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UploadObject)((Iterator)localObject1).next();
      this.jdField_a_of_type_ComTribeAsyncReactiveStream = this.jdField_a_of_type_ComTribeAsyncReactiveStream.map((StreamFunction)localObject2);
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new iil(this, null));
  }
  
  private void f()
  {
    a(2, new ErrorMessage());
    a(4, new ErrorMessage());
    c();
  }
  
  private void g()
  {
    int k = 1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_Int == 7)) {}
    for (int j = 1; j != 0; j = 0)
    {
      SLog.d("Q.qqstory.publish:BasePublishTask", "stop fake progress for task fail");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      j = this.i;
      SLog.c("Q.qqstory.publish:BasePublishTask", "task success");
    }
    for (;;)
    {
      int m = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_Int;
      Bosses.get().postLightWeightJob(new iij(this, m, j), k);
      return;
      m = 500;
      j = 4;
      k = m;
      if (this.g + 4 > 90)
      {
        j = 90 - this.g;
        k = m;
      }
    }
  }
  
  public BaseTaskInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo;
  }
  
  protected List a()
  {
    return null;
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.publish:BasePublishTask", "user try to stop task" + this);
    this.jdField_a_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
  }
  
  public void a(int paramInt, ErrorMessage paramErrorMessage)
  {
    SLog.c("Q.qqstory.publish:BasePublishTask", "mTaskInfo:" + this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo);
    if (paramErrorMessage.isFail()) {
      SLog.d("Q.qqstory.publish:BasePublishTask", "mTaskInfo:%s with fail result: %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo, paramErrorMessage });
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener.a(this, paramErrorMessage);
    }
  }
  
  public void a(OnPublishTaskListener paramOnPublishTaskListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener = paramOnPublishTaskListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public List b()
  {
    return null;
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.publish:BasePublishTask", "user try to force stop task" + this);
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
  }
  
  protected abstract void c();
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    this.i = ((this.h - this.g) / 1);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_Int != 1) {
      a(1, new ErrorMessage());
    }
    e();
    g();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BasePublishTask{");
    localStringBuilder.append("mTaskInfo=").append(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\task\BasePublishTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */