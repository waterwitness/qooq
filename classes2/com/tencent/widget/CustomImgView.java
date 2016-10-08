package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CustomImgView
  extends FrameLayout
{
  public ImageView a;
  public ImageView b;
  
  public CustomImgView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public CustomImgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CustomImgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new URLImageView(getContext());
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, localLayoutParams);
    this.b = new ImageView(getContext());
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.b, localLayoutParams);
    this.b.setDuplicateParentStateEnabled(true);
  }
  
  public Drawable a()
  {
    return this.a.getDrawable();
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
  
  public void setURLDrawableListener(URLDrawableDownListener paramURLDrawableDownListener)
  {
    if ((this.a != null) && ((this.a instanceof URLImageView))) {
      ((URLImageView)this.a).setURLDrawableDownListener(paramURLDrawableDownListener);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\CustomImgView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */