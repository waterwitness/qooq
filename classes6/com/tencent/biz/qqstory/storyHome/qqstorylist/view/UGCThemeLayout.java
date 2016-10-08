package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class UGCThemeLayout
  extends RelativeLayout
{
  protected View a;
  protected ImageView a;
  protected TextView a;
  protected ImageView b;
  protected ImageView c;
  
  public UGCThemeLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public UGCThemeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public UGCThemeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2130904498, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302958));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302954));
    this.b = ((ImageView)findViewById(2131302955));
    this.c = ((ImageView)findViewById(2131302959));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302957);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ((int)(ScreenUtil.b * 0.5D));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    setMaskAlpha(0.3F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      paramMotionEvent = new ScaleAnimation(1.0F, 0.95F, 1.0F, 0.95F, 1, 0.5F, 1, 0.5F);
      paramMotionEvent.setDuration(300L);
      paramMotionEvent.setFillAfter(true);
      startAnimation(paramMotionEvent);
      paramMotionEvent = new AlphaAnimation(0.3F, 0.7F);
      paramMotionEvent.setDuration(300L);
      paramMotionEvent.setFillAfter(true);
      this.b.startAnimation(paramMotionEvent);
    }
    for (;;)
    {
      return true;
      if ((i == 3) || (i == 1))
      {
        paramMotionEvent = new ScaleAnimation(0.95F, 1.0F, 0.95F, 1.0F, 1, 0.5F, 1, 0.5F);
        paramMotionEvent.setDuration(300L);
        paramMotionEvent.setFillAfter(true);
        startAnimation(paramMotionEvent);
        paramMotionEvent = new AlphaAnimation(0.7F, 0.3F);
        paramMotionEvent.setDuration(300L);
        paramMotionEvent.setFillAfter(true);
        this.b.startAnimation(paramMotionEvent);
        if (i == 1) {
          super.performClick();
        }
      }
    }
  }
  
  public void setMaskAlpha(float paramFloat)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    this.b.startAnimation(localAlphaAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\UGCThemeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */