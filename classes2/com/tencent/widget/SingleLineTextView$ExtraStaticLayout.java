package com.tencent.widget;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SingleLineTextView$ExtraStaticLayout
  extends StaticLayout
{
  public SingleLineTextView$ExtraStaticLayout(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4)
  {
    super(paramCharSequence, paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4);
  }
  
  public SingleLineTextView$ExtraStaticLayout(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    super(paramCharSequence, paramTextPaint, paramInt, paramAlignment, paramFloat1, paramFloat2, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getParagraphDirection(int paramInt)
  {
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\SingleLineTextView$ExtraStaticLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */