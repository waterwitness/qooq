import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;

public class tcx
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private tcx(RoamSearchDialog paramRoamSearchDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      this.a.a();
      return true;
    }
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 84))
    {
      if (paramKeyEvent.getAction() == 1) {
        this.a.a();
      }
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */