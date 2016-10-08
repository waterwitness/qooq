package com.tencent.biz.widgets;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class KandianTextView
  extends TextView
{
  private static final String jdField_a_of_type_JavaLangString = "KandianTextView";
  private boolean jdField_a_of_type_Boolean;
  
  public KandianTextView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public KandianTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KandianTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT < 16) {}
    while (this.a) {
      return;
    }
    String str2;
    if (super.getLineCount() == 2)
    {
      paramInt2 = super.getLayout().getLineVisibleEnd(0);
      paramInt3 = super.getLayout().getLineVisibleEnd(1);
      if ((paramInt3 - paramInt2 == 1) || (paramInt3 - paramInt2 == 2))
      {
        str2 = super.getText().toString();
        if (paramInt3 - paramInt2 != 2) {
          break label180;
        }
        if ((str2.charAt(paramInt2 - 1) < '一') || (str2.charAt(paramInt2 - 1) > 40869)) {
          break label212;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        String str1 = str2.substring(0, paramInt2 - 1);
        str2 = str2.substring(paramInt2 - 1, paramInt3);
        super.setText(str1 + "\n" + str2);
      }
      this.a = true;
      return;
      label180:
      if ((str2.charAt(paramInt2 - 1) >= '一') && (str2.charAt(paramInt2 - 1) <= 40869)) {
        paramInt1 = 1;
      } else {
        label212:
        paramInt1 = 0;
      }
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.a = false;
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\widgets\KandianTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */