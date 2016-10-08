package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.network.handler.GetHotTopicListHandler;
import com.tencent.biz.qqstory.network.handler.GetHotTopicListHandler.HotTopicListEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;
import ism;
import isn;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class GetHotTopicListStep
  extends QQUIEventReceiver
  implements Step
{
  public static final String a = "Q.qqstory.home.Repository,GetHotTopicListStep";
  protected Repository a;
  protected Step.ErrorCallBack a;
  public Step.FinishCallBack a;
  protected Step a;
  
  public GetHotTopicListStep(Repository paramRepository)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
  }
  
  private void a(GetHotTopicListHandler.HotTopicListEvent paramHotTopicListEvent)
  {
    SLog.b("Q.qqstory.home.Repository,GetHotTopicListStep", "receive hot topic story list data");
    if (paramHotTopicListEvent == null)
    {
      SLog.e("Q.qqstory.home.Repository,GetHotTopicListStep", "receive hot topic event is null");
      paramHotTopicListEvent = new ErrorMessage(100801, "event is null!");
      paramHotTopicListEvent.extraMsg = a();
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramHotTopicListEvent);
      }
    }
    do
    {
      return;
      if (!paramHotTopicListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
        break;
      }
      SLog.e("Q.qqstory.home.Repository,GetHotTopicListStep", "GetHotTopicListHandler failed:" + paramHotTopicListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      ThreadManager.c().post(new isn(this));
      paramHotTopicListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg = a();
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack == null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramHotTopicListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    if ((paramHotTopicListEvent.jdField_a_of_type_JavaUtilArrayList == null) || (paramHotTopicListEvent.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      SLog.d("Q.qqstory.home.Repository,GetHotTopicListStep", "GetHotTopicListHandler data is empty");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.d().clear();
      return;
    }
    Iterator localIterator = paramHotTopicListEvent.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      HotTopicItem localHotTopicItem = (HotTopicItem)localIterator.next();
      StoryReportor.a("ugc_video", "exp_topic", 0, 0, new String[] { String.valueOf(localHotTopicItem.topicId), QQStoryContext.a().a(), localHotTopicItem.topicName });
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.d().clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.d().addAll(paramHotTopicListEvent.jdField_a_of_type_JavaUtilArrayList);
    SLog.d("Q.qqstory.home.Repository,GetHotTopicListStep", "receive hot topic count=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.d().size()) });
  }
  
  public Step a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep;
  }
  
  public Object a()
  {
    return null;
  }
  
  public String a()
  {
    return "GetHotTopicListStep";
  }
  
  public void a()
  {
    SLog.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository,GetHotTopicListStep", "Q.qqstory.home.Repository,GetHotTopicListStep");
  }
  
  public void a(Repository paramRepository, GetHotTopicListHandler.HotTopicListEvent paramHotTopicListEvent)
  {
    paramRepository.a(new ism(this, paramHotTopicListEvent));
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack = paramFinishCallBack;
  }
  
  public void a(Step paramStep)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep = paramStep;
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return false;
  }
  
  public Class acceptEventClass()
  {
    return GetHotTopicListHandler.HotTopicListEvent.class;
  }
  
  public void b()
  {
    Dispatchers.get().registerSubscriber(this);
    new GetHotTopicListHandler().a();
  }
  
  public void c()
  {
    Dispatchers.get().unRegisterSubscriber(this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetHotTopicListStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */