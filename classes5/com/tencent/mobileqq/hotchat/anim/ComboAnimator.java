package com.tencent.mobileqq.hotchat.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import suy;

public class ComboAnimator
{
  public static final String a = "ComboAnimator";
  public static final int b;
  public static final int c;
  public float a;
  public int a;
  public Context a;
  public WindowManager.LayoutParams a;
  public WindowManager a;
  public RelativeLayout.LayoutParams a;
  public RelativeLayout a;
  public TextView a;
  public boolean a;
  public TextView b;
  public boolean b;
  public boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = (int)(BaseApplicationImpl.a().getResources().getDisplayMetrics().density * 12.0F + 0.5F);
    jdField_c_of_type_Int = (int)(BaseApplicationImpl.a().getResources().getDisplayMetrics().density * 12.0F + 0.5F);
  }
  
  public ComboAnimator(Context paramContext)
  {
    this.jdField_a_of_type_Float = 0.0125F;
    this.jdField_a_of_type_Int = 9999;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    boolean bool;
    if ((VersionUtils.e()) && (this.jdField_a_of_type_AndroidViewWindowManager != null))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(13);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(jdField_c_of_type_Int * 5, jdField_b_of_type_Int * 2, 2, 131112, -2);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
      paramContext = DeviceInfoUtil.h();
      if (paramContext == null) {
        break label180;
      }
      i = j;
      if (!paramContext.contains("Xiaomi")) {
        if (!paramContext.contains("xiaomi")) {
          break label180;
        }
      }
    }
    label180:
    for (int i = j;; i = 0)
    {
      if ((i != 0) && (Build.VERSION.SDK_INT == 15)) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
      bool = false;
      break;
    }
  }
  
  private TextView a()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setGravity(17);
    localTextView.setTextSize(1, 12.0F);
    localTextView.setTextColor(Color.parseColor("#f25d5d"));
    localTextView.setSingleLine(true);
    localTextView.setIncludeFontPadding(false);
    localTextView.setLayerType(2, null);
    return localTextView;
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 11.0F)), 0, 1, 18);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)), 1, paramString.length(), 18);
    paramTextView.setText(localSpannableStringBuilder);
  }
  
  private void c()
  {
    Animator localAnimator;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localAnimator = (Animator)this.jdField_a_of_type_AndroidWidgetTextView.getTag();
      if (localAnimator != null)
      {
        localAnimator.removeAllListeners();
        localAnimator.end();
      }
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localAnimator = (Animator)this.jdField_b_of_type_AndroidWidgetTextView.getTag();
      if (localAnimator != null)
      {
        localAnimator.removeAllListeners();
        localAnimator.end();
      }
    }
  }
  
  protected void a()
  {
    c();
    if ((this.jdField_a_of_type_AndroidViewWindowManager != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_b_of_type_AndroidWidgetTextView = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComboAnimator", 2, "stop removeViewImmediate mAnimContainer", localException);
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((!this.jdField_a_of_type_Boolean) || (paramInt1 <= 0))
    {
      bool = false;
      return bool;
    }
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Boolean = true;
      Object localObject1;
      if (paramInt1 > this.jdField_a_of_type_Int)
      {
        localObject1 = "x" + this.jdField_a_of_type_Int + "+";
        if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
          this.jdField_a_of_type_AndroidWidgetTextView = a();
        }
        if ((this.jdField_b_of_type_AndroidWidgetTextView == null) && (this.jdField_c_of_type_Boolean)) {
          this.jdField_b_of_type_AndroidWidgetTextView = a();
        }
        a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject1);
        if (this.jdField_c_of_type_Boolean) {
          a(this.jdField_b_of_type_AndroidWidgetTextView, (String)localObject1);
        }
        if (i != 0) {
          break label668;
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
          if (this.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
          }
        }
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = (paramInt2 - (int)(jdField_c_of_type_Int * 2.5F));
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (paramInt3 - jdField_b_of_type_Int);
      }
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        for (;;)
        {
          try
          {
            this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
            Object localObject2 = new Keyframe[4];
            localObject2[0] = Keyframe.ofFloat(0.0F, 1.0F);
            localObject2[1] = Keyframe.ofFloat(6.0F * this.jdField_a_of_type_Float, 1.5F);
            localObject2[2] = Keyframe.ofFloat(11.0F * this.jdField_a_of_type_Float, 1.0F);
            localObject2[3] = Keyframe.ofFloat(1.0F, 1.0F);
            localObject1 = PropertyValuesHolder.ofKeyframe("scaleX", (Keyframe[])localObject2);
            localObject2 = PropertyValuesHolder.ofKeyframe("scaleY", (Keyframe[])localObject2);
            localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetTextView, new PropertyValuesHolder[] { localObject1 }).setDuration(300L);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetTextView, new PropertyValuesHolder[] { localObject2 }).setDuration(300L);
            ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "alpha", new float[] { 1.0F, 0.5F }).setDuration(300L);
            AnimatorSet localAnimatorSet = new AnimatorSet();
            localAnimatorSet.addListener(new suy(this));
            localAnimatorSet.play(localObjectAnimator).with((Animator)localObject1).with((Animator)localObject2);
            localAnimatorSet.start();
            this.jdField_a_of_type_AndroidWidgetTextView.setTag(localAnimatorSet);
            if (!this.jdField_c_of_type_Boolean) {
              break;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.0F);
            localObject1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, "alpha", new float[] { 0.5F, 0.0F }).setDuration(300L);
            localObject2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, "scaleX", new float[] { 1.0F, 1.5F }).setDuration(300L);
            localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, "scaleY", new float[] { 1.0F, 1.5F }).setDuration(300L);
            localAnimatorSet = new AnimatorSet();
            localAnimatorSet.play((Animator)localObject1).with((Animator)localObject2).with(localObjectAnimator);
            localAnimatorSet.start();
            this.jdField_b_of_type_AndroidWidgetTextView.setTag(localAnimatorSet);
            return true;
            localObject1 = "x" + paramInt1;
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ComboAnimator", 2, "stop removeViewImmediate mAnimContainer", localException1);
            continue;
          }
          label668:
          WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          localLayoutParams.x = (paramInt2 - (int)(jdField_c_of_type_Int * 2.5F));
          localLayoutParams.y = (paramInt3 - jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\anim\ComboAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */