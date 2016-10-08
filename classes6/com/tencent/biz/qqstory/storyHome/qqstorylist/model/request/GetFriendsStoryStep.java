package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import isk;
import isl;

public class GetFriendsStoryStep
  implements Step
{
  public static final String a = "Q.qqstory.home.Repository.GetFriendsStoryStep";
  protected Repository a;
  public Step.ErrorCallBack a;
  public Step.FinishCallBack a;
  protected StepExector a;
  
  public GetFriendsStoryStep(Repository paramRepository)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector = new StepExector(paramRepository);
  }
  
  public Step a()
  {
    return null;
  }
  
  public Object a()
  {
    return null;
  }
  
  public String a()
  {
    return "GetFriendsStoryStep";
  }
  
  public void a() {}
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack = paramFinishCallBack;
  }
  
  public void a(Step paramStep) {}
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetFriendUinListStep(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository)).a(new Uin2QQItemStep(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository)).a(new SplitUinListStep(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository)).a(new GetStoryDesHandlerStep(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository, true)).a(new isl(this)).a(new isk(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.b();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\GetFriendsStoryStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */