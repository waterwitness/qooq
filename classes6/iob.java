import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.GestureHandler;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoControlListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class iob
  implements StoryPlayVideoActivity.GestureHandler
{
  public iob(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    Object localObject;
    if ((this.a.J == 0) || (this.a.J == 8) || (this.a.J == 4) || (this.a.J == 6))
    {
      localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a();
      if (localObject != null) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).a);
        } while ((TextUtils.isEmpty(((StoryVideoItem)localObject).mLabel)) || (!((StoryVideoItem)localObject).hasRelativeVideo()));
        StoryPlayVideoActivity.a(this.a, ((StoryVideoItem)localObject).mLabel, ((StoryVideoItem)localObject).mVid);
        ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "clk_discover", 0, 0, "2", "", "", ((StoryVideoItem)localObject).mVid);
        return;
      } while ((this.a.J != 1) && (this.a.J != 2));
      localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a();
    } while ((localObject == null) || (((StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).a)).mViewCount == 0));
    ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).d.performClick();
    ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "exp_friend", 0, 0, "2", "", "", "");
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.a.c();
    this.a.a();
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.f(this.a.K);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */