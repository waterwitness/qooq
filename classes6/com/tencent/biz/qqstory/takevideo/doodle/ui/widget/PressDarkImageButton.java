package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PressDarkImageButton
  extends ImageButton
{
  public PressDarkImageButton(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\widget\PressDarkImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */