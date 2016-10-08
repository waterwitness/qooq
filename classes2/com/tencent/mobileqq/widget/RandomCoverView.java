package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

public class RandomCoverView
  extends URLImageView
{
  protected Paint a;
  protected URLDrawable a;
  protected QQAppInterface a;
  protected String a;
  protected boolean a;
  protected String b;
  
  public RandomCoverView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = getResources().getDrawable(2130841028);
      setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qzonecover.", 2, localOutOfMemoryError.toString());
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (TextUtils.isEmpty(paramString2)) {
      a();
    }
    while ((paramQQAppInterface.a().equals(this.jdField_a_of_type_JavaLangString)) && ((TextUtils.isEmpty(paramString2)) || (paramBoolean)))
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        float f = DisplayUtil.a(getContext(), 14.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#4CFFFFFF"));
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f);
      }
      this.b = getResources().getString(2131370902);
      this.jdField_a_of_type_Boolean = true;
      return;
      a(paramString2, paramBoolean);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
        }
        Object localObject2;
        for (((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;; ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2))
        {
          localObject2 = (Activity)getContext();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ProfileCardUtil.c((Activity)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ProfileCardUtil.b((Activity)localObject2);
          localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
          this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject1);
          setImageDrawable((Drawable)localObject1);
          this.jdField_a_of_type_Boolean = paramBoolean;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.", 2, "updateCover " + paramString + " isDef:" + paramBoolean);
          return;
          localObject2 = getResources().getDrawable(2130841028);
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        }
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, paramString.toString());
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidGraphicsPaint != null) && (!TextUtils.isEmpty(this.b)) && (getHeight() != 0) && (getWidth() != 0) && (this.jdField_a_of_type_Boolean))
    {
      float f = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.b);
      int i = getHeight() / 2;
      int j = (getWidth() - (int)f) / 2;
      paramCanvas.drawText(this.b, j, i, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\RandomCoverView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */