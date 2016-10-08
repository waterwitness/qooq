import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.ReportWatchVideoListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step.FinishCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class isx
  implements Runnable
{
  public isx(ReportWatchVideoListStep paramReportWatchVideoListStep)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Dispatchers.get().unRegisterSubscriber(this.a);
    this.a.a.a(this.a.a());
    SLog.d("Q.qqstory.home.Repository,ReportWatchVideoListStep", "receive event. step is done");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */