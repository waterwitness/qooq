import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class sfv
  extends TimerTask
{
  public sfv(LocalVideoFileView paramLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LocalVideoFileView.h(this.a).runOnUiThread(new sfw(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */