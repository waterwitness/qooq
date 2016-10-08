import android.text.format.Time;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sfa
  implements Runnable
{
  sfa(sez paramsez)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((LocalMusicFileView.a(this.a.a.a) == null) || (!LocalMusicFileView.a(this.a.a.a).b(LocalMusicFileView.a(this.a.a.a)))) {
      return;
    }
    int i = LocalMusicFileView.a(this.a.a.a).b();
    LocalMusicFileView.a(this.a.a.a).setProgress(i);
    Object localObject = new Time();
    ((Time)localObject).set(i);
    localObject = ((Time)localObject).format("%M:%S");
    LocalMusicFileView.a(this.a.a.a).setText((CharSequence)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */