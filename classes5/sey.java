import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class sey
  extends TimerTask
{
  public sey(LocalMusicFileView paramLocalMusicFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LocalMusicFileView.b(this.a).runOnUiThread(new sez(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */