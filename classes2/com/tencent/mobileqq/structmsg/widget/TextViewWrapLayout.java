package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TextViewWrapLayout
  extends RelativeLayout
{
  private boolean a;
  
  public TextViewWrapLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TextViewWrapLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TextViewWrapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    requestLayout();
    invalidate();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      if (this.a)
      {
        TextView localTextView1 = (TextView)findViewById(2131296360);
        TextView localTextView2 = (TextView)findViewById(2131296361);
        if ((localTextView2 != null) && (localTextView1 != null)) {
          localTextView2.setMaxLines(4 - localTextView1.getLineCount());
        }
        this.a = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\widget\TextViewWrapLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */