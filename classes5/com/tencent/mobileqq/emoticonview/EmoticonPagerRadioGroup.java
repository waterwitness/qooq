package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import rkl;

public class EmoticonPagerRadioGroup
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final int jdField_b_of_type_Int = 2;
  private static final int jdField_c_of_type_Int = 3;
  private static final int d = 4;
  private static int g = 1;
  private static int h = 2;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton = a(2);
  private boolean jdField_a_of_type_Boolean;
  RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  RadioButton jdField_c_of_type_AndroidWidgetRadioButton;
  private int e = -1;
  private int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EmoticonPagerRadioGroup(Context paramContext)
  {
    super(paramContext);
    this.b = a(3);
    this.c = a(4);
  }
  
  public EmoticonPagerRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = a(3);
    this.c = a(4);
  }
  
  private RadioButton a(int paramInt)
  {
    float f1 = 13.0F;
    float f2 = 10.0F;
    rkl localrkl = new rkl(this, getContext());
    Resources localResources;
    if (paramInt == 2)
    {
      localrkl.setButtonDrawable(2130841714);
      localrkl.setGravity(17);
      localResources = super.getContext().getResources();
      if (paramInt != 2) {
        break label209;
      }
      f1 = 15.0F;
      f2 = 15.0F;
    }
    for (;;)
    {
      RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, f1, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, f2, localResources.getDisplayMetrics()));
      localLayoutParams.gravity = 17;
      int i = (int)TypedValue.applyDimension(1, 3.0F, localResources.getDisplayMetrics());
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      localrkl.setLayoutParams(localLayoutParams);
      localrkl.setClickable(true);
      if ((AppSetting.j) && (paramInt != 3) && (paramInt != 2))
      {
        localrkl.setClickable(false);
        localrkl.setFocusable(false);
      }
      return localrkl;
      if (paramInt == 3)
      {
        localrkl.setButtonDrawable(2130841715);
        break;
      }
      if (paramInt == 4)
      {
        localrkl.setButtonDrawable(2130837758);
        break;
      }
      localrkl.setButtonDrawable(2130838487);
      break;
      label209:
      if (paramInt == 3) {
        f1 = 24.0F;
      } else if (paramInt == 4) {
        f2 = 13.0F;
      } else {
        f1 = 10.0F;
      }
    }
  }
  
  public ViewPager a()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewViewPager;
  }
  
  public void a()
  {
    this.e = -1;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j;
    RadioButton localRadioButton;
    if (paramBoolean1)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        removeAllViews();
        j = SystemAndEmojiEmoticonInfo.m;
        int k = SystemAndEmojiEmoticonInfo.l;
        int m = Math.max(SystemAndEmojiEmoticonInfo.m, SystemAndEmojiEmoticonInfo.l);
        super.addView(this.b);
        paramInt = 0;
        while (paramInt < m)
        {
          super.addView(a(1));
          paramInt += 1;
        }
        super.addView(this.jdField_a_of_type_AndroidWidgetRadioButton);
        paramInt = i;
        while (paramInt < k + j - m - 2)
        {
          localRadioButton = a(1);
          localRadioButton.setVisibility(8);
          super.addView(localRadioButton);
          paramInt += 1;
        }
      }
    }
    else
    {
      super.removeView(this.jdField_a_of_type_AndroidWidgetRadioButton);
      super.removeView(this.b);
      removeAllViews();
      if (paramBoolean2) {
        super.addView(this.c);
      }
      this.e = -1;
      j = getChildCount();
      if (paramInt > j)
      {
        i = 0;
        while (i < paramInt - j)
        {
          super.addView(a(1));
          i += 1;
        }
      }
      if (paramInt < j)
      {
        i = j - 1;
        while (i >= paramInt)
        {
          super.removeViewAt(i);
          i -= 1;
        }
      }
      if ((paramInt > 0) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null))
      {
        localRadioButton = (RadioButton)super.getChildAt(0);
        if (!paramBoolean2) {
          localRadioButton.setButtonDrawable(2130838487);
        }
        localRadioButton.setChecked(true);
      }
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        ((RadioButton)super.getChildAt(paramInt)).setVisibility(0);
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Boolean = paramBoolean1;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int j;
    int k;
    int i;
    RadioButton localRadioButton;
    if (super.getChildCount() > paramInt)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label353;
      }
      j = SystemAndEmojiEmoticonInfo.m;
      k = SystemAndEmojiEmoticonInfo.l;
      if (((this.e != j) || (paramInt != j - 1)) && (paramInt != 0)) {
        break label212;
      }
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      if (j < k)
      {
        i = j + 1;
        while (i <= k)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      this.f = h;
      if (this.f != h) {
        break label343;
      }
      i = paramInt + 1;
      label171:
      this.e = paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (i >= super.getChildCount()) {
        paramInt = super.getChildCount() - 1;
      }
      localRadioButton = (RadioButton)super.getChildAt(paramInt);
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      return;
      label212:
      if ((paramInt != j) && (paramInt != j + k - 1)) {
        break;
      }
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      if (j < k)
      {
        i = j + 1;
        while (i <= k)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      this.f = g;
      break;
      label343:
      i = paramInt - (j - 1);
      break label171;
      label353:
      this.e = -1;
      i = paramInt;
    }
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmoticonPagerRadioGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */