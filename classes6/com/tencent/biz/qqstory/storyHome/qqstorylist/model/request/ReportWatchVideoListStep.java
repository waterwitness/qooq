package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.model.ReportWatchVideoManager;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager.WatchVideoBatchFinishEvent;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;
import isx;

public class ReportWatchVideoListStep
  extends QQUIEventReceiver
  implements Step
{
  public static final String a = "Q.qqstory.home.Repository,ReportWatchVideoListStep";
  protected Repository a;
  public Step.FinishCallBack a;
  protected Step a;
  
  public ReportWatchVideoListStep(Repository paramRepository)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
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
    return "ReportWatchVideoListStep";
  }
  
  public void a()
  {
    SLog.a("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository,ReportWatchVideoListStep", "Q.qqstory.home.Repository,ReportWatchVideoListStep");
  }
  
  public void a(Repository paramRepository, ReportWatchVideoManager.WatchVideoBatchFinishEvent paramWatchVideoBatchFinishEvent)
  {
    paramRepository.a(new isx(this));
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack) {}
  
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
    return ReportWatchVideoManager.WatchVideoBatchFinishEvent.class;
  }
  
  public void b()
  {
    Dispatchers.get().registerSubscriber(this);
    ((ReportWatchVideoManager)SuperManager.a(13)).c();
  }
  
  public void c()
  {
    ReportWatchVideoManager localReportWatchVideoManager = (ReportWatchVideoManager)SuperManager.a(13);
    Dispatchers.get().unRegisterSubscriber(this);
    localReportWatchVideoManager.d();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\ReportWatchVideoListStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */