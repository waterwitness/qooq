import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vxj
  extends View.AccessibilityDelegate
{
  public vxj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    EditText localEditText = (EditText)paramView;
    localEditText.setHint("");
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setContentDescription(localEditText.getContentDescription());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */