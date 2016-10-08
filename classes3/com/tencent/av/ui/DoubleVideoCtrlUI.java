package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.report.AVReport;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockCircle.AnimationListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.QQCallLightalkConfig;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import grk;
import grl;
import grm;
import grn;
import gro;
import grp;
import grq;
import grr;
import grs;
import grt;
import gru;
import grx;
import gry;
import grz;
import gsa;
import gsb;
import gsc;
import gsd;
import gse;
import gsf;
import gsg;
import gsh;
import gsi;
import gsj;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  static final String jdField_a_of_type_JavaLangString = "DoubleVideoCtrlUI";
  int jdField_a_of_type_Int;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
  public ChildLockCircle.AnimationListener a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  public boolean a;
  public int b;
  Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener;
  public Animation b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable;
  public boolean b;
  public Animation.AnimationListener c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  Runnable jdField_c_of_type_JavaLangRunnable;
  boolean jdField_c_of_type_Boolean;
  Runnable jdField_d_of_type_JavaLangRunnable;
  boolean jdField_d_of_type_Boolean;
  boolean e;
  public boolean f;
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    this.jdField_a_of_type_JavaLangRunnable = new grk(this);
    this.jdField_b_of_type_JavaLangRunnable = new grx(this);
    this.jdField_c_of_type_JavaLangRunnable = new gsd(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new gsh(this);
    this.jdField_d_of_type_JavaLangRunnable = new grr(this);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new grs(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new grt(this);
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener = new gru(this);
  }
  
  public void A()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long != 1L) {
        super.ad();
      }
    }
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
              if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {
                break;
              }
              if (this.jdField_c_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              }
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long == 1L);
            super.ad();
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().f());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().al);
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long == 1L);
      super.ad();
      return;
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long == 1L);
    super.ad();
  }
  
  public void B()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.b()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().ak)) {
      return;
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    super.ad();
  }
  
  public void D()
  {
    ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045)).setVisibility(4);
    super.D();
  }
  
  public void E()
  {
    ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045)).setVisibility(0);
    super.E();
  }
  
  void F()
  {
    if (this.jdField_d_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || ((!this.jdField_a_of_type_ComTencentAvVideoController.a().c()) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().e())) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean)) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80060A7", "0X80060A7", 0, 0, "", "", "", "");
    this.jdField_d_of_type_Boolean = true;
  }
  
  protected int a()
  {
    return 2130903542;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, paramInt);
    }
    return 0;
  }
  
  public void a()
  {
    View localView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045);
    if (localView != null) {
      localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427379));
    }
  }
  
  void a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    switch (paramInt)
    {
    }
    label289:
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
                  do
                  {
                    return;
                  } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 26));
                  if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l != 1004) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 1000) && (i != 5)) {
                    break;
                  }
                } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
                this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
                this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
                return;
                k(0);
                return;
              } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (this.jdField_a_of_type_ComTencentAvVideoController.d()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 26));
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().C) {
                break label289;
              }
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 1006) {
                break;
              }
            } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(22, true);
            return;
            if (j >= 16) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(21, true);
          return;
        } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(22, true);
        return;
        if ((i == 4) || (i == 2)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(21, true);
      return;
    } while (j >= 16);
    k(1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onTerSwitchSyncStatus cameraStatus：" + paramInt1 + ", micStatus:" + paramInt2);
    }
    if (paramInt1 == 1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      label131:
      Object localObject;
      boolean bool;
      if (paramInt1 == 0)
      {
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        if ((paramInt1 == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
          break label292;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 2;
          f(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
        }
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (paramInt2 != 0) {
          break label334;
        }
        bool = true;
        label146:
        ((SessionInfo)localObject).jdField_c_of_type_Boolean = bool;
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
          break label340;
        }
        super.p(2131299015);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131363362));
        }
      }
      label292:
      label334:
      label340:
      do
      {
        return;
        v();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false) });
        break;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
          break label131;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 1;
        f(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
        break label131;
        bool = false;
        break label146;
        super.q(2131299015);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, (String)localObject);
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131363361));
      return;
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 27) || (paramInt1 == 26)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(27, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(27, paramBoolean);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    paramBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onClick view.getId = " + paramView.getId());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    String str;
    Object localObject1;
    label1092:
    int i;
    Object localObject2;
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
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean));
                      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
                      localObject1 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                      switch (paramView.getId())
                      {
                      case 2131299348: 
                      default: 
                        return;
                      case 2131299012: 
                        boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().H;
                        paramView = this.jdField_a_of_type_ComTencentAvVideoController;
                        if (!bool2) {
                          bool1 = true;
                        }
                        DataReport.a(paramView, bool1);
                        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
                        ag();
                        return;
                      }
                    } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.b(7)) || (localObject1 == null));
                    DialogUtil.a((Context)localObject1, 230).setMessage(((AVActivity)localObject1).getString(2131363689)).setPositiveButton(((AVActivity)localObject1).getString(2131363687), new grm(this)).show();
                    return;
                  } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 22));
                  if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) {
                    if (localObject1 != null) {
                      DialogUtil.a((Context)localObject1, 230).setMessage(((AVActivity)localObject1).getString(2131363688)).setPositiveButton(((AVActivity)localObject1).getString(2131363687), new grn(this)).show();
                    }
                  }
                  for (;;)
                  {
                    ag();
                    return;
                    if (((!VcSystemInfo.d()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1) || (!this.jdField_a_of_type_ComTencentAvVideoController.c())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 1011))
                    {
                      ReportController.b(null, "CliOper", "", "", "0X8005612", "0X8005612", 0, 0, "", "", "", "");
                      if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1) {
                        ReportController.b(null, "CliOper", "", "", "0X8004E93", "0X8004E93", 0, 0, "", "", "", "");
                      }
                      a(paramView.getId());
                    }
                  }
                } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 22) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011));
                a(paramView.getId());
                ag();
                return;
              } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().f());
              if (this.t - this.v > 2)
              {
                this.v = this.t;
                this.u = 0;
              }
              this.u += 1;
            } while (this.u <= 5);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(112) });
            this.u = 0;
            this.v = 0;
            return;
            if (((this instanceof HYControlUI)) || ((this instanceof MicSpeakerControlUI)) || (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null))
            {
              TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean = false;
              if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().K) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
                ag();
              }
              this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().z != -1) {}
              for (;;)
              {
                this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = true;
                DataReport.d(this.jdField_a_of_type_ComTencentAvVideoController);
                if (this.jdField_b_of_type_Boolean) {
                  DataReport.z(this.jdField_a_of_type_ComTencentAvVideoController);
                }
                if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
                  DataReport.f();
                }
                this.jdField_a_of_type_ComTencentAvVideoController.c(str, this.jdField_a_of_type_ComTencentAvVideoController.a().z);
                this.jdField_a_of_type_Boolean = true;
                this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean = false;
                return;
                this.jdField_a_of_type_ComTencentAvVideoController.a().z = 0;
              }
            }
            this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gro(this, str));
            return;
            paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
            if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean)
            {
              bool1 = true;
              paramView.jdField_c_of_type_Boolean = bool1;
              if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
                break label1092;
              }
              super.p(2131299015);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
              this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131363362));
            }
            for (;;)
            {
              ag();
              DataReport.c(this.jdField_a_of_type_ComTencentAvVideoController);
              return;
              bool1 = false;
              break;
              super.q(2131299015);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
              this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131363361));
            }
            b();
            DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("DoubleVideoCtrlUI", 2, "qav_bottombar_camera");
            }
            DataReport.l(this.jdField_a_of_type_ComTencentAvVideoController);
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().A == 2) {
              ReportController.b(null, "CliOper", "", "", "0X8004E98", "0X8004E98", 0, 0, "", "", "", "");
            }
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("DoubleVideoCtrlUI", 2, "open camera");
              }
              localObject1 = new VideoViewInfo();
              str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
              paramView = str;
              if (str.startsWith("+")) {
                paramView = str.substring(1);
              }
              ((VideoViewInfo)localObject1).jdField_a_of_type_Long = CharacterUtil.a(paramView);
              ((VideoViewInfo)localObject1).jdField_a_of_type_Int = 1;
              paramView = new ArrayList();
              paramView.add(localObject1);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), paramView });
              v();
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false) });
              ReportController.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().x) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new grp(this), 500L);
              }
            }
            for (;;)
            {
              if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.c()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
              {
                this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
                this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
              }
              ag();
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
                if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
                {
                  w();
                  this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
                  if (QLog.isColorLevel()) {
                    QLog.d("DoubleVideoCtrlUI", 2, "local close camera");
                  }
                }
                else
                {
                  v();
                  this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false) });
                  if (QLog.isColorLevel()) {
                    QLog.d("DoubleVideoCtrlUI", 2, "local open camera");
                  }
                }
              }
            }
            i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
            DataReport.g(paramView.getId(), i);
            TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean = false;
            paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString));
          } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
          localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().u == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString)))
          {
            localObject2 = VideoActionSheet.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            ((VideoActionSheet)localObject2).a(2131372446);
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Int == 1) {
              ((VideoActionSheet)localObject2).a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131372444), ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130839269), 0);
            }
            for (;;)
            {
              ((VideoActionSheet)localObject2).c(2131372445);
              ((VideoActionSheet)localObject2).d(2131367262);
              ((VideoActionSheet)localObject2).a(new grq(this, (VideoActionSheet)localObject2, str, (Context)localObject1, paramView));
              ((VideoActionSheet)localObject2).show();
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Int == 2) {
                ((VideoActionSheet)localObject2).a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131372444), ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130839268), 0);
              } else {
                ((VideoActionSheet)localObject2).a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131372444), ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130839267), 0);
              }
            }
          }
          if (localObject1 != null)
          {
            ((Context)localObject1).startActivity(paramView);
            paramView = new Intent("tencent.video.v2q.insertSystemCall");
            paramView.putExtra("phoneNumber", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString);
            paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
          }
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.c(str, 0);
          return;
          DataReport.k(this.jdField_a_of_type_ComTencentAvVideoController);
          paramView = new Intent();
          paramView.setAction("tencent.video.v2q.AddContactsFromC2C");
          paramView.putExtra("peerUin", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
          paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
          ag();
        } while ((!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)));
        paramView = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (paramView == null);
      paramView = paramView.a();
    } while (paramView == null);
    paramView.c();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "switchcamera");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107) });
    ag();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = false;
      ReportController.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
      UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131363398));
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = true;
    ReportController.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
    UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131363397));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "qav_bottombar_leave_msg_no_answer");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().e;
      this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramView, (String)localObject1, (String)localObject2, true);
    }
    DataReport.v(this.jdField_a_of_type_ComTencentAvVideoController);
    this.jdField_a_of_type_ComTencentAvVideoController.c(str, this.jdField_a_of_type_ComTencentAvVideoController.a().z);
    return;
    DataReport.g();
    ReportController.b(null, "CliOper", "", "", "0X800501D", "0X800501D", 0, 0, "", "", "", "");
    throw new IllegalArgumentException("美颜需要重新响应, 记得加break");
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().c()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().e()))) {
      ReportController.b(null, "CliOper", "", "", "0X80060A6", "0X80060A6", 0, 0, "", "", "", "");
    }
    throw new IllegalArgumentException("美颜需要重新响应, 记得加break");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123) });
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a(str, 1, 5, 1);
    a(2131363725, 0, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492908));
  }
  
  public void a(QQCallLightalkConfig paramQQCallLightalkConfig, Intent paramIntent, boolean paramBoolean)
  {
    VideoActionSheet localVideoActionSheet = VideoActionSheet.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localVideoActionSheet.a(String.format(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getString(2131372175), new Object[] { this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString }));
    if ((NetworkUtil.e((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!TextUtils.isEmpty(paramQQCallLightalkConfig.jdField_g_of_type_JavaLangString)))
    {
      new InitUrlDrawable().c();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramQQCallLightalkConfig.jdField_g_of_type_JavaLangString, 0, 0, null, null, false);
      localVideoActionSheet.a(paramQQCallLightalkConfig.jdField_f_of_type_JavaLangString, localURLDrawable, 0);
    }
    for (;;)
    {
      localVideoActionSheet.c(2131372177);
      localVideoActionSheet.d(2131367262);
      localVideoActionSheet.setOnKeyListener(new grz(this, paramBoolean));
      localVideoActionSheet.a(new gsa(this, paramBoolean));
      localVideoActionSheet.a(new gsb(this, localVideoActionSheet, new int[] { 1, 2 }, paramQQCallLightalkConfig, paramIntent));
      localVideoActionSheet.show();
      return;
      localVideoActionSheet.c(2131372174);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 25)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoCtrlUI", 2, "setQCallNickName");
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    super.a(paramString);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoCtrlUI", 2, "setQCallHead uin = " + paramString);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
    super.a(paramString, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onInviteReached remotePhoneState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int + " # remoteTerminal = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int + " # phoneOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int + " # pcOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().n + " # subState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long + " # isPeerNetworkWell = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().c()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ag) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011)) {}
    int i;
    label350:
    label501:
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString.contains(paramString1));
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int;
      if ((i >= 0) && (this.j != null))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          break label350;
        }
        this.j.setText(2131363590);
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363590);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(2131363590);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long == 0L) {}
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
        }
        if ((i <= 0) || (i == 3)) {
          break label501;
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(i + 9 - 1, true);
        }
        DataReport.h(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
        this.j.setText(paramString2);
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramString2);
        break;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long == 2L)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 8, 0L);
          if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_JavaLangString))) {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(66, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_JavaLangString, 0L, 0);
          }
          ReportController.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
        }
      }
      if ((i == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().n == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(3, true);
        return;
      }
    } while ((i != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1));
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(6, true);
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if ((this.j != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoCtrlUI", 2, "setTitleText :" + paramString);
      }
      this.j.setText(paramString);
    }
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "mRingAnimator.mfRingAnimation:" + this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.jdField_a_of_type_Boolean);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null))
    {
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramBoolean);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    }
    h(paramBoolean);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (!(this instanceof HYControlUI)) && (!(this instanceof MicSpeakerControlUI)))
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.u)) {
          break label199;
        }
        localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
        {
          paramBoolean = true;
          ((QavPanel)localObject).a(paramBoolean, false, false);
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        if (!(this instanceof HYControlUI)) {
          break label245;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getColor(2131427779));
        }
        if (this.j != null) {
          this.j.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getColor(2131427779));
        }
        return;
        paramBoolean = false;
        break;
        label199:
        localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ((QavPanel)localObject).a(paramBoolean, BeautySettingUi.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface), true);
          break;
        }
        label245:
        localObject = this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
        paramBoolean = bool2;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
          paramBoolean = true;
        }
        ((TipsManager)localObject).a(paramBoolean, true);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (!(this instanceof HYControlUI)) && (!(this instanceof MicSpeakerControlUI)))
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.u)) {
        break label421;
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
        break label416;
      }
    }
    label416:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((QavPanel)localObject).a(paramBoolean, false, false);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        if (!(this instanceof HYControlUI)) {
          break label467;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(true);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.j == null) {
        break;
      }
      this.j.setTextColor(Color.parseColor("#566B7D"));
      return;
    }
    label421:
    Object localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((QavPanel)localObject).a(paramBoolean, BeautySettingUi.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface), false);
      break;
    }
    label467:
    localObject = this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      ((TipsManager)localObject).a(paramBoolean, false);
      break;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onAfterOpenCamera success: " + paramBoolean + ", preSessionType: " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if ((this.jdField_w_of_type_Int > 1) && (this.jdField_b_of_type_AndroidWidgetImageButton != null)) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
          super.p(2131299023);
        }
        o(true);
        if ((paramInt == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().H) && ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_r_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
        }
        DataReport.c();
        DataReport.q(this.jdField_a_of_type_ComTencentAvVideoController);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
          f(2);
        }
      }
      return;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onPhoneCalling isSelf = " + paramBoolean1 + " # isCalling = " + paramBoolean2);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null)) {}
    label65:
    do
    {
      do
      {
        do
        {
          break label65;
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 2);
          if (!paramBoolean1) {
            break;
          }
          if (paramBoolean2)
          {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(39, true);
            return;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(39, false);
        } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
        DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230).setMessage(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131363719)).setPositiveButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131363687), new gsi(this)).show();
        ReportController.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
        return;
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        if (!paramBoolean2) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, (String)localObject);
        }
      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(38, true);
      Object localObject = new TraeMediaPlayer((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (GAudioSoundUtil.a("qav_peer_phone_calling.mp3")) {
        ((TraeMediaPlayer)localObject).a(2, 0, null, GAudioSoundUtil.a() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
      }
      while (this.jdField_a_of_type_ComTencentAvVideoController.a().K)
      {
        ReportController.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
        return;
        ((TraeMediaPlayer)localObject).a(0, 2131165196, null, null, false, 1, false, true, 0);
        GAudioSoundUtil.a(BaseApplicationImpl.a());
      }
      ReportController.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
      return;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, (String)localObject);
      }
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(38, false);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean) {
        bool = true;
      }
      return bool;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    return false;
  }
  
  void b()
  {
    super.n(a());
    super.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 2800)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(11);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
      }
    }
    else
    {
      F();
      g(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299085));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299086));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131296829));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299060));
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
        break label558;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(15, this.jdField_a_of_type_AndroidContentResResources.getString(2131363368));
      }
      i(false);
      label188:
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 1011) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString)) {
          break label593;
        }
        if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null)
        {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setEnabled(true);
          DataReport.e(this.jdField_a_of_type_ComTencentAvVideoController);
        }
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().k) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(7, false);
      }
      c();
      if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() != 1))
      {
        localObject = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299462);
        if (localObject != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493874);
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
      }
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.setAnimationListener(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener);
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_f_of_type_AndroidWidgetRelativeLayout, null, this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299055), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299128), this.jdField_d_of_type_AndroidWidgetLinearLayout);
      GAudioSoundUtil.a(BaseApplicationImpl.a());
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(12);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((QavPanel)localObject).a(4, bool, BeautySettingUi.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
        this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
        break;
      }
      label558:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(15, this.jdField_a_of_type_AndroidContentResResources.getString(2131363437));
      }
      i(true);
      break label188;
      label593:
      if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void b(int paramInt)
  {
    z();
    super.b(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onClose type = " + paramInt);
    }
    int k = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long == 2L)
    {
      i = 1;
      if (paramInt != 12) {
        break label458;
      }
      j = 1;
      label80:
      if (((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((this.jdField_a_of_type_ComTencentAvVideoController.a().h()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26)) && (this.jdField_e_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 2)))
      {
        if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          DataReport.u(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString)) {
            break label463;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(16, false);
          label262:
          if ((paramInt == 3) && (this.jdField_b_of_type_AndroidWidgetImageButton != null)) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
          }
          if (((paramInt != 3) && (paramInt != 12)) || (!VideoUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().l, this.jdField_a_of_type_ComTencentAvVideoController.a().A))) {
            break label476;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(17, 4);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(16, 4);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.f();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
      }
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
        DataReport.f();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean = false;
      if (paramInt == 24)
      {
        this.jdField_o_of_type_Boolean = true;
        this.h.setText(2131363561);
      }
      return;
      i = 0;
      break;
      label458:
      j = 0;
      break label80;
      label463:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(16, true);
      break label262;
      label476:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(17, true);
    }
  }
  
  public void b(String paramString) {}
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onPeerSwitchTerminal, bStartSwitch : " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(35, true);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(35, false);
    if (this.jdField_a_of_type_ComTencentAvVideoController.c()) {
      if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1))
      {
        if (!VcSystemInfo.d()) {
          break label166;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
      }
    }
    for (;;)
    {
      t_();
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, paramString);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
      return;
      label166:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      continue;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoCtrlUI", 2, "onPeerSwitchTerminal, local close camera");
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        }
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(23, true);
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
    {
      if (((!VcSystemInfo.d()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1)) && (paramBoolean))
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
        }
        ReportController.b(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (this.jdField_w_of_type_Int > 1))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
          this.jdField_f_of_type_Boolean = true;
        }
        label162:
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {
            break label402;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(5, false);
        }
        label188:
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
          break label414;
        }
        super.q(2131299023);
      }
    }
    for (;;)
    {
      e();
      do
      {
        return;
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        break;
        if (!paramBoolean)
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.d()))
          {
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
              break label162;
            }
            this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
            this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
            break label162;
          }
          if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
            break label162;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
          break label162;
        }
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.c()) || (!VcSystemInfo.d())) {
          break label347;
        }
      } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
      return;
      label347:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
        break label162;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.postDelayed(new gsg(this), 1000L);
      break label162;
      label402:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(5, true);
      break label188;
      label414:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        super.p(2131299023);
        if (this.jdField_w_of_type_Int > 1) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        }
      }
      else
      {
        super.q(2131299023);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean) {
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(false) });
    if ((!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
      a(2131363600, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492908));
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().h()))
    {
      o(this.jdField_a_of_type_ComTencentAvVideoController.a().z);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new grl(this), 150L);
    }
    if (SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((SmallScreenActivityPlugin)localObject).a();
          }
        }
      }
    }
    return false;
  }
  
  protected void c()
  {
    super.c();
    Object localObject;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        i = UITools.b((Context)localObject);
        j = UITools.a((Context)localObject);
        UITools.a((Context)localObject);
      }
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299055)).getLayoutParams();
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      int k;
      switch (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int)
      {
      default: 
      case 2: 
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          return;
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
            break;
          }
          ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
        }
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          k = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.c();
          j = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.b(k);
        }
        break;
      }
      for (;;)
      {
        int m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494094);
        if ((k == 1) || (k == 2))
        {
          if (this.jdField_m_of_type_Boolean)
          {
            ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
            ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
            ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
            if (!this.s)
            {
              ((RelativeLayout.LayoutParams)localObject).topMargin = (j + (i - c() - j) / 2);
              break;
            }
            ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
            ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
            ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
            ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
            break;
          }
          ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
          break;
        }
        if ((k != 3) && (k != 4)) {
          break;
        }
        if (this.jdField_m_of_type_Boolean)
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = (j + m);
          break;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
        break;
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        if (j <= 320)
        {
          if ((this.jdField_d_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_d_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
          {
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = (c() + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494011));
            break;
          }
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = (c() + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494010));
          break;
        }
        if (j <= 480)
        {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = (c() + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494009));
          break;
        }
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (c() + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494008));
        break;
        j = 0;
        k = 0;
      }
      j = 0;
      i = 0;
    }
  }
  
  public void c(int paramInt)
  {
    if ((Build.VERSION.SDK_INT > 11) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean))) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(360 - paramInt);
    }
    if ((Build.VERSION.SDK_INT > 11) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(0.0F);
    }
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.setRotation(360 - paramInt);
    }
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    this.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
    z();
  }
  
  void c(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299055);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramBoolean)
    {
      int i = 0;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        i = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
      if (i <= 320)
      {
        localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494157);
        localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494160);
        localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494160);
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams(localLayoutParams1);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
        return;
        if (i <= 480)
        {
          localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494156);
          localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494159);
          localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494159);
        }
        else
        {
          localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494155);
          localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494158);
          localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494158);
        }
      }
    }
    localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493999);
    localRelativeLayout.setLayoutParams(localLayoutParams1);
    localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493975);
    localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493975);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
  }
  
  boolean c()
  {
    return true;
  }
  
  public void d()
  {
    super.d();
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAvVideoController.a(302, 1, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, l1);
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_DoubleVideoCtrlUI", 4, ">>>onCreate(), ts=" + l1);
    }
    b();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
      super.p(2131299023);
    }
    int j;
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d()))
    {
      j = 1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().K) {
        j = 0;
      }
      i = 1;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().C) {
        i = 4;
      }
      if (1008 != this.jdField_a_of_type_ComTencentAvVideoController.a().l) {
        break label2888;
      }
      i = 4;
    }
    label437:
    label694:
    label1207:
    label1476:
    label1529:
    label1570:
    label1606:
    label1684:
    label1922:
    label1954:
    label1967:
    label2082:
    label2090:
    label2119:
    label2825:
    label2888:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean) {
        j = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i);
      }
      Object localObject;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoCtrlUI", 2, "result = " + j);
        }
        if (j == 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoCtrlUI", 2, "Video connect fail!");
        }
        if (j == -2)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 9);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a()) {
          VideoController.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            ((Activity)localObject).finish();
          }
        }
        return;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString.equals("Lightalk")) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString != null))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().B == 0)
          {
            i = 1;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 24) {
              break label694;
            }
            i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().l, this.jdField_a_of_type_ComTencentAvVideoController.a().e, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, null, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().A, 1024, null, null);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(65, true);
            }
            j = i;
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("DoubleVideoCtrlUI", 2, "setBindInfo: mBindType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().A + ",mBindId = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString);
            }
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvVideoController.a().A, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString);
            j = i;
            break;
            i = 4;
            break label437;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 25)
            {
              if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString.startsWith("+"))) {
                this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString.substring(3);
              }
              i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().l, this.jdField_a_of_type_ComTencentAvVideoController.a().e, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, null, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().A, 1025, null, null);
            }
            else
            {
              i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().A);
            }
          }
        }
        j = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().l, this.jdField_a_of_type_ComTencentAvVideoController.a().e, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte, null, null, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoCtrlUI", 2, "Session State = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int + ",SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoCtrlUI", 2, "deviceName = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_r_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 2))
        {
          this.jdField_x_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_x_of_type_JavaLangString);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(9, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(9, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, false);
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
          break label2119;
        }
        if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        localObject = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045);
        if ((VideoUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().l, this.jdField_a_of_type_ComTencentAvVideoController.a().A)) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(65, false);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
          break label1922;
        }
        ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427800));
        n(false);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localObject = localContext;
          if (localContext != null) {
            localObject = localContext.getApplicationContext();
          }
          if ((localObject == null) || (!NetworkUtil.i((Context)localObject)) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().K)) {}
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
          break label1967;
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null))
        {
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().L) {
            break label1954;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(38, true);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
          break label2082;
        }
        i(true);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          n(BeautySettingUi.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
        }
        if (!VcSystemInfo.d()) {
          break label2090;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
          n();
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(9, true);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(9, true);
        }
        t_();
        DataReport.d(this.jdField_a_of_type_ComTencentAvVideoController, true);
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean) {
          u();
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().K)
        {
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
          break label2825;
        }
        super.p(2131299015);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131363362));
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
          b(false);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.post(new gsf(this));
        if ((this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) && (!(this instanceof HYControlUI)) && (!(this instanceof MicSpeakerControlUI))) {
          this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
        }
        long l2 = System.currentTimeMillis();
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("IVR_TS_DoubleVideoCtrlUI", 4, "<<<onCreate(), ts=" + l2 + ", cost=%dms" + (l2 - l1));
        return;
        this.jdField_x_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        break label1207;
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_w_of_type_Int <= 1)) {
          break label1476;
        }
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        break label1476;
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
        break label1529;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b() < 2L) {
          break label1529;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
            break label1529;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(27, true);
          break label1529;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) == 5)
        {
          if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(26, true);
          }
          DataReport.i(this.jdField_a_of_type_ComTencentAvVideoController);
          break label1529;
        }
        if ((!this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b()) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)) {
          break label1529;
        }
        break label1529;
        n(false);
        break label1570;
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break label1606;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        break label1606;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().e())
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().K)
          {
            i = 2131363460;
            this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427799));
          }
          for (;;)
          {
            this.j.setText(i);
            if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
              this.jdField_c_of_type_AndroidWidgetTextView.setText(i);
            }
            if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(i);
            break;
            i = 2131363310;
          }
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
        {
          i = 2131363512;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().ag) {
            i = 2131363668;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011) {
            i = 2131363558;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().K)
          {
            this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427799));
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)) {
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(6, true);
            }
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
            {
              this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
              this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
            }
            DataReport.d(this.jdField_a_of_type_ComTencentAvVideoController, false);
            this.j.setText(i);
            if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
              this.jdField_c_of_type_AndroidWidgetTextView.setText(i);
            }
            if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
              this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(i);
            }
            i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
            localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject);
            i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int;
            if ((i == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().n == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Int == 0)) {
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(3, true);
            }
            if ((i <= 0) || (i == 3)) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(i + 9 - 1, true);
            }
            DataReport.h(this.jdField_a_of_type_ComTencentAvVideoController);
            break;
            localObject = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045);
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().K) {
              ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427800));
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d())
        {
          this.j.setText(2131363504);
          if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363504);
          }
          if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
            break label1684;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(2131363504);
          break label1684;
        }
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().g()) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().h())) {
          break label1684;
        }
        o(this.jdField_a_of_type_ComTencentAvVideoController.a().z);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011)
        {
          this.j.setText(2131363563);
          if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363512);
          }
          if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(2131363512);
          }
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gse(this), 150L);
        break label1684;
        super.q(2131299015);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131363361));
        }
      }
    }
  }
  
  void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011) && (paramInt != 2131363558) && (paramInt != 2131363174)) {}
    do
    {
      return;
      if ((this.j != null) && (paramInt > 0)) {
        this.j.setText(paramInt);
      }
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (paramInt > 0)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
      }
    } while ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) || (paramInt <= 0));
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(paramInt);
  }
  
  void d(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_x_of_type_Int = 1;
      if (!paramBoolean) {
        break label71;
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(26, true);
      }
    }
    label71:
    do
    {
      return;
      this.jdField_x_of_type_Int = 2;
      break;
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(26, false);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(27, false);
        if ((this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b()) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(24, true);
        }
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long == 1L);
    super.ad();
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l == 21) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011))
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, false);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      }
      this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299087).setEnabled(false);
      this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299087).setClickable(false);
    }
    if (((Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1) || (!VcSystemInfo.d())) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onDetectNoDevicePermission issueType = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramInt == 2)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        break label198;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoCtrlUI", 2, "onDetectNoDevicePermission remote has video,local close camera");
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean = false;
      n(false);
      if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().k = false;
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(7, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, false);
        }
        FrameLayout localFrameLayout = (FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299014);
        if (localFrameLayout != null) {
          localFrameLayout.setClickable(true);
        }
      }
      super.e(paramInt);
      return;
      label198:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoCtrlUI", 2, "onDetectNoDevicePermission remote has no video,local close camera");
        }
      }
    }
  }
  
  void e(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      UITools.a(this.jdField_c_of_type_AndroidWidgetTextView, paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.d()))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
        n();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
  }
  
  public void f()
  {
    super.f();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_DoubleVideoCtrlUI", 4, ">>>onStart(), ts=" + l1);
    }
    label173:
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
      {
        if (!AVReport.a().jdField_a_of_type_Boolean) {
          break label303;
        }
        AVReport.a().j = SystemClock.elapsedRealtime();
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int < 0) || (this.j == null)) {
          break label549;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 1011) {
          break label315;
        }
        this.j.setText(2131363558);
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363558);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(2131363558);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null) {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
        if ((i == 1) || (i == 3) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().x)) {
          break label566;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean = false;
        g(false);
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_DoubleVideoCtrlUI", 4, "<<<onStart(), ts=" + l2);
        QLog.d("IVR_TS_DoubleVideoCtrlUI", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      return;
      label303:
      AVReport.a().y = SystemClock.elapsedRealtime();
      break;
      label315:
      this.j.setText(2131363590);
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363590);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(2131363590);
      }
      l2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Long;
      String str = ColorRingManager.a(l2, 3);
      if (new File(str).exists())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Int;
        ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l2 + "", "", "");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator == null) {
          break label547;
        }
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
        break;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165200, null, -1, null);
        }
      }
      label547:
      break label173;
      label549:
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator == null) {
        break label173;
      }
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
      break label173;
      label566:
      z();
    }
  }
  
  public void f(int paramInt)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "avSwitch sessionType = " + paramInt);
    }
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045);
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    }
    if (paramInt == 1)
    {
      u();
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, false);
      }
      c(true);
      i(false);
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427800));
      n(false);
      j(0);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) {
        super.q(2131299023);
      }
      localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
        break label269;
      }
      bool1 = true;
      label161:
      ((SensorHelper)localObject).c(bool1);
      localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
        break label274;
      }
    }
    label269:
    label274:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((SensorHelper)localObject).b(bool1);
      c();
      return;
      if (paramInt != 2) {
        break;
      }
      if ((!this.jdField_m_of_type_Boolean) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        UITools.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427379));
      i(true);
      break;
      bool1 = false;
      break label161;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onAfterCloseCamera success : " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
    }
    super.q(2131299023);
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
    {
      if (this.jdField_w_of_type_Int > 1)
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setClickable(true);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (paramBoolean)
    {
      o(false);
      DataReport.d();
      DataReport.r(this.jdField_a_of_type_ComTencentAvVideoController);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
        f(1);
      }
      if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) && (Build.VERSION.SDK_INT > 11)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(0.0F);
      }
    }
  }
  
  public void g()
  {
    super.g();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_DoubleVideoCtrlUI", 4, ">>>onResume(), ts=" + System.currentTimeMillis());
    }
    SensorHelper localSensorHelper;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f()))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long != 1L) {
        super.ad();
      }
      localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
        break label193;
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      localSensorHelper.b(bool);
      u();
      DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_DoubleVideoCtrlUI", 4, "<<<onResume(), ts=" + l2);
        QLog.d("IVR_TS_DoubleVideoCtrlUI", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      this.jdField_e_of_type_Boolean = false;
      return;
    }
  }
  
  void g(int paramInt)
  {
    this.h = this.j;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299056));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299058));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299055)).getLayoutParams();
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    boolean bool;
    if (paramInt == 1)
    {
      bool = true;
      c(bool);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {
        break label175;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
      }
      DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
    }
    for (;;)
    {
      if ((g()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131299019))) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
      }
      e();
      return;
      bool = false;
      break;
      label175:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
      {
        t_();
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
        }
        DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().y = this.jdField_m_of_type_Boolean;
      if (this.jdField_m_of_type_Boolean) {
        j(0);
      }
    }
  }
  
  public void h()
  {
    super.h();
  }
  
  public void h(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()))
    {
      if (!this.jdField_m_of_type_Boolean) {
        j(paramInt);
      }
      return;
    }
    j(paramInt);
    ag();
  }
  
  void h(boolean paramBoolean)
  {
    ImageView localImageView;
    TextView localTextView;
    if ((this.jdField_d_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localImageView = (ImageView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131299129);
      localTextView = (TextView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131299130);
      if ((localImageView != null) && (localTextView != null)) {}
    }
    else
    {
      return;
    }
    Drawable localDrawable1;
    Drawable localDrawable2;
    TintStateDrawable localTintStateDrawable;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().u == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString)))
    {
      localDrawable1 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130839067);
      localDrawable2 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130839071);
      if (!paramBoolean) {
        break label249;
      }
      localTintStateDrawable = TintStateDrawable.a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), 2130839071, 2131428154);
      localTextView.setTextColor(-1);
    }
    for (;;)
    {
      localTintStateDrawable.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
      localImageView.setMinimumWidth(localDrawable1.getIntrinsicWidth());
      localImageView.setMinimumHeight(localDrawable1.getIntrinsicHeight());
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setImageDrawable(localDrawable1);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(localTintStateDrawable);
      return;
      localDrawable1 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130839066);
      break;
      label249:
      localTintStateDrawable = TintStateDrawable.a(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), 2130839071, 2131428153);
      localTextView.setTextColor(-10525329);
    }
  }
  
  public void i()
  {
    super.i();
    this.jdField_e_of_type_Boolean = true;
    y();
  }
  
  public void i(int paramInt)
  {
    if (1 == paramInt) {
      if (!this.jdField_e_of_type_Boolean) {
        x();
      }
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        y();
        return;
      }
    } while ((2 != paramInt) || (!c()) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(68, true);
    ReportController.b(null, "CliOper", "", "", "0X80061FB", "0X80061FB", 0, 0, "", "", "", "");
  }
  
  void i(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label45:
    label102:
    label146:
    label263:
    label286:
    label291:
    label296:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
      h(paramBoolean);
      AVActivity localAVActivity;
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        if ((this instanceof HYControlUI)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (!(this instanceof HYControlUI)) && (!(this instanceof MicSpeakerControlUI)))
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.u)) {
            break label263;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, false, false);
        }
        F();
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)))
        {
          localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramBoolean) {
            break label286;
          }
          bool1 = true;
          localAVActivity.a(bool1);
          if (paramBoolean) {
            break label291;
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAVActivity.c(bool1);
        localAVActivity.b(paramBoolean);
        if (!paramBoolean) {
          break label296;
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(8);
        }
        if (this.j != null) {
          this.j.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(paramBoolean);
        break label45;
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, BeautySettingUi.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface), false);
        break label102;
        bool1 = false;
        break label146;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(0);
      }
      if (this.j != null) {
        this.j.setVisibility(0);
      }
      if (this.jdField_f_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void j()
  {
    super.j();
    if (QLog.isDevelopLevel()) {
      QLog.d("DoubleVideoCtrlUI", 4, "onStop()");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
        super.ae();
      }
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
      if ((!this.jdField_a_of_type_Boolean) && (!SessionMgr.a().a())) {
        this.jdField_a_of_type_ComTencentAvVideoController.k();
      }
    }
  }
  
  public void j(int paramInt)
  {
    super.j(paramInt);
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Int == 2)) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, true);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnClickListener(15, null);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.l = false;
    this.jdField_m_of_type_Boolean = true;
    this.t = 0;
    this.jdField_w_of_type_JavaLangString = null;
    this.i = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
    this.h = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.j = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    this.jdField_d_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.c();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.k();
  }
  
  void k(int paramInt)
  {
    Object localObject;
    String str;
    switch (paramInt)
    {
    default: 
      localObject = null;
      str = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        localObject = PopupDialog.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230, (String)localObject, str, 2131363885, 2131363906, new gsc(this, paramInt), null);
        if (localObject != null) {
          ((QQCustomDialog)localObject).show();
        }
      }
      return;
      str = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131363904);
      localObject = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131363909);
      ReportController.b(null, "CliOper", "", "", "0X8005CFC", "0X8005CFC", 0, 0, "", "", "", "");
      continue;
      str = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131363905);
      localObject = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131363908);
      ReportController.b(null, "CliOper", "", "", "0X8005CFE", "0X8005CFE", 0, 0, "", "", "", "");
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
    {
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str);
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onConnected");
    }
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299045);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().K) {
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427800));
    }
    if (this.j != null) {
      this.j.setText(2131363686);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363686);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(2131363686);
    }
    if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      c();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(6);
    }
    int i;
    label274:
    label348:
    int j;
    label405:
    SensorHelper localSensorHelper;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean)
    {
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int;
      if ((i > 0) && (i != 3) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(i + 9 - 1);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().H)
      {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
          break label856;
        }
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
        DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(9, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(9, true);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
        break label886;
      }
      c(true);
      i(true);
      n(BeautySettingUi.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
      b(true);
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentAvVideoController.b((String)localObject);
      j = this.jdField_a_of_type_ComTencentAvVideoController.c((String)localObject);
      if (i != 5) {
        break label920;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ak) {
        break label894;
      }
      super.ad();
      t_();
      localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
        break label1127;
      }
    }
    label856:
    label886:
    label894:
    label920:
    label1127:
    for (boolean bool = true;; bool = false)
    {
      localSensorHelper.b(bool);
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.f();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.k);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.b()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        }
      }
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 5000L);
      }
      if ((this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b()) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(24, true);
      }
      if (VideoUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().l, this.jdField_a_of_type_ComTencentAvVideoController.a().A))
      {
        if (((this.jdField_a_of_type_ComTencentAvVideoController.a().l != 0) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_r_of_type_Int == 3024)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, false);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(65, false);
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
        f(1);
      }
      return;
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      break label274;
      n(false);
      break label348;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_c_of_type_Boolean = true;
      break label405;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b())
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().ak)
        {
          super.ad();
          break label405;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        this.jdField_c_of_type_Boolean = true;
        break label405;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        this.jdField_c_of_type_Boolean = true;
        break label405;
      }
      if (j > 18)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ak) && (this.jdField_a_of_type_ComTencentAvVideoController.a().al))
        {
          super.ad();
          break label405;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        this.jdField_c_of_type_Boolean = true;
        break label405;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ak)
      {
        super.ad();
        break label405;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_c_of_type_Boolean = true;
      break label405;
    }
  }
  
  void n()
  {
    if ((VideoUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().l, this.jdField_a_of_type_ComTencentAvVideoController.a().A)) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().l != 0) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_r_of_type_Int == 3024)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onPauseVideo");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      f(1);
      z();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, true);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (Build.VERSION.SDK_INT > 11))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoubleVideoCtrlUI", 2, "onResumeVideo setRotation");
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(0.0F);
        }
      }
      return;
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, true);
      }
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onResumeVideo");
    }
    if ((!VcSystemInfo.d()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
      }
      ReportController.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 2;
      f(2);
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165195, null, 0, null);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, false);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().x) {
        g(true);
      }
    }
    ag();
  }
  
  public void q() {}
  
  public void r()
  {
    if ((!VcSystemInfo.d()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1))
    {
      this.jdField_f_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean)
    {
      f(2);
      if (!VcSystemInfo.d()) {
        break label150;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 2;
        f(2);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(16, false);
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, false);
      this.jdField_f_of_type_Boolean = true;
      return;
      label150:
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      }
    }
  }
  
  void s()
  {
    u_();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation);
  }
  
  void t()
  {
    if ((!(this instanceof HYControlUI)) && (!(this instanceof MicSpeakerControlUI)) && (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gsj(this));
    }
  }
  
  public void t_()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.d())
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, true);
      }
      DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
    }
    DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "refreshUI");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Object localObject1;
    label507:
    label527:
    label544:
    do
    {
      return;
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      Object localObject3 = this.jdField_a_of_type_ComTencentAvVideoController.a().e;
      Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3, true, true);
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject3);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = ((String)localObject1);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299056));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299058));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131296829));
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
          i(true);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
        {
          if ((!this.jdField_b_of_type_AndroidWidgetImageButton.isShown()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (this.jdField_w_of_type_Int > 1)) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
          }
          i(true);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.a == null) {
            break label507;
          }
          a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.a);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b);
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 25) {
          break label544;
        }
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().e;
        }
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1);
        localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, (String)localObject1, true, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(str);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
        if ((!((String)localObject2).equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString)) || (localObject1 == null)) {
          break label527;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        return;
        i(false);
        break;
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      return;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
    }
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onBeforeCloseCamera");
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
    }
    if ((this.jdField_w_of_type_Int > 1) && (this.jdField_b_of_type_AndroidWidgetImageButton != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageButton.setClickable(false);
    }
  }
  
  void x()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.setIsLock(true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidViewAnimationAnimation == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968696);
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
        break;
      }
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.setVisibility(4);
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
      this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.setIsLock(false);
    }
    this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  void y()
  {
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_b_of_type_Int = -1;
    }
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.b();
  }
  
  public void z()
  {
    y();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_w_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gry(this), 300L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\DoubleVideoCtrlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */