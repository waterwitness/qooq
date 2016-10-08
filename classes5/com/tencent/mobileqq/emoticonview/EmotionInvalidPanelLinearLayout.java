package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class EmotionInvalidPanelLinearLayout
  extends LinearLayout
{
  public static final int a = 3;
  public static final String a = "ClassicEmoticonPanelView";
  public static final int b = 4;
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  private boolean jdField_a_of_type_Boolean;
  protected int c;
  private int d;
  private int e;
  
  public EmotionInvalidPanelLinearLayout(Context paramContext, EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.jdField_a_of_type_Float = super.getContext().getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 4) {}
    for (bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.d = paramInt1;
      this.e = paramInt2;
      new DisplayMetrics();
      this.c = paramContext.getResources().getDisplayMetrics().widthPixels;
      super.setOrientation(1);
      a();
      return;
    }
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    super.removeAllViews();
    int i = 0;
    while (i < this.d)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      int j = (int)(72.0F * this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_Boolean) {
        j = (this.c - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7;
      }
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, j);
      localLinearLayout.setOrientation(0);
      label109:
      Object localObject1;
      Object localObject3;
      if (this.jdField_a_of_type_Boolean)
      {
        localLayoutParams.topMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
        j = 0;
        if (j >= this.e) {
          break label605;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label273;
        }
        localObject1 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject1).setId(2131296394);
        int k = (this.c - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7;
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
        ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((URLImageView)localObject1).setVisibility(8);
        ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        ((URLImageView)localObject1).setAdjustViewBounds(false);
        ((URLImageView)localObject1).setFocusable(true);
        ((URLImageView)localObject1).setFocusableInTouchMode(true);
        localLinearLayout.addView((View)localObject1);
      }
      for (;;)
      {
        j += 1;
        break label109;
        if (i == 0)
        {
          localLayoutParams.topMargin = ((int)(16.0F * this.jdField_a_of_type_Float));
          break;
        }
        localLayoutParams.topMargin = ((int)(14.0F * this.jdField_a_of_type_Float));
        break;
        label273:
        localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject1 = new LinearLayout.LayoutParams(this.c / this.e, (int)(72.0F * this.jdField_a_of_type_Float));
        ((RelativeLayout)localObject3).setFocusable(true);
        ((RelativeLayout)localObject3).setFocusableInTouchMode(true);
        ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        try
        {
          localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
          if (localObject1 != null)
          {
            ((TextView)localObject1).setVisibility(8);
            ((TextView)localObject1).setId(2131296396);
            ((TextView)localObject1).setTextSize(11.0F);
            localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams1.addRule(12);
            localLayoutParams1.addRule(14);
            localLayoutParams1.topMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
            ((RelativeLayout)localObject3).addView((View)localObject1, localLayoutParams1);
          }
          localObject1 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
          ((URLImageView)localObject1).setId(2131296394);
          RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(56.0F * this.jdField_a_of_type_Float), (int)(56.0F * this.jdField_a_of_type_Float));
          localLayoutParams1.addRule(13, -1);
          localLayoutParams1.addRule(2, 2131296396);
          localLayoutParams1.addRule(14);
          ((URLImageView)localObject1).setVisibility(8);
          ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
          ((URLImageView)localObject1).setAdjustViewBounds(false);
          ((RelativeLayout)localObject3).addView((View)localObject1, localLayoutParams1);
          localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject1).setId(2131296395);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(7, 2131296394);
          localLayoutParams1.addRule(8, 2131296394);
          ((RelativeLayout)localObject3).addView((View)localObject1, localLayoutParams1);
          if (AppSetting.j) {
            ((RelativeLayout)localObject3).setFocusable(true);
          }
          if (AppSetting.j) {
            ((RelativeLayout)localObject3).setFocusable(true);
          }
          localLinearLayout.addView((View)localObject3);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
      label605:
      super.addView(localLinearLayout, localLayoutParams);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassicEmoticonPanelView", 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - l) + "issmallemotion = " + this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionInvalidPanelLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */