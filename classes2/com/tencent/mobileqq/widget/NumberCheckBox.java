package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NumberCheckBox
  extends CheckBox
{
  private int a;
  
  public NumberCheckBox(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = -1;
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = -1;
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = -1;
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    String str2 = "";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (this.a >= 0) {
        str1 = String.valueOf(this.a);
      }
    }
    if (!str1.equals(getText())) {
      setText(str1);
    }
  }
  
  public void setCheckedNumber(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      setText(String.valueOf(paramInt));
    }
    setChecked(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\NumberCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */