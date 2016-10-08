import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class wle
  extends ExploreByTouchHelper
{
  public wle(ClearableEditText paramClearableEditText, View paramView)
  {
    super(paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    if ((ClearableEditText.b(this.a)) && (paramFloat1 > this.a.getWidth() - this.a.getPaddingRight() - this.a.a.getIntrinsicWidth())) {
      return 0;
    }
    return -1;
  }
  
  protected void getVisibleVirtualViews(List paramList)
  {
    if (ClearableEditText.b(this.a)) {
      paramList.add(Integer.valueOf(0));
    }
  }
  
  protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClearableEditTextHelper", 2, "onPerformActionForVirtualView virtualViewId:" + paramInt1);
    }
    return false;
  }
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramInt == 0) {
      paramAccessibilityEvent.setContentDescription("删除 按钮");
    }
  }
  
  protected void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramInt == 0)
    {
      paramAccessibilityNodeInfoCompat.setContentDescription("删除 按钮");
      paramAccessibilityNodeInfoCompat.addAction(16);
      paramAccessibilityNodeInfoCompat.setBoundsInParent(new Rect(this.a.getWidth() - this.a.getPaddingRight() - this.a.a.getIntrinsicWidth(), this.a.getPaddingTop(), this.a.getWidth() - this.a.getPaddingRight(), this.a.getHeight() - this.a.getPaddingBottom()));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */