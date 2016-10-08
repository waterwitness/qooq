import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetFriendsStoryStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.CompletedHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class isk
  implements StepExector.CompletedHandler
{
  public isk(GetFriendsStoryStep paramGetFriendsStoryStep)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.home.Repository.GetFriendsStoryStep", "finish get all data from server steps");
    this.a.a.a(this.a.a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */