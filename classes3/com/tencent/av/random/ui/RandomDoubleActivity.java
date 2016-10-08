package com.tencent.av.random.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RandomListener;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.AvImpeachUtil;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.Circle3D;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.Rotate3dAnimation;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import glb;
import gld;
import gle;
import glf;
import glg;
import glh;
import gli;
import glj;
import glk;
import glm;
import gln;
import glo;
import glp;
import glq;
import glr;
import gls;
import glv;
import glw;
import glx;
import gly;
import java.lang.reflect.Field;
import mqq.app.BaseActivity;

public class RandomDoubleActivity
  extends BaseActivity
  implements SensorEventListener
{
  static final String jdField_a_of_type_JavaLangString = "RandomDoubleActivity";
  public int a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Bitmap a;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  public Animation a;
  public Button a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  Toast jdField_a_of_type_AndroidWidgetToast;
  public VideoController a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver;
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver;
  public CameraUtils a;
  RandomController.RandomListener jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener;
  public RandomController a;
  public DialogVideoLayerUI a;
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver;
  public VideoLayerUI a;
  public AvAddFriendHelper a;
  public Circle3D a;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  QQAnimationListener jdField_a_of_type_ComTencentAvUtilsQQAnimationListener;
  public SparkDot a;
  public TipsManager a;
  public TraeHelper a;
  public glx a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  public boolean a;
  public int b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public Button b;
  public ImageButton b;
  public ImageView b;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public Circle3D b;
  public Runnable b;
  public String b;
  boolean jdField_b_of_type_Boolean;
  public int c;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  public Button c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  public TextView c;
  public Circle3D c;
  public Runnable c;
  public String c;
  public boolean c;
  int jdField_d_of_type_Int;
  public Button d;
  public TextView d;
  public Circle3D d;
  Runnable jdField_d_of_type_JavaLangRunnable;
  boolean jdField_d_of_type_Boolean;
  public int e;
  public Button e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean;
  public int f;
  Button f;
  public TextView f;
  public boolean f;
  public int g;
  public TextView g;
  public boolean g;
  int h;
  public boolean h;
  
  public RandomDoubleActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_c_of_type_AndroidWidgetButton = null;
    this.jdField_d_of_type_AndroidWidgetButton = null;
    this.jdField_e_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_f_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_g_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = new gls(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvRandomRandomController = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = null;
    this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    this.jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener = new glb(this);
    this.jdField_a_of_type_ComTencentAvCameraCameraObserver = new glh(this);
    this.jdField_c_of_type_JavaLangRunnable = new glj(this);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = new glm(this);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new gle(this);
    this.jdField_d_of_type_JavaLangRunnable = new glf(this);
    this.jdField_e_of_type_Int = 5;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new glw(this);
    this.jdField_h_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Glx = new glx(this);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new glr(this);
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "quitChat: " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean == true) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    e();
    this.jdField_a_of_type_ComTencentAvRandomRandomController.c();
    this.jdField_a_of_type_ComTencentAvVideoController.j(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_H_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b(this.jdField_a_of_type_ComTencentAvRandomRandomController.f);
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.c();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a(0, 0, 3000);
    }
    finish();
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "startChangeAnimation");
    }
    if (Build.VERSION.SDK_INT <= 10)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839235);
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "startChangeAnimation api level <= 10, return!");
      }
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_d_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RandomDoubleActivity", 2, "changeAnimation has already start!");
      return;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
      if (this.jdField_c_of_type_AndroidWidgetImageView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839235);
        this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_ComTencentAvUtilsCircle3D);
        this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_ComTencentAvUtilsCircle3D);
        return;
      }
    } while (this.jdField_c_of_type_AndroidWidgetImageView != this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839235);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_ComTencentAvUtilsCircle3D);
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_ComTencentAvUtilsCircle3D);
  }
  
  public void BtnOnClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "BtnOnClick : view " + paramView.toString());
    }
    switch (paramView.getId())
    {
    }
    label335:
    label339:
    label919:
    label1391:
    label1883:
    label2405:
    label2412:
    label3118:
    do
    {
      int i;
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
                for (;;)
                {
                  return;
                  i = 0;
                  if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null) {
                    if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 5) {
                      break label335;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) || (i == 0)) {
                      break label339;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomDoubleActivity", 2, "getPeerSdkVersion = " + this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvRandomRandomController.f));
                    }
                    if ((this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvRandomRandomController.f) >= 45) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)) {
                      break;
                    }
                    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
                    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
                    return;
                  }
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.d("RandomDoubleActivity", 2, "getPeerSdkVersion = " + this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvRandomRandomController.f));
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("RandomDoubleActivity", 2, "qav_bottombar_camera");
                  }
                  ReportController.b(null, "CliOper", "", "", "0X8006980", "0X8006980", 0, 0, "", "", "", "");
                  if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_H_of_type_Int == 0)
                  {
                    a(2131363809, 1, getResources().getDimensionPixelSize(2131492908));
                    return;
                  }
                  if (this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvRandomRandomController.f) < 45)
                  {
                    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
                    {
                      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
                      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
                    }
                  }
                  else
                  {
                    if (this.jdField_a_of_type_ComTencentAvVideoController.b() <= SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_Int)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("RandomDoubleActivity", 2, "qav_bottombar_camera time = " + this.jdField_a_of_type_ComTencentAvVideoController.b());
                      }
                      o();
                      return;
                    }
                    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
                    {
                      this.jdField_a_of_type_ComTencentAvVideoController.a().G = 1;
                      this.jdField_a_of_type_ComTencentAvVideoController.R();
                      this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(1);
                      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 60000L);
                    }
                    while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.c()))
                    {
                      this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
                      this.jdField_d_of_type_AndroidWidgetButton.setClickable(false);
                      return;
                      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
                        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
                        {
                          if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a() > 1) && (this.jdField_b_of_type_AndroidWidgetImageButton != null))
                          {
                            this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
                            this.jdField_b_of_type_AndroidWidgetImageButton.setClickable(false);
                          }
                          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
                          this.jdField_d_of_type_AndroidWidgetButton.setClickable(false);
                          c();
                          if (QLog.isColorLevel()) {
                            QLog.d("RandomDoubleActivity", 2, "local close camera");
                          }
                        }
                        else
                        {
                          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
                          this.jdField_d_of_type_AndroidWidgetButton.setClickable(false);
                          c(false);
                          if (QLog.isColorLevel()) {
                            QLog.d("RandomDoubleActivity", 2, "local open camera");
                          }
                        }
                      }
                    }
                  }
                }
                ReportController.b(null, "CliOper", "", "", "0X80053B8", "0X80053B8", 0, 0, "", "", "", "");
                this.jdField_a_of_type_Boolean = false;
                finish();
                i = 2130968685;
                if (this.jdField_a_of_type_ComTencentAvVideoController != null)
                {
                  paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
                  if (paramView == null) {
                    break label919;
                  }
                }
                for (i = SmallScreenUtils.a(paramView.J);; i = SmallScreenUtils.a(7))
                {
                  overridePendingTransition(0, i);
                  if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a();
                  return;
                }
              } while (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null);
              bool = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_H_of_type_Boolean;
              paramView = this.jdField_a_of_type_ComTencentAvVideoController;
              if (!bool) {}
              for (bool = true;; bool = false)
              {
                DataReport.a(paramView, bool);
                this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
                if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_H_of_type_Boolean) {
                  break;
                }
                ReportController.b(null, "CliOper", "", "", "0X80053B6", "0X80053B6", 0, 0, "", "", "", "");
                return;
              }
              ReportController.b(null, "CliOper", "", "", "0X80053B7", "0X80053B7", 0, 0, "", "", "", "");
              h();
              return;
              if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f) == 2) {
                ReportController.b(null, "CliOper", "", "", "0X80053BB", "0X80053BB", 0, 0, "", "", "", "");
              }
              if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f) == 0) {
                ReportController.b(null, "CliOper", "", "", "0X80053B9", "0X80053B9", 0, 0, "", "", "", "");
              }
              f();
              return;
              ReportController.b(null, "CliOper", "", "", "0X80067B4", "0X80067B4", 0, 0, "", "", "", "");
              v();
              return;
            } while (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null);
            paramView = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d);
            if (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_c_of_type_Boolean) {}
            for (boolean bool = true;; bool = false)
            {
              paramView.jdField_c_of_type_Boolean = bool;
              paramView = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_c_of_type_JavaLangString;
              if (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_c_of_type_Boolean) {
                break label1391;
              }
              c(2131299015);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
              this.jdField_a_of_type_ComTencentAvVideoController.a(true, paramView);
              if (this.jdField_c_of_type_AndroidWidgetButton == null) {
                break;
              }
              UITools.a(this.jdField_c_of_type_AndroidWidgetButton, getResources().getString(2131363362));
              return;
            }
            d(2131299015);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
            this.jdField_a_of_type_ComTencentAvVideoController.a(false, paramView);
          } while (this.jdField_c_of_type_AndroidWidgetButton == null);
          UITools.a(this.jdField_c_of_type_AndroidWidgetButton, getResources().getString(2131363361));
          return;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          g();
          return;
          AvImpeachUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_ComTencentAvRandomRandomController.f);
          ReportController.b(null, "CliOper", "", "", "0X8005724", "0X8005724", 0, 0, "", "", "", "");
          return;
        } while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvRandomRandomController.f)) || (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f) != 0));
        ReportController.b(null, "CliOper", "", "", "0X80053BA", "0X80053BA", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentAvVideoController.b() < 30L)
        {
          paramView = (TextView)findViewById(2131299406);
          paramView.setVisibility(0);
          paramView.setText(2131363805);
          paramView.setContentDescription(getResources().getString(2131363805));
          return;
        }
        this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f, 3023);
        return;
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvRandomRandomController.f)) || (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f) != 2));
      ReportController.b(null, "CliOper", "", "", "0X80053BC", "0X80053BC", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      g();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "send flower from infos mWebIsMask = " + this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean);
      }
      String str2;
      String str3;
      Object localObject2;
      Object localObject3;
      String str1;
      SessionInfo localSessionInfo;
      String str4;
      if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800696E", "0X800696E", 0, 0, "5", "", "", "");
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvRandomRandomController.f)) {
          break label2412;
        }
        localObject1 = Utils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        str2 = this.jdField_a_of_type_ComTencentAvRandomRandomController.f;
        if (!this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean) {
          break label2405;
        }
        localObject1 = "1";
        str3 = NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) + "," + NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f);
        localObject2 = "";
        if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)
        {
          localObject3 = "";
          str1 = "";
          localSessionInfo = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d);
          str4 = localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString;
          i = "voice_hall_avatar_".length();
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str4))
          {
            localObject2 = localObject3;
            if (!TextUtils.equals(str4, "null"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("RandomDoubleActivity", 2, "uin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", headUrl = " + str4);
              }
              localObject2 = str4.substring(str4.lastIndexOf("voice_hall_avatar_") + i);
            }
          }
          str4 = this.jdField_a_of_type_ComTencentAvRandomRandomController.h;
          localObject3 = str1;
          if (!TextUtils.isEmpty(str4))
          {
            localObject3 = str1;
            if (!TextUtils.equals(str4, "null"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("RandomDoubleActivity", 2, "uin: " + this.jdField_a_of_type_ComTencentAvRandomRandomController.f + ", headUrl = " + str4);
              }
              localObject3 = str4.substring(str4.lastIndexOf("voice_hall_avatar_") + i);
            }
          }
          str1 = localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.g;
          localObject2 = (String)localObject2 + "|" + str1 + "|" + (String)localObject3 + "|" + this.jdField_a_of_type_ComTencentAvRandomRandomController.g + "|1";
        }
        paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050&uidList=%s&anonyInfo=%s", new Object[] { NearbyURLSafeUtil.a(str2), paramView.toLowerCase(), Integer.valueOf(4), "ran.card.s", localObject1, str3, localObject2 });
        if (QLog.isColorLevel()) {
          QLog.d("RandomDoubleActivity", 2, "url = " + paramView);
        }
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        startActivity((Intent)localObject1);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
        ReportController.b(null, "CliOper", "", "", "0X800696E", "0X800696E", 0, 0, "4", "", "", "");
        break;
        localObject1 = "0";
        break label1883;
        if (QLog.isColorLevel()) {
          QLog.e("RandomDoubleActivity", 2, "uin is empty!");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "switchcamera");
      }
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.e();
      }
      m();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "send flower mWebIsMask = " + this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800696E", "0X800696E", 0, 0, "3", "", "", "");
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvRandomRandomController.f)) {
          continue;
        }
        localObject1 = Utils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        str2 = this.jdField_a_of_type_ComTencentAvRandomRandomController.f;
        if (!this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean) {
          break label3118;
        }
      }
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        str3 = NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) + "," + NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f);
        localObject2 = "";
        if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)
        {
          localObject3 = "";
          str1 = "";
          localSessionInfo = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d);
          str4 = localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString;
          i = "voice_hall_avatar_".length();
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str4))
          {
            localObject2 = localObject3;
            if (!TextUtils.equals(str4, "null"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("RandomDoubleActivity", 2, "uin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", headUrl = " + str4);
              }
              localObject2 = str4.substring(str4.lastIndexOf("voice_hall_avatar_") + i);
            }
          }
          str4 = this.jdField_a_of_type_ComTencentAvRandomRandomController.h;
          localObject3 = str1;
          if (!TextUtils.isEmpty(str4))
          {
            localObject3 = str1;
            if (!TextUtils.equals(str4, "null"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("RandomDoubleActivity", 2, "uin: " + this.jdField_a_of_type_ComTencentAvRandomRandomController.f + ", headUrl = " + str4);
              }
              localObject3 = str4.substring(str4.lastIndexOf("voice_hall_avatar_") + i);
            }
          }
          str1 = localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.g;
          localObject2 = (String)localObject2 + "|" + str1 + "|" + (String)localObject3 + "|" + this.jdField_a_of_type_ComTencentAvRandomRandomController.g + "|1";
        }
        paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050&uidList=%s&anonyInfo=%s", new Object[] { NearbyURLSafeUtil.a(str2), paramView.toLowerCase(), Integer.valueOf(4), "ran.select.s", localObject1, str3, localObject2 });
        if (QLog.isColorLevel()) {
          QLog.d("RandomDoubleActivity", 2, "url = " + paramView);
        }
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        startActivity((Intent)localObject1);
        return;
        ReportController.b(null, "CliOper", "", "", "0X800696E", "0X800696E", 0, 0, "2", "", "", "");
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RandomDoubleActivity", 2, "uin is empty!");
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299116));
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {}
    do
    {
      return 0;
      j = getResources().getDimensionPixelSize(2131493888);
      if (!this.jdField_f_of_type_Boolean) {
        break;
      }
    } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null);
    int j = getResources().getDimensionPixelSize(2131493989);
    int k = j / this.jdField_e_of_type_Int * this.jdField_f_of_type_Int;
    i = k;
    if (k > j) {
      i = j;
    }
    for (;;)
    {
      return i;
      if (this.jdField_g_of_type_Boolean)
      {
        if (UITools.a(this) <= 320) {
          i = j + getResources().getDimensionPixelSize(2131493991);
        } else if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
          i = j + getResources().getDimensionPixelSize(2131493989);
        }
      }
      else if (UITools.a()) {
        i = getResources().getDimensionPixelSize(2131494049) + 0;
      }
    }
  }
  
  String a()
  {
    return "";
  }
  
  void a()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299116));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299115));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299046));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131299013));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131299012));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131299022));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131299087));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131299015));
    Object localObject1 = getResources().getDrawable(2130839060);
    Object localObject2 = TintStateDrawable.a(getResources(), 2130839060, 2131428165);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_c_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject2, null, null);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131299023));
    localObject1 = getResources().getDrawable(2130839050);
    localObject2 = TintStateDrawable.a(getResources(), 2130839050, 2131428165);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_d_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject2, null, null);
    this.jdField_d_of_type_AndroidWidgetButton.setTextColor(getResources().getColorStateList(2131428166));
    d(2131299023);
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)findViewById(2131299118));
    localObject1 = getResources().getDrawable(2130839189);
    localObject2 = TintStateDrawable.a(getResources(), 2130839189, 2131428165);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_f_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject2, null, null);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299119));
    localObject1 = getResources().getDrawable(2130839056);
    localObject2 = TintStateDrawable.a(getResources(), 2130839056, 2131428165);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject2, null, null);
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)findViewById(2131299117));
    localObject1 = getResources().getDrawable(2130839191);
    localObject2 = TintStateDrawable.a(getResources(), 2130839191, 2131428165);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_e_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject2, null, null);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296829));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299086));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299109));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299112));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299111));
    this.jdField_c_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299110));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299105));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299106));
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot = ((SparkDot)findViewById(2131299114));
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot.setDotCount(6);
    this.jdField_b_of_type_JavaLangRunnable = new gli(this);
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)
    {
      localObject1 = (LinearLayout)super.findViewById(2131297994);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (LinearLayout)localObject1);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299120));
    int i = UITools.a(getApplicationContext());
    localObject1 = (LinearLayout)findViewById(2131297994);
    localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
    if (i <= 480)
    {
      ((RelativeLayout.LayoutParams)localObject2).topMargin = getResources().getDimensionPixelSize(2131494062);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131494063);
      ((LinearLayout)localObject1).setLayoutParams(localLayoutParams);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = getResources().getDimensionPixelSize(2131493988);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetButton.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = getResources().getDimensionPixelSize(2131493988);
      this.jdField_b_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    try
    {
      if (ImageResUtil.a("random_talk_bg_2.png"))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(getResources(), ImageResUtil.b() + "random_talk_bg_2.png");
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap();
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("RandomBackground", 2, "RandomBackground double OOM: " + localOutOfMemoryError);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentAvVideoController.T();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      return;
      if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentAvVideoController.U();
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      int i = Build.VERSION.SDK_INT;
      if ((i != 14) && (i != 15)) {
        this.jdField_a_of_type_AndroidWidgetToast.cancel();
      }
    }
    this.jdField_a_of_type_AndroidWidgetToast = null;
    Context localContext = getApplicationContext();
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
        QLog.e("RandomDoubleActivity", 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt1, paramInt2).b(paramInt3);
      return;
    }
  }
  
  public void a(View paramView, Animation paramAnimation)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d);
    if (localSessionInfo == null) {}
    do
    {
      do
      {
        return;
        if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info == null) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 5)) {
          break;
        }
      } while (!this.jdField_d_of_type_Boolean);
      j();
      a(this.jdField_c_of_type_AndroidWidgetImageView, SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    } while (!this.jdField_d_of_type_Boolean);
    paramView.startAnimation(paramAnimation);
  }
  
  void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    int i = paramImageView.getWidth();
    int j = paramImageView.getHeight();
    float f1 = i / 2.0F;
    float f2 = j / 2.0F;
    Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(0.0F, 90.0F, f1, f2, 150.0F, true);
    localRotate3dAnimation.setDuration(500L);
    localRotate3dAnimation.setAnimationListener(new glk(this, paramImageView, paramBitmap, f1, f2));
    paramImageView.startAnimation(localRotate3dAnimation);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "setIconStatus : " + paramInt);
    }
    Object localObject2 = (LinearLayout)findViewById(2131299403);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131299400);
    Button localButton1 = (Button)findViewById(2131299405);
    Button localButton2 = (Button)findViewById(2131299404);
    Object localObject1;
    switch (paramInt)
    {
    case 3: 
    default: 
      paramString = "";
      localObject1 = null;
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      }
      localObject2 = (ImageView)findViewById(2131299113);
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      localObject2 = (ImageView)findViewById(2131299398);
      if (localObject1 != null)
      {
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      }
      break;
    }
    for (;;)
    {
      localObject1 = (TextView)findViewById(2131299406);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(paramString);
      ((TextView)localObject1).setContentDescription(paramString);
      return;
      localObject1 = getResources().getDrawable(2130838971);
      paramString = getResources().getString(2131363802);
      localLinearLayout.setVisibility(0);
      ((LinearLayout)localObject2).setVisibility(8);
      break;
      localObject1 = getResources().getDrawable(2130838973);
      paramString = getResources().getString(2131363801);
      localButton1.setEnabled(false);
      localLinearLayout.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(0);
      break;
      localObject1 = getResources().getDrawable(2130838972);
      paramString = getResources().getString(2131363804);
      localLinearLayout.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(0);
      localButton1.setEnabled(false);
      localObject2 = (LinearLayout.LayoutParams)localButton2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      localButton2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break;
      localLinearLayout.setVisibility(8);
      ((LinearLayout)localObject2).setVisibility(0);
      localButton1.setEnabled(true);
      paramString = a();
      localObject1 = null;
      break;
      ((ImageView)localObject2).setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramBoolean);
    }
  }
  
  public int b()
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299046));
    }
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
      return 0;
    }
    int i = getResources().getDimensionPixelSize(2131493887);
    if (this.jdField_f_of_type_Boolean) {
      i += getResources().getDimensionPixelSize(2131493995) / this.jdField_e_of_type_Int * this.jdField_f_of_type_Int;
    }
    for (;;)
    {
      return i;
      if (this.jdField_g_of_type_Boolean) {
        i += getResources().getDimensionPixelSize(2131493995);
      } else {
        i = 0;
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().G = 3;
    c(true);
    this.jdField_a_of_type_ComTencentAvVideoController.S();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "setAvUiType sessionType: " + paramInt);
    }
    if (paramInt == 1)
    {
      a(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299115));
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f, this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString));
    }
    while (paramInt != 2)
    {
      m();
      return;
    }
    a(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    paramInt = b();
    int i = a();
    VideoLayerUI localVideoLayerUI;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      localVideoLayerUI = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (this.jdField_g_of_type_Boolean) {
        break label366;
      }
    }
    label366:
    for (boolean bool = true;; bool = false)
    {
      localVideoLayerUI.a(paramInt, i, bool);
      if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299115));
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_g_of_type_Boolean = true;
      ((ImageView)findViewById(2131299113)).setVisibility(8);
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), paramBoolean);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
      if (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c()) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
    }
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, getResources().getString(2131363364));
      return;
      UITools.a(this.jdField_c_of_type_AndroidWidgetButton, getResources().getString(2131363381));
      this.jdField_c_of_type_AndroidWidgetButton.setSelected(true);
      return;
      UITools.a(this.jdField_d_of_type_AndroidWidgetButton, getResources().getString(2131363360));
      this.jdField_d_of_type_AndroidWidgetButton.setSelected(true);
    } while (VcSystemInfo.d());
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, paramBoolean);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "startTimer");
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new glv(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
  }
  
  public void d(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, getResources().getString(2131363365));
      return;
      UITools.a(this.jdField_c_of_type_AndroidWidgetButton, getResources().getString(2131363382));
      this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
      return;
      UITools.a(this.jdField_d_of_type_AndroidWidgetButton, getResources().getString(2131363837));
      this.jdField_d_of_type_AndroidWidgetButton.setSelected(false);
    } while (VcSystemInfo.d());
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "showMatchingView " + paramBoolean);
    }
    if ((SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null) && (QLog.isColorLevel())) {
      QLog.d("RandomDoubleActivity", 2, "showMatchingView : matchStatus = " + SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int);
    }
    ImageView localImageView1 = (ImageView)findViewById(2131299113);
    ImageView localImageView2 = (ImageView)findViewById(2131299398);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(72);
      }
      if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {
        break label631;
      }
    }
    label631:
    for (int i = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
        i = 2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "showMatchingView : status = " + i);
      }
      switch (i)
      {
      default: 
        if ((SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null) && (QLog.isColorLevel())) {
          QLog.d("RandomDoubleActivity", 2, "showMatchingView : matchStatus = " + SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, true);
        }
        this.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetImageView.setClickable(false);
        this.jdField_f_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_d_of_type_AndroidWidgetButton.setClickable(false);
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        if (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a()) {
          a(true);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
          this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299115));
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, true);
        break;
        if (!this.jdField_f_of_type_Boolean) {
          w();
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, true);
        break;
        this.jdField_a_of_type_ComTencentAvUtilsSparkDot.b();
        this.jdField_f_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, false);
        }
      } while ((SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) || (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).f()));
      this.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
      return;
    }
  }
  
  public void e()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "stopTimer");
      }
      this.jdField_c_of_type_Boolean = false;
    } while ((this.jdField_a_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void e(int paramInt)
  {
    try
    {
      GraphicRenderMgr.getInstance().setBeautyOrFaceConfig((paramInt + 9) / 10, 0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RandomDoubleActivity", 2, "BeautySetting UnsatisfiedLinkError! libqav_graphics.so no impl");
    }
  }
  
  void f()
  {
    if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject1;
    int i;
    int j;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground() == null)
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(getResources(), 2130839236, (BitmapFactory.Options)localObject1);
      i = ((BitmapFactory.Options)localObject1).outWidth / UITools.a(getApplicationContext());
      j = ((BitmapFactory.Options)localObject1).outHeight / UITools.b(getApplicationContext());
      if (i >= j) {
        break label377;
      }
      ((BitmapFactory.Options)localObject1).inSampleSize = i;
    }
    for (;;)
    {
      if (((BitmapFactory.Options)localObject1).inSampleSize <= 0) {
        ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      }
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      try
      {
        localObject1 = BitmapFactory.decodeResource(getResources(), 2130839236, (BitmapFactory.Options)localObject1);
        if (localObject1 != null)
        {
          localObject1 = BitmapTools.a((Bitmap)localObject1, 20);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject1);
        }
        localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)findViewById(2131299107)).getLayoutParams();
        localObject3 = (RelativeLayout)findViewById(2131299394);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
        localLayoutParams.topMargin = ((RelativeLayout.LayoutParams)localObject1).topMargin;
        ((RelativeLayout)localObject3).setLayoutParams(localLayoutParams);
        localObject1 = (ImageView)findViewById(2131299397);
        localObject3 = (TextView)findViewById(2131299399);
        ((ImageView)localObject1).setImageBitmap(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap);
        ((RelativeLayout)findViewById(2131299396)).setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString + getResources().getString(2131363796));
        ((TextView)localObject3).setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString);
        ((TextView)localObject3).setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString);
        i = this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f);
        a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f, i);
        return;
        label377:
        ((BitmapFactory.Options)localObject1).inSampleSize = j;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject3 = null;
          Object localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("RandomDoubleActivity", 2, "bg = null !");
            localObject2 = localObject3;
          }
        }
      }
    }
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "finish");
    }
    super.finish();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "refreshUI ");
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299109));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299105));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299106));
    if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvRandomRandomController.g);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
      {
        a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString + getResources().getString(2131363800));
        this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString, false);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString);
      }
      if (this.jdField_c_of_type_AndroidWidgetButton == null) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "startChange");
    }
    if (this.jdField_e_of_type_AndroidWidgetButton != null) {
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
      SessionMgr.a().c(this.jdField_a_of_type_ComTencentAvRandomRandomController.d);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 1;
      l();
      m();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a() > 1) && (this.jdField_b_of_type_AndroidWidgetImageButton != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetImageButton.setClickable(false);
      }
      this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_d_of_type_AndroidWidgetButton.setClickable(false);
      c();
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "local close camera");
      }
    }
    e();
    if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b(this.jdField_a_of_type_ComTencentAvRandomRandomController.f);
    }
    this.jdField_a_of_type_ComTencentAvRandomRandomController.d();
    if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "startChange mSessionInfo is null!");
      }
      this.jdField_a_of_type_Boolean = true;
      finish();
      return;
    }
    d(true);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean = false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onCloseAnimation");
    }
    QQFrameByFrameAnimation localQQFrameByFrameAnimation = new QQFrameByFrameAnimation();
    localQQFrameByFrameAnimation.a(100);
    localQQFrameByFrameAnimation.c(8);
    localQQFrameByFrameAnimation.a(new int[] { 2130839042, 2130839043 });
    localQQFrameByFrameAnimation.a(this.jdField_a_of_type_AndroidWidgetImageButton);
    localQQFrameByFrameAnimation.b();
    localQQFrameByFrameAnimation.a(this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener);
  }
  
  void j()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "stopChangeAnimation");
      }
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_c_of_type_AndroidWidgetImageView == this.jdField_a_of_type_AndroidWidgetImageView) {
        break label100;
      }
      this.jdField_c_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      label100:
      this.jdField_c_of_type_AndroidWidgetImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  void k()
  {
    float f1 = this.jdField_a_of_type_AndroidWidgetImageView.getWidth() / 2.0F;
    float f2 = this.jdField_a_of_type_AndroidWidgetImageView.getHeight() / 2.0F;
    this.jdField_b_of_type_ComTencentAvUtilsCircle3D = new Circle3D(0.2F, 1.0F, f1, f2, 600.0F, true);
    this.jdField_b_of_type_ComTencentAvUtilsCircle3D.setFillAfter(true);
    this.jdField_b_of_type_ComTencentAvUtilsCircle3D.setDuration('̠');
    this.jdField_b_of_type_ComTencentAvUtilsCircle3D.setAnimationListener(new gln(this));
    this.jdField_a_of_type_ComTencentAvUtilsCircle3D = new Circle3D(1.0F, 0.2F, f1, f2, 600.0F, false);
    this.jdField_a_of_type_ComTencentAvUtilsCircle3D.setFillAfter(true);
    this.jdField_a_of_type_ComTencentAvUtilsCircle3D.setDuration('̠');
    this.jdField_a_of_type_ComTencentAvUtilsCircle3D.setAnimationListener(new glo(this));
    f1 = this.jdField_b_of_type_AndroidWidgetImageView.getWidth() / 2.0F;
    f2 = this.jdField_b_of_type_AndroidWidgetImageView.getHeight() / 2.0F;
    this.jdField_d_of_type_ComTencentAvUtilsCircle3D = new Circle3D(1.0F, 0.2F, f1, f2, 600.0F, false);
    this.jdField_d_of_type_ComTencentAvUtilsCircle3D.setFillAfter(true);
    this.jdField_d_of_type_ComTencentAvUtilsCircle3D.setDuration('̠');
    this.jdField_d_of_type_ComTencentAvUtilsCircle3D.setAnimationListener(new glp(this));
    this.jdField_c_of_type_ComTencentAvUtilsCircle3D = new Circle3D(0.2F, 1.0F, f1, f2, 600.0F, true);
    this.jdField_c_of_type_ComTencentAvUtilsCircle3D.setFillAfter(true);
    this.jdField_c_of_type_ComTencentAvUtilsCircle3D.setDuration('̠');
    this.jdField_c_of_type_ComTencentAvUtilsCircle3D.setAnimationListener(new gld(this));
  }
  
  public void l()
  {
    boolean bool = true;
    if (this.jdField_h_of_type_Boolean) {}
    label10:
    do
    {
      do
      {
        break label10;
        break label10;
        do
        {
          return;
        } while (this.jdField_f_of_type_Boolean);
        if (QLog.isColorLevel()) {
          QLog.e("RandomDoubleActivity", 2, "switchToolBar-->mToolbarDisplay = " + this.jdField_g_of_type_Boolean);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("RandomDoubleActivity", 2, "switchToolBar-->mVideoController is null, Why???");
      return;
    } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.jdField_g_of_type_Boolean));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) {
      this.jdField_g_of_type_Boolean = true;
    }
    RelativeLayout localRelativeLayout1;
    TextView localTextView;
    RelativeLayout localRelativeLayout2;
    label235:
    do
    {
      for (;;)
      {
        localRelativeLayout1 = (RelativeLayout)findViewById(2131299116);
        localTextView = (TextView)findViewById(2131299115);
        localRelativeLayout2 = (RelativeLayout)findViewById(2131299046);
        if (!this.jdField_g_of_type_Boolean) {
          break label401;
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(false);
        }
        if ((!localRelativeLayout1.isShown()) || (!localRelativeLayout2.isShown())) {
          break label271;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("RandomDoubleActivity", 2, "switchToolBar-->isShown  return ");
        return;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
          break label235;
        }
        this.jdField_g_of_type_Boolean = true;
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2);
    if (!this.jdField_g_of_type_Boolean) {}
    for (;;)
    {
      this.jdField_g_of_type_Boolean = bool;
      break;
      bool = false;
    }
    label271:
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplicationContext(), 2130968677);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplicationContext(), 2130968711);
    glw localglw;
    for (this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplicationContext(), 2130968677);; this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplicationContext(), 2130968676))
    {
      localglw = new glw(this);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(localglw);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(localglw);
      if (VcSystemInfo.c()) {
        break label446;
      }
      if (QLog.isColorLevel()) {
        QLog.e("RandomDoubleActivity", 2, "switchToolBar-->startAnimation");
      }
      localRelativeLayout1.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      localTextView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
        break;
      }
      localRelativeLayout2.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      return;
      label401:
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplicationContext(), 2130968676);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplicationContext(), 2130968710);
    }
    label446:
    if ((localglw != null) && (QLog.isColorLevel())) {
      QLog.e("RandomDoubleActivity", 2, "switchToolBar-->onAnimationEnd");
    }
    localglw.onAnimationEnd(null);
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RandomDoubleActivity", 2, "resetToolBarTimer SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
      if (this.jdField_g_of_type_Boolean)
      {
        ((VideoAppInterface)super.getAppRuntime()).a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        ((VideoAppInterface)super.getAppRuntime()).a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 6000L);
      }
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1)
    {
      return;
      ((VideoAppInterface)super.getAppRuntime()).a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      return;
    }
    if (!this.jdField_g_of_type_Boolean) {
      l();
    }
    ((VideoAppInterface)super.getAppRuntime()).a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "setClosedByFriendUI");
    }
    d(false);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a() > 1) && (this.jdField_b_of_type_AndroidWidgetImageButton != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetImageButton.setClickable(false);
      }
      c();
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "local close camera");
      }
    }
    if (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a())
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 1;
      b(1);
    }
    if ((!PopupDialog.a()) || (this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a()))
    {
      this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(false);
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839235);
    }
    if (!this.jdField_f_of_type_AndroidWidgetButton.isEnabled()) {
      this.jdField_f_of_type_AndroidWidgetButton.setEnabled(true);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      TipsManager localTipsManager1 = this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
      TipsManager localTipsManager2 = this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
      localTipsManager1.b(72, true);
    }
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    }
    if (this.jdField_e_of_type_AndroidWidgetButton != null) {
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
    }
    this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_d_of_type_AndroidWidgetButton.setClickable(false);
    this.jdField_a_of_type_Boolean = false;
  }
  
  void o()
  {
    if (PopupDialog.a()) {
      return;
    }
    Context localContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext();
    String str = String.format(getResources().getString(2131363831), new Object[] { Integer.valueOf(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_Int / 60) });
    PopupDialog.b(localContext, 230, getResources().getString(2131363832), str, 2131363540, 0, null, new glg(this));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
      v();
    }
    do
    {
      return;
      String str = null;
      if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null) {
        str = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_c_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(false) });
    } while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onCreate");
    }
    super.requestWindowFeature(1);
    super.setContentView(2130903539);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    if (Build.VERSION.SDK_INT >= 19) {}
    Object localObject1;
    Object localObject2;
    try
    {
      super.getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
      {
        paramBundle = super.getString(2131363272) + " 0x00";
        Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
        this.jdField_a_of_type_Boolean = true;
        finish();
        return;
      }
    }
    catch (NoSuchFieldException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomDoubleActivity", 2, "Not exist FLAG_NEEDS_MENU_KEY filed", paramBundle);
        }
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomDoubleActivity", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramBundle);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomDoubleActivity", 2, "onCreate,VideoAppInterface.PROC_STATUS_CAN_CLOSED");
        }
        this.jdField_a_of_type_Boolean = true;
        finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController == null)
      {
        paramBundle = super.getString(2131363272) + " 0x01";
        Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
        this.jdField_a_of_type_Boolean = true;
        finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvRandomRandomController = RandomController.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvRandomRandomController.a(1, getIntent());
      this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener);
      this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130839012);
      a();
      k();
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_b_of_type_AndroidWidgetButton);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper = new AvAddFriendHelper(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, new glq(this));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
      paramBundle = super.findViewById(2131299104);
      localObject1 = paramBundle.findViewById(2131299421);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
        ((View)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, paramBundle);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(false);
        if (this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI == null) {
          this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI = new DialogVideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this, findViewById(2131299121));
        }
        localObject2 = super.getIntent();
        if (!this.jdField_a_of_type_ComTencentAvRandomRandomController.b()) {
          break label1719;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RandomDoubleActivity", 2, "onCreate,IsAccompanyReturn");
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null) {
          break label627;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RandomDoubleActivity", 2, "onCreate,mRandom.mSessionId is null!");
        return;
        ((View)localObject1).setBackgroundResource(2130839236);
      }
      label627:
      if (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_c_of_type_Boolean) {
        break label1320;
      }
    }
    c(2131299015);
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      UITools.a(this.jdField_c_of_type_AndroidWidgetButton, getResources().getString(2131363362));
    }
    label677:
    if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "onCreate -> IsAccompanyReturn isConnected");
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.D == 0) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null))
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, this.jdField_a_of_type_ComTencentAvVideoController.D);
        this.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(0);
      }
      d(false);
      d();
      a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f, this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString));
      if (!TextUtils.isEmpty(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d);
      localObject1 = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.f, false);
      }
      if (paramBundle != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString + getResources().getString(2131363800));
        label1033:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString + getResources().getString(2131363800));
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
        {
          b(2);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
            c(2131299023);
          }
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
        }
      }
    }
    for (;;)
    {
      s();
      p();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = new SmallScreenActivityPlugin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      paramBundle = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
      paramBundle = SharedPreUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).getString("qav_anychat_time_value", "120");
      if (paramBundle == null) {
        break;
      }
      int i = Integer.parseInt(paramBundle);
      SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_Int = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RandomDoubleActivity", 2, "onCreate -> config time limit is : " + i / 60 + " minutes! ");
      return;
      label1320:
      d(2131299015);
      if (this.jdField_c_of_type_AndroidWidgetButton == null) {
        break label677;
      }
      UITools.a(this.jdField_c_of_type_AndroidWidgetButton, getResources().getString(2131363361));
      break label677;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839235);
      break label1033;
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomDoubleActivity", 2, "onCreate -> IsAccompanyReturn CloseByFriend");
        }
        localObject2 = ((Intent)localObject2).getStringExtra("session_name");
        paramBundle = "";
        if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null)
        {
          localObject1 = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d;
          paramBundle = (Bundle)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("RandomDoubleActivity", 2, "onCreate -> roomTopic = " + SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d + ", exRoomTopic = " + (String)localObject1);
            paramBundle = (Bundle)localObject1;
          }
        }
        if (localObject2 != null) {
          if (((String)localObject2).equals(paramBundle)) {
            i = 1;
          }
        }
        while (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RandomDoubleActivity", 2, "onCreate -> mAnyChatCloseByFriend");
          }
          n();
          this.jdField_c_of_type_AndroidWidgetTextView.setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d);
          this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = new SmallScreenActivityPlugin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          paramBundle = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
          registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
          return;
          i = 0;
          this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean = false;
          continue;
          i = 1;
        }
      }
      this.jdField_a_of_type_ComTencentAvRandomRandomController.e();
      d(true);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d);
      continue;
      label1719:
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b();
      boolean bool = getApplicationContext().getSharedPreferences("qav_SP", 0).getBoolean("qav_random_speakeron", false);
      if (QLog.isColorLevel()) {
        QLog.d("RandomDoubleActivity", 2, "qav_random_speakeron: " + bool);
      }
      if (bool) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null) {
          break label1873;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RandomDoubleActivity", 2, "onCreate,mRandom.mSessionId is null! mAnyChatCloseByFriend: " + this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean);
        return;
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      label1873:
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean)
      {
        String str = ((Intent)localObject2).getStringExtra("session_name");
        paramBundle = "";
        if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) != null)
        {
          localObject1 = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d;
          paramBundle = (Bundle)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("RandomDoubleActivity", 2, "onCreate -> roomTopic = " + SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d + ", exRoomTopic = " + (String)localObject1);
            paramBundle = (Bundle)localObject1;
          }
        }
        if (str != null) {
          if (str.equals(paramBundle)) {
            i = 1;
          }
        }
        while (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RandomDoubleActivity", 2, "onCreate -> mAnyChatCloseByFriend");
          }
          n();
          this.jdField_c_of_type_AndroidWidgetTextView.setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d);
          this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.d);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = new SmallScreenActivityPlugin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          paramBundle = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
          registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
          return;
          i = 0;
          this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean = false;
          continue;
          i = 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.E, this.jdField_a_of_type_ComTencentAvVideoController.a, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
      }
      SessionMgr.a().b(this.jdField_a_of_type_ComTencentAvRandomRandomController.d);
      this.jdField_a_of_type_ComTencentAvVideoController.c(false);
      this.jdField_a_of_type_ComTencentAvRandomRandomController.a((Intent)localObject2);
      ReportController.b(null, "CliOper", "", "", "0X80053BD", "0X80053B2", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvRandomRandomController.b();
      d(true);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_e_of_type_JavaLangString);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onDestroy mIsQuit = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    if (this.jdField_d_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    }
    if ((this.jdField_a_of_type_ComTencentAvRandomRandomController != null) && (this.jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener != null)) {
      this.jdField_a_of_type_ComTencentAvRandomRandomController.b(this.jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener);
    }
    if (this.jdField_a_of_type_ComTencentAvRandomRandomController != null) {
      this.jdField_a_of_type_ComTencentAvRandomRandomController.h();
    }
    e();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a();
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper = null;
    }
    try
    {
      if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
      {
        unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i();
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = null;
      }
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils = null;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
        this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
      }
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {}
      try
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {}
        try
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if (this.jdField_g_of_type_AndroidWidgetTextView != null) {}
          try
          {
            this.jdField_g_of_type_AndroidWidgetTextView.clearAnimation();
            this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_g_of_type_Boolean = true;
            this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
            this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
            this.jdField_g_of_type_AndroidWidgetTextView = null;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
            this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
            return;
          }
          catch (Exception localException1)
          {
            for (;;) {}
          }
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
    catch (Exception localException4)
    {
      for (;;) {}
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if (this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a())
      {
        this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(false);
        a(this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.jdField_c_of_type_Int);
        return true;
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        }
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onNewIntent");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_a_of_type_ComTencentAvRandomRandomController.b(super.getIntent());
  }
  
  protected void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onPause");
    }
    try
    {
      super.onPause();
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(false);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
    super.onResume();
    this.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onResume");
    }
    this.jdField_a_of_type_ComTencentAvRandomRandomController.e();
    this.jdField_a_of_type_ComTencentAvVideoController.a(false);
    String str;
    boolean bool1;
    boolean bool3;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().G == 1)
    {
      this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(1);
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().G == 3))
      {
        str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
        boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
        bool3 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean;
        if ((bool3) && (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b()) && (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c())) {
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        }
        if ((!bool3) || (!bool1)) {
          break label331;
        }
        if (!bool2) {
          break label306;
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, true, false, false);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
        this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e();
      }
      t();
      q();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(true);
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().G != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvRandomUiDialogVideoLayerUI.a(0);
      break;
      label306:
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, true, false, false);
      continue;
      label331:
      if (bool3) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
      } else if (bool1) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, true, false, false);
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSensorEvent != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramSensorEvent.values);
    }
  }
  
  protected void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onStart");
    }
    super.onStart();
    if (!this.jdField_a_of_type_ComTencentAvRandomRandomController.b()) {
      this.jdField_a_of_type_ComTencentAvRandomRandomController.a(1, getIntent());
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.E();
    this.jdField_a_of_type_ComTencentAvRandomRandomController.e();
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
      j();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onStop mIsQuit = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a(this.jdField_a_of_type_Boolean);
    }
    u();
    QAVNotification localQAVNotification;
    int i;
    if ((!this.jdField_a_of_type_Boolean) && (!SessionMgr.a().a()))
    {
      localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null) {
        return;
      }
      if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 5) {
        break label174;
      }
      i = 52;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
        break label180;
      }
      i = 60;
    }
    label174:
    label180:
    for (;;)
    {
      localQAVNotification.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.d, "", null, null, i, 1011, 1);
      this.jdField_a_of_type_ComTencentAvVideoController.D();
      r();
      return;
      i = 51;
      break;
    }
  }
  
  void p()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager == null) && (this.jdField_a_of_type_AndroidHardwareSensor == null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    }
  }
  
  void q()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
  }
  
  void r()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
  }
  
  void s()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener == null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new gly(this, super.getApplicationContext(), 2);
    }
  }
  
  void t()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
  }
  
  void u()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\random\ui\RandomDoubleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */