import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class sgv
  implements SeekBar.OnSeekBarChangeListener
{
  public sgv(TroopLocalVideoFileView paramTroopLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LocalVideoFileView", 2, "progress:" + paramInt);
    }
    paramSeekBar = TroopLocalVideoFileView.a(this.a, paramInt);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramSeekBar);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.c = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.c = false;
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramSeekBar.getProgress());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */