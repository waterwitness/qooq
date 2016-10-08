package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import wmz;
import wna;
import wnb;
import wnc;

public class PaFlashLightView
  extends LinearLayout
{
  public static final int a = 1;
  public static final int b = 2;
  public Animation a;
  public URLImageView a;
  public wnc a;
  public boolean a;
  public Animation b;
  public URLImageView b;
  public int c;
  public Animation c;
  public URLImageView c;
  
  public PaFlashLightView(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Wnc = new wnc(this);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setGravity(17);
    setOrientation(1);
    Drawable localDrawable = getResources().getDrawable(2131427379);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    try
    {
      paramString1 = URLDrawableHelper.a(paramString1, localDrawable, localDrawable);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString1);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
      paramString1 = new LinearLayout.LayoutParams(-2, -2);
      paramString1.gravity = 1;
      this.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams(paramString1);
    }
    catch (Exception paramString1)
    {
      try
      {
        paramString1 = URLDrawableHelper.a(paramString2, localDrawable, localDrawable);
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramString1);
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
        addView(this.jdField_b_of_type_ComTencentImageURLImageView);
        this.jdField_c_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
        paramContext = new LinearLayout.LayoutParams(-2, -2);
        paramContext.gravity = 5;
        this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams(paramContext);
      }
      catch (Exception paramString1)
      {
        try
        {
          for (;;)
          {
            paramContext = URLDrawableHelper.a(paramString3, localDrawable, localDrawable);
            this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramContext);
            this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(8);
            addView(this.jdField_c_of_type_ComTencentImageURLImageView);
            this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.01F, 1.0F);
            this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(150L);
            this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(0);
            this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new wmz(this));
            this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.01F, 1.0F);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(1150L);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(0);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(new wna(this));
            this.jdField_c_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.01F);
            this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(800L);
            this.jdField_c_of_type_AndroidViewAnimationAnimation.setRepeatCount(0);
            this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(new wnb(this));
            return;
            paramString1 = paramString1;
            paramString1.printStackTrace();
          }
          paramString1 = paramString1;
          paramString1.printStackTrace();
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Wnc.sendEmptyMessageDelayed(this.jdField_c_of_type_Int, 1200L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\PaFlashLightView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */