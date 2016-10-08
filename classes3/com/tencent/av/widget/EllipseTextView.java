package com.tencent.av.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EllipseTextView
  extends TextView
{
  private float a;
  private float b;
  
  public EllipseTextView(Context paramContext)
  {
    super(paramContext);
    this.a = 1.0F;
    this.b = 0.0F;
  }
  
  public EllipseTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = 1.0F;
    this.b = 0.0F;
  }
  
  public EllipseTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 1.0F;
    this.b = 0.0F;
  }
  
  public String a(int paramInt, String paramString)
  {
    StaticLayout localStaticLayout = new StaticLayout(paramString, super.getPaint(), super.getWidth() - super.getPaddingLeft() - super.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.a, this.b, false);
    String str = paramString;
    if (localStaticLayout.getLineCount() > paramInt) {
      str = paramString.substring(0, localStaticLayout.getLineEnd(paramInt - 1)).trim();
    }
    return str;
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.b = paramFloat1;
    this.a = paramFloat2;
    super.setLineSpacing(paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\EllipseTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */