package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter.ViewHolder;
import com.tencent.qphone.base.util.QLog;
import vtn;
import vto;

public class ScaleGallery
  extends Gallery
{
  public static final float a = 2000.0F;
  public static final String a = "ScaleGallery";
  protected static final int b = 0;
  protected static final int c = 1;
  protected static final int e = 3;
  protected int a;
  Handler a;
  public AdapterView.OnItemSelectedListener a;
  protected boolean a;
  protected float b;
  public AdapterView.OnItemSelectedListener b;
  public boolean b;
  protected float c;
  protected float d;
  public int d;
  
  public ScaleGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Float = 0.5F;
    this.c = 0.61F;
    this.jdField_a_of_type_AndroidOsHandler = new vtn(this);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemSelectedListener = new vto(this);
    setStaticTransformationsEnabled(true);
  }
  
  private int a()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  private void a(View paramView, Transformation paramTransformation)
  {
    NearbyMemberAdapter.ViewHolder localViewHolder = (NearbyMemberAdapter.ViewHolder)paramView.getTag();
    int i;
    int j;
    float f1;
    float f3;
    float f2;
    if (paramView == getSelectedView())
    {
      i = 1;
      paramTransformation = paramTransformation.getMatrix();
      j = getWidth() / 2;
      int k = paramView.getWidth();
      int m = paramView.getLeft();
      int n = k / 2;
      f1 = k;
      f1 = 1.0F / (int)((k * this.c + f1) / 2.0F);
      f3 = Math.min(1.0F, Math.max(-1.0F, (m + n - j) * f1));
      if (this.jdField_b_of_type_Float != 1.0F)
      {
        f2 = (this.jdField_b_of_type_Float - 1.0F) * Math.abs(f3) + 1.0F;
        f1 = f2;
        if (f2 < this.jdField_b_of_type_Float) {
          f1 = this.jdField_b_of_type_Float;
        }
        if (Build.VERSION.SDK_INT <= 11) {
          break label314;
        }
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setAlpha(f1);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setAlpha(f1);
      }
      label163:
      f2 = Math.abs(f3) * -1.0F + 1.0F;
      f1 = f2;
      if (f2 < 0.1F) {
        f1 = 0.0F;
      }
      if (Build.VERSION.SDK_INT <= 11) {
        break label342;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetButton.setAlpha(f1);
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setAlpha(f1);
    }
    for (;;)
    {
      if (this.c != 1.0F)
      {
        f2 = (this.c - 1.0F) * Math.abs(f3) + 1.0F;
        f1 = f2;
        if (f2 < this.c) {
          f1 = this.c;
        }
        paramTransformation.setScale(f1, f1);
      }
      i = paramView.getHeight();
      j = paramView.getWidth();
      paramTransformation.preTranslate(-(j / 2), -(i / 2));
      paramTransformation.postTranslate(j / 2, i / 2);
      return;
      i = 0;
      break;
      label314:
      Drawable localDrawable = localViewHolder.jdField_b_of_type_AndroidWidgetImageView.getBackground();
      if (localDrawable == null) {
        break label163;
      }
      localDrawable.setAlpha((int)(f1 * 255.0F));
      break label163;
      label342:
      if (i != 0)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  public void a()
  {
    int i = getSelectedItemPosition();
    if (QLog.isColorLevel()) {
      QLog.i("ScaleGallery.scroll", 2, "checkScroll:" + i + ", " + this.d);
    }
    if (i > this.d) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
    while (i >= this.d) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public boolean a()
  {
    onKeyDown(21, null);
    return true;
  }
  
  public boolean b()
  {
    onKeyDown(22, null);
    return true;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    a(paramView, paramTransformation);
    paramView.invalidate();
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f2 = Math.abs(paramFloat1);
    float f1 = paramFloat1;
    if (f2 > 2000.0F) {
      f1 = f2 / paramFloat1 * 2000.0F;
    }
    super.onFling(paramMotionEvent1, paramMotionEvent2, f1, paramFloat2);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    Object localObject = getSelectedView();
    if ((localObject == null) || (!(((View)localObject).getTag() instanceof NearbyMemberAdapter.ViewHolder))) {
      return super.onSingleTapUp(paramMotionEvent);
    }
    NearbyMemberAdapter.ViewHolder localViewHolder = (NearbyMemberAdapter.ViewHolder)((View)localObject).getTag();
    int i = (int)(paramMotionEvent.getX() + getScrollX() - ((View)localObject).getLeft());
    int j = (int)(paramMotionEvent.getY() + getScrollY() - ((View)localObject).getTop());
    localObject = new Rect();
    localViewHolder.jdField_a_of_type_AndroidWidgetButton.getHitRect((Rect)localObject);
    if (((Rect)localObject).contains(i, j)) {
      localViewHolder.jdField_a_of_type_AndroidWidgetButton.performClick();
    }
    for (;;)
    {
      return super.onSingleTapUp(paramMotionEvent);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.getHitRect((Rect)localObject);
      if (((Rect)localObject).contains(i, j)) {
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.performClick();
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = a();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if ((paramMotionEvent.getAction() == 0) && (QLog.isColorLevel())) {
      QLog.i("ScaleGallery", 2, "onTouchEvent:" + getSelectedItemPosition());
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    super.setOnItemSelectedListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemSelectedListener);
    this.jdField_b_of_type_AndroidWidgetAdapterView$OnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setSelectionNew(int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.d = paramInt;
    int i = getSelectedItemPosition();
    if (QLog.isColorLevel()) {
      QLog.i("ScaleGallery", 2, "setSelectionNew:" + i + ", " + this.d);
    }
    if (i == paramInt) {}
    do
    {
      return;
      if (i > paramInt)
      {
        if (i - paramInt > 3)
        {
          setSelection(paramInt + 3);
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10L);
        return;
      }
    } while (i >= paramInt);
    if (paramInt - i > 3)
    {
      setSelection(paramInt - 3);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10L);
  }
  
  public void setUnselectedAlpha(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setUnselectedScale(float paramFloat)
  {
    this.c = paramFloat;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\ScaleGallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */