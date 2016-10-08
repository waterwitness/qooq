package com.tencent.mobileqq.hotchat.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotchat.ui.HeartView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class HeartLayout
  extends RelativeLayout
  implements HeartAnimator.HeartAnimatorListener
{
  public static final int[] a;
  public static Bitmap[] a;
  public static int c;
  public float a;
  public int a;
  public Rect a;
  public HeartAnimator a;
  public HeartLayout.HeartLayoutListener a;
  public Random a;
  public boolean a;
  public float b;
  public int b;
  public boolean b;
  public float c;
  public boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
  }
  
  public HeartLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ArrayOfAndroidGraphicsBitmap != null)
    {
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length)
      {
        if (jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] != null) {
          jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].recycle();
        }
        i += 1;
      }
      jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = null;
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener.a(this, paramFloat1, paramFloat2);
      }
    }
    while ((paramFloat1 < this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.right) || (paramFloat2 < this.jdField_a_of_type_AndroidGraphicsRect.top) || (paramFloat2 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) || (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener.a(this, paramFloat1, paramFloat2);
  }
  
  public HeartAnimator.Config a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator != null) {
      return this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a();
    }
    return null;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Float = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 5);
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator = new HeartAnimator(this);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(this);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilRandom.nextInt(100) < 100 - jdField_c_of_type_Int) {
        break;
      }
    } while ((jdField_a_of_type_ArrayOfAndroidGraphicsBitmap == null) || (jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length == 0));
    a(jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.jdField_a_of_type_JavaUtilRandom.nextInt(jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length)], paramFloat1, paramFloat2);
    return;
    a(jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_JavaUtilRandom.nextInt(jdField_a_of_type_ArrayOfInt.length)], paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator == null) {
      return;
    }
    HeartView localHeartView = new HeartView(getContext(), paramInt);
    localHeartView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(localHeartView, paramFloat1, paramFloat2, this);
  }
  
  public void a(int paramInt1, float paramFloat1, float paramFloat2, long paramLong, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator == null) {
      return;
    }
    HeartView localHeartView = new HeartView(getContext(), paramInt1, false);
    localHeartView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(localHeartView, paramFloat1, paramFloat2, this, paramLong, paramInt2);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator == null) || (paramBitmap == null)) {
      return;
    }
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(localImageView, paramFloat1, paramFloat2, this);
  }
  
  public void a(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener.a(paramAnimation);
    }
  }
  
  public void b(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener.b(paramAnimation);
    }
  }
  
  public void clearAnimation()
  {
    super.clearAnimation();
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = 0;
    while (i < super.getChildCount())
    {
      super.getChildAt(i).clearAnimation();
      i += 1;
    }
    super.removeAllViews();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = super.getMeasuredWidth();
    this.jdField_b_of_type_Int = super.getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!this.jdField_c_of_type_Boolean) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.jdField_a_of_type_Boolean);
      bool1 = bool2;
    } while (!super.isEnabled());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Boolean = true;
      continue;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if ((float)Math.sqrt(Math.pow(f1 - this.jdField_a_of_type_Float, 2.0D) + Math.pow(f2 - this.jdField_b_of_type_Float, 2.0D)) <= this.jdField_c_of_type_Float) {
          b(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
    }
  }
  
  public void setCanDoAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (Build.VERSION.SDK_INT < 11) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = super.getChildCount() - 1;
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if (localView == null) {}
        for (;;)
        {
          i -= 1;
          break;
          Boolean localBoolean = (Boolean)localView.getTag(2131296576);
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            localView.clearAnimation();
            super.removeView(localView);
          }
        }
      }
    }
  }
  
  public void setHeartListener(HeartLayout.HeartLayoutListener paramHeartLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener = paramHeartLayoutListener;
  }
  
  public void setListenTouchEvent(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setSpecialHeart(int paramInt, Set paramSet)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt >= 0) {
        jdField_c_of_type_Int = paramInt;
      }
    } while ((paramSet == null) || (paramSet.size() <= 0));
    jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[paramSet.size()];
    paramSet = paramSet.iterator();
    paramInt = 0;
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt] = BitmapFactory.decodeFile(str);
        paramInt += 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;) {}
      }
    }
  }
  
  public void setValidRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\anim\HeartLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */