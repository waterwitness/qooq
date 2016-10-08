package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import jkz;
import jla;
import jlb;

public class GalleryPageView
  extends AbstractGalleryPageView
{
  public int a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public TextView a;
  public AbstractGalleryScene a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  public AlphaAnimation b;
  
  public GalleryPageView()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaLangRunnable = new jlb(this);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.b = new AlphaAnimation(1.0F, 0.0F);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public void a(Activity paramActivity, AbstractGalleryScene paramAbstractGalleryScene, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAbstractGalleryScene.a();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, this.jdField_a_of_type_Int, paramActivity.getResources().getDisplayMetrics()) + paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#e6e9e9e9"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296415);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.b.setDuration(300L);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene = paramAbstractGalleryScene;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new jkz(this));
    this.b.setAnimationListener(new jla(this));
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (paramAdapterView.d_() > 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "/" + paramAdapterView.d_());
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 4)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\galleryactivity\GalleryPageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */