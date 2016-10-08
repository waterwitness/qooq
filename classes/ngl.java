import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;

public class ngl
  extends AccessibilityDelegateCompat
{
  public ngl(PressToSpeakPanel paramPressToSpeakPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if ((AppSetting.j) && (PressToSpeakPanel.a(this.a) > 0) && (!PressToSpeakPanel.a(this.a)) && (PressToSpeakPanel.a(this.a).a() == 1))
    {
      PressToSpeakPanel.a(this.a, true);
      PressToSpeakPanel.b(this.a);
      AccessibilityUtil.a(this.a, this.a.getContext().getString(2131362107));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ngl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */