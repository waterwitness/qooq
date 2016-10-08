package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PressDarkImageView
  extends ImageView
{
  public static final int[] a;
  public float a;
  public float b = 0.5F;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 16843210, 16843211 };
  }
  
  public PressDarkImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PressDarkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressDarkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = 1.0F;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_Float = paramContext.getFloat(0, this.jdField_a_of_type_Float);
    this.b = paramContext.getFloat(1, this.b);
    paramContext.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (isPressed())
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        super.setImageAlpha((int)(this.b * 255.0F));
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(this.b);
        return;
      }
      super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.jdField_a_of_type_Float);
      return;
    }
    super.clearColorFilter();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\PressDarkImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */