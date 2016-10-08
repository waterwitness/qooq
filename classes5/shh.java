import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class shh
  implements Runnable
{
  shh(shg paramshg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText("00:00");
    this.a.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    this.a.a.b.setText("/" + TroopLocalVideoFileView.a(this.a.a, this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration()));
    int i = (int)this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    this.a.a.jdField_a_of_type_AndroidWidgetSeekBar.setMax(i);
    TroopLocalVideoFileView.a(this.a.a, false);
    TroopLocalVideoFileView.e(this.a.a);
    TroopLocalVideoFileView.f(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */