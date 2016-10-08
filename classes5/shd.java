import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class shd
  implements Runnable
{
  shd(shc paramshc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.a.a.c)) {
      return;
    }
    String str = TroopLocalVideoFileView.a(this.a.a, this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    this.a.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */