import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import mqq.os.MqqHandler;

public class pko
  implements Runnable
{
  public pko(ShortVideoPlayActivity paramShortVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.b())
    {
      if (this.a.b <= 0L) {
        this.a.i();
      }
      ShortVideoPlayActivity.a(this.a, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      if (ShortVideoPlayActivity.a(this.a) != 0L)
      {
        ShortVideoPlayActivity.a(this.a, (int)((float)ShortVideoPlayActivity.a(this.a) * 100.0F / (float)this.a.b + 0.5D));
        this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(ShortVideoPlayActivity.a(this.a));
        this.a.b(ShortVideoPlayActivity.a(this.a));
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "mPlayProgress:" + ShortVideoPlayActivity.a(this.a) + " currentPlayTime=" + this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() * this.a.b / 100000L + " cacheTime=" + this.a.jdField_a_of_type_AndroidWidgetSeekBar.getSecondaryProgress() * this.a.b / 100000L);
        }
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.a.g != 0L))
    {
      if (!this.a.jdField_f_of_type_Boolean) {
        break label541;
      }
      ShortVideoPlayActivity.b(this.a, (int)(this.a.jdField_f_of_type_Long * 100L / this.a.g));
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetSeekBar.getSecondaryProgress() != ShortVideoPlayActivity.b(this.a))
      {
        this.a.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(ShortVideoPlayActivity.b(this.a));
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "mCacheProgress:" + ShortVideoPlayActivity.b(this.a) + " currentPlayTime=" + this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() * this.a.b / 100000L + " cacheTime=" + this.a.jdField_a_of_type_AndroidWidgetSeekBar.getSecondaryProgress() * this.a.b / 100000L);
        }
      }
      if ((this.a.c()) && (ShortVideoPlayActivity.c(this.a) > 0) && (ShortVideoPlayActivity.a(this.a) != null) && (ShortVideoPlayActivity.a(this.a).getVisibility() == 0))
      {
        String str = ShortVideoUtils.a(this.a.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.c(this.a) * 1024);
        ShortVideoPlayActivity.a(this.a).setText(str + "/s");
      }
      if (!this.a.isFinishing()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "check progress, while finishing");
      }
      return;
      label541:
      ShortVideoPlayActivity.b(this.a, 100);
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */