package com.tencent.mobileqq.ptt;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LSRecordTextView
  extends TextView
{
  private boolean a;
  private boolean b;
  
  public LSRecordTextView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LSRecordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LSRecordTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void requestLayout()
  {
    if ((this.b) && (this.a)) {
      return;
    }
    super.requestLayout();
  }
  
  public void setNotLayoutInSettingText(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (this.b) {
      this.a = true;
    }
    super.setText(paramCharSequence, paramBufferType);
    this.a = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\LSRecordTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */