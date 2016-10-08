package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import wkv;
import wkx;

public class AutoSwitchIconView
  extends RelativeLayout
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public ScaleAnimation a;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  int b;
  public ScaleAnimation b;
  
  public AutoSwitchIconView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AutoSwitchIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c);
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(0);
    this.jdField_a_of_type_Float = paramAttributeSet.getDimension(1, 13.0F);
    this.jdField_a_of_type_Int = paramAttributeSet.getColor(2, paramContext.getResources().getColor(2131427407));
    this.jdField_b_of_type_Int = ((int)paramAttributeSet.getDimension(3, AIOUtils.a(15.0F, paramContext.getResources())));
    paramAttributeSet.recycle();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramAttributeSet = new LinearLayout(paramContext);
      paramAttributeSet.setOrientation(0);
      paramAttributeSet.setVerticalGravity(15);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
      localLayoutParams.gravity = 16;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841025);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130841025));
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, AIOUtils.a(1.0F, paramContext.getResources()));
      paramAttributeSet.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = AIOUtils.a(3.0F, paramContext.getResources());
      localLayoutParams.gravity = 16;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      paramAttributeSet.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      int i = AIOUtils.a(3.0F, getResources());
      int j = AIOUtils.a(10.0F, getResources());
      paramAttributeSet.setPadding(j, i, j, i);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(13);
      addView(paramAttributeSet, paramContext);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    paramContext = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841025);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130841025));
    paramContext.addRule(13);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, paramContext);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, this.jdField_b_of_type_Int / 2.0F, this.jdField_b_of_type_Int / 2.0F);
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setInterpolator(new DecelerateInterpolator(1.3F));
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new wkv(this));
    }
    if (this.jdField_b_of_type_AndroidViewAnimationScaleAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, this.jdField_b_of_type_Int / 2.0F, this.jdField_b_of_type_Int / 2.0F);
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(150L);
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setInterpolator(new AccelerateInterpolator(1.3F));
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new wkx(this));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
  }
  
  public void setIconSize(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\AutoSwitchIconView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */