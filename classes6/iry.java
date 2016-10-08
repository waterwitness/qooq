import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetStoryDesHandlerStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SplitUinListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iry
  implements Runnable
{
  public iry(Repository paramRepository, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    GetStoryDesHandlerStep localGetStoryDesHandlerStep = new GetStoryDesHandlerStep(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository, true);
    localGetStoryDesHandlerStep.a(false);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c != null)
    {
      SLog.d("Q.qqstory.home.Repository", "mLoadMoreSteps need reset!");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c.b();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c = new StepExector(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository).a(new SplitUinListStep(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository)).a(localGetStoryDesHandlerStep).a(new isa(this)).a(new irz(this));
    SLog.d("Q.qqstory.home.Repository", "get more date start");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c.a();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */