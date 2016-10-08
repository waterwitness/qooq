import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sev
  implements View.OnClickListener
{
  public sev(LocalMusicFileView paramLocalMusicFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FileManagerReporter.a("0X8004BE2");
    if (LocalMusicFileView.c(this.a) != null) {
      LocalMusicFileView.d(this.a).c(LocalMusicFileView.a(this.a));
    }
    LocalMusicFileView.a(this.a).setProgress(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */