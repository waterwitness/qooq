import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sgy
  implements View.OnClickListener
{
  public sgy(TroopLocalVideoFileView paramTroopLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.getWindowManager().getDefaultDisplay();
    int i;
    if (paramView.getWidth() > paramView.getHeight())
    {
      i = 0;
      if (i == 0) {
        break label70;
      }
      this.a.a.setRequestedOrientation(0);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840419);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_Boolean = false;
      return;
      i = 1;
      break;
      label70:
      this.a.a.setRequestedOrientation(1);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840422);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */