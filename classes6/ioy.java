import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ioy
  implements MediaPlayer.OnInfoListener
{
  private final int jdField_a_of_type_Int;
  protected final ImageView a;
  private TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  protected final QQStoryLoadingView a;
  
  public ioy(StoryPlayVideoActivity paramStoryPlayVideoActivity, int paramInt, TextureVideoView paramTextureVideoView, ImageView paramImageView, QQStoryLoadingView paramQQStoryLoadingView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = paramTextureVideoView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = paramQQStoryLoadingView;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "StoryVideoOnInfoListener onInfo time:" + System.currentTimeMillis() + ", what:" + paramInt1 + ",index:" + this.jdField_a_of_type_Int);
    }
    if (paramInt1 == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.StoryPlayVideoActivity", 2, "onInfo隐藏cover");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(4);
      StoryPlayVideoActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
      ((StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a).get(this.jdField_a_of_type_Int)).mIsPlaying = 2;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ioy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */