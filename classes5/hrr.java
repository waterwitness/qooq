import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class hrr
  implements SeekBar.OnSeekBarChangeListener
{
  public hrr(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    long l3 = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    long l2 = (paramInt / 100.0D * l3);
    long l1 = l2;
    if (Math.abs(l3 - l2) < 3000L)
    {
      l1 = l2;
      if (l3 > 20000L) {
        l1 = (int)l3 - 3000;
      }
    }
    this.a.a(l1);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.f = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.a.f = false;
    int i = paramSeekBar.getProgress();
    long l = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    int j = (int)(i / 100.0D * l);
    i = j;
    if (Math.abs(l - j) < 3000L)
    {
      i = j;
      if (l > 20000L) {
        i = (int)l - 3000;
      }
    }
    this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(i);
    if (this.a.e == true)
    {
      ReportController.b(null, "CliOper", "", "", "0X8006767", "0X8006767", 0, 0, "", this.a.d, "", this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006760", "0X8006760", 0, 0, "", "", this.a.d, this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */