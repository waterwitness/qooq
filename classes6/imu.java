import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class imu
  implements Runnable
{
  public imu(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.a.e = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setMax((int)this.a.e);
      this.a.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.a, 500L);
      this.a.b.setVisibility(8);
      return;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
        this.a.e = this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */