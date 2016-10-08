package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mio;
import mqq.app.Constants.LogoutReason;

public class RegisterGuideActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final float jdField_a_of_type_Float = 0.95F;
  private static final int jdField_a_of_type_Int = 800;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  
  public RegisterGuideActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    int i = (int)(getResources().getDisplayMetrics().heightPixels * 0.15F);
    int j = getResources().getDimensionPixelSize(2131493443);
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = Math.max(i, j);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  private void b()
  {
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(super.getResources(), super.getAssets().open("splash.png"));
      if (localBitmapDrawable != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localBitmapDrawable);
        int i = super.getResources().getDisplayMetrics().widthPixels;
        int j = super.getResources().getDisplayMetrics().heightPixels;
        int k = localBitmapDrawable.getIntrinsicHeight() * i / localBitmapDrawable.getIntrinsicWidth();
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new RelativeLayout.LayoutParams(i, k));
        if (k <= j)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          return;
        }
        if (k > j)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void c()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.0F, 0.95F, 1.0F, 0.95F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(800L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(this.jdField_a_of_type_AndroidViewView.getHeight() / 2));
    localTranslateAnimation.setDuration(800L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setFillAfter(true);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(800L);
    ((Animation)localObject).setFillBefore(true);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
  }
  
  public void doOnBackPressed()
  {
    finish();
    if ((getAppRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)super.getAppRuntime()).b(false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903394);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298408));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297952);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    a();
    b();
    super.findViewById(2131298409).setOnClickListener(this);
    super.findViewById(2131298410).setOnClickListener(this);
    return true;
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      new Handler().post(new mio(this));
    }
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298409: 
      paramView = getIntent();
      paramView.setClass(this, LoginActivity.class);
      paramView.addFlags(67108864);
      paramView.putExtra("from_register_guide", true);
      super.startActivity(paramView);
      finish();
      return;
    }
    paramView = new Intent(this, RegisterPhoneNumActivity.class);
    paramView.putExtra("leftViewText", super.getString(2131367975));
    paramView.addFlags(67108864);
    super.startActivity(paramView);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\RegisterGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */