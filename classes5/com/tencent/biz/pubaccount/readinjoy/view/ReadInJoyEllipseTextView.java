package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReadInJoyEllipseTextView
  extends TextView
{
  public ReadInJoyEllipseTextView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReadInJoyEllipseTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyEllipseTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (super.getLineCount() <= 1)
    {
      paramInt1 = super.getLayout().getLineVisibleEnd(0);
      if (super.getText() == null)
      {
        setVisibility(4);
        return;
      }
      if (paramInt1 < super.getText().toString().length())
      {
        setVisibility(4);
        return;
      }
      setVisibility(0);
      return;
    }
    setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoyEllipseTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */