import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hch
  extends AccessibilityDelegateCompat
{
  public hch(ShimmerTextView paramShimmerTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setVisibleToUser(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */