package com.tencent.mobileqq.dating.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import rgm;
import rgn;

public class CustomTabBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 400;
  private long jdField_a_of_type_Long = 400L;
  private Context jdField_a_of_type_AndroidContentContext;
  public ImageView a;
  private CustomTabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView$OnTabChangeListener;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private long[] jdField_a_of_type_ArrayOfLong = { 0L, 0L, 0L };
  public TextView[] a;
  private boolean b;
  public int f = 3;
  private int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = CustomTabBarView.class.getSimpleName();
  }
  
  public CustomTabBarView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
    a(paramContext, 2130904133);
  }
  
  public CustomTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
    a(paramContext, 2130904133);
  }
  
  private View a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException(jdField_a_of_type_JavaLangString + "init context is null.");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(paramInt, this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramContext.findViewById(2131301524));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramContext.findViewById(2131301526));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramContext.findViewById(2131301527));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131301528));
    paramInt = 0;
    while (paramInt <= 2)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(this);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setSingleLine(true);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setEllipsize(TextUtils.TruncateAt.END);
      paramInt += 1;
    }
    setClickable(false);
    setOnClickListener(null);
    this.g = ((int)(getResources().getDisplayMetrics().density * 51.0F + 0.5D));
    this.jdField_a_of_type_Boolean = false;
    setBackgroundColor(getResources().getColor(2131428296));
    View localView1 = paramContext.findViewById(2131301522);
    View localView2 = paramContext.findViewById(2131301523);
    paramInt = getResources().getColor(2131428199);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramContext.findViewById(2131301525).setBackgroundColor(paramInt);
    return paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].setClickable(false);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].setOnClickListener(null);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].setTextColor(getResources().getColor(2131428311));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    StringBuilder localStringBuilder;
    if (paramInt1 >= 1000000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("看过 ");
      localStringBuilder.append(paramInt1 / 10000);
      localStringBuilder.append("万");
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(localStringBuilder.toString());
      if (paramInt2 < 1000000) {
        break label293;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("评论 ");
      localStringBuilder.append(paramInt1 / 10000);
      localStringBuilder.append("万");
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1].setText(localStringBuilder.toString());
      label115:
      if (paramInt3 < 1000000) {
        break label321;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("报名 ");
      localStringBuilder.append(paramInt1 / 10000);
      localStringBuilder.append("万");
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].setText(localStringBuilder.toString());
      label171:
      this.jdField_a_of_type_Boolean = false;
      requestLayout();
      if (!AppSetting.j) {
        return;
      }
      paramInt1 = i;
      label189:
      if (paramInt1 > 2) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt1].getText().toString());
      if (paramInt1 != 0) {
        break label349;
      }
      localStringBuilder.append(",进入看过的人列表 按钮.");
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt1].setContentDescription(this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt1].getText().toString());
      paramInt1 += 1;
      break label189;
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(String.format("看过 %d", new Object[] { Integer.valueOf(paramInt1) }));
      break;
      label293:
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1].setText(String.format("评论 %d", new Object[] { Integer.valueOf(paramInt2) }));
      break label115;
      label321:
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].setText(String.format("报名 %d", new Object[] { Integer.valueOf(paramInt3) }));
      break label171;
      label349:
      if (paramInt1 == 1) {
        localStringBuilder.append(",进入评论列表 按钮.");
      } else if (paramInt1 == 2) {
        localStringBuilder.append(",进入报名的人列表 按钮.");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      removeAllViews();
      a(this.jdField_a_of_type_AndroidContentContext, 2130904134).findViewById(2131301529).setBackgroundColor(getResources().getColor(2131428199));
      setCurrentTab(this.f);
    }
    this.b = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1]) {
      if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ArrayOfLong[1] > this.jdField_a_of_type_Long)
      {
        setCurrentTab(1);
        this.jdField_a_of_type_ArrayOfLong[1] = SystemClock.elapsedRealtime();
      }
    }
    do
    {
      do
      {
        return;
        if (paramView != this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2]) {
          break;
        }
      } while (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ArrayOfLong[2] <= this.jdField_a_of_type_Long);
      setCurrentTab(2);
      this.jdField_a_of_type_ArrayOfLong[2] = SystemClock.elapsedRealtime();
      return;
    } while ((paramView != this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0]) || (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ArrayOfLong[0] <= this.jdField_a_of_type_Long));
    setCurrentTab(0);
    this.jdField_a_of_type_ArrayOfLong[0] = SystemClock.elapsedRealtime();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
      paramInt1 = i;
      while (paramInt1 <= 2)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt1] = (this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt1].getLeft() + (this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt1].getMeasuredWidth() - this.g) / 2);
        paramInt1 += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.layout(this.jdField_a_of_type_ArrayOfInt[this.f], this.jdField_a_of_type_AndroidWidgetImageView.getTop(), this.jdField_a_of_type_ArrayOfInt[this.f] + this.g, this.jdField_a_of_type_AndroidWidgetImageView.getBottom());
  }
  
  public void setCurrentTab(int paramInt)
  {
    setCurrentTab(paramInt, false);
  }
  
  public void setCurrentTab(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    if ((paramInt > 2) || (paramInt < 0)) {}
    while (paramInt == this.f) {
      return;
    }
    int i = j;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = j;
    }
    if (i <= 2)
    {
      if (i == paramInt) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setTextColor(getResources().getColor(2131428268));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((!this.b) && (i == 2)) {
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setTextColor(getResources().getColor(2131428311));
        } else {
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setTextColor(getResources().getColor(2131428302));
        }
      }
    }
    if ((this.jdField_a_of_type_ArrayOfInt[paramInt] == 0) && (this.jdField_a_of_type_ArrayOfInt[this.f] == 0))
    {
      this.f = paramInt;
      return;
    }
    if (getVisibility() != 0)
    {
      this.f = paramInt;
      this.jdField_a_of_type_AndroidWidgetImageView.layout(this.jdField_a_of_type_ArrayOfInt[this.f], this.jdField_a_of_type_AndroidWidgetImageView.getTop(), this.jdField_a_of_type_ArrayOfInt[this.f] + this.g, this.jdField_a_of_type_AndroidWidgetImageView.getBottom());
      this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_ArrayOfInt[paramInt] - this.jdField_a_of_type_ArrayOfInt[this.f], 0.0F, 0.0F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new rgm(this));
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new rgn(this, paramInt, paramBoolean), 400L);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localTranslateAnimation);
  }
  
  public void setOnTabChangeListener(CustomTabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView$OnTabChangeListener = paramOnTabChangeListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\widget\CustomTabBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */