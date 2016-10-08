import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.IMyStroyPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class lyl
  implements MessageQueue.IdleHandler
{
  public lyl(Now paramNow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    SLog.b("NowTab", "queueIdle init doodle manager");
    if (Now.a(this.a) != null) {
      Now.a(this.a).c();
    }
    Now.a(this.a, new StoryListPresenter(this.a.a()));
    Now.a(this.a).setListEventListener(Now.a(this.a));
    Now.a(this.a).a(this.a);
    Now.a(this.a).a();
    SLog.b("NowTab", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.a(this.a.a);
    SLog.b("NowTab", "queueIdle loadShortVideoSo end");
    SLog.b("NowTab", "queueIdle startDownloadFilterSo start");
    this.a.d = PtvFilterSoLoad.a(this.a.a, BaseApplicationImpl.getContext());
    SLog.b("NowTab", "queueIdle startDownloadFilterSo end");
    SLog.b("NowTab", "queueIdle pre load class : " + NewStoryTakeVideoActivity.class.getSimpleName());
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */