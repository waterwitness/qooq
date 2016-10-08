import android.os.Build.VERSION;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sfk
  implements SeekBar.OnSeekBarChangeListener
{
  public sfk(LocalVideoFileView paramLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    LocalVideoFileView.a(this.a, paramInt);
    if (paramBoolean)
    {
      paramSeekBar = LocalVideoFileView.a(this.a, paramInt);
      LocalVideoFileView.a(this.a).setText(paramSeekBar);
      if ((LocalVideoFileView.a(this.a) != null) && (LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {}
    }
    else
    {
      return;
    }
    LocalVideoFileView.a(this.a).a(paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalVideoFileView.a(this.a) == null) || (!LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {
      return;
    }
    LocalVideoFileView.a(this.a).d();
    if (Build.VERSION.SDK_INT > 16)
    {
      LocalVideoFileView.a(this.a).setBackground(null);
      return;
    }
    LocalVideoFileView.a(this.a).setBackgroundDrawable(null);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalVideoFileView.a(this.a) == null) || (!LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {
      return;
    }
    LocalVideoFileView.a(this.a).e();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */