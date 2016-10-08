import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.VideoCoverView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.io.File;

class inr
  implements Runnable
{
  inr(inq paraminq, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Inq.a.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
    if (this.jdField_a_of_type_Inq.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_Inq.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(VideoCoverView.a(this.jdField_a_of_type_Inq.a), this.jdField_a_of_type_Inq.a.jdField_b_of_type_JavaLangString, 0L, 0L);
    }
    if (this.jdField_a_of_type_Inq.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
      this.jdField_a_of_type_Inq.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(this.jdField_a_of_type_Inq.a.jdField_b_of_type_JavaLangString);
    }
    if (!this.jdField_a_of_type_Inq.a.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Inq.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "mNicknameText VISIBLE 1");
      }
      if (this.jdField_a_of_type_Inq.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user != null) {
        this.jdField_a_of_type_Inq.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Inq.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.nick);
      }
      this.jdField_a_of_type_Inq.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Inq.a.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Inq.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
        this.jdField_a_of_type_Inq.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */