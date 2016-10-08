package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.pgc.PGCUrlChecker;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetPreloadVideoHandler;
import com.tencent.biz.qqstory.network.handler.GetPreloadVideoHandler.GetPreloadVideoEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;
import isq;
import isr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GetPreloadVideoStep
  extends QQUIEventReceiver
  implements Step
{
  public static final String a = "Q.qqstory.home.Repository.GetPreloadVideoStep";
  protected GetPreloadVideoHandler a;
  protected Repository a;
  protected Step.ErrorCallBack a;
  public Step.FinishCallBack a;
  protected Step a;
  protected List a;
  public String b;
  public List b;
  
  public GetPreloadVideoStep(Repository paramRepository, String paramString, List paramList1, List paramList2)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetPreloadVideoHandler = new GetPreloadVideoHandler();
    this.jdField_b_of_type_JavaLangString = paramString;
    if (paramList1 != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
      return;
    }
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList2);
  }
  
  private void a(GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent)
  {
    if (paramGetPreloadVideoEvent == null)
    {
      SLog.e("Q.qqstory.home.Repository.GetPreloadVideoStep", "handleGetPreloadVideoEvent,event = null!");
      return;
    }
    if (paramGetPreloadVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.e("Q.qqstory.home.Repository.GetPreloadVideoStep", "handleGetPreloadVideoEvent,error:" + paramGetPreloadVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage());
      return;
    }
    if (this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.d))
    {
      c(paramGetPreloadVideoEvent);
      return;
    }
    if (this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.e))
    {
      d(paramGetPreloadVideoEvent);
      return;
    }
    b(paramGetPreloadVideoEvent);
  }
  
  private void b(GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramGetPreloadVideoEvent.jdField_a_of_type_JavaUtilMap != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        List localList = (List)paramGetPreloadVideoEvent.jdField_a_of_type_JavaUtilMap.get(localLong);
        if ((localList != null) && (localList.size() > 0)) {
          ((StoryManager)SuperManager.a(5)).a().a(this.jdField_b_of_type_JavaLangString, String.valueOf(localLong), localList, false);
        }
      }
    }
  }
  
  private void c(GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramGetPreloadVideoEvent.jdField_a_of_type_JavaUtilMap != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        List localList = (List)paramGetPreloadVideoEvent.jdField_a_of_type_JavaUtilMap.get(localLong);
        if ((localList != null) && (localList.size() > 0)) {
          ((StoryManager)SuperManager.a(5)).a().a(this.jdField_b_of_type_JavaLangString, String.valueOf(localLong), localList, false);
        }
      }
    }
  }
  
  private void d(GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (paramGetPreloadVideoEvent.b != null)) {
      PGCUrlChecker.a(paramGetPreloadVideoEvent.b, new isr(this, paramGetPreloadVideoEvent));
    }
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
    return "GetPreloadVideoStep";
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        localStringBuilder.append("," + l);
      }
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("," + str);
      }
    }
    SLog.b("Q.qqstory.home.Repository.GetPreloadVideoStep", "category=" + this.jdField_b_of_type_JavaLangString + "," + localStringBuilder.toString());
  }
  
  public void a(Repository paramRepository, GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent)
  {
    SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.GetPreloadVideoStepcategory=" + this.jdField_b_of_type_JavaLangString + ", event = " + paramGetPreloadVideoEvent);
    paramRepository.a(new isq(this, paramGetPreloadVideoEvent));
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
    return GetPreloadVideoHandler.GetPreloadVideoEvent.class;
  }
  
  public void b()
  {
    a();
    if (((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) || ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)))
    {
      SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.GetPreloadVideoStepcategory=" + this.jdField_b_of_type_JavaLangString + ", register!");
      if (this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.a))
      {
        Dispatchers.get().registerSubscriber(this);
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetPreloadVideoHandler.a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        return;
      }
      if (this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.jdField_b_of_type_JavaLangString))
      {
        Dispatchers.get().registerSubscriber(this);
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetPreloadVideoHandler.a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        return;
      }
      if (this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.e))
      {
        Dispatchers.get().registerSubscriber(this);
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetPreloadVideoHandler.a(3, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        return;
      }
      if (this.jdField_b_of_type_JavaLangString.equals(IPreloadVideoSource.d))
      {
        Dispatchers.get().registerSubscriber(this);
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetPreloadVideoHandler.a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
  }
  
  public void c()
  {
    Dispatchers.get().unRegisterSubscriber(this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetPreloadVideoStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */