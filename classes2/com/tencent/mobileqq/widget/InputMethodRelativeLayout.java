package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class InputMethodRelativeLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  protected InputMethodRelativeLayout.onSizeChangedListenner a;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
      this.c = paramContext.getWidth();
      this.d = paramContext.getHeight();
      return;
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.c = paramContext.widthPixels;
    this.d = paramContext.heightPixels;
  }
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout$onSizeChangedListenner != null) && (paramInt1 == paramInt3) && (paramInt3 != 0) && (paramInt4 != 0))
    {
      if (paramInt2 >= paramInt4) {
        break label104;
      }
      if (Math.abs(paramInt2 - this.d) <= AIOUtils.a(150.0F, getResources())) {
        break label96;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout$onSizeChangedListenner.a(this.jdField_a_of_type_Boolean, paramInt4, paramInt2);
      measure(this.jdField_a_of_type_Int - paramInt1 + getWidth(), this.b - paramInt2 + getHeight());
      return;
      label96:
      this.jdField_a_of_type_Boolean = false;
      continue;
      label104:
      if (Math.abs(paramInt2 - paramInt4) < AIOUtils.a(150.0F, getResources())) {
        this.jdField_a_of_type_Boolean = true;
      } else {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void setOnSizeChangedListenner(InputMethodRelativeLayout.onSizeChangedListenner paramonSizeChangedListenner)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout$onSizeChangedListenner = paramonSizeChangedListenner;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\InputMethodRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */