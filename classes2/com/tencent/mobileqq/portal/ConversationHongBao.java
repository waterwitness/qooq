package com.tencent.mobileqq.portal;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.HongBaoListViewListener;
import java.util.Arrays;
import mqq.app.Constants.LogoutReason;
import tto;
import ttp;
import ttq;
import ttr;
import tts;
import ttt;
import ttu;

public class ConversationHongBao
{
  public static final int a = -1;
  public static final long a = 400L;
  public static final int b = 1;
  public static final long b = 2000L;
  public static final int c = 2;
  public static final long c = 30L;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int l = 1001;
  public static final int m = 1002;
  public Activity a;
  protected CountDownTimer a;
  public Handler a;
  protected ViewGroup a;
  protected FrameLayout a;
  public ImageView a;
  public Conversation a;
  protected BreathEffectView a;
  public FormalView a;
  public PrepareView a;
  public ProgressViewRed a;
  public ProgressViewYellow a;
  public HongBaoListView a;
  public HongBaoListViewListener a;
  public Runnable a;
  public String a;
  public StringBuilder a;
  public boolean a;
  protected String b;
  public StringBuilder b;
  public boolean b;
  public long d;
  public long e;
  public long f;
  public int g;
  public long g;
  public int h;
  protected int i;
  public int j;
  public int k;
  
  public ConversationHongBao(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = -1;
    this.f = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new tto(this));
    this.jdField_a_of_type_JavaLangRunnable = new ttp(this);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener = new ttq(this);
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(12);
    this.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder(8);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = paramConversation.a();
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    FrameHelperActivity.a(true);
    this.j = 0;
    this.d = 0L;
    this.e = 0L;
    ((PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78)).e();
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.c == -this.h)
    {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.d(0);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_g_of_type_Long == paramLong) {
      return;
    }
    this.jdField_g_of_type_Long = paramLong;
    int i1 = (int)(paramLong / 1000L);
    int n = i1 / 60;
    i1 %= 60;
    int i2 = (int)paramLong % 100;
    this.jdField_b_of_type_JavaLangStringBuilder.delete(0, this.jdField_b_of_type_JavaLangStringBuilder.length());
    if (n < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(n).append(":");
    this.jdField_a_of_type_JavaLangStringBuilder.append(n).append(" : ");
    if (i1 < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(i1).append(".");
    this.jdField_a_of_type_JavaLangStringBuilder.append(i1).append(" . ");
    if (i2 < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(i2);
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_b_of_type_JavaLangStringBuilder);
  }
  
  public void a(long paramLong1, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showPrepare, " + this.k + ", " + paramLong1 + ", " + paramString + ", " + paramLong2 + ", " + paramBoolean);
    }
    if ((this.f == paramLong1) && (!paramBoolean) && (paramLong2 <= 0L)) {
      return;
    }
    b();
    this.f = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setBackground(paramBitmap2, paramBitmap1);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setLogo(paramBitmap3, true);
    if (this.k != 2)
    {
      this.k = 2;
      d();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.G();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setComboListener(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.setVisibility(8);
      l();
      a();
      if (this.jdField_b_of_type_Boolean)
      {
        paramBitmap1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
        if (paramBitmap1 != null) {
          paramBitmap1.h();
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a(paramString);
    if (paramLong2 >= 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a(paramLong2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.c();
  }
  
  public void a(long paramLong1, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showTask, " + this.k + ", " + paramLong1 + ", " + paramLong2 + ", " + paramBoolean + ", " + paramInt);
    }
    if ((this.f == paramLong1) && (!paramBoolean) && (((this.k == 3) && (paramLong2 == -1L)) || ((this.k == 5) && (paramLong2 == 0L)))) {
      return;
    }
    b();
    this.f = paramLong1;
    if ((this.k != 3) && (this.k != 4) && (this.k != 5))
    {
      d();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setComboListener(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(0);
    }
    HongBaoListView localHongBaoListView = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
    if (this.k != 3) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localHongBaoListView.setLogo(paramBitmap3, paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setBackground(paramBitmap2, paramBitmap1);
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString4;
      if (paramLong2 >= 0L) {
        break label348;
      }
      if (this.k == 3) {
        break;
      }
      this.k = 3;
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b();
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.G();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.h();
      }
      a();
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      paramBitmap1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
      if (paramBitmap1 == null) {
        break;
      }
      paramBitmap1.h();
      return;
    }
    label348:
    if (paramLong2 == 0L)
    {
      if (this.k != 5)
      {
        this.k = 5;
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.d(0);
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.d();
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.G();
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setLogo(this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_AndroidGraphicsBitmap, true);
        l();
        a();
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramInt, paramString2, paramString3);
      return;
    }
    b(paramLong2);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (this.k == -1) {
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean, String paramString, PortalManager.ResultData paramResultData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onBrashRequestResult, " + this.k + ", " + paramBoolean + ", " + paramString + ", " + paramResultData);
    }
    if (paramBoolean)
    {
      PortalManager.a(this.jdField_a_of_type_AndroidAppActivity, paramResultData);
      paramString = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
      if (paramString != null)
      {
        paramString.b(1);
        paramString.f();
      }
    }
    while (this.k != 4) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramString);
    this.d = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    if ((this.k == -1) || (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentWidgetHongBaoListView.l;
  }
  
  public void b()
  {
    if (this.k == -1)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297790));
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView = ((HongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297791));
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao = this;
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.j = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493758));
      this.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493770));
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297792));
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView = new PrepareView(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView = new FormalView(this.jdField_a_of_type_AndroidAppActivity);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalFormalView);
      this.i = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493761));
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow = new ProgressViewYellow(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.d = (-this.i);
      localLayoutParams = new ViewGroup.LayoutParams(-1, this.i);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed = new ProgressViewRed(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setTextSize(0, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493766));
      int n = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493760);
      localLayoutParams = new ViewGroup.LayoutParams(-1, n);
      this.h = n;
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297793));
      this.k = 1;
    }
  }
  
  public void b(long paramLong)
  {
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
    long[] arrayOfLong = localPortalManager.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startCountDown");
      if (arrayOfLong == null) {
        break label77;
      }
    }
    label77:
    for (String str = Arrays.toString(arrayOfLong);; str = "null")
    {
      QLog.d("PortalManager", 2, str);
      if (arrayOfLong != null) {
        break;
      }
      return;
    }
    if (this.k != 4)
    {
      this.k = 4;
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.setVisibility(0);
      FrameHelperActivity.a(false);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.F();
      if ((paramLong != -1L) && (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.c == 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.h);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.d(-this.h);
      }
      l();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.d();
    }
    if (paramLong == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b(true);
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      localPortalManager.b(2);
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer = new ttr(this, arrayOfLong[1], 30L, arrayOfLong);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  public boolean b()
  {
    if (FrameHelperActivity.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "showListViewPreGuide" + this.k);
      }
      return false;
    }
    return this.jdField_a_of_type_ComTencentWidgetHongBaoListView.b();
  }
  
  public void c()
  {
    if (this.k == -1) {}
    while (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "normalMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.d(0);
    FrameHelperActivity.a(true);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.c();
    l();
    a();
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.d();
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.f = -1L;
    this.k = 1;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "startGestureGuide, " + this.k);
    }
    switch (this.k)
    {
    default: 
      return false;
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(1L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new tts(this));
    int n = (int)this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDimension(2131493773);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, -this.jdField_a_of_type_ComTencentWidgetHongBaoListView.c(), 0, n + -this.jdField_a_of_type_ComTencentWidgetHongBaoListView.c());
    localTranslateAnimation.setDuration(1500L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new ttt(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setAnimationListener(new ttu(this));
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
    return true;
  }
  
  public void d()
  {
    if (this.k == -1) {}
    while (a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "hongbaoMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.e();
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.d();
    }
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.E();
    }
    j();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    if (!a()) {
      return;
    }
    switch (this.k)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) {
        switch (this.k)
        {
        }
      }
      break;
    }
    for (;;)
    {
      j();
      return;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.h();
      break;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
    }
  }
  
  public void g()
  {
    if (this.k == -1) {
      return;
    }
    c();
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1002)) {}
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
    } while (!a());
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.c();
    }
    switch (this.k)
    {
    }
    for (;;)
    {
      j();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
      if (localPortalManager == null) {
        break;
      }
      localPortalManager.b();
      localPortalManager.h();
      return;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.h();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
    }
  }
  
  public void j()
  {
    if (!a()) {
      return;
    }
    switch (this.k)
    {
    default: 
      return;
    }
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
    if ((!this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean) || (FrameHelperActivity.a()))
    {
      localPortalManager.e();
      FrameHelperActivity.a(true);
      return;
    }
    FrameHelperActivity.a(false);
    localPortalManager.b(2);
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.E();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.d();
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    j();
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void m()
  {
    if (!a()) {
      return;
    }
    j();
  }
  
  public void n()
  {
    if (!a()) {
      return;
    }
    j();
  }
  
  public void o()
  {
    if (!a()) {
      return;
    }
    switch (this.k)
    {
    default: 
      return;
    }
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\ConversationHongBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */