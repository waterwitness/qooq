package com.tencent.mobileqq.hotchat.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import svc;

public class HeartBeatAnimator
{
  public static final int a = 150;
  public static final String a = "HeartBeatAnimator";
  public static final int b;
  public static final int c = (int)(BaseApplicationImpl.a().getResources().getDisplayMetrics().density * 14.0F + 0.5F);
  public Context a;
  public WindowManager.LayoutParams a;
  public WindowManager a;
  public ImageView a;
  public RelativeLayout.LayoutParams a;
  public RelativeLayout a;
  public boolean a;
  public boolean b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = (int)(BaseApplicationImpl.a().getResources().getDisplayMetrics().density * 14.0F + 0.5F);
  }
  
  public HeartBeatAnimator(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    if ((VersionUtils.e()) && (this.jdField_a_of_type_AndroidViewWindowManager != null)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(jdField_b_of_type_Int * 2, jdField_b_of_type_Int * 2, 2, 131112, -2);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(jdField_b_of_type_Int, jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(13);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Animator localAnimator = (Animator)this.jdField_a_of_type_AndroidWidgetImageView.getTag();
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
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HeartBeatAnimator", 2, "stop removeViewImmediate mAnimContainer", localException);
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840821);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      if (i == 0)
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        }
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramInt1;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramInt2;
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
            localObject2[1] = Keyframe.ofFloat(0.2F, 1.2F);
            localObject2[2] = Keyframe.ofFloat(0.5F, 1.5F);
            localObject2[3] = Keyframe.ofFloat(1.0F, 1.0F);
            Object localObject1 = PropertyValuesHolder.ofKeyframe("scaleX", (Keyframe[])localObject2);
            localObject2 = PropertyValuesHolder.ofKeyframe("scaleY", (Keyframe[])localObject2);
            localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetImageView, new PropertyValuesHolder[] { localObject1 }).setDuration(150L);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetImageView, new PropertyValuesHolder[] { localObject2 }).setDuration(150L);
            AnimatorSet localAnimatorSet = new AnimatorSet();
            localAnimatorSet.addListener(new svc(this));
            localAnimatorSet.play((Animator)localObject1).with((Animator)localObject2);
            localAnimatorSet.start();
            this.jdField_a_of_type_AndroidWidgetImageView.setTag(localAnimatorSet);
            return true;
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("HeartBeatAnimator", 2, "stop removeViewImmediate mAnimContainer", localException1);
            continue;
          }
          WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          localLayoutParams.x = paramInt1;
          localLayoutParams.y = paramInt2;
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\anim\HeartBeatAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */