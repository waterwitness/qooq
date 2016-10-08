import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetStoryDesHandlerStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SplitUinListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class isc
  implements Runnable
{
  public isc(Repository paramRepository)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    GetStoryDesHandlerStep localGetStoryDesHandlerStep = new GetStoryDesHandlerStep(this.a, true);
    localGetStoryDesHandlerStep.a(false);
    if (this.a.c != null) {
      this.a.c.b();
    }
    this.a.c = new StepExector(this.a).a(new SplitUinListStep(this.a)).a(localGetStoryDesHandlerStep).a(new ise(this)).a(new isd(this));
    SLog.d("Q.qqstory.home.Repository", "get more date start");
    this.a.c.a();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */