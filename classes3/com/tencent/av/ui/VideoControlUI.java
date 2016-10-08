package com.tencent.av.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import gys;
import gyt;
import gyu;
import gyv;
import gyw;
import gyx;
import gyy;
import gyz;
import gza;
import gzb;
import gzc;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public abstract class VideoControlUI
{
  private static final String jdField_a_of_type_JavaLangString = "VideoControlUI";
  static final int jdField_j_of_type_Int = 0;
  static final int jdField_k_of_type_Int = 1;
  static final int jdField_l_of_type_Int = 2;
  static final int m = 3;
  static final int n = 4;
  static final int o = 5;
  static final int p = 6;
  static final int jdField_q_of_type_Int = 0;
  static final int jdField_r_of_type_Int = 1;
  final int A;
  public String A;
  final int B;
  int C;
  public int D;
  public int E;
  public int F;
  public int G;
  float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  public Resources a;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener;
  public GestureDetector a;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public FrameLayout a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  Toast jdField_a_of_type_AndroidWidgetToast;
  public VideoController a;
  public VideoAppInterface a;
  public ControlUIObserver a;
  public QavPanel a;
  public VideoNetStateBar a;
  QQAnimationListener jdField_a_of_type_ComTencentAvUtilsQQAnimationListener;
  QQFrameByFrameAnimation jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation;
  RingAnimator jdField_a_of_type_ComTencentAvUtilsRingAnimator;
  public SensorHelper a;
  public TipsManager a;
  TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  public ChildLockCircle a;
  private gyy jdField_a_of_type_Gyy;
  public gzc a;
  public WeakReference a;
  public ViewGroup b;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  Button jdField_b_of_type_AndroidWidgetButton;
  public FrameLayout b;
  public ImageButton b;
  public LinearLayout b;
  ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  public Animation c;
  TranslateAnimation jdField_c_of_type_AndroidViewAnimationTranslateAnimation;
  Button jdField_c_of_type_AndroidWidgetButton;
  public FrameLayout c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  public View d;
  Animation.AnimationListener jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener;
  Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  TranslateAnimation jdField_d_of_type_AndroidViewAnimationTranslateAnimation;
  Button jdField_d_of_type_AndroidWidgetButton;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  public LinearLayout d;
  public View e;
  Animation.AnimationListener jdField_e_of_type_AndroidViewAnimationAnimation$AnimationListener;
  Animation jdField_e_of_type_AndroidViewAnimationAnimation;
  TranslateAnimation jdField_e_of_type_AndroidViewAnimationTranslateAnimation;
  public Button e;
  public RelativeLayout e;
  Animation jdField_f_of_type_AndroidViewAnimationAnimation;
  Button jdField_f_of_type_AndroidWidgetButton;
  public RelativeLayout f;
  Button g;
  public TextView h;
  public TextView i;
  Runnable i;
  public TextView j;
  Runnable jdField_j_of_type_JavaLangRunnable;
  public TextView k;
  Runnable jdField_k_of_type_JavaLangRunnable;
  TextView jdField_l_of_type_AndroidWidgetTextView;
  public boolean l;
  public TextView m;
  public boolean m;
  public boolean n;
  public boolean o;
  public boolean p;
  boolean jdField_q_of_type_Boolean;
  boolean jdField_r_of_type_Boolean;
  int s;
  public boolean s;
  public int t;
  public boolean t;
  int u;
  int v;
  public int w;
  public String w;
  int jdField_x_of_type_Int;
  String jdField_x_of_type_JavaLangString;
  public int y;
  public String y;
  final int z;
  public String z;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_s_of_type_Int = 0;
    this.jdField_t_of_type_Int = 0;
    this.u = 0;
    this.v = 0;
    this.jdField_w_of_type_Int = 0;
    this.jdField_x_of_type_Int = 0;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = true;
    this.n = false;
    this.jdField_w_of_type_JavaLangString = null;
    this.jdField_x_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    this.jdField_i_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
    this.h = null;
    this.jdField_i_of_type_AndroidWidgetTextView = null;
    this.jdField_j_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_k_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_l_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle = null;
    this.jdField_c_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_d_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetButton = null;
    this.jdField_d_of_type_AndroidWidgetButton = null;
    this.jdField_e_of_type_AndroidWidgetButton = null;
    this.jdField_f_of_type_AndroidWidgetButton = null;
    this.g = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_m_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_c_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_c_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_d_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_j_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    this.jdField_e_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation = null;
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation = null;
    this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation = null;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = null;
    this.jdField_f_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_y_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_z_of_type_Int = 1;
    this.jdField_A_of_type_Int = 2;
    this.B = 3;
    this.C = -1;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.p = false;
    this.q = false;
    this.r = false;
    this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = new gys(this);
    this.jdField_k_of_type_JavaLangRunnable = new gyt(this);
    this.D = 5;
    this.jdField_a_of_type_Gzc = new gzc(this);
    this.jdField_e_of_type_AndroidViewAnimationAnimation$AnimationListener = new gyu(this);
    this.jdField_t_of_type_Boolean = true;
    this.jdField_A_of_type_JavaLangString = (Build.MANUFACTURER + "." + Build.MODEL);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new gyw(this);
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new gyx(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
    paramVideoAppInterface = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "VideoControlUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentResResources = paramVideoAppInterface.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "mRes is null. exit video progress");
      }
      paramAVActivity = paramVideoAppInterface.getString(2131363272) + " 0x01";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "mVideoController is null. exit video progress");
      }
      paramAVActivity = this.jdField_a_of_type_AndroidContentResResources.getString(2131363272) + " 0x01";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b()) || (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).c())) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "camera already opening or opened, ignore camera availability broadcast");
      }
    }
    label288:
    label319:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
            {
              if (paramBoolean)
              {
                if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2))
                {
                  if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
                  {
                    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(9, true);
                    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
                    return;
                  }
                  this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(9, false);
                  this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
                  return;
                }
                this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(9, true);
                this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
                return;
              }
              this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(9, false);
              this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
              return;
            }
            if (!paramBoolean) {
              break label319;
            }
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2)) {
              break label288;
            }
            if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
              break;
            }
            if (this.jdField_e_of_type_AndroidWidgetButton != null) {
              this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
            }
          } while (this.jdField_b_of_type_AndroidWidgetButton == null);
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
          return;
          if (this.jdField_e_of_type_AndroidWidgetButton != null) {
            this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
          }
        } while (this.jdField_b_of_type_AndroidWidgetButton == null);
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        return;
        if (this.jdField_e_of_type_AndroidWidgetButton != null) {
          this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
        }
      } while (this.jdField_b_of_type_AndroidWidgetButton == null);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      if (this.jdField_e_of_type_AndroidWidgetButton != null) {
        this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
      }
    } while (this.jdField_b_of_type_AndroidWidgetButton == null);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void A() {}
  
  public void B() {}
  
  void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "displayToolBar");
    }
    if (!e())
    {
      this.jdField_m_of_type_Boolean = false;
      j(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
  }
  
  public void D()
  {
    ai();
  }
  
  public void E()
  {
    aj();
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  AlphaAnimation a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setStartOffset(0L);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setFillAfter(true);
      return localAlphaAnimation;
    }
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      int i1 = Build.VERSION.SDK_INT;
      if ((i1 != 14) && (i1 != 15)) {
        this.jdField_a_of_type_AndroidWidgetToast.cancel();
      }
    }
    this.jdField_a_of_type_AndroidWidgetToast = null;
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      if (paramInt3 == 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt1, paramInt2).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("VideoControlUI", 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt1, paramInt2).b(paramInt3);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      int i1 = Build.VERSION.SDK_INT;
      if ((i1 != 14) && (i1 != 15)) {
        this.jdField_a_of_type_AndroidWidgetToast.cancel();
      }
    }
    this.jdField_a_of_type_AndroidWidgetToast = null;
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      if (paramInt4 == 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("VideoControlUI", 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).b(paramInt4);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    ImageButton localImageButton;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
                  {
                    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(5, paramBoolean);
                    return;
                  }
                } while (this.jdField_c_of_type_AndroidWidgetButton == null);
                this.jdField_c_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
                return;
                if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
                {
                  this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, paramBoolean);
                  return;
                }
              } while (this.jdField_d_of_type_AndroidWidgetButton == null);
              this.jdField_d_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
              return;
              if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, paramBoolean);
            } while (VcSystemInfo.d());
            this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
            return;
          } while (this.jdField_b_of_type_AndroidWidgetButton == null);
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
        } while (VcSystemInfo.d());
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      } while (this.jdField_b_of_type_AndroidViewViewGroup == null);
      localImageButton = (ImageButton)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299087);
    } while (localImageButton == null);
    localImageButton.setEnabled(paramBoolean);
  }
  
  public void a(Intent paramIntent) {}
  
  public abstract void a(View paramView);
  
  public void a(TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = paramTipsManager;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.r == paramBoolean2) {}
    do
    {
      do
      {
        return;
        this.r = paramBoolean2;
        if (!paramBoolean2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoControlUI", 2, "onPhoneCalling call start isSelf: " + paramBoolean1 + ",deviceName: " + this.jdField_a_of_type_ComTencentAvVideoController.a().r);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b();
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().r;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "onPhoneCalling call end isSelf: " + paramBoolean1 + ",mAudioStateBeforePhoneCall: " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_JavaLangString + ",mAudioSesstionType:" + this.jdField_x_of_type_JavaLangString);
      }
    } while ((this.jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null));
    if ("DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      return;
    }
    if ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_x_of_type_JavaLangString);
  }
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  public void ab()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "onPauseAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      if ((this.jdField_x_of_type_Int != 0) && (this.jdField_x_of_type_Int != 1)) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(27, true);
    }
    label48:
    while (this.jdField_x_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
  }
  
  public void ac()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "onResumeAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, false);
    }
  }
  
  public void ad()
  {
    if (this.jdField_l_of_type_Boolean) {}
    while (((this.jdField_s_of_type_Int < 2) || (this.jdField_s_of_type_Int > 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "startTimer");
    }
    this.jdField_l_of_type_Boolean = true;
    if (this.jdField_i_of_type_JavaLangRunnable == null) {
      this.jdField_i_of_type_JavaLangRunnable = new gza(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_i_of_type_JavaLangRunnable, 0L);
  }
  
  public void ae()
  {
    if (!this.jdField_l_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "stopTimer");
      }
      this.jdField_l_of_type_Boolean = false;
    } while (this.jdField_i_of_type_JavaLangRunnable == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
    this.jdField_i_of_type_JavaLangRunnable = null;
  }
  
  public void af()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    }
  }
  
  public void ag()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4)) {
      if (this.jdField_m_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {}
      }
    }
    while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 3))
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_k_of_type_JavaLangRunnable, 6000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
      return;
    }
    if (!this.jdField_m_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
        return;
      }
      j(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
  }
  
  public void ah()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_t_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
    }
  }
  
  public void ai()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
    }
  }
  
  public void aj()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b();
    }
  }
  
  public void ak()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(5, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(9, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(13, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(11, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(15, false);
    }
  }
  
  public void al()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.h();
    }
  }
  
  public int b()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup == null) {}
    do
    {
      return 0;
      if (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299046));
      }
    } while (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null);
    int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493887);
    if (this.jdField_s_of_type_Boolean) {
      i1 += this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493995) / this.D * this.E;
    }
    for (;;)
    {
      return i1;
      if (this.jdField_m_of_type_Boolean) {
        i1 += this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493995);
      } else {
        i1 = 0;
      }
    }
  }
  
  void b()
  {
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299046));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299463));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299087));
    Object localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839068);
    Object localObject2 = TintStateDrawable.a(this.jdField_a_of_type_AndroidContentResResources, 2130839068, 2131428165);
    this.jdField_b_of_type_AndroidWidgetImageButton.setMinimumWidth(((Drawable)localObject1).getIntrinsicWidth());
    this.jdField_b_of_type_AndroidWidgetImageButton.setMinimumHeight(((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_b_of_type_AndroidWidgetImageButton.setImageDrawable((Drawable)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299090));
    this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299047));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299009));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299017));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299013));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299019));
    this.g = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299021));
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299024));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299015));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299012));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299023));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299016));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299018));
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299020));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299022));
    localObject1 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "initUI-->can not get AVActivity");
      }
    }
    label1200:
    label1214:
    do
    {
      return;
      this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject1).findViewById(2131298952));
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
      this.jdField_m_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_m_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((AVActivity)localObject1).findViewById(2131297994));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject1).findViewById(2131298951));
      this.jdField_k_of_type_AndroidWidgetTextView.getPaint().setFlags(8);
      this.jdField_d_of_type_AndroidViewView = ((AVActivity)localObject1).findViewById(2131298947);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((AVActivity)localObject1).findViewById(2131298948));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject1).findViewById(2131298949));
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle = ((ChildLockCircle)((AVActivity)localObject1).findViewById(2131298956));
      localObject2 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject2 == null)
      {
        QLog.e("VideoControlUI", 2, "fail to get context");
        return;
      }
      if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299065) != null) && (this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299066) != null)) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)localObject1, this.jdField_b_of_type_AndroidViewViewGroup);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a();
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
        }
      }
      localObject1 = (WindowManager)((Context)localObject2).getSystemService("window");
      localObject2 = new DisplayMetrics();
      ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
      this.jdField_a_of_type_Float = ((DisplayMetrics)localObject2).widthPixels;
      int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494045);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_Float / 6.0F - this.jdField_a_of_type_Float / 4.0F, 0.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_Float / 4.0F - this.jdField_a_of_type_Float / 6.0F, 0.0F, 0.0F);
      this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_Float - this.jdField_a_of_type_Float / 2.0F - (this.jdField_a_of_type_Float - this.jdField_a_of_type_Float / 4.0F), 0.0F, 0.0F);
      this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_Float - this.jdField_a_of_type_Float / 4.0F - (this.jdField_a_of_type_Float - this.jdField_a_of_type_Float / 2.0F), 0.0F, 0.0F);
      this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, -i1, 0.0F, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_e_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_e_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968671);
      this.jdField_e_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_e_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1000L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1000L);
      this.jdField_f_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968693);
      localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break label1200;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = new SensorHelper((Activity)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        if (!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 2) {
          break label1214;
        }
        try
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        catch (Exception localException)
        {
          return;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_c_of_type_AndroidWidgetButton);
      }
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel != null);
    this.jdField_i_of_type_AndroidWidgetTextView.setText(null);
    this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839076), null, null, null);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "onClose type = " + paramInt + ", state = " + this.jdField_a_of_type_ComTencentAvVideoController.a().j);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().g()) {
      o(paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
      }
      if (SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 2) {
          break;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      if ((paramInt == 25) || (paramInt == 56)) {
        o(paramInt);
      }
      s();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(11, false);
      return;
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setEnabled(false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramInt1, paramInt2);
    }
  }
  
  void b(int paramInt, boolean paramBoolean) {}
  
  public void b(String paramString) {}
  
  public void b(String paramString, boolean paramBoolean) {}
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    int i1 = 0;
    if (this.jdField_b_of_type_AndroidViewViewGroup == null) {}
    do
    {
      return 0;
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299009));
      }
    } while ((this.jdField_e_of_type_AndroidWidgetRelativeLayout == null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
    int i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493888);
    if (this.jdField_s_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        i2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.b();
        label82:
        int i3 = i2 / this.D * this.E;
        i1 = i3;
        if (i3 <= i2) {
          break label249;
        }
        i1 = i2;
      }
    }
    label249:
    for (;;)
    {
      return i1;
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout == null) {
        break;
      }
      i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493989);
      break label82;
      if (this.jdField_m_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= 320)) {
          i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493991) + i2;
        } else if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          i1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.b();
        } else if (this.jdField_e_of_type_AndroidWidgetRelativeLayout != null) {
          i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493989) + i2;
        }
      }
      else if (f()) {
        i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494049) + 0;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    int i1;
    int i2;
    float f1;
    do
    {
      return;
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      i1 = UITools.b(localActivity);
      i2 = UITools.a(localActivity);
      f1 = UITools.a(localActivity);
    } while (!QLog.isColorLevel());
    QLog.d("VideoControlUI", 2, "bottomBarHeight = " + c() + ", topBarHeight = " + b() + ", density = " + f1 + ", screenHeight = " + i1 + ", screenWidth = " + i2 + ", hasSmartBar = " + f());
  }
  
  public void c(int paramInt) {}
  
  public void c(int paramInt1, int paramInt2) {}
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 11) {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(42, true);
      }
    }
    while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
      return;
    }
    TipsManager.a(105, paramString);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(105, paramString, true);
  }
  
  public void d()
  {
    this.jdField_s_of_type_Int = 1;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Gyy == null))
    {
      this.jdField_a_of_type_Gyy = new gyy(this);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
        break label117;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "register camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Gyy, localIntentFilter);
      }
    }
    label117:
    while (!QLog.isColorLevel())
    {
      IntentFilter localIntentFilter;
      return;
    }
    QLog.d("VideoControlUI", 2, "CANNOT register camera availability change receiver!");
  }
  
  void d(int paramInt) {}
  
  public abstract void d(String paramString);
  
  public void d(boolean paramBoolean) {}
  
  public void d_(boolean paramBoolean) {}
  
  public void e(int paramInt)
  {
    this.G = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "onDetectNoDeviceLimits type ： " + paramInt);
    }
    this.jdField_y_of_type_JavaLangString = "";
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject;
    if (paramInt == 1)
    {
      localObject = localAVActivity.getString(2131363688);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
      {
        this.jdField_y_of_type_JavaLangString = "0X8004892";
        this.jdField_z_of_type_JavaLangString = "0X8004893";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1)
        {
          this.jdField_y_of_type_JavaLangString = "0X8004898";
          this.jdField_z_of_type_JavaLangString = "0X8004899";
        }
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          this.jdField_t_of_type_Boolean = true;
          ReportController.b(null, "CliOper", "", "", this.jdField_y_of_type_JavaLangString, this.jdField_y_of_type_JavaLangString, 0, 0, "", "", this.jdField_A_of_type_JavaLangString, "");
          localObject = DialogUtil.a(localAVActivity, 230).setMessage((CharSequence)localObject).setPositiveButton(localAVActivity.getString(2131363687), new gyv(this));
          if (localAVActivity.isResume()) {
            ((QQCustomDialog)localObject).show();
          }
          return;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
          {
            this.jdField_y_of_type_JavaLangString = "0X800488C";
            this.jdField_z_of_type_JavaLangString = "0X800488D";
          }
        }
        if (paramInt == 2)
        {
          localObject = localAVActivity.getString(2131363688);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
          {
            this.jdField_y_of_type_JavaLangString = "0X80049D3";
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1) {
              this.jdField_y_of_type_JavaLangString = "0X80049D4";
            }
          }
          for (;;)
          {
            this.jdField_t_of_type_Boolean = false;
            break;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().h == 1) {
              this.jdField_y_of_type_JavaLangString = "0X80049D1";
            } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
              this.jdField_y_of_type_JavaLangString = "0X80049D2";
            }
          }
        }
        if (paramInt == 3)
        {
          localObject = localAVActivity.getString(2131363689);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
          {
            this.jdField_y_of_type_JavaLangString = "0X800488F";
            this.jdField_z_of_type_JavaLangString = "0X8004890";
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1)
            {
              this.jdField_y_of_type_JavaLangString = "0X8004895";
              this.jdField_z_of_type_JavaLangString = "0X8004896";
            }
          }
          for (;;)
          {
            this.jdField_t_of_type_Boolean = true;
            break;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
            {
              this.jdField_y_of_type_JavaLangString = "0X8004889";
              this.jdField_z_of_type_JavaLangString = "0X800488A";
            }
            else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
            {
              this.jdField_y_of_type_JavaLangString = "0X8004885";
              this.jdField_z_of_type_JavaLangString = "0X8004886";
            }
          }
        }
        if ((paramInt == 4) && (localAVActivity != null))
        {
          if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(25, true);
          }
          localObject = "";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
          {
            localObject = "0X8004891";
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1) {
              localObject = "0X8004897";
            }
          }
          for (;;)
          {
            ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", this.jdField_A_of_type_JavaLangString, "");
            return;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
              localObject = "0X800488B";
            } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) {
              localObject = "0X8004887";
            }
          }
        }
      } while (paramInt != 2048);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(7, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, true);
      }
      localObject = (FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299014);
    } while (localObject == null);
    ((FrameLayout)localObject).setClickable(true);
  }
  
  public abstract void e(String paramString);
  
  public void e(boolean paramBoolean) {}
  
  boolean e()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel; (this.jdField_f_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) || (((View)localObject).getVisibility() != 0); localObject = this.jdField_e_of_type_AndroidWidgetRelativeLayout) {
      return false;
    }
    return true;
  }
  
  public void f()
  {
    this.jdField_s_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d();
    }
  }
  
  public abstract void f(boolean paramBoolean);
  
  protected boolean f()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if (Build.DEVICE.equals("mx2")) {
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
        return false;
      }
    }
    return false;
  }
  
  public void g()
  {
    this.jdField_s_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e();
    }
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
          if (QLog.isColorLevel()) {
            QLog.e("VideoControlUI", 2, "isKeyguardLocked = " + localKeyguardManager.isKeyguardLocked() + ". isKeyguardSecure =" + localKeyguardManager.isKeyguardSecure());
          }
          if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
          {
            boolean bool = localKeyguardManager.isKeyguardSecure();
            if (bool) {
              return true;
            }
          }
          return false;
        }
        catch (SecurityException localSecurityException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoControlUI", 2, "isKeyguardLocked() = " + localSecurityException);
          }
          return QQUtils.a(localContext);
        }
      }
      return QQUtils.a(localContext);
    }
    return true;
  }
  
  public void h()
  {
    this.jdField_s_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.f();
    }
  }
  
  public abstract void h(int paramInt);
  
  public void i() {}
  
  public abstract void i(int paramInt);
  
  public void j()
  {
    this.jdField_s_of_type_Int = 5;
    ae();
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.g();
    }
  }
  
  public void j(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoControlUI", 2, "switchToolBar-->mVideoController is null, Why???");
      }
    }
    label22:
    label269:
    label284:
    label315:
    label458:
    label490:
    label533:
    label602:
    label616:
    do
    {
      do
      {
        do
        {
          break label22;
          do
          {
            return;
          } while (((this.jdField_a_of_type_ComTencentAvVideoController.a().l == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_t_of_type_Boolean)) || (this.p) || ((!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)));
          if (QLog.isColorLevel()) {
            QLog.e("VideoControlUI", 2, "switchToolBar-->mToolbarDisplay = " + this.jdField_m_of_type_Boolean);
          }
          if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("VideoControlUI", 2, "switchToolBar-->mRootView is null Why");
        return;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
          break;
        }
        this.jdField_m_of_type_Boolean = true;
        if (this.jdField_e_of_type_AndroidWidgetRelativeLayout == null) {
          this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299009));
        }
        if (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null) {
          this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299046));
        }
        if (!this.jdField_m_of_type_Boolean) {
          break label533;
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(false);
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break label458;
        }
      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown()) && (this.jdField_f_of_type_AndroidWidgetRelativeLayout.isShown()));
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (paramInt != 1) {
          break label490;
        }
        this.jdField_c_of_type_AndroidViewAnimationAnimation = a(true);
        this.jdField_d_of_type_AndroidViewAnimationAnimation = a(true);
        if (this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener == null) {
          this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener = new gzb(this);
        }
        this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_d_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener);
        if (VcSystemInfo.c()) {
          break label616;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break label602;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
        {
          this.jdField_m_of_type_Boolean = true;
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 3)
        {
          this.jdField_m_of_type_Boolean = true;
          break;
        }
        if (!this.jdField_m_of_type_Boolean) {}
        for (boolean bool = true;; bool = false)
        {
          this.jdField_m_of_type_Boolean = bool;
          break;
        }
        if ((!this.jdField_e_of_type_AndroidWidgetRelativeLayout.isShown()) || (!this.jdField_f_of_type_AndroidWidgetRelativeLayout.isShown())) {
          break label269;
        }
        return;
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        break label284;
        this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968677);
        this.jdField_d_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968711);
        break label315;
        if (paramInt == 1)
        {
          this.jdField_c_of_type_AndroidViewAnimationAnimation = a(false);
          this.jdField_d_of_type_AndroidViewAnimationAnimation = a(false);
          break label315;
        }
        this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968676);
        this.jdField_d_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968710);
        break label315;
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_m_of_type_Boolean), Boolean.valueOf(true), Long.valueOf(0L) });
      }
      if (this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
        this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(null);
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_m_of_type_Boolean), Boolean.valueOf(false), Long.valueOf(0L) });
  }
  
  public void j(String paramString) {}
  
  public void k()
  {
    this.jdField_s_of_type_Int = 6;
    ae();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gzc);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Gyy != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label430;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "UnRegister camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Gyy);
      this.jdField_a_of_type_Gyy = null;
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.g();
        this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
      }
      this.q = false;
      this.jdField_a_of_type_AndroidContentResResources = null;
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      if (this.jdField_b_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_b_of_type_AndroidViewViewGroup = null;
      }
      this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
      this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
      this.h = null;
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
      this.jdField_c_of_type_AndroidWidgetButton = null;
      this.jdField_d_of_type_AndroidWidgetButton = null;
      this.jdField_b_of_type_AndroidWidgetButton = null;
      this.jdField_d_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_AndroidWidgetImageButton = null;
      this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_d_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_a_of_type_AndroidWidgetToast = null;
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
      this.jdField_d_of_type_AndroidWidgetImageView = null;
      this.jdField_e_of_type_AndroidViewView = null;
      this.jdField_i_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
      this.jdField_i_of_type_AndroidWidgetTextView = null;
      this.jdField_j_of_type_AndroidWidgetTextView = null;
      this.jdField_e_of_type_AndroidWidgetButton = null;
      this.jdField_f_of_type_AndroidWidgetButton = null;
      this.g = null;
      this.jdField_b_of_type_AndroidWidgetImageButton = null;
      this.jdField_c_of_type_AndroidViewViewGroup = null;
      this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_c_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_e_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
      this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = null;
      this.jdField_e_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(false);
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c();
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
      }
      return;
      label430:
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "CANNOT UnRegister camera availability change receiver!!");
      }
    }
  }
  
  public void k(String paramString) {}
  
  public void l() {}
  
  public void m() {}
  
  public void n(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null) {
        localActivity.getLayoutInflater().inflate(paramInt, this.jdField_b_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  public void n(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && ((this instanceof DoubleVideoCtrlUI)) && (!(this instanceof HYControlUI)) && (!(this instanceof MicSpeakerControlUI)))
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.u)) {
        break label107;
      }
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
        break label102;
      }
    }
    label102:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      localQavPanel.a(paramBoolean, false, false);
      return;
    }
    label107:
    QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localQavPanel.a(bool1, paramBoolean, false);
      return;
    }
  }
  
  public void o() {}
  
  void o(int paramInt)
  {
    int i1 = 2131363559;
    switch (paramInt)
    {
    default: 
      i1 = 2131363563;
    case 12: 
    case 43: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011) {
        if (paramInt != 9) {
          break label182;
        }
      }
      break;
    }
    label182:
    for (i1 = 2131363174;; i1 = 2131363558)
    {
      d(i1);
      return;
      i1 = 2131363327;
      break;
      i1 = 2131363560;
      break;
      i1 = 2131363565;
      break;
      i1 = 2131363562;
      break;
      i1 = 2131363564;
      break;
      i1 = 2131363563;
      break;
    }
  }
  
  void o(boolean paramBoolean)
  {
    if (!AVNotifyCenter.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {}
    while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 2) {
      return;
    }
    n(paramBoolean);
  }
  
  public void p() {}
  
  void p(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
            {
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, this.jdField_a_of_type_AndroidContentResResources.getString(2131363382));
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, true);
              return;
            }
          } while (this.jdField_d_of_type_AndroidWidgetButton == null);
          UITools.a(this.jdField_d_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131363382));
          this.jdField_d_of_type_AndroidWidgetButton.setSelected(true);
          return;
          if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, this.jdField_a_of_type_AndroidContentResResources.getString(2131363360));
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, true);
        } while (VcSystemInfo.d());
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        return;
      } while (this.jdField_b_of_type_AndroidWidgetButton == null);
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131363360));
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
    } while (VcSystemInfo.d());
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  void p(boolean paramBoolean)
  {
    if (this.jdField_j_of_type_JavaLangRunnable == null) {
      this.jdField_j_of_type_JavaLangRunnable = new gyz(this);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_j_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
  }
  
  public void q() {}
  
  public void q(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
            {
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, this.jdField_a_of_type_AndroidContentResResources.getString(2131363381));
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, false);
              return;
            }
          } while (this.jdField_d_of_type_AndroidWidgetButton == null);
          UITools.a(this.jdField_d_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131363381));
          this.jdField_d_of_type_AndroidWidgetButton.setSelected(false);
          return;
          if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, this.jdField_a_of_type_AndroidContentResResources.getString(2131363359));
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, false);
        } while (VcSystemInfo.d());
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        return;
      } while (this.jdField_b_of_type_AndroidWidgetButton == null);
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131363359));
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
    } while (VcSystemInfo.d());
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void q(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(paramBoolean);
    }
  }
  
  public void r() {}
  
  public void r(int paramInt)
  {
    this.jdField_w_of_type_Int = paramInt;
  }
  
  public void r(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(paramBoolean);
    }
  }
  
  void s() {}
  
  public void s(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "setTipsRotation --> Rotation = " + paramInt);
    }
    if (((paramInt != 0) || (paramInt != 180)) && (Build.VERSION.SDK_INT >= 11)) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(360 - paramInt);
    }
  }
  
  public void s(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramBoolean);
    }
  }
  
  public void t() {}
  
  public void t(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(paramBoolean);
    }
  }
  
  public void u() {}
  
  void u_()
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = new QQFrameByFrameAnimation();
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(100);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.c(8);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(new int[] { 2130839042, 2130839043 });
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener);
  }
  
  public abstract void v();
  
  public abstract void w();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\VideoControlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */