package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RightArrowTextView
  extends TextView
{
  public RightArrowTextView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RightArrowTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RightArrowTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Drawable localDrawable = getResources().getDrawable(2130843205);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    SpannableString localSpannableString = new SpannableString(paramCharSequence.toString() + "[arrow]");
    localSpannableString.setSpan(new ImageSpan(localDrawable, 1), paramCharSequence.length(), paramCharSequence.length() + "[arrow]".length(), 17);
    super.setText(localSpannableString, paramBufferType);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\RightArrowTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */