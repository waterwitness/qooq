package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.handler.GetStoryDesHandler;
import com.tencent.biz.qqstory.network.handler.GetStoryDesHandler.GetStoryDesListEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;
import ist;
import isu;
import isv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class GetStoryDesHandlerStep
  extends QQUIEventReceiver
  implements Step
{
  public static final int a = 0;
  public static final String a = "Q.qqstory.home.Repository.GetStoryDesHandlerStep";
  public static final int b = 1;
  public static final int c = 2;
  public static final int e = 30;
  public long a;
  protected GetStoryDesHandler a;
  protected Repository a;
  protected Step.ErrorCallBack a;
  public Step.FinishCallBack a;
  protected Step a;
  protected List a;
  protected boolean a;
  protected boolean b;
  public int d;
  
  public GetStoryDesHandlerStep(Repository paramRepository, boolean paramBoolean)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetStoryDesHandler = new GetStoryDesHandler();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = paramBoolean;
  }
  
  private boolean a(List paramList)
  {
    if (paramList == null) {
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {}
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == paramList.size())
    {
      return true;
      return false;
    }
    return false;
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
    return "GetStoryDesHandlerStep";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("uinlist=");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        localStringBuilder.append("," + l);
      }
      SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.GetStoryDesHandlerStep" + localStringBuilder.toString());
      return;
    }
    SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.GetStoryDesHandlerStep");
  }
  
  public void a(Repository paramRepository, GetStoryDesHandler.GetStoryDesListEvent paramGetStoryDesListEvent)
  {
    SLog.b("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "receive the event:");
    paramRepository.a(new isv(this, paramGetStoryDesListEvent));
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
  
  public void a(Object paramObject)
  {
    if (paramObject != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll((List)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      SLog.e("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "setParam error:" + paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(GetStoryDesHandler.GetStoryDesListEvent paramGetStoryDesListEvent)
  {
    SLog.b("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "receive friend story list data");
    if (paramGetStoryDesListEvent == null) {
      SLog.e("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "receive friend story event is null!");
    }
    do
    {
      do
      {
        return true;
        if (!paramGetStoryDesListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
          break;
        }
        SLog.e("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "handleFriendStoryListEvent failed:" + paramGetStoryDesListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
        ThreadManager.c().post(new ist(this));
        paramGetStoryDesListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg = a();
      } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack == null);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramGetStoryDesListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
      return true;
      if (paramGetStoryDesListEvent.jdField_a_of_type_JavaUtilList != null) {
        break;
      }
      SLog.e("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "handleFriendStoryListEvent null");
      ThreadManager.c().post(new isu(this));
      paramGetStoryDesListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg = a();
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack == null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramGetStoryDesListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return true;
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    Object localObject1 = (UserManager)SuperManager.a(2);
    Object localObject2 = paramGetStoryDesListEvent.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      StoryItem localStoryItem = (StoryItem)((Iterator)localObject2).next();
      localStoryItem.user = ((UserManager)localObject1).c(localStoryItem.user.uid);
      if (localStoryItem.liveVideo != null) {
        localStoryManager.a(localStoryItem.user.uid, localStoryItem.liveVideo);
      } else {
        localStoryManager.a(localStoryItem.user.uid);
      }
    }
    SLog.d("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "receive friends count=" + paramGetStoryDesListEvent.jdField_a_of_type_JavaUtilList.size());
    localObject1 = new ArrayList();
    paramGetStoryDesListEvent = paramGetStoryDesListEvent.jdField_a_of_type_JavaUtilList.iterator();
    while (paramGetStoryDesListEvent.hasNext())
    {
      localObject2 = (StoryItem)paramGetStoryDesListEvent.next();
      ((List)localObject1).add(String.valueOf(((StoryItem)localObject2).user.uid));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c.remove(Long.valueOf(((StoryItem)localObject2).user.uid));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.b((StoryItem)localObject2);
    }
    ((StoryManager)SuperManager.a(5)).a().a(IPreloadVideoSource.b, (List)localObject1);
    localStoryManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c(), 0, true);
    return true;
  }
  
  public Class acceptEventClass()
  {
    return GetStoryDesHandler.GetStoryDesListEvent.class;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SLog.a("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "Start run %s step", getClass().getSimpleName());
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      SLog.b("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "there is no friends story!");
      this.d = 2;
      a(null);
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      SLog.a("Q.qqstory.home.Repository.GetStoryDesHandlerStep", "finish %s step and cost time=%d", getClass().getSimpleName(), Long.valueOf(l1 - l2));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
      return;
    }
    this.d = 1;
    Dispatchers.get().registerSubscriber(this);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetStoryDesHandler.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c()
  {
    if (this.d == 1) {
      Dispatchers.get().unRegisterSubscriber(this);
    }
    this.d = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetStoryDesHandlerStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */