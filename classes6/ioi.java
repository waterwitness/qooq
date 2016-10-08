import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ioi
  implements Runnable
{
  public ioi(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = Build.MANUFACTURER;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).toLowerCase().contains("meizu"))) {}
    do
    {
      return;
      localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a();
    } while ((localObject == null) || (((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).f.getVisibility() != 0));
    int i = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
    if (i > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.StoryPlayVideoActivity", 2, "进度条里隐藏cover，currentPosition：" + i);
      }
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).f.setVisibility(4);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(4);
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 20L);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ioi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */