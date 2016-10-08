import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.PopupMenuDialog;

public class xul
  extends View.AccessibilityDelegate
{
  public xul(PopupMenuDialog paramPopupMenuDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */