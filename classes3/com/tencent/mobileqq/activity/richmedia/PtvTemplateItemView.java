package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import pdj;

public class PtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final int a = 54;
  public static final int b = 3;
  public static final int c = 50;
  public static final int d = 70;
  public static final int e = 20;
  public static final int f = 2;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  PtvTemplateAdapter.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback;
  PtvTemplateItemView.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  View jdField_b_of_type_AndroidViewView;
  CircleProgress jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress;
  int g;
  
  public PtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PtvTemplateItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    setOrientation(0);
    int k = AIOUtils.a(54.0F, getResources());
    int m = AIOUtils.a(50.0F, getResources());
    int j = AIOUtils.a(70.0F, getResources());
    int n = AIOUtils.a(20.0F, getResources());
    int i1 = getResources().getColor(2131428262);
    int i2 = getResources().getColor(2131427713);
    int i3 = AIOUtils.a(18.0F, getResources());
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = j;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new RelativeLayout.LayoutParams(m, m);
    this.jdField_a_of_type_ComTencentImageURLImageView.setMinimumWidth(m);
    this.jdField_a_of_type_ComTencentImageURLImageView.setMinimumHeight(m);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = new CircleProgress(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(n, n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumHeight(n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumWidth(n);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(2.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, i1, 100, i2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(i3, i3);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841250);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(2.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress = new CircleProgress(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(3.0F);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, 1226741, 100, 1226741);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumWidth(k);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumHeight(k);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(k, k);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress, (ViewGroup.LayoutParams)localObject);
    paramInt2 = (paramInt1 - k) / 2;
    localObject = new LinearLayout.LayoutParams(paramInt2, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(k, k);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(paramInt2, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_b_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    if (AudioHelper.b()) {
      QLog.d("PtvTemplateItemView", 4, String.format("[%s]初始化View, itemWidth[%s], fullHeight[%s], thumbWidthWithCircle[%s], thumbWidth[%s], itemHeight[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) }));
    }
  }
  
  public void a(int paramInt, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateAdapter.IPtvTemplateItemCallback paramIPtvTemplateItemCallback)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setTag(paramPtvTemplateInfo);
      this.g = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback = paramIPtvTemplateItemCallback;
      if (!TextUtils.isEmpty(paramPtvTemplateInfo.id)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (!TextUtils.isEmpty(paramPtvTemplateInfo.iconurl))
    {
      paramIPtvTemplateItemCallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt = AIOUtils.a(50.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131427623));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      paramIPtvTemplateItemCallback.mRequestWidth = paramInt;
      paramIPtvTemplateItemCallback.mRequestHeight = paramInt;
      paramIPtvTemplateItemCallback.mFailedDrawable = localGradientDrawable;
      paramIPtvTemplateItemCallback.mLoadingDrawable = localGradientDrawable;
      paramIPtvTemplateItemCallback = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, paramIPtvTemplateItemCallback);
      paramIPtvTemplateItemCallback.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
      paramIPtvTemplateItemCallback.setDecodeHandler(URLDrawableDecodeHandler.a);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramIPtvTemplateItemCallback);
      if ((!paramPtvTemplateInfo.usable) && (!paramPtvTemplateInfo.id.equals("0"))) {
        break label256;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      return;
      if (!"0".equals(paramPtvTemplateInfo.id)) {
        break;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843537);
      break;
      label256:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateItemView.IPtvTemplateItemCallback paramIPtvTemplateItemCallback)
  {
    int i = 4;
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setId(paramInt);
      setTag(paramPtvTemplateInfo);
      this.g = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback = paramIPtvTemplateItemCallback;
      if (!TextUtils.isEmpty(paramPtvTemplateInfo.id)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if ("0".equals(paramPtvTemplateInfo.id)) {
      if (TextUtils.isEmpty(paramPtvTemplateInfo.iconurl)) {
        break label388;
      }
    }
    label129:
    label377:
    label388:
    for (paramInt = Integer.valueOf(paramPtvTemplateInfo.iconurl).intValue();; paramInt = 0)
    {
      if (paramInt > 0)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(paramInt);
        if ((!paramPtvTemplateInfo.usable) && (!paramPtvTemplateInfo.id.equals("0"))) {
          break label377;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        paramPtvTemplateInfo = this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress;
        paramInt = i;
        if (paramBoolean1) {
          paramInt = 0;
        }
        paramPtvTemplateInfo.setVisibility(paramInt);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(false);
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new pdj(this));
        return;
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843537);
        break label129;
        if (TextUtils.isEmpty(paramPtvTemplateInfo.iconurl)) {
          break label129;
        }
        paramIPtvTemplateItemCallback = URLDrawable.URLDrawableOptions.obtain();
        paramInt = AIOUtils.a(50.0F, getResources());
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(getResources().getColor(2131427623));
        localGradientDrawable.setShape(1);
        localGradientDrawable.setSize(paramInt, paramInt);
        paramIPtvTemplateItemCallback.mRequestWidth = paramInt;
        paramIPtvTemplateItemCallback.mRequestHeight = paramInt;
        paramIPtvTemplateItemCallback.mFailedDrawable = localGradientDrawable;
        paramIPtvTemplateItemCallback.mLoadingDrawable = localGradientDrawable;
        paramIPtvTemplateItemCallback = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, paramIPtvTemplateItemCallback);
        paramIPtvTemplateItemCallback.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
        if (paramBoolean2) {
          paramIPtvTemplateItemCallback.setDecodeHandler(URLDrawableDecodeHandler.a);
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramIPtvTemplateItemCallback);
        break label129;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(255, 224, 176, 216));
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(Color.argb(255, 168, 168, 236));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(255, 152, 252, 209));
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.argb(255, 221, 225, 179));
    if ((paramPtvTemplateInfo != null) && ("0".equals(paramPtvTemplateInfo.id)))
    {
      setBackgroundColor(-16711681);
      return;
    }
    setBackgroundColor(-7829368);
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 100)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (paramInt < 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback.a(this.g);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateItemView$IPtvTemplateItemCallback.a(this.g);
    }
  }
  
  public void setHightlight(boolean paramBoolean)
  {
    CircleProgress localCircleProgress = this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localCircleProgress.setVisibility(i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\PtvTemplateItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */