package com.tencent.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class KeyboardDetectorRelativeLayout
  extends RelativeLayout
{
  protected Rect a;
  protected IKeyboardChanged a;
  
  public KeyboardDetectorRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
  }
  
  public void a(IKeyboardChanged paramIKeyboardChanged)
  {
    this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged = paramIKeyboardChanged;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    Activity localActivity = (Activity)super.getContext();
    localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int j = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int k = localActivity.getWindowManager().getDefaultDisplay().getHeight();
    if ((this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged != null) && (i != 0))
    {
      if (k - j - i <= 100) {
        break label112;
      }
      this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged.a(Math.abs(this.jdField_a_of_type_AndroidGraphicsRect.height()) - getPaddingBottom() - getPaddingTop());
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      label112:
      this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\widget\KeyboardDetectorRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */