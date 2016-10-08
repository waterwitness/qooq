package com.tencent.mobileqq.apollo.store;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class ApolloWrapperCardView$ApolloCardView
  extends RelativeLayout
{
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ApolloBoxData.ApolloBoxDataItem jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData$ApolloBoxDataItem;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private final int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private final int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private final int jdField_g_of_type_Int;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  private final int s;
  private final int t;
  
  public ApolloWrapperCardView$ApolloCardView(float paramFloat1, float paramFloat2, float paramFloat3, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    float f1;
    if (paramFloat3 <= 0.0F)
    {
      f1 = ApolloWrapperCardView.jdField_b_of_type_Float;
      this.jdField_a_of_type_Float = f1;
      this.jdField_a_of_type_Int = ((int)(ApolloUtil.a(35.0F, ApolloBoxWindow.jdField_b_of_type_Float) * paramFloat3));
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = ((int)(0.756F * paramFloat1));
      this.jdField_d_of_type_Int = ((int)(0.743F * paramFloat2));
      this.jdField_e_of_type_Int = ((int)(0.69F * paramFloat2));
      this.jdField_f_of_type_Int = ((int)(0.176F * paramFloat2));
      this.jdField_g_of_type_Int = ((int)(0.12F * paramFloat2));
      this.h = ((int)(0.22F * paramFloat1));
      this.i = this.h;
      this.j = ((int)(0.054F * paramFloat1));
      this.k = ((int)(0.068F * paramFloat1));
      this.l = ((int)(paramFloat1 * 0.315F));
      this.m = ((int)(paramFloat1 * 0.04D));
      this.n = ((int)(paramFloat1 * 0.315F));
      this.o = ((int)(0.08F * paramFloat1));
      this.p = this.o;
      this.q = ((int)(0.318F * paramFloat2));
      this.r = ((int)(0.422F * paramFloat1));
      this.s = ((int)paramFloat1);
      this.t = ((int)paramFloat2);
      paramFloat2 = FontSettingManager.a() / 16.0F;
      paramFloat1 = paramFloat2;
      if (paramFloat2 == 0.0F) {
        paramFloat1 = 1.0F;
      }
      if (this.jdField_a_of_type_Float != ApolloWrapperCardView.jdField_a_of_type_Float) {
        break label277;
      }
      this.jdField_b_of_type_Float = (14.0F / paramFloat1);
      this.jdField_c_of_type_Float = (14.0F / paramFloat1);
    }
    for (this.jdField_d_of_type_Float = (12.0F / paramFloat1);; this.jdField_d_of_type_Float = (10.0F / paramFloat1))
    {
      label277:
      do
      {
        c();
        return;
        f1 = paramFloat3;
        break;
      } while ((this.jdField_a_of_type_Float != ApolloWrapperCardView.jdField_b_of_type_Float) && (this.jdField_a_of_type_Float != ApolloWrapperCardView.jdField_c_of_type_Float));
      this.jdField_b_of_type_Float = (11.0F / paramFloat1);
      this.jdField_c_of_type_Float = (11.0F / paramFloat1);
    }
  }
  
  private void c()
  {
    this.jdField_c_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_c_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    super.addView(this.jdField_c_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
    super.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.jdField_g_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Integer.MIN_VALUE);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("[套装]巴西假日");
    super.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(this.o, this.p);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.q;
    super.addView(this.jdField_b_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidWidgetImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject1 = new RelativeLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.jdField_f_of_type_Int;
    super.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(-1, this.n);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    super.addView(this.jdField_e_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    super.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(this.h, this.i);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.k;
    super.addView(this.jdField_d_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setGravity(16);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, this.n);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    super.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = this.l;
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(this.jdField_c_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, this.m, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("夏日的苹果");
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    ((LinearLayout)localObject1).addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = this.l;
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(this.jdField_d_of_type_Float);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1761607681);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("一年前");
    this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    ((LinearLayout)localObject1).addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(this.s, this.s);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_f_of_type_AndroidWidgetImageView.setBackgroundColor(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    super.addView(this.jdField_f_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_g_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(this.s, this.s);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_g_of_type_AndroidWidgetImageView.setBackgroundColor(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    super.addView(this.jdField_g_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(this.r, this.r);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(this.r * 0.27D) - this.r / 2);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(this.r * 0.315F) - this.r / 2);
    this.jdField_a_of_type_AndroidWidgetImageView.setRotation(30.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData$ApolloBoxDataItem == null) {}
    AnimationSet localAnimationSet;
    Object localObject;
    do
    {
      return;
      localAnimationSet = new AnimationSet(false);
      localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(600L);
      ((ScaleAnimation)localObject).setInterpolator(new OvershootInterpolator(1.5F));
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = (ViewGroup)super.getParent();
    } while (localObject == null);
    ((ViewGroup)localObject).startAnimation(localAnimationSet);
  }
  
  public void a(ApolloBoxData.ApolloBoxDataItem paramApolloBoxDataItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData$ApolloBoxDataItem = paramApolloBoxDataItem;
    if (paramApolloBoxDataItem == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Resources)localObject1).getDrawable(2130837718);
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = null;
    label166:
    int i1;
    if ("A".equals(paramApolloBoxDataItem.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837716);
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(ApolloImageDownloader.a("apollo_card_bg_a.png", (URLDrawable.URLDrawableOptions)localObject2, ApolloImageDownloader.a("apollo_card_bg_a.png")));
      if (!paramApolloBoxDataItem.jdField_a_of_type_Boolean) {
        break label700;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long) {
        break label638;
      }
      localObject1 = ApolloImageDownloader.a("apollo_has_got_20160615.png", null, ApolloImageDownloader.a("apollo_has_got_20160615.png"));
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      localObject1 = ApolloImageDownloader.a("apollo_has_got_blur_20160615.png", null, ApolloImageDownloader.a("apollo_has_got_blur_20160615.png"));
      this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramApolloBoxDataItem.jdField_b_of_type_Boolean) {
        break label693;
      }
      i1 = 0;
      label181:
      ((ImageView)localObject1).setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (paramApolloBoxDataItem.jdField_b_of_type_Int <= 0) {
        break label937;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.e;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = null;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.o;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.p;
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER);
      localObject1 = ApolloImageDownloader.a("apollo_diamond.png", (URLDrawable.URLDrawableOptions)localObject1, ApolloImageDownloader.a("apollo_diamond.png"));
      ((URLDrawable)localObject1).setTargetDensity(320);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      ((URLDrawable)localObject1).setBounds(0, 0, this.o, this.p);
      ((URLDrawable)localObject1).startDownload();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label346:
      if (3 != paramApolloBoxDataItem.jdField_a_of_type_Short) {
        break label949;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.e;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelper.e;
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = null;
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      localObject2 = new RelativeLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_e_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = this.jdField_f_of_type_Int;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      localObject1 = ApolloImageDownloader.a(String.valueOf(paramApolloBoxDataItem.jdField_a_of_type_Short) + "_" + String.valueOf(paramApolloBoxDataItem.jdField_a_of_type_Int), (URLDrawable.URLDrawableOptions)localObject1, ApolloImageDownloader.a(paramApolloBoxDataItem.jdField_a_of_type_Short, paramApolloBoxDataItem.jdField_a_of_type_Int));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramApolloBoxDataItem.jdField_a_of_type_JavaLangString);
      return;
      if ("B".equals(paramApolloBoxDataItem.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837717);
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(ApolloImageDownloader.a("apollo_card_bg_b.png", (URLDrawable.URLDrawableOptions)localObject2, ApolloImageDownloader.a("apollo_card_bg_b.png")));
        break;
      }
      if ("C".equals(paramApolloBoxDataItem.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837720);
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(ApolloImageDownloader.a("apollo_card_bg_c.png", (URLDrawable.URLDrawableOptions)localObject2, ApolloImageDownloader.a("apollo_card_bg_c.png")));
        break;
      }
      if (!"S".equals(paramApolloBoxDataItem.jdField_b_of_type_JavaLangString)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837721);
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(ApolloImageDownloader.a("apollo_card_bg_s.png", (URLDrawable.URLDrawableOptions)localObject2, ApolloImageDownloader.a("apollo_card_bg_s.png")));
      break;
      label638:
      localObject1 = ApolloImageDownloader.a("apollo_has_stolen_20160509.png", null, ApolloImageDownloader.a("apollo_has_stolen_20160509.png"));
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      localObject1 = ApolloImageDownloader.a("apollo_has_stolen_blur_20160509.png", null, ApolloImageDownloader.a("apollo_has_stolen_blur_20160509.png"));
      this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label166;
      label693:
      i1 = 8;
      break label181;
      label700:
      localObject1 = ApolloImageDownloader.a("apollo_circle_stolen_20160509.png", null, ApolloImageDownloader.a("apollo_circle_stolen_20160509.png"));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130837719);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(paramApolloBoxDataItem.jdField_c_of_type_JavaLangString)) {}
      for (localObject1 = String.valueOf(paramApolloBoxDataItem.jdField_a_of_type_Long);; localObject1 = paramApolloBoxDataItem.jdField_c_of_type_JavaLangString)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(TimeFormatterUtils.c(paramApolloBoxDataItem.jdField_c_of_type_Long * 1000L));
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(1677721600);
        if (TextUtils.isEmpty(paramApolloBoxDataItem.d)) {
          break;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ImageUtil.b();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable;
        localObject2 = new ApolloImageDownloader.ApolloDrawableExtraInfo();
        ((ApolloImageDownloader.ApolloDrawableExtraInfo)localObject2).jdField_a_of_type_Int = ApolloImageDownloader.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
        localObject1 = ApolloImageDownloader.a(Utils.Crc64String(paramApolloBoxDataItem.d), (URLDrawable.URLDrawableOptions)localObject1, paramApolloBoxDataItem.d);
        this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130837730);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        i1 = (int)(ApolloUtil.a(2.0F, ApolloBoxWindow.jdField_b_of_type_Float) * this.jdField_a_of_type_Float);
        this.jdField_d_of_type_AndroidWidgetImageView.setPadding(i1, i1, i1, i1);
        break;
      }
      label937:
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label346;
      label949:
      localObject1 = null;
    }
  }
  
  public void b()
  {
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setAlpha(0.6F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.4F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.4F });
    localObjectAnimator1.setInterpolator(new AccelerateInterpolator(2.0F));
    localObjectAnimator2.setInterpolator(new AccelerateInterpolator(2.0F));
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, 30.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, this.s / 2 - (int)(this.r * 0.315F) });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, -(this.t / 2 - (int)(this.r * 0.27D)) });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5, localObjectAnimator6 });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.start();
    localAnimatorSet.addListener(new ApolloWrapperCardView.MaskListener(this));
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.4F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.4F });
    localObjectAnimator1.setInterpolator(new AccelerateInterpolator(2.0F));
    localObjectAnimator2.setInterpolator(new AccelerateInterpolator(2.0F));
    localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, 30.0F });
    localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, this.s / 2 - (int)(this.r * 0.315F) });
    localObjectAnimator5 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, -(this.t / 2 - (int)(this.r * 0.27D)) });
    localObjectAnimator6 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.6F, 0.0F });
    localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5, localObjectAnimator6 });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloWrapperCardView$ApolloCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */