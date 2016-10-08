package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTaskManager;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import iic;
import java.util.ArrayList;
import java.util.List;

public class StoryVideoUploadManager
  extends BasePublishTaskManager
{
  public static final String a = "Q.qqstory.publish:StoryVideoUploadManager";
  
  public StoryVideoUploadManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void g()
  {
    SLog.c("Q.qqstory.publish:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new iic(this));
  }
  
  protected BasePublishTask a(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    return new StoryVideoUploadTask(paramStoryVideoTaskInfo);
  }
  
  public void a()
  {
    super.a();
    g();
  }
  
  protected void a(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    if (a())
    {
      SLog.c("Q.qqstory.publish:StoryVideoUploadManager", "manager had stopped");
      return;
    }
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    Object localObject = paramStoryVideoTaskInfo.a();
    localStoryManager.a(paramStoryVideoTaskInfo.a(), (StoryVideoItem)localObject);
    SLog.b("Q.qqstory.publish:StoryVideoUploadManager", "task state write:" + localObject);
    StoryVideoUploadManager.StoryVideoPublishStatusEvent localStoryVideoPublishStatusEvent = new StoryVideoUploadManager.StoryVideoPublishStatusEvent();
    localStoryVideoPublishStatusEvent.a = ((StoryVideoItem)localObject);
    if (localStoryVideoPublishStatusEvent.a.isUploadSuc())
    {
      localStoryVideoPublishStatusEvent.b = paramStoryVideoTaskInfo.a();
      localStoryVideoPublishStatusEvent.b.mVid = paramStoryVideoTaskInfo.h;
      localStoryVideoPublishStatusEvent.b = localStoryManager.a(paramStoryVideoTaskInfo.h, localStoryVideoPublishStatusEvent.b);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(localStoryVideoPublishStatusEvent.b);
      localStoryManager.a(QQStoryContext.a().a(), 0, (List)localObject, false);
      if (paramStoryVideoTaskInfo.jdField_a_of_type_Boolean) {
        StoryReportor.a("mystory", "suc_retrypub", 0, 0, new String[0]);
      }
      StoryReportor.b("publish_story", "publish_all", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - paramStoryVideoTaskInfo.jdField_a_of_type_Long), StoryReportor.a(BaseApplication.getContext()), paramStoryVideoTaskInfo.h });
    }
    if (localStoryVideoPublishStatusEvent.a.isUploadFail())
    {
      Dispatchers.get().dispatchDelayed(localStoryVideoPublishStatusEvent, 500);
      StoryReportor.a("mystory", "publish_fail", 0, 0, new String[0]);
      long l1 = System.currentTimeMillis();
      long l2 = paramStoryVideoTaskInfo.jdField_a_of_type_Long;
      StoryReportor.b("publish_story", "publish_all", 0, paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg, String.valueOf(l1 - l2) });
      return;
    }
    Dispatchers.get().dispatch(localStoryVideoPublishStatusEvent);
  }
  
  protected void a(StoryVideoTaskInfo paramStoryVideoTaskInfo, ErrorMessage paramErrorMessage)
  {
    Dispatchers.get().dispatch(new StoryVideoUploadManager.StoryVideoAllTaskChangeEvent());
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    paramStoryVideoItem = new StoryVideoTaskInfo(paramStoryVideoItem);
    paramStoryVideoItem.jdField_a_of_type_Boolean = true;
    b(paramStoryVideoItem);
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    StoryVideoUploadManager.StoryVideoPublishStatusEvent localStoryVideoPublishStatusEvent = new StoryVideoUploadManager.StoryVideoPublishStatusEvent();
    localStoryVideoPublishStatusEvent.a = localStoryManager.a(paramStoryVideoItem.a(), paramStoryVideoItem.a());
    Dispatchers.get().dispatch(localStoryVideoPublishStatusEvent);
    e();
    Dispatchers.get().dispatch(new StoryVideoUploadManager.StoryVideoAllTaskChangeEvent());
    SLog.d("Q.qqstory.publish:StoryVideoUploadManager", "retry upload video %s", new Object[] { paramStoryVideoItem });
  }
  
  public void a(String paramString)
  {
    ((StoryManager)SuperManager.a(5)).a(paramString);
    DeleteStoryVideoEvent localDeleteStoryVideoEvent = new DeleteStoryVideoEvent(new ErrorMessage(), paramString, true);
    Dispatchers.get().dispatch(localDeleteStoryVideoEvent);
    c(new StoryVideoTaskInfo(paramString));
    Dispatchers.get().dispatch(new StoryVideoUploadManager.StoryVideoAllTaskChangeEvent());
    SLog.a("Q.qqstory.publish:StoryVideoUploadManager", "delete video %s", paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong)
  {
    paramString1 = new StoryVideoTaskInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2, paramLong);
    b(paramString1);
    paramString2 = new StoryVideoUploadManager.StoryVideoPublishStatusEvent();
    paramString2.a = ((StoryManager)SuperManager.a(5)).a(paramString1.a(), paramString1.a());
    Dispatchers.get().dispatch(paramString2);
    e();
    Dispatchers.get().dispatch(new StoryVideoUploadManager.StoryVideoAllTaskChangeEvent());
    SLog.d("Q.qqstory.publish:StoryVideoUploadManager", "create video %s", new Object[] { paramString1 });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\StoryVideoUploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */