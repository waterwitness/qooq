package com.tencent.av.ui;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import gyh;
import gyi;
import gyj;
import gyk;
import gyl;
import mqq.app.BaseActivity;

public class QavPanel
  extends RelativeLayout
{
  private static double jdField_a_of_type_Double = 0.12667D;
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "QavPanel";
  private static double jdField_b_of_type_Double = 0.09333D;
  public static final int b = 1;
  private static double jdField_c_of_type_Double = 0.177333D;
  public static final int c = 2;
  private static double jdField_d_of_type_Double = 0.093333D;
  public static final int d = 3;
  private static double jdField_e_of_type_Double = 0.16267D;
  public static final int e = 4;
  private static double jdField_f_of_type_Double = 0.19067D;
  public static final int f = 5;
  private static double jdField_g_of_type_Double = 0.13067D;
  public static final int g = 6;
  private static double jdField_h_of_type_Double = 0.16D;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 0;
  public static final int o = 1;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  View jdField_a_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  public FrameLayout a;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public QavPanelSlideTouchListener a;
  public QavPanelSoundWaveView a;
  ShimmerTextView jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
  gyl jdField_a_of_type_Gyl = null;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView = null;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  public FrameLayout b;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public boolean b;
  View jdField_c_of_type_AndroidViewView = null;
  Animation jdField_c_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_c_of_type_AndroidWidgetButton = null;
  FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout = null;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  public boolean c;
  Animation jdField_d_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_d_of_type_AndroidWidgetButton = null;
  public FrameLayout d;
  Animation jdField_e_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_e_of_type_AndroidWidgetButton = null;
  public FrameLayout e;
  Animation jdField_f_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_f_of_type_AndroidWidgetButton = null;
  public FrameLayout f;
  Animation jdField_g_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_g_of_type_AndroidWidgetButton = null;
  public FrameLayout g;
  Animation jdField_h_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_h_of_type_AndroidWidgetButton = null;
  FrameLayout jdField_h_of_type_AndroidWidgetFrameLayout = null;
  Animation jdField_i_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_i_of_type_AndroidWidgetButton = null;
  Animation jdField_j_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_j_of_type_AndroidWidgetButton = null;
  Animation jdField_k_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_k_of_type_AndroidWidgetButton = null;
  Animation jdField_l_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_l_of_type_AndroidWidgetButton = null;
  Button m = null;
  Button n = null;
  Button o = null;
  int jdField_p_of_type_Int = 0;
  Button jdField_p_of_type_AndroidWidgetButton = null;
  int q = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QavPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_e_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_f_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_g_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_e_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_f_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_g_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_e_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_f_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_g_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = a(paramInt1);
    if (localView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = paramInt2;
    localLayoutParams.leftMargin = paramInt3;
    localView.setLayoutParams(localLayoutParams);
  }
  
  public int a()
  {
    if (getResources().getDisplayMetrics().heightPixels <= 854) {
      return getResources().getDimensionPixelSize(2131494124);
    }
    return getResources().getDimensionPixelSize(2131494123);
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "getViewVisibility --> viewType = " + paramInt);
    }
    View localView = a(paramInt);
    if (localView != null) {
      return localView.getVisibility();
    }
    return -1;
  }
  
  View a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("QavPanel", 2, "WRONG BTN TYPE --> " + paramInt);
      }
      return null;
    case 7: 
      return this.jdField_j_of_type_AndroidWidgetButton;
    case 1: 
      return this.jdField_k_of_type_AndroidWidgetButton;
    case 3: 
      return this.jdField_h_of_type_AndroidWidgetButton;
    case 18: 
      return this.jdField_a_of_type_AndroidWidgetButton;
    case 20: 
      return this.jdField_c_of_type_AndroidWidgetButton;
    case 19: 
      return this.jdField_b_of_type_AndroidWidgetButton;
    case 16: 
      return this.o;
    case 9: 
      return this.m;
    case 5: 
      return this.jdField_l_of_type_AndroidWidgetButton;
    case 15: 
      return this.jdField_a_of_type_AndroidWidgetImageButton;
    case 11: 
      return this.jdField_g_of_type_AndroidWidgetButton;
    case 13: 
      return this.n;
    case 21: 
      return this.jdField_d_of_type_AndroidWidgetButton;
    case 23: 
      return this.jdField_f_of_type_AndroidWidgetButton;
    case 24: 
      return this.jdField_c_of_type_AndroidViewView;
    case 22: 
      return this.jdField_e_of_type_AndroidWidgetButton;
    case 2: 
      return this.jdField_e_of_type_AndroidWidgetFrameLayout;
    case 4: 
      return this.jdField_b_of_type_AndroidWidgetFrameLayout;
    case 14: 
      return this.jdField_h_of_type_AndroidWidgetFrameLayout;
    case 17: 
      return this.jdField_p_of_type_AndroidWidgetButton;
    case 8: 
      return this.jdField_d_of_type_AndroidWidgetFrameLayout;
    case 12: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    case 6: 
      return this.jdField_f_of_type_AndroidWidgetFrameLayout;
    case 10: 
      return this.jdField_g_of_type_AndroidWidgetFrameLayout;
    case 25: 
      return this.jdField_a_of_type_AndroidWidgetImageView;
    case 26: 
      return this.jdField_c_of_type_AndroidWidgetFrameLayout;
    }
    return this.jdField_i_of_type_AndroidWidgetButton;
  }
  
  public QavPanelSoundWaveView a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_p_of_type_Int = paramInt;
    label19:
    Object localObject;
    if (paramBoolean1)
    {
      paramInt = 0;
      this.q = paramInt;
      c();
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = new QavPanelSoundWaveView(getContext());
      localObject = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131494125));
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (!(getContext() instanceof BaseActivity)) {
        break label2748;
      }
      localObject = (BaseActivity)getContext();
      if (!(((BaseActivity)localObject).getAppRuntime() instanceof VideoAppInterface)) {
        break label2748;
      }
    }
    label2748:
    for (boolean bool = ((VideoAppInterface)((BaseActivity)localObject).getAppRuntime()).i();; bool = false)
    {
      switch (this.jdField_p_of_type_Int)
      {
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewView != null) {
          addView(this.jdField_a_of_type_AndroidViewView);
        }
        addView(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
        bringChildToFront(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
        b();
        this.jdField_a_of_type_Gyl = new gyl(this);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        getContext().registerReceiver(this.jdField_a_of_type_Gyl, (IntentFilter)localObject);
        this.jdField_a_of_type_Boolean = true;
        if (!AudioHelper.b()) {
          break;
        }
        if (this.jdField_f_of_type_AndroidWidgetFrameLayout != null) {
          this.jdField_f_of_type_AndroidWidgetFrameLayout.setBackgroundColor(Color.argb(255, 255, 255, 255));
        }
        if (this.jdField_l_of_type_AndroidWidgetButton != null) {
          this.jdField_l_of_type_AndroidWidgetButton.setBackgroundColor(Color.argb(255, 68, 128, 2));
        }
        if (this.jdField_g_of_type_AndroidWidgetFrameLayout != null) {
          this.jdField_g_of_type_AndroidWidgetFrameLayout.setBackgroundColor(Color.argb(100, 255, 255, 255));
        }
        if (this.m == null) {
          break;
        }
        this.m.setBackgroundColor(Color.argb(255, 68, 128, 2));
        return;
        paramInt = 1;
        break label19;
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903591, this, false);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299115);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299359));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299358));
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299355));
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299356));
        this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299354));
        d(false);
        continue;
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903590, this, false);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299115);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298002));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298004));
        this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298003));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298001));
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297998);
        this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297999));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298000));
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297997));
        this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = new QavPanelSlideTouchListener(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
        if (bool)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131363303));
          this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new gyh(this));
        }
        for (;;)
        {
          e(false);
          break;
          this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener);
        }
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903599, this, false);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298002));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298004));
        this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298003));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298001));
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297998);
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297997));
        this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = new QavPanelSlideTouchListener(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
        if (bool)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131363303));
          this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new gyi(this));
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener);
          continue;
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903589, this, false);
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299115);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131299013));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299345));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299051));
          this.o = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299026));
          this.jdField_p_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299027));
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299343));
          this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299119));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299018));
          this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299019));
          this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299346));
          this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299347));
          this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299014));
          this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299015));
          this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299022));
          this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299023));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299011));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299012));
          this.jdField_g_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299348));
          this.m = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299349));
          a(paramBoolean1, paramBoolean2, false);
          continue;
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903598, this, false);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131299013));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299115);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299343));
          this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299119));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299018));
          this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299019));
          this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299014));
          this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299015));
          this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299022));
          this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299023));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299011));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299012));
          this.jdField_h_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299020));
          this.n = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299021));
          b(false);
          continue;
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903593, this, false);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131299013));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299115);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299343));
          this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299119));
          this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299014));
          this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299015));
          this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299022));
          this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299023));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299011));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299012));
          this.jdField_h_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299020));
          this.n = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299021));
          c(false);
          continue;
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903594, this, false);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131299013));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299011));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299012));
          this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
          continue;
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903592, this, false);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131299013));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299115);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299343));
          this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299119));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299018));
          this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299019));
          this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299014));
          this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299015));
          this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299022));
          this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299023));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299011));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299012));
          a(false);
          continue;
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903597, this, false);
          continue;
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903596, this, false);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298002));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298004));
          this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298003));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298001));
          this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297998);
          this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297999));
          this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298000));
          this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297997));
          this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = new QavPanelSlideTouchListener(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
          if (bool)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131363303));
            this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
            this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new gyj(this));
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener);
            continue;
            this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903595, this, false);
            this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299115);
            this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131299013));
            this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299345));
            this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299051));
            this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299343));
            this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299018));
            this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299014));
            this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299022));
            this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299011));
            this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
            continue;
            this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903588, this, false);
            this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131299013));
            this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299011));
            this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299012));
            this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299343));
            this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299119));
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
            AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, false, 2130839056);
            AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, false, 2130839053);
          }
        }
      }
    }
  }
  
  void a(Animation.AnimationListener paramAnimationListener)
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation1.setFillEnabled(true);
      localAlphaAnimation1.setFillAfter(true);
      localAlphaAnimation1.setDuration(400L);
      AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation2.setFillEnabled(true);
      localAlphaAnimation2.setFillAfter(true);
      localAlphaAnimation2.setDuration(400L);
      localAlphaAnimation2.setAnimationListener(paramAnimationListener);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAlphaAnimation1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(localAlphaAnimation2);
    }
  }
  
  public void a(QQFrameByFrameAnimation paramQQFrameByFrameAnimation)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      paramQQFrameByFrameAnimation.a(this.jdField_a_of_type_AndroidWidgetImageButton);
      paramQQFrameByFrameAnimation.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics;
    int i2;
    int i1;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localDisplayMetrics = getResources().getDisplayMetrics();
      i2 = (int)(localDisplayMetrics.widthPixels * jdField_g_of_type_Double);
      i1 = (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double);
      if (i1 <= b() * 2 / 5) {
        break label321;
      }
      i1 = b() * 2 / 5;
    }
    label321:
    for (;;)
    {
      int i3 = (int)(localDisplayMetrics.widthPixels * jdField_a_of_type_Double);
      a(8, i2, i3);
      a(4, i2 + 10, i3 - 5);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_c_of_type_Double);
      a(2, i2, i3);
      a(6, i2, i3);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
      localLayoutParams.width = i1;
      localLayoutParams.height = i1;
      localLayoutParams.leftMargin = i3;
      this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
      a(12, i2, (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double) * 2 + (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double) - 5);
      AudioHelper.a(getResources(), this.jdField_j_of_type_AndroidWidgetButton, paramBoolean, 2130839060);
      AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, paramBoolean, 2130839056);
      AudioHelper.a(getResources(), this.jdField_k_of_type_AndroidWidgetButton, paramBoolean, 2130839050);
      AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, paramBoolean, 2130839053);
      AudioHelper.a(getResources(), this.jdField_h_of_type_AndroidWidgetButton, paramBoolean, 2130839044);
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((this.jdField_c_of_type_AndroidWidgetFrameLayout != null) && (paramBoolean))
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_i_of_type_AndroidWidgetButton.setEnabled(false);
      Resources localResources = getResources();
      Button localButton = this.jdField_i_of_type_AndroidWidgetButton;
      paramBoolean = bool;
      if (this.q == 0) {
        paramBoolean = true;
      }
      AudioHelper.a(localResources, localButton, paramBoolean, paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "videoSession :" + paramBoolean1 + ", localHasVideo:" + paramBoolean2 + ", isVipFunCall:" + paramBoolean3);
    }
    if ((this.jdField_p_of_type_Int == 11) || (this.jdField_p_of_type_Int == 10) || (this.jdField_p_of_type_Int == 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavPanel", 2, "resizeLayout" + this.q + "panelStyle ignored");
      }
      return;
    }
    if ((paramBoolean1) || (paramBoolean3))
    {
      paramBoolean3 = true;
      if (!paramBoolean1) {
        break label354;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label155:
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(paramBoolean3);
      if (!paramBoolean2) {
        break label374;
      }
      this.jdField_g_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      label175:
      if (this.jdField_a_of_type_Boolean) {
        break label386;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
        this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(null);
      }
      label199:
      if (!paramBoolean3) {
        break label586;
      }
    }
    for (;;)
    {
      this.q = i1;
      AudioHelper.a(getResources(), this.jdField_j_of_type_AndroidWidgetButton, paramBoolean3, 2130839060);
      AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, paramBoolean3, 2130839056);
      AudioHelper.a(getResources(), this.jdField_k_of_type_AndroidWidgetButton, paramBoolean3, 2130839050);
      AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, paramBoolean3, 2130839053);
      if (paramBoolean2) {
        AudioHelper.a(getResources(), this.m, paramBoolean3, 2130839051);
      }
      AudioHelper.a(getResources(), this.jdField_i_of_type_AndroidWidgetButton, paramBoolean3, 2130839063);
      AudioHelper.a(getResources(), this.jdField_h_of_type_AndroidWidgetButton, paramBoolean3, 2130839044);
      AudioHelper.a(getResources(), this.o, paramBoolean3, 2130839065);
      AudioHelper.a(getResources(), this.jdField_p_of_type_AndroidWidgetButton, paramBoolean3, 2130839073);
      return;
      paramBoolean3 = false;
      break;
      label354:
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label155;
      label374:
      this.jdField_g_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      break label175;
      label386:
      if (paramBoolean2 == this.jdField_b_of_type_Boolean) {
        break label199;
      }
      this.jdField_b_of_type_Boolean = paramBoolean2;
      this.jdField_d_of_type_AndroidWidgetFrameLayout.clearAnimation();
      this.jdField_e_of_type_AndroidWidgetFrameLayout.clearAnimation();
      this.jdField_f_of_type_AndroidWidgetFrameLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetFrameLayout.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetFrameLayout.clearAnimation();
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_e_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
        this.jdField_f_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_e_of_type_AndroidViewAnimationAnimation);
        this.jdField_g_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_g_of_type_AndroidViewAnimationAnimation);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_i_of_type_AndroidViewAnimationAnimation);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_k_of_type_AndroidViewAnimationAnimation);
        break label199;
      }
      this.jdField_d_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.jdField_e_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
      this.jdField_f_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_f_of_type_AndroidViewAnimationAnimation);
      this.jdField_g_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_h_of_type_AndroidViewAnimationAnimation);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_j_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_l_of_type_AndroidViewAnimationAnimation);
      break label199;
      label586:
      i1 = 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "checkButton --> btnType = " + paramInt);
    }
    return a(paramInt) == null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewBackground --> viewType = " + paramInt1 + " , resId = " + paramInt2);
    }
    View localView = a(paramInt1);
    if (localView != null)
    {
      localView.setBackgroundResource(paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewMargin --> viewType = " + paramInt1 + " , direction = " + paramInt2 + " , margin = " + paramInt3);
    }
    if (paramInt3 < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavPanel", 2, "setViewMargin --> margin < 0, margin = " + paramInt3);
      }
      return false;
    }
    View localView = a(paramInt1);
    if (localView == null) {
      return false;
    }
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams == null) {
        return false;
      }
      if (paramInt2 == 1) {
        localLayoutParams.leftMargin = paramInt3;
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        return true;
        if (paramInt2 == 2) {
          localLayoutParams.rightMargin = paramInt3;
        } else if (paramInt2 == 4) {
          localLayoutParams.bottomMargin = paramInt3;
        } else if (paramInt2 == 3) {
          localLayoutParams.topMargin = paramInt3;
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewAccText --> viewType = " + paramInt + " , Text = " + paramString);
    }
    View localView = a(paramInt);
    if (localView != null)
    {
      UITools.a(localView, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewAccText --> viewType = " + paramInt1 + " , Text = " + paramString + " , AudioType = " + paramInt2);
    }
    View localView = a(paramInt1);
    if (localView != null)
    {
      UITools.a(localView, paramString, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewSelected --> viewType = " + paramInt + " , selected = " + paramBoolean);
    }
    View localView = a(paramInt);
    if (localView != null)
    {
      localView.setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(QavPanel.SlideAcceptListener paramSlideAcceptListener)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener.a(paramSlideAcceptListener);
    return true;
  }
  
  public boolean a(TraeHelper paramTraeHelper)
  {
    if ((paramTraeHelper != null) && (this.jdField_l_of_type_AndroidWidgetButton != null))
    {
      paramTraeHelper.a(this.jdField_l_of_type_AndroidWidgetButton);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (getResources().getDisplayMetrics().heightPixels <= 854) {
      return getResources().getDimensionPixelSize(2131494128);
    }
    return getResources().getDimensionPixelSize(2131494127);
  }
  
  void b()
  {
    Object localObject = getResources().getDisplayMetrics();
    int i1 = getResources().getDimensionPixelSize(2131494123);
    int i2 = getResources().getDimensionPixelSize(2131494125);
    int i3 = getResources().getDimensionPixelSize(2131494127);
    int i4 = getResources().getDimensionPixelSize(2131494129);
    int i5 = getResources().getDimensionPixelSize(2131494131);
    if (((DisplayMetrics)localObject).heightPixels <= 854)
    {
      i1 = getResources().getDimensionPixelSize(2131494124);
      i2 = getResources().getDimensionPixelSize(2131494126);
      i3 = getResources().getDimensionPixelSize(2131494128);
      i4 = getResources().getDimensionPixelSize(2131494130);
      i5 = getResources().getDimensionPixelSize(2131494132);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_p_of_type_Int != 7)
        {
          localObject = (RelativeLayout.LayoutParams)getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = i1;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = i2;
          this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = i3;
          this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        a(8, 4, i4);
        a(2, 4, i4);
        if ((this.jdField_p_of_type_Int == 7) || (this.jdField_p_of_type_Int == 12))
        {
          a(6, 4, getResources().getDimensionPixelSize(2131494129));
          a(10, 4, i4);
          if (this.jdField_p_of_type_Int == 6)
          {
            a(14, 4, getResources().getDimensionPixelSize(2131494129));
            if ((this.jdField_p_of_type_Int == 2) || (this.jdField_p_of_type_Int == 3) || (this.jdField_p_of_type_Int == 10))
            {
              a(20, 4, i5);
              a(23, 4, i5);
              a(19, 4, i5);
            }
          }
        }
        else
        {
          a(6, 4, i4);
          continue;
        }
        a(14, 4, i4);
      }
      catch (Exception localException) {}
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i1 = 0;
    label28:
    DisplayMetrics localDisplayMetrics;
    int i2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        break label364;
      }
      this.q = i1;
      localDisplayMetrics = getResources().getDisplayMetrics();
      i2 = (int)(localDisplayMetrics.widthPixels * jdField_g_of_type_Double);
      i1 = (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double);
      if (i1 <= b() * 2 / 5) {
        break label370;
      }
      i1 = b() * 2 / 5;
    }
    label364:
    label370:
    for (;;)
    {
      int i3 = (int)(localDisplayMetrics.widthPixels * jdField_b_of_type_Double);
      a(8, i2, i3);
      a(4, i2 + 10, i3 - 5);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_d_of_type_Double);
      a(2, i2, i3);
      a(6, i2, i3);
      a(14, i2 + 10, i3 - 5);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_f_of_type_Double);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
      localLayoutParams.width = i1;
      localLayoutParams.height = i1;
      localLayoutParams.leftMargin = i3;
      this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
      a(12, i2, (int)(localDisplayMetrics.widthPixels * jdField_f_of_type_Double) * 2 + (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double) - 5);
      AudioHelper.a(getResources(), this.jdField_j_of_type_AndroidWidgetButton, paramBoolean, 2130839060);
      AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, paramBoolean, 2130839056);
      AudioHelper.a(getResources(), this.jdField_k_of_type_AndroidWidgetButton, paramBoolean, 2130839050);
      AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, paramBoolean, 2130839053);
      AudioHelper.a(getResources(), this.n, paramBoolean, 2130839133);
      AudioHelper.a(getResources(), this.jdField_h_of_type_AndroidWidgetButton, paramBoolean, 2130839044);
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      i1 = 1;
      break label28;
    }
  }
  
  public boolean b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "isViewEnable --> viewType = " + paramInt);
    }
    View localView = a(paramInt);
    if (localView != null) {
      return localView.isEnabled();
    }
    return false;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewRule --> viewType = " + paramInt1 + " Rule = " + paramInt2);
    }
    View localView = a(paramInt1);
    if (localView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.addRule(paramInt2);
        localView.setLayoutParams(localLayoutParams);
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return false;
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewClickable --> viewType = " + paramInt);
    }
    View localView = a(paramInt);
    if (localView != null)
    {
      localView.setClickable(paramBoolean);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double) + (float)(jdField_d_of_type_Double - jdField_c_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double) + (float)(jdField_c_of_type_Double - jdField_d_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_e_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double) + (float)(jdField_d_of_type_Double - jdField_c_of_type_Double) * 2.0F, 1, 0.0F, 1, 0.0F);
    this.jdField_e_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_e_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_f_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double) + (float)(jdField_c_of_type_Double - jdField_d_of_type_Double) * 2.0F, 1, 0.0F, 1, 0.0F);
    this.jdField_f_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_f_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_g_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double) + (float)(jdField_d_of_type_Double - jdField_c_of_type_Double) * 3.0F, 1, 0.0F, 1, 0.0F);
    this.jdField_g_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_g_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_h_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double) + (float)(jdField_c_of_type_Double - jdField_d_of_type_Double) * 3.0F, 1, 0.0F, 1, 0.0F);
    this.jdField_h_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_h_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_i_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_i_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_i_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_j_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_j_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_j_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    int i1 = (int)(localDisplayMetrics.widthPixels * jdField_f_of_type_Double) * 2 + (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double);
    int i2 = (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double);
    i2 = (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double) + i2 * 2;
    if (localDisplayMetrics.widthPixels != 0) {}
    for (float f1 = (i1 - i2) / localDisplayMetrics.widthPixels + (float)(jdField_b_of_type_Double - jdField_a_of_type_Double);; f1 = 0.0F)
    {
      if (localDisplayMetrics.widthPixels != 0) {}
      for (float f2 = (i2 - i1) / localDisplayMetrics.widthPixels + (float)(jdField_a_of_type_Double - jdField_b_of_type_Double);; f2 = 0.0F)
      {
        this.jdField_k_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, f1, 1, 0.0F, 1, 0.0F);
        this.jdField_k_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
        this.jdField_k_of_type_AndroidViewAnimationAnimation.setDuration(150L);
        this.jdField_l_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, f2, 1, 0.0F, 1, 0.0F);
        this.jdField_l_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
        this.jdField_l_of_type_AndroidViewAnimationAnimation.setDuration(150L);
        this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new gyk(this);
        this.jdField_g_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_h_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        return;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i1 = 0;
    label28:
    DisplayMetrics localDisplayMetrics;
    int i2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        break label335;
      }
      this.q = i1;
      localDisplayMetrics = getResources().getDisplayMetrics();
      i2 = (int)(localDisplayMetrics.widthPixels * jdField_g_of_type_Double);
      i1 = (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double);
      if (i1 <= b() * 2 / 5) {
        break label341;
      }
      i1 = b() * 2 / 5;
    }
    label335:
    label341:
    for (;;)
    {
      int i3 = (int)(localDisplayMetrics.widthPixels * jdField_a_of_type_Double);
      a(8, i2, i3);
      a(14, i2 + 10, i3 - 5);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_c_of_type_Double);
      a(2, i2, i3);
      a(6, i2, i3);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
      localLayoutParams.width = i1;
      localLayoutParams.height = i1;
      localLayoutParams.leftMargin = i3;
      this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
      a(12, i2, (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double) * 2 + (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double) - 5);
      AudioHelper.a(getResources(), this.jdField_j_of_type_AndroidWidgetButton, paramBoolean, 2130839060);
      AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, paramBoolean, 2130839056);
      AudioHelper.a(getResources(), this.jdField_k_of_type_AndroidWidgetButton, paramBoolean, 2130839050);
      AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, paramBoolean, 2130839053);
      AudioHelper.a(getResources(), this.n, paramBoolean, 2130839133);
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      i1 = 1;
      break label28;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.f();
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131427779));
      }
      if (this.jdField_c_of_type_AndroidWidgetButton != null) {
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131427779));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(paramBoolean);
      }
      if (this.jdField_e_of_type_AndroidWidgetButton != null) {
        AudioHelper.a(getResources(), this.jdField_e_of_type_AndroidWidgetButton, paramBoolean, 2130839048);
      }
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        AudioHelper.a(getResources(), this.jdField_b_of_type_AndroidWidgetButton, paramBoolean, 2130839020);
      }
      return;
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_c_of_type_AndroidWidgetButton != null) {
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#566B7D"));
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.g();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(paramBoolean);
    }
    if (this.jdField_f_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_f_of_type_AndroidWidgetButton, paramBoolean, 2130839048);
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_b_of_type_AndroidWidgetButton, paramBoolean, 2130839020);
    }
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_c_of_type_AndroidWidgetButton, paramBoolean, 2130839204);
    }
  }
  
  public void f()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Gyl != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_Gyl);
      this.jdField_a_of_type_Gyl = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.c();
    }
  }
  
  public void setAcceptDrawableTop(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(null, paramDrawable, null, null);
  }
  
  public void setBtnOnClickListener(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setBtnOnClickListener --> BtnType = " + paramInt);
    }
    View localView = a(paramInt);
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setMultiPstnCallback(boolean paramBoolean)
  {
    Button localButton1 = (Button)findViewById(2131299362);
    Button localButton2 = (Button)findViewById(2131299363);
    Button localButton3 = (Button)findViewById(2131299364);
    if (localButton1 != null)
    {
      AudioHelper.a(getResources(), localButton1, false, 2130839060);
      localButton1.setEnabled(false);
      if (paramBoolean) {
        localButton1.setVisibility(0);
      }
    }
    else
    {
      if (localButton2 != null)
      {
        AudioHelper.a(getResources(), localButton2, false, 2130839050);
        localButton2.setEnabled(false);
        if (!paramBoolean) {
          break label164;
        }
        localButton2.setVisibility(0);
      }
      label94:
      if (localButton3 != null)
      {
        AudioHelper.a(getResources(), localButton3, false, 2130839053);
        localButton3.setEnabled(false);
        if (!paramBoolean) {
          break label173;
        }
        localButton3.setVisibility(0);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label183;
      }
      setViewVisibility(7, 8);
      setViewVisibility(1, 8);
      setViewVisibility(5, 8);
      return;
      localButton1.setVisibility(8);
      break;
      label164:
      localButton2.setVisibility(8);
      break label94;
      label173:
      localButton3.setVisibility(8);
    }
    label183:
    setViewVisibility(7, 0);
    setViewVisibility(1, 0);
    setViewVisibility(5, 0);
  }
  
  public void setViewEnable(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewEnable --> viewType = " + paramInt + " ,  enable = " + paramBoolean);
    }
    View localView = a(paramInt);
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewVisibility --> viewType = " + paramInt1 + " ,  visibility = " + paramInt2);
    }
    View localView = a(paramInt1);
    if (localView != null) {
      localView.setVisibility(paramInt2);
    }
  }
  
  public void setWaveVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\QavPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */