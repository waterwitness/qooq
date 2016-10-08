import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class rpt
  implements DialogInterface.OnKeyListener
{
  public rpt(UniformDownloadActivity paramUniformDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      if (this.a.a != null)
      {
        this.a.a.dismiss();
        this.a.a = null;
      }
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      bool = true;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */