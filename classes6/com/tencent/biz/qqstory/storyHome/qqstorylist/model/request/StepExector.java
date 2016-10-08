package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import isy;
import java.util.ArrayList;
import java.util.Iterator;

public class StepExector
  implements Step.ErrorCallBack, Step.FinishCallBack
{
  public static final String a = "Q.qqstory.home.Repository.StepExector";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public int a;
  public Handler a;
  protected Repository a;
  public Step a;
  public StepExector.CompletedHandler a;
  protected StepExector.ErrorHandler a;
  public Object a;
  public ArrayList a;
  protected Handler b;
  
  public StepExector(Repository paramRepository)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
    this.b = paramRepository.jdField_a_of_type_AndroidOsHandler;
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((Step)localIterator.next()).a();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int == 2) {
      return;
    }
    this.b.post(new isy(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public StepExector a(Step paramStep)
  {
    SLog.b("Q.qqstory.home.Repository.StepExector", "add Step:" + paramStep.getClass().getSimpleName());
    this.jdField_a_of_type_JavaUtilArrayList.add(paramStep);
    return this;
  }
  
  public StepExector a(StepExector.CompletedHandler paramCompletedHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$CompletedHandler = paramCompletedHandler;
    return this;
  }
  
  public StepExector a(StepExector.ErrorHandler paramErrorHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$ErrorHandler = paramErrorHandler;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    d();
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a();
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$ErrorHandler != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$ErrorHandler.a(paramErrorMessage);
    }
    b();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a();
    d();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 2;
    SLog.b("Q.qqstory.home.Repository.StepExector", "reset");
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep != null)
    {
      if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep instanceof PageLoaderStep)) {
        break label57;
      }
      ((PageLoaderStep)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep).c();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$ErrorHandler = null;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$CompletedHandler = null;
      return;
      label57:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep instanceof GetStoryDesHandlerStep)) {
        ((GetStoryDesHandlerStep)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep).c();
      } else if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep instanceof GetPreloadVideoStep)) {
        ((GetPreloadVideoStep)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep).c();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\StepExector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */