import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nck
  extends View.AccessibilityDelegate
{
  public nck(BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramAccessibilityNodeInfo.setVisibleToUser(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */