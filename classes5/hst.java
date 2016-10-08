import android.os.Handler;
import android.view.ViewGroup;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.TimerTask;

public class hst
  extends TimerTask
{
  public hst(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l1;
    long l2;
    if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (!this.a.i))
    {
      l1 = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      l2 = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
      if (this.a.jdField_a_of_type_AndroidWidgetSeekBar == null) {
        this.a.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298795));
      }
      if (this.a.jdField_a_of_type_AndroidWidgetSeekBar != null)
      {
        if (l2 != 0L) {
          break label141;
        }
        this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new hsu(this, l1));
      return;
      label141:
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(l1 / l2 * 100.0D));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */