import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.AsyncStepExector;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.ErrorHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class isi
  implements Runnable
{
  public isi(AsyncStepExector paramAsyncStepExector)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SLog.e("Q.qqstory.home.Repository.AsyncStepExector", "time out!!");
    this.a.b();
    this.a.a.a(new ErrorMessage(100805, "time out!"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */