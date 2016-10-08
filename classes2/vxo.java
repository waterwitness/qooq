import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vxo
  extends View.AccessibilityDelegate
{
  public vxo(CharSequence paramCharSequence, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if (this.jdField_a_of_type_JavaLangCharSequence != null) {
      paramAccessibilityNodeInfo.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    paramAccessibilityNodeInfo.setClassName(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */