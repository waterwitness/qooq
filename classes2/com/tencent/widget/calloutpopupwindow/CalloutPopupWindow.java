package com.tencent.widget.calloutpopupwindow;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import java.lang.ref.WeakReference;
import xvw;
import xvx;

public class CalloutPopupWindow
  extends PopupWindow
{
  private static final int jdField_a_of_type_Int = 250;
  private static final String jdField_a_of_type_JavaLangString = "CalloutPopupWindow";
  private static final int b = 120;
  private static final int c = 1;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new xvx();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private int d;
  private int e = 81;
  private int f;
  private int g;
  private int h;
  
  public CalloutPopupWindow(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, -2, paramInt2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CalloutPopupWindow(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    if (paramInt1 < 0) {
      throw new RuntimeException("You must specify the window width explicitly(do not use WRAP_CONTENT or MATCH_PARENT)!!!");
    }
    this.g = paramInt3;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    setBackgroundDrawable(new ColorDrawable());
    setOutsideTouchable(true);
    setFocusable(false);
  }
  
  public static CalloutPopupWindow.Builder a(Context paramContext)
  {
    return new CalloutPopupWindow.Builder(paramContext, null);
  }
  
  private void a(ImageView paramImageView)
  {
    Rect localRect = new Rect(0, 0, paramImageView.getDrawable().getIntrinsicWidth(), paramImageView.getDrawable().getIntrinsicHeight());
    Matrix localMatrix = new Matrix();
    paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    localMatrix.postRotate(180.0F, localRect.width() / 2, localRect.height() / 2);
    paramImageView.setImageMatrix(localMatrix);
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        i = DisplayUtil.a(paramView.getContext(), 250.0F);
        int j = DisplayUtil.a(paramView.getContext(), 120.0F);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(i, j);
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        j = localRect.right - localRect.left;
        int m = localRect.bottom - localRect.top;
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        float f1;
        int n;
        int i2;
        int k;
        if ((this.g == 51) || (this.g == 52))
        {
          i = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable().getIntrinsicWidth();
          setWidth(getWidth() + i);
          if (this.g == 51)
          {
            i = (i + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth()) * -1;
            if (this.e == 83)
            {
              f1 = (localRect.centerY() - arrayOfInt[1]) / m;
              paramInt2 = (int)((paramView.getHeight() + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight()) / 2 - f1 * this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth() / 2.0F) * -1;
              paramInt1 = i;
              n = arrayOfInt[0] + paramInt1;
              i2 = getWidth();
              int i1 = arrayOfInt[1] + paramInt2;
              int i3 = i1 + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight();
              k = 0;
              i = 0;
              if ((this.g != 51) && (this.g != 52)) {
                continue;
              }
              if (i3 > m - this.d) {
                i = i3 - (m - this.d);
              }
              j = paramInt1;
              if (i1 < localRect.top + this.d)
              {
                i = localRect.top + this.d - i1;
                j = paramInt1;
              }
              c(paramView, j, i);
              super.showAsDropDown(paramView, j, i + paramInt2);
              if (this.f <= 0) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new WeakReference(this)), this.f * 1000);
            }
          }
          else
          {
            if (this.g != 52) {
              break label670;
            }
            i = paramView.getWidth() + i;
            continue;
          }
          paramInt1 = i;
          if (this.e != 82) {
            continue;
          }
          paramInt2 = (paramView.getHeight() + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight()) * -1 / 2;
          paramInt1 = i;
          continue;
        }
        else
        {
          i = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable().getIntrinsicHeight();
          if (this.g == 49) {
            paramInt2 = (i + (this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight() + paramView.getHeight())) * -1;
          }
          if (this.e == 83)
          {
            f1 = (localRect.centerX() - arrayOfInt[0]) / j;
            float f2 = (paramView.getWidth() - getWidth()) / 2;
            paramInt1 = (int)(f1 * getWidth() / 2.0F + f2);
            continue;
          }
          if (this.e != 82) {
            break label667;
          }
          paramInt1 = (paramView.getWidth() - getWidth()) / 2;
          continue;
        }
        if (n + i2 > j - this.d) {
          paramInt1 = j - this.d - getWidth() - arrayOfInt[0];
        }
        i = k;
        j = paramInt1;
        if (n >= localRect.left + this.d) {
          continue;
        }
        paramInt1 = localRect.left;
        i = this.d;
        j = arrayOfInt[0];
        j = paramInt1 + i - j;
        i = k;
        continue;
        continue;
      }
      catch (Exception paramView)
      {
        Log.e("CalloutPopupWindow", "[showInternal] failed to show window", paramView);
        return;
      }
      label667:
      label670:
      int i = paramInt1;
    }
  }
  
  private void c(View paramView, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((this.g == 51) || (this.g == 52))
    {
      paramInt1 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight();
      i = localDrawable.getIntrinsicHeight();
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, (paramInt1 - i) / 2 - paramInt2, 0, 0);
      return;
    }
    paramInt2 = paramView.getWidth();
    int i = localDrawable.getIntrinsicWidth();
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding((paramInt2 - i) / 2 - paramInt1, 0, 0, 0);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(View paramView)
  {
    a(paramView, 0, 0);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView.getWidth() == 0) && (paramView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new xvw(this, paramView, paramInt1, paramInt2));
      return;
    }
    b(paramView, paramInt1, paramInt2);
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(paramDrawable);
    super.setBackgroundDrawable(new ColorDrawable());
  }
  
  public void setContentView(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    switch (this.g)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, -2, -2);
      super.setContentView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -2, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, -2, -2);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.h);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\calloutpopupwindow\CalloutPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */