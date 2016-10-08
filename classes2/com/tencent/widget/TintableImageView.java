package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TintableImageView
  extends URLImageView
{
  ColorStateList a;
  
  public TintableImageView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TintableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public TintableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    setColorFilter(this.a.getColorForState(getDrawableState(), 0));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aw, paramInt, 0);
    this.a = paramContext.getColorStateList(0);
    paramContext.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.a != null) && (this.a.isStateful())) {
      a();
    }
  }
  
  public void setColorFilter(ColorStateList paramColorStateList)
  {
    this.a = paramColorStateList;
    super.setColorFilter(paramColorStateList.getColorForState(getDrawableState(), 0));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\TintableImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */