import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class iqo
  implements MessageQueue.IdleHandler
{
  public iqo(QQStoryMainActivity paramQQStoryMainActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    SLog.b("Q.qqstory.home.QQStoryMainActivity", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.a(this.a.app);
    SLog.b("Q.qqstory.home.QQStoryMainActivity", "queueIdle loadShortVideoSo end");
    SLog.b("Q.qqstory.home.QQStoryMainActivity", "queueIdle startDownloadFilterSo start");
    this.a.c = PtvFilterSoLoad.a(this.a.app, BaseApplicationImpl.getContext());
    SLog.b("Q.qqstory.home.QQStoryMainActivity", "queueIdle startDownloadFilterSo end");
    SLog.b("Q.qqstory.home.QQStoryMainActivity", "queueIdle pre load class : " + NewStoryTakeVideoActivity.class.getSimpleName());
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */