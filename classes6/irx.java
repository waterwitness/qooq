import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.CompletedHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class irx
  implements StepExector.CompletedHandler
{
  public irx(Repository paramRepository)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.Repository", "completed mPullAllStep");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */