import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetFriendsStoryStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.ErrorCallBack;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.ErrorHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class isl
  implements StepExector.ErrorHandler
{
  public isl(GetFriendsStoryStep paramGetFriendsStoryStep)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("Q.qqstory.home.Repository.GetFriendsStoryStep", "error occur when get friends data from server steps=%s,error=%s", new Object[] { paramErrorMessage.extraMsg, paramErrorMessage.getErrorMessage() });
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramErrorMessage);
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(this.a.a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */