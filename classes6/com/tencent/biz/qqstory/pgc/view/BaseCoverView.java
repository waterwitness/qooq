package com.tencent.biz.qqstory.pgc.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.biz.qqstory.view.widget.StrokeTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ilv;
import ilw;

public abstract class BaseCoverView
  extends RelativeLayout
{
  public int a;
  public ObjectAnimator a;
  public View a;
  protected TranslateAnimation a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  protected QQStoryContentActivity a;
  public Story a;
  protected SplitedProgressBar a;
  public StrokeTextView a;
  public boolean a;
  public int b;
  public ObjectAnimator b;
  protected View b;
  public TranslateAnimation b;
  public ImageView b;
  public ObjectAnimator c;
  public ImageView c;
  
  public BaseCoverView(Context paramContext, Story paramStory)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory = paramStory;
    LayoutInflater.from(getContext()).inflate(2130904466, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302833));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView = ((StrokeTextView)findViewById(2131302834));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302835));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302836));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297122));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302837));
    this.jdField_a_of_type_AndroidViewView = ((TextView)findViewById(2131302838));
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)findViewById(2131302839));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131302833));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView = ((StrokeTextView)super.findViewById(2131302834));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302837));
    this.jdField_a_of_type_AndroidViewView = ((TextView)super.findViewById(2131302838));
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)super.findViewById(2131302839));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131302731);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity = ((QQStoryContentActivity)paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setShowMaxCount(50);
  }
  
  private void a(ObjectAnimator paramObjectAnimator, long paramLong)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(paramObjectAnimator);
    localAnimatorSet.setStartDelay(paramLong);
    localAnimatorSet.start();
  }
  
  public void a()
  {
    a(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(paramInt);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.clearAnimation();
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    if (this.jdField_c_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_c_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    super.removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(this.jdField_b_of_type_Int, 0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ilv(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ilw(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void f()
  {
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void g() {}
  
  public void h() {}
  
  public void setIndex(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(paramInt2);
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(paramInt1, 0);
  }
  
  public void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTipsClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
  }
  
  public void setTips(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setText(paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setStrokeColor(Color.argb(127, 0, 0, 0));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\BaseCoverView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */