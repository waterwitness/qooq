import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vxk
  extends View.AccessibilityDelegate
{
  public vxk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    paramAccessibilityNodeInfo.setVisibleToUser(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */