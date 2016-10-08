import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sfn
  implements View.OnClickListener
{
  public sfn(LocalVideoFileView paramLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = LocalVideoFileView.c(this.a).getWindowManager().getDefaultDisplay();
    int i;
    if (paramView.getWidth() > paramView.getHeight())
    {
      i = 0;
      if (i == 0) {
        break label71;
      }
      LocalVideoFileView.c(this.a).setRequestedOrientation(0);
      LocalVideoFileView.a(this.a).setBackgroundResource(2130840419);
    }
    for (;;)
    {
      LocalVideoFileView.a(this.a, false);
      return;
      i = 1;
      break;
      label71:
      LocalVideoFileView.c(this.a).setRequestedOrientation(1);
      LocalVideoFileView.a(this.a).setBackgroundResource(2130840422);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */