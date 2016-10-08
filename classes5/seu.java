import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class seu
  implements View.OnClickListener
{
  public seu(LocalMusicFileView paramLocalMusicFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FileManagerReporter.a("0X8004BE3");
    if (LocalMusicFileView.a(this.a) != null) {
      LocalMusicFileView.b(this.a).b(LocalMusicFileView.a(this.a));
    }
    LocalMusicFileView.a(this.a).setProgress(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\seu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */