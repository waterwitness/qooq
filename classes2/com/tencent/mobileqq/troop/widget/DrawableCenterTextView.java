package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DrawableCenterTextView
  extends TextView
{
  public DrawableCenterTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DrawableCenterTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DrawableCenterTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getCompoundDrawables();
    if (localObject != null)
    {
      localObject = localObject[0];
      if (localObject != null)
      {
        float f1 = getPaint().measureText(getText().toString());
        int i = getCompoundDrawablePadding();
        float f2 = ((Drawable)localObject).getIntrinsicWidth();
        float f3 = i;
        paramCanvas.translate((getWidth() - (f2 + f1 + f3)) / 2.0F, 0.0F);
      }
    }
    super.onDraw(paramCanvas);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\DrawableCenterTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */