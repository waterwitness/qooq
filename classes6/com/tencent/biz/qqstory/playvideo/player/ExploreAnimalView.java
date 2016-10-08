package com.tencent.biz.qqstory.playvideo.player;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.view.widget.StrokeTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ipo;
import ipp;

public class ExploreAnimalView
  extends RelativeLayout
{
  protected AnimatorSet a;
  public AlphaAnimation a;
  protected TranslateAnimation a;
  public LinearLayout a;
  public StrokeTextView a;
  public TranslateAnimation b;
  
  public ExploreAnimalView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ExploreAnimalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExploreAnimalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(getContext(), 2130904505, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302833));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView = ((StrokeTextView)findViewById(2131302834));
  }
  
  private void a(View paramView, long paramLong)
  {
    paramView.setAlpha(0.0F);
    paramView.setVisibility(0);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    paramView.setDuration(1200L);
    paramView.setRepeatCount(-1);
    paramView.setRepeatMode(-1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(paramView);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setStartDelay(paramLong);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.b.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.b = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.b.setDuration(300L);
    this.b.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ipo(this));
    this.b.setAnimationListener(new ipp(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void a(int paramInt)
  {
    this.b = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.b.setDuration(paramInt);
    this.b.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.b);
  }
  
  public void b()
  {
    this.b = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.b.setDuration(300L);
    this.b.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.b);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.b.cancel();
      this.b = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  public void setText(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setText(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      a();
    }
    while (paramInt != 4) {
      return;
    }
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\player\ExploreAnimalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */