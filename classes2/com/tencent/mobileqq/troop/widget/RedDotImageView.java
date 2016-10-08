package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;
import vtl;
import vtm;

public class RedDotImageView
  extends ImageView
{
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private int jdField_a_of_type_Int = 13;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  private int b = 13;
  
  public RedDotImageView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      ThreadManager.a().post(new vtl(this, paramAppInterface, paramString));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843321);
      }
      postInvalidate();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(AppInterface paramAppInterface, String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      a(false);
      ThreadManager.a().post(new vtm(this, paramAppInterface, paramString));
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      int i = (int)Math.ceil(getWidth() * 0.5D + this.jdField_a_of_type_Float * this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * 0.5D);
      int j = (int)Math.ceil(getHeight() * 0.5D - this.jdField_a_of_type_Float * this.b - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() * 0.5D);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, j, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + i, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + j);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void setRedDotDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
  }
  
  public void setReddotXOffsetDp(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Int = paramInt;
      postInvalidate();
    }
  }
  
  public void setReddotYOffsetDp(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.b))
    {
      this.b = paramInt;
      postInvalidate();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\RedDotImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */