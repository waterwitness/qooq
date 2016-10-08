package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SplitUinListStep
  implements Step
{
  private static final int a = 50;
  public static final String a = "Q.qqstory.home.Repository.SplitUinListStep";
  protected long a;
  protected Repository a;
  protected Step.ErrorCallBack a;
  protected Step.FinishCallBack a;
  protected Step a;
  protected List a;
  protected boolean a;
  
  public SplitUinListStep(Repository paramRepository)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
  }
  
  public Step a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public String a()
  {
    return "SplitUinListStep";
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
  
  public void a(Step paramStep)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep = paramStep;
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SLog.a("Q.qqstory.home.Repository.SplitUinListStep", "Start run %s step", getClass().getSimpleName());
    this.jdField_a_of_type_JavaUtilList = new ArrayList(50);
    int i = 0;
    while ((i < 50) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.e().size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.e().get(0));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c.put(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.e().get(0), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.e().get(0));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.e().remove(0);
      i += 1;
    }
    SLog.d("Q.qqstory.home.Repository.SplitUinListStep", "request more friends size = " + this.jdField_a_of_type_JavaUtilList.size());
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    SLog.a("Q.qqstory.home.Repository.SplitUinListStep", "finish %s step and cost time=%d", getClass().getSimpleName(), Long.valueOf(l1 - l2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\SplitUinListStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */