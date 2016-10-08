import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sfx
  implements Runnable
{
  sfx(sfw paramsfw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((LocalVideoFileView.a(this.a.a.a) == null) || (!LocalVideoFileView.a(this.a.a.a).b(LocalVideoFileView.a(this.a.a.a)))) {
      return;
    }
    int i = LocalVideoFileView.a(this.a.a.a).b();
    String str = LocalVideoFileView.a(this.a.a.a, i);
    LocalVideoFileView.a(this.a.a.a).setProgress(i);
    LocalVideoFileView.a(this.a.a.a).setText(str);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */