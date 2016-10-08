package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BaselineTextView
  extends TextView
{
  public BaselineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(0.0F, getHeight() - getBaseline() - getPaddingBottom());
    super.onDraw(paramCanvas);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\BaselineTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */