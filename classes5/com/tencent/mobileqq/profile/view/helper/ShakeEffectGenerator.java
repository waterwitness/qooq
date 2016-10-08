package com.tencent.mobileqq.profile.view.helper;

import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import txu;

public class ShakeEffectGenerator
{
  private static final int jdField_a_of_type_Int = 50;
  private static final int b = 80;
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_a_of_type_Boolean;
  private final int c;
  private final int d;
  private int e;
  private int f;
  
  public ShakeEffectGenerator(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new txu(this);
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.c = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 15.0F);
      this.d = ((int)(this.c / 1.5D));
      return;
    }
    throw new IllegalArgumentException("Wrapped View shouldn't be null!");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.e = 0;
    this.f = 0;
    for (;;)
    {
      int j = (int)(this.d * (Math.random() * 2.0D - 1.0D));
      int i = (int)Math.sqrt(this.d * this.d - j * j);
      if (Math.random() > 0.5D) {}
      while ((this.e + j) * (this.e + j) + (this.f + i) * (this.f + i) <= this.c * this.c)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(this.e, this.e + j, this.f, this.f + i);
        this.e = (j + this.e);
        this.f = (i + this.f);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(this.d * (int)(50.0D + Math.random() * 30.0D));
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        return;
        i = -i;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getAnimation() == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (a()) {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\helper\ShakeEffectGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */