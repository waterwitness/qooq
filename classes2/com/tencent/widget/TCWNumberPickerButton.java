package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TCWNumberPickerButton
  extends ImageButton
{
  private TCWNumberPicker a;
  
  public TCWNumberPickerButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TCWNumberPickerButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TCWNumberPickerButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    if (2131298548 == getId()) {
      this.a.a();
    }
    while (2131298550 != getId()) {
      return;
    }
    this.a.b();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      a();
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 23) || (paramInt == 66)) {
      a();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  public void setNumberPicker(TCWNumberPicker paramTCWNumberPicker)
  {
    this.a = paramTCWNumberPicker;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\TCWNumberPickerButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */