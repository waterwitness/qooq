import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vxm
  extends View.AccessibilityDelegate
{
  public vxm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setVisibleToUser(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */