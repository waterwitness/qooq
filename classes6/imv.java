import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class imv
  implements View.OnTouchListener
{
  public imv(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getY();
    if ((i == 0) || (i == 2))
    {
      if (this.a.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))) {
          this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a.getContext(), this.a.jdField_b_of_type_JavaLangString, 0L, 0L, null, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
        }
        StoryReportor.b("story_play", "content_video_play", 0, 0, new String[] { this.a.a(), StoryReportor.a(this.a.getContext().getApplicationContext()), "0", this.a.b() });
        this.a.jdField_e_of_type_Boolean = false;
        return true;
      }
      if ((this.a.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.a.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) && (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      while (f < this.a.jdField_e_of_type_AndroidViewView.getHeight() - this.a.f.getHeight())
      {
        this.a.jdField_e_of_type_Boolean = true;
        return false;
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      this.a.jdField_e_of_type_Boolean = false;
      return true;
    }
    if ((i == 3) || (i == 1))
    {
      this.a.jdField_e_of_type_Boolean = false;
      return false;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */