import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class shc
  extends TimerTask
{
  public shc(TroopLocalVideoFileView paramTroopLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.post(new shd(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */