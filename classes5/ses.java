import android.text.format.Time;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ses
  implements SeekBar.OnSeekBarChangeListener
{
  public ses(LocalMusicFileView paramLocalMusicFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((LocalMusicFileView.a(this.a) == null) || (!LocalMusicFileView.a(this.a).b(LocalMusicFileView.a(this.a)))) {}
    while (!paramBoolean) {
      return;
    }
    LocalMusicFileView.a(this.a).a(paramInt);
    paramSeekBar = new Time();
    paramSeekBar.set(paramInt);
    paramSeekBar = paramSeekBar.format("%M:%S");
    LocalMusicFileView.a(this.a).setText(paramSeekBar);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalMusicFileView.a(this.a) == null) || (!LocalMusicFileView.a(this.a).b(LocalMusicFileView.a(this.a)))) {
      return;
    }
    LocalMusicFileView.a(this.a).d();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalMusicFileView.a(this.a) == null) || (!LocalMusicFileView.a(this.a).b(LocalMusicFileView.a(this.a)))) {
      return;
    }
    LocalMusicFileView.a(this.a).e();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */