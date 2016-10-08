package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class PatchedButton
  extends Button
{
  private static final String a = "PatchedTextView";
  
  public PatchedButton(Context paramContext)
  {
    super(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PatchedButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PatchedButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.onMeasure", localException);
      }
      setText(getText().toString());
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public void setGravity(int paramInt)
  {
    try
    {
      super.setGravity(paramInt);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.setGravity", localException);
      }
      setText(getText().toString());
      super.setGravity(paramInt);
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    try
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    catch (Exception paramBufferType)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.setText", paramBufferType);
      }
      super.setText(paramCharSequence.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\PatchedButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */