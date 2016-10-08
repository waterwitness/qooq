import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pjs
  implements SeekBar.OnSeekBarChangeListener
{
  public pjs(ShortVideoPlayActivity paramShortVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onProgressChanged: progress = " + paramInt + ",fromUser=" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramSeekBar = this.a;
      paramSeekBar.r += 1;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStartTrackingTouch: progress = " + i);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.m();
    paramSeekBar = this.a;
    paramSeekBar.s += 1;
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    int j = (int)(i / 100.0D * this.a.b);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStopTrackingTouch: seekProgress = " + i + ", mCacheProgress= " + ShortVideoPlayActivity.b(this.a) + ", timestamp = " + j);
    }
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.a.i == 2) {
        this.a.a();
      }
      this.a.a(j);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pjs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */