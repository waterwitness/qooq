package com.tencent.widget.immersive;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ImmersiveTitleBar2
  extends View
{
  public static boolean a;
  public static boolean b;
  public int a;
  private int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
  }
  
  public ImmersiveTitleBar2(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ImmersiveTitleBar2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ImmersiveTitleBar2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public void a(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  public void a(Context paramContext)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "ImmersiveTitleBar initUI");
    }
    if ((jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      jdField_b_of_type_Boolean = bool;
      this.jdField_b_of_type_Int = ImmersiveUtils.a(paramContext);
      if (!jdField_b_of_type_Boolean) {
        break label74;
      }
      setCustomHeight(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      setBackgroundColor(getResources().getColor(2131428295));
      return;
      bool = false;
      break;
      label74:
      setCustomHeight(0);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "ImmersiveTitleBar onMeasure=" + this.jdField_a_of_type_Int);
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_Int);
  }
  
  public void setCustomHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\immersive\ImmersiveTitleBar2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */