import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class plb
  implements MediaPlayer.OnPreparedListener
{
  public plb(ShortVideoPreviewActivity paramShortVideoPreviewActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared: mDuration=" + this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.a.start();
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.a.seekTo(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.b(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\plb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */