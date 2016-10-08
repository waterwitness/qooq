import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class iov
  implements MediaPlayer.OnPreparedListener
{
  private final int jdField_a_of_type_Int;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final QQStoryLoadingView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
  
  public iov(StoryPlayVideoActivity paramStoryPlayVideoActivity, int paramInt, ImageView paramImageView, QQStoryLoadingView paramQQStoryLoadingView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = paramQQStoryLoadingView;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "onPrepared time:" + System.currentTimeMillis() + ", videoIndex = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */