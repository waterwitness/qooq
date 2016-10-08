import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoControlListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ioj
  implements StoryPlayVideoActivity.VideoControlListener
{
  public static final String a = "videolistener_tag";
  
  public ioj(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onNext:" + paramInt);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onSingleTapNext:" + paramInt);
    }
    this.a.a(paramInt, 3);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onSlideNext:" + paramInt);
    }
    ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "clk_next", 0, 0, "2", "", "", "");
    this.a.a(paramInt, 3);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onSlidePrevious:" + paramInt);
    }
    ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "clk_previous", 0, 0, "", "", "", "");
    this.a.a(paramInt, 3);
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onClickClose:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.a).size()))
    {
      ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "clk_quit", 0, 0, "", "", "", "");
      return;
    }
    this.a.a(paramInt, 2);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.a).get(paramInt);
    ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "clk_quit", 0, 0, "", "", "", localStoryVideoItem.mVid);
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onSlideClose:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.a).size()))
    {
      ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "slide_quit", 0, 0, "", "", "", "");
      return;
    }
    this.a.a(paramInt, 2);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.a).get(paramInt);
    ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "slide_quit", 0, 0, "", "", "", localStoryVideoItem.mVid);
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onPlayEndClose:" + paramInt);
    }
  }
  
  public void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onPlayComplete:" + paramInt);
    }
    this.a.a(paramInt, 1);
  }
  
  public void i(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onPressBackKeyClose:" + paramInt);
    }
    this.a.a(paramInt, 2);
  }
  
  public void j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onStartPlay:" + paramInt);
    }
    StoryPlayVideoActivity.a(this.a, System.currentTimeMillis());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ioj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */