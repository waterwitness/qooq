package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.tencent.av.funchat.magicface.MagicfaceViewControllerForAV;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.VideoConnRateReport;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import gpb;
import gpc;
import gpd;
import gpe;
import gpf;
import gpg;
import gph;
import gpk;
import gpl;
import gpm;
import gpo;
import gpv;
import gpw;
import gpx;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener
{
  public static final int a = 0;
  public static final int b = 1;
  static final String jdField_b_of_type_JavaLangString = "AVActivity";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  long jdField_a_of_type_Long;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public BroadcastReceiver a;
  public Bitmap a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  public RelativeLayout a;
  public TextView a;
  public VideoController a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver;
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver;
  public CameraUtils a;
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  public BeautySettingUi a;
  public ChildGuideUi a;
  private ConfigInfoTips jdField_a_of_type_ComTencentAvUiConfigInfoTips;
  public ControlUIObserver a;
  public EffectSettingUi a;
  public VideoControlUI a;
  public VideoLayerUI a;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  public TipsManager a;
  public VipFullScreenVideoView a;
  public VipFunCallMediaListener a;
  public Runnable a;
  String jdField_a_of_type_JavaLangString;
  public WeakReference a;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  public Bitmap b;
  boolean jdField_b_of_type_Boolean;
  public Bitmap c;
  public String c;
  boolean c;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  String e;
  public boolean e;
  String f;
  public boolean f;
  public int g;
  String g;
  public boolean g;
  public int h;
  public String h;
  boolean h;
  int jdField_i_of_type_Int;
  String jdField_i_of_type_JavaLangString;
  public boolean i;
  public int j;
  String jdField_j_of_type_JavaLangString;
  boolean jdField_j_of_type_Boolean;
  public int k;
  public String k;
  boolean k;
  int jdField_l_of_type_Int;
  String jdField_l_of_type_JavaLangString;
  private boolean jdField_l_of_type_Boolean;
  public int m;
  public String m;
  private boolean m;
  int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean;
  public int p;
  public int q;
  
  public AVActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_g_of_type_Int = 1;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.o = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    this.p = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new gpo(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvCameraCameraObserver = new gpb(this);
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener = new gph(this);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = new gpv(this);
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppDialog = null;
    this.jdField_m_of_type_Boolean = true;
  }
  
  private String a(Intent paramIntent)
  {
    int i3 = paramIntent.getIntExtra("uinType", -1);
    int i2 = UITools.a(i3);
    int i1 = i2;
    if (i2 == 0) {
      i1 = 3;
    }
    String str;
    if (i3 == 1006)
    {
      str = paramIntent.getStringExtra("toMobile");
      if (!paramIntent.getBooleanExtra("isDoubleVideoMeeting", false)) {
        break label169;
      }
      i1 = 10;
      str = paramIntent.getStringExtra("GroupId");
    }
    label169:
    for (;;)
    {
      if ((i3 == -1) || (TextUtils.isEmpty(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AVActivity", 2, "genSessionIdFromIntent error: uinType " + i3 + ", relationId " + str);
        }
        return null;
        if ((i1 == 1) || (i1 == 2))
        {
          str = paramIntent.getStringExtra("GroupId");
          break;
        }
        str = paramIntent.getStringExtra("uin");
        break;
      }
      return SessionMgr.a(i1, str, new int[] { paramIntent.getIntExtra("MultiAVType", -1) });
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("Fromwhere");
    return (paramIntent != null) && (paramIntent.compareTo("AVNotification") == 0);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Boolean = false;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().p = true;
    }
    super.findViewById(2131298954).setVisibility(0);
    this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a(paramBoolean);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.D();
    }
    String str;
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString) != 5) {
        break label136;
      }
    }
    label136:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, false, false, paramBoolean);
      a(false);
      return;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a(paramBoolean);
    a(false);
  }
  
  private void m()
  {
    if (this.jdField_l_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_l_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.j();
  }
  
  public void BtnOnClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "BtnOnClick");
    }
    if (!this.jdField_i_of_type_Boolean) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null) && (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.b()))
      {
        this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a(paramView);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a()))
      {
        this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a(paramView);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramView);
  }
  
  public SmallScreenActivityPlugin a()
  {
    return this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onCreateUI SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_j_of_type_Int == 1008)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130839128);
      this.jdField_b_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130839144);
      this.jdField_c_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130839012);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298952));
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)
      {
        localObject1 = (LinearLayout)super.findViewById(2131297994);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (LinearLayout)localObject1);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298946));
      }
      this.jdField_a_of_type_JavaLangRunnable = new gpe(this);
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
      }
      localObject1 = super.findViewById(2131298944);
      localObject2 = ((View)localObject1).findViewById(2131299421);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131299481);
      if (this.jdField_j_of_type_Int != 1008) {
        break label879;
      }
      ((View)localObject2).setBackgroundResource(2130839128);
      label255:
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        break label913;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (View)localObject1);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a.a.jdField_a_of_type_ComTencentAvUtilsTipsManager = this.jdField_a_of_type_ComTencentAvUtilsTipsManager;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new gpf(this));
      label325:
      b(false);
    }
    switch (this.jdField_h_of_type_Int)
    {
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
          if ((this.jdField_j_of_type_Int == 9500) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
          {
            localObject1 = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            ((DoubleVideoCtrlUI)localObject1).a(26, this.jdField_a_of_type_ComTencentAvVideoController.s, 2130839063);
            if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
              ((DoubleVideoCtrlUI)localObject1).a.setViewEnable(1, false);
            }
            if (!this.jdField_a_of_type_ComTencentAvVideoController.u) {
              ((DoubleVideoCtrlUI)localObject1).a.a(true, false, false);
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
        {
          localObject1 = super.getIntent();
          if (localObject1 != null)
          {
            localObject1 = ((Intent)localObject1).getStringExtra("Fromwhere");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals("SmallScreen"))) {}
          }
        }
        localObject1 = (RelativeLayout)super.findViewById(2131299351);
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi == null) {
            this.jdField_a_of_type_ComTencentAvUiEffectSettingUi = new EffectSettingUi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (ViewGroup)localObject1, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          }
          if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
            this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a();
          }
        }
        localObject1 = (RelativeLayout)super.findViewById(2131298954);
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi == null) {
            this.jdField_a_of_type_ComTencentAvUiBeautySettingUi = new BeautySettingUi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (ViewGroup)localObject1, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          }
          if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null) {
            this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a();
          }
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 4) && (this.jdField_h_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) && (this.jdField_m_of_type_Int != 2))
        {
          int i1 = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 6, true, null);
          VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1);
          if (i1 > 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
            }
            int i2 = VipFunCallManager.a();
            localObject1 = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
            if (localObject1 != null)
            {
              localObject2 = new File((String)localObject1);
              if ((localObject2 == null) || (!((File)localObject2).exists())) {
                break label1356;
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gpg(this, (String)localObject1, i2, i1), 1000L);
              }
            }
          }
        }
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130839012);
          break;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130839012);
        break;
        label879:
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
        {
          ((View)localObject2).setBackgroundResource(2130839012);
          break label255;
        }
        ((View)localObject2).setBackgroundResource(2130839128);
        break label255;
        label913:
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.y();
        break label325;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
        {
          if (this.jdField_m_of_type_Int != 2) {
            break label998;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new HYControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver, this.jdField_i_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(false);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.r(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label998:
          if (this.jdField_j_of_type_Int == 2800)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MicSpeakerControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver, this.jdField_i_of_type_JavaLangString);
          }
          else if (this.jdField_g_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          }
        }
        if (!this.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.r(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
    {
      if (!this.jdField_g_of_type_Boolean) {
        break label1231;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.r(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      break;
      label1231:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 1)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      }
      else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVActivity", 2, "OnCreateUI --> Not Set MultiAVType");
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      }
    }
    label1356:
    QLog.e("AVActivity", 1, "funcall --> !file.exists() + path:" + (String)localObject1);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(paramInt1, paramString, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (boolean bool = false;; bool = true)
    {
      this.jdField_q_of_type_Int += 1;
      MagicfaceViewControllerForAV.a().a((ViewGroup)findViewById(2131298945), paramString, new AVActivity.MagicPlayListener(this), bool);
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = AIOUtils.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    this.jdField_e_of_type_Boolean = false;
    finish();
    int i1 = 2130968685;
    paramInt = i1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      paramInt = i1;
      if (paramString1 != null) {
        paramInt = SmallScreenUtils.a(paramString1.J);
      }
    }
    overridePendingTransition(0, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().p = false;
    }
    SessionMgr.a();
    this.jdField_a_of_type_JavaLangString = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    SessionMgr.a();
    Object localObject = SessionMgr.a(3, "beautySetting", new int[0]);
    SessionMgr.a().a((String)localObject, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.h();
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.E();
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramBoolean))
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        bool = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString) != 5) {
          break label165;
        }
      }
      label165:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, bool, false, paramBoolean);
        return;
      }
    }
    if (2 == this.jdField_h_of_type_Int) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.b(this)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVActivity", 2, "chatAbility is invalid ,finish.");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
        this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 0);
        this.jdField_e_of_type_Boolean = true;
        finish();
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      localObject = (RelativeLayout)super.findViewById(2131299351);
      if (localObject == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi == null) {
        this.jdField_a_of_type_ComTencentAvUiEffectSettingUi = new EffectSettingUi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (ViewGroup)localObject, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      }
      if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a();
      return;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.r(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.u();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVActivity", 2, "onCreateUI mControlUI is null ,finish.");
        }
        finish();
        continue;
        if (1 == this.jdField_h_of_type_Int)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AVActivity", 2, "hideBeautySetting, reason:" + paramInt);
          }
          if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.b(this)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AVActivity", 2, "chatAbility is invalid ,finish.");
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
            this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 0);
            this.jdField_e_of_type_Boolean = true;
            finish();
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean = false;
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.r(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("AVActivity", 2, "mControlUI is null ,finish.");
              }
              finish();
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_m_of_type_Boolean;
  }
  
  void b()
  {
    g();
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) || (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a()))
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4)
        {
          ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
          int i1 = 0;
          if (i1 < localArrayList.size())
          {
            VideoViewInfo localVideoViewInfo = (VideoViewInfo)localArrayList.get(i1);
            String str = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
            int i2 = localVideoViewInfo.jdField_a_of_type_Int;
            if (localVideoViewInfo.jdField_b_of_type_Long == 5L) {}
            for (boolean bool = true;; bool = false)
            {
              if (!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
                this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, i2, false, false, bool);
              }
              i1 += 1;
              break;
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(false);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f();
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h();
    }
    if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.e();
    }
    if (this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi.d();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(true);
    j();
    this.jdField_a_of_type_ComTencentAvVideoController.h(false);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a(this.jdField_e_of_type_Boolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_n_of_type_Boolean;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "processExtraData");
    }
    Object localObject3 = super.getIntent();
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVActivity", 2, "processExtraData-->can not get intent");
      }
      return;
    }
    int i3 = ((Intent)localObject3).getIntExtra("sessionType", 0);
    int i4 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    boolean bool = ((Intent)localObject3).getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_g_of_type_Boolean = bool;
    Object localObject2 = ((Intent)localObject3).getStringExtra("Fromwhere");
    if ((localObject2 != null) && (((String)localObject2).compareTo("AVNotification") == 0))
    {
      if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 13)) && (i3 != 1) && (i3 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVActivity", 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().z) {
          break label335;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 0);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 10) {
          break label376;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
      }
    }
    label335:
    long l1;
    for (;;)
    {
      if (bool) {
        ReportController.b(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
      if (i3 != 0) {
        break label412;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AVActivity", 2, "processExtraData-->can not get session type in intent.");
      }
      finish();
      return;
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.b(3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 1);
      break;
      label376:
      ReportController.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
    }
    label412:
    Object localObject1 = null;
    String str = null;
    int i2 = 0;
    if ((i3 == 1) || (i3 == 2))
    {
      localObject1 = ((Intent)localObject3).getStringExtra("uin");
      if ((localObject2 == null) || (((String)localObject2).compareTo("AVNotification") != 0)) {
        break label2255;
      }
      if ((i3 != 1) && (i3 != 2)) {
        break label524;
      }
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    }
    label524:
    label1260:
    label1596:
    label1613:
    label1715:
    label2252:
    label2255:
    for (;;)
    {
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AVActivity", 2, "processExtraData-->can not get uin in intent.");
        }
        finish();
        return;
        if ((i3 != 3) && (i3 != 4)) {
          break;
        }
        localObject1 = ((Intent)localObject3).getStringExtra("GroupId");
        break;
        if ((i3 != 3) && (i3 != 4)) {
          break label2255;
        }
        if (bool)
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          continue;
        }
        localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        continue;
      }
      int i1;
      if ((i4 == 1) || (i4 == 2))
      {
        str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        i1 = UITools.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int);
        localObject2 = str;
        if (str == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AVActivity", 2, "can not get the original peeruin");
          }
          finish();
        }
      }
      else if ((i4 == 3) || (i4 == 4))
      {
        str = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        i1 = this.jdField_a_of_type_ComTencentAvVideoController.E;
        localObject2 = str;
        if (str == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AVActivity", 2, "can not get the original group uin");
          }
          finish();
        }
      }
      else
      {
        localObject2 = str;
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("AVActivity", 2, "original session type is none");
          i1 = i2;
          localObject2 = str;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "processExtraData-->IntentSessionType=" + i3 + ", OriginalSessionType=" + i4 + ", IntentUin=" + (String)localObject1);
      }
      if ((localObject2 != null) && (QLog.isColorLevel())) {
        QLog.d("AVActivity", 2, "processExtraData-->OriginalUin=" + (String)localObject2 + ", originalRelationType=" + i1);
      }
      if ((i4 == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.n()))
      {
        d();
        if (QLog.isColorLevel()) {
          QLog.d("AVActivity", 2, "mSessionType: " + this.jdField_h_of_type_Int + ", mUinType: " + this.jdField_j_of_type_Int + ", mPeerUin: " + this.jdField_c_of_type_JavaLangString + ", mPeerName: " + this.jdField_d_of_type_JavaLangString + ", mPhoneNum: " + this.jdField_e_of_type_JavaLangString + ", mSelfNation: " + this.jdField_f_of_type_JavaLangString + ", mSelfMobile: " + this.jdField_g_of_type_JavaLangString + ", mIsReceiver:" + this.jdField_a_of_type_Boolean + ", mIsAudioMode: " + this.jdField_b_of_type_Boolean + ", mExtraUin: " + this.jdField_h_of_type_JavaLangString + ", mIsPeerNetworkWell: " + this.jdField_c_of_type_Boolean + ", mIsFriend: " + this.jdField_d_of_type_Boolean + ", mFromWhere: " + this.jdField_i_of_type_JavaLangString);
        }
        HexUtil.a("AVActivity", this.jdField_a_of_type_ArrayOfByte);
        return;
      }
      if ((i4 == 3) || (i4 == 4) || (this.jdField_a_of_type_ComTencentAvVideoController.n()))
      {
        if ((i4 != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.n())) {
          break label2252;
        }
        localObject2 = "";
      }
      for (;;)
      {
        if ((i3 == 1) || (i3 == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.n()) {
            this.jdField_a_of_type_ComTencentAvVideoController.g(true);
          }
          for (;;)
          {
            d();
            return;
            this.jdField_a_of_type_ComTencentAvVideoController.a(i1, Long.valueOf((String)localObject2).longValue(), 0, new int[0]);
          }
        }
        if ((i3 != 3) && (i3 != 4)) {
          break;
        }
        l1 = Long.valueOf((String)localObject1).longValue();
        i4 = ((Intent)localObject3).getIntExtra("MultiAVType", 0);
        this.jdField_a_of_type_ComTencentAvVideoController.a().as = ((Intent)localObject3).getBooleanExtra("isConferenceFlyTicket", false);
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().D != 0) && (i4 != this.jdField_a_of_type_ComTencentAvVideoController.a().D) && (i4 != 0)) {}
        for (i2 = 1;; i2 = 0)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(i4);
          if (!bool) {
            if (this.jdField_a_of_type_ComTencentAvVideoController.n())
            {
              this.jdField_a_of_type_ComTencentAvVideoController.g(true);
              if (i2 != 0)
              {
                this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 0, new int[0]);
                this.jdField_a_of_type_ComTencentAvVideoController.a().a(i4);
                this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 3;
              }
              this.jdField_a_of_type_ComTencentAvVideoController.a().E = ((Intent)localObject3).getIntExtra("Type", -1);
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Long = l1;
              this.jdField_a_of_type_ComTencentAvVideoController.a().s = ((String)localObject1);
              if (((String)localObject1).compareTo((String)localObject2) != 0) {
                break label1613;
              }
              if (i2 == 0) {
                break label1596;
              }
              this.jdField_h_of_type_Int = i3;
              localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
              i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
              ((SessionInfo)localObject1).jdField_l_of_type_Int = i1;
              this.jdField_j_of_type_Int = i1;
              this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().E == -1) {
                this.jdField_a_of_type_ComTencentAvVideoController.a().E = 0;
              }
              this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean;
              if (QLog.isColorLevel()) {
                QLog.d("AVActivity", 2, "processExtraData multiAVType: " + this.jdField_a_of_type_ComTencentAvVideoController.a().D);
              }
            }
          }
          for (;;)
          {
            if (i2 != 0) {
              break label1715;
            }
            this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int;
            this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
            this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean;
            break;
            if ((((String)localObject1).compareTo((String)localObject2) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
              break label1260;
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 0, new int[0]);
            this.jdField_a_of_type_ComTencentAvVideoController.a().a(i4);
            break label1260;
            this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
            continue;
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = i3;
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int = ((Intent)localObject3).getIntExtra("uinType", -1);
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().E == 0) || (this.jdField_a_of_type_ComTencentAvVideoController.a().E == 1)) {
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_ArrayOfLong = ((Intent)localObject3).getLongArrayExtra("DiscussUinList");
            }
            this.jdField_h_of_type_Int = i3;
            continue;
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString = ((String)localObject1);
            this.jdField_h_of_type_Int = i3;
          }
          break;
          if (((i4 != 1) && (i4 != 2)) || ((i3 != 1) && (i3 != 2))) {
            break;
          }
          i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
          if ((i1 != -1) && (i1 != this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int))
          {
            if (QLog.isColorLevel()) {
              QLog.w("AVActivity", 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a(false, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
            if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
            }
            localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
            localObject2 = SessionMgr.a(3, (String)localObject1, new int[0]);
            if (SessionMgr.a().a((String)localObject2) == null)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AVActivity", 2, "Can not get SessionInfo : SessionId = " + (String)localObject2);
              }
              finish();
              return;
            }
            str = SessionMgr.a().a((String)localObject2).jdField_e_of_type_JavaLangString;
            i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int;
            localObject3 = SessionMgr.a().a((String)localObject2).t;
            this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 0);
            this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, i1, (String)localObject1, str, 0, (String)localObject3, false, true);
            d();
            localObject1 = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
            localObject2 = SessionMgr.a().a((String)localObject1, false);
            ((SessionInfo)localObject2).jdField_a_of_type_Boolean = true;
            ((SessionInfo)localObject2).jdField_j_of_type_Int = 2;
            ((SessionInfo)localObject2).ae = false;
            if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
              break;
            }
            this.jdField_a_of_type_JavaLangString = ((String)localObject1);
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.w("AVActivity", 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
          }
          this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
          this.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().z;
          this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int;
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
          this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString;
          this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().A;
          this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString;
          this.jdField_l_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().B;
          this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
          this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString;
          this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean;
          this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().K;
          this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean;
          this.jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int;
          break;
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), paramBoolean);
    }
  }
  
  void d()
  {
    Object localObject = super.getIntent();
    this.jdField_h_of_type_Int = ((Intent)localObject).getIntExtra("sessionType", 0);
    this.jdField_j_of_type_Int = ((Intent)localObject).getIntExtra("uinType", -1);
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
    this.jdField_l_of_type_JavaLangString = ((Intent)localObject).getStringExtra("dstClient");
    this.jdField_g_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_m_of_type_JavaLangString = ((Intent)localObject).getStringExtra("bindId");
    this.jdField_k_of_type_Int = ((Intent)localObject).getIntExtra("bindType", 0);
    this.jdField_i_of_type_Int = ((Intent)localObject).getIntExtra("subServiceType", 0);
    this.jdField_l_of_type_Int = ((Intent)localObject).getIntExtra("extraType", 0);
    this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("name");
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("selfNation");
    this.jdField_g_of_type_JavaLangString = ((Intent)localObject).getStringExtra("selfMobile");
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("toMobile");
    this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("receive", false);
    this.jdField_b_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isAudioMode", true);
    this.jdField_h_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extraUin");
    String str1 = ((Intent)localObject).getStringExtra("extraCode");
    byte[] arrayOfByte = ((Intent)localObject).getByteArrayExtra("sig");
    this.jdField_c_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isPeerNetworkWell", false);
    this.jdField_d_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isFriend", false);
    this.jdField_i_of_type_JavaLangString = ((Intent)localObject).getStringExtra("from");
    this.jdField_f_of_type_Boolean = ((Intent)localObject).getBooleanExtra("shutCamera", false);
    String str2 = ((Intent)localObject).getStringExtra("headUrl");
    this.jdField_a_of_type_Long = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
    this.o = ((Intent)localObject).getIntExtra("vipType", 0);
    this.jdField_h_of_type_Boolean = ((Intent)localObject).getBooleanExtra("triggerBeauty", false);
    if (((Intent)localObject).hasExtra("c2b_logo_url")) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_JavaLangString = ((Intent)localObject).getStringExtra("c2b_logo_url");
    }
    if (((Intent)localObject).hasExtra("c2b_session_id"))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_JavaLangString = ((Intent)localObject).getStringExtra("c2b_session_id");
      if (!((Intent)localObject).hasExtra("c2b_app_id")) {
        break label720;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().n = ((Intent)localObject).getStringExtra("c2b_app_id");
      label382:
      if (!((Intent)localObject).hasExtra("c2b_user_info")) {
        break label734;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().o = ((Intent)localObject).getStringExtra("c2b_user_info");
      label409:
      if (!((Intent)localObject).hasExtra("c2b_call_direct_artificial")) {
        break label748;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().x = ((Intent)localObject).getStringExtra("c2b_call_direct_artificial");
      label436:
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "mTriggerBeauty = " + this.jdField_h_of_type_Boolean);
      }
      if ((this.jdField_j_of_type_Int == 0) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_j_of_type_Int == 1008) {
        this.jdField_m_of_type_Int = 2;
      }
      if (this.jdField_j_of_type_Int != 1011) {
        break label788;
      }
      if (arrayOfByte == null) {
        break label762;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[arrayOfByte.length + 3];
      this.jdField_a_of_type_ArrayOfByte[0] = 1;
      this.jdField_a_of_type_ArrayOfByte[1] = 1;
      this.jdField_a_of_type_ArrayOfByte[2] = -118;
      System.arraycopy(arrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 3, arrayOfByte.length);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, String.format("We get businessType in intent data is %d.", new Object[] { Integer.valueOf(this.jdField_m_of_type_Int) }));
      }
      AVReport.a().jdField_i_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_h_of_type_Int != 3) && (this.jdField_h_of_type_Int != 4)) {
        break label1038;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().E = ((Intent)localObject).getIntExtra("Type", -1);
      this.jdField_a_of_type_ComTencentAvVideoController.a().s = ((Intent)localObject).getStringExtra("GroupId");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().s)) {
        break label796;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AVActivity", 2, "relationIdStr is null");
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_JavaLangString = null;
      break;
      label720:
      this.jdField_a_of_type_ComTencentAvVideoController.a().n = null;
      break label382;
      label734:
      this.jdField_a_of_type_ComTencentAvVideoController.a().o = null;
      break label409;
      label748:
      this.jdField_a_of_type_ComTencentAvVideoController.a().x = null;
      break label436;
      label762:
      this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      continue;
      label788:
      this.jdField_a_of_type_ArrayOfByte = arrayOfByte;
    }
    label796:
    Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().s).longValue();
    int i2 = ((Intent)localObject).getIntExtra("MultiAVType", 0);
    int i1 = i2;
    if (i2 == 0)
    {
      i2 = this.jdField_a_of_type_ComTencentAvVideoController.a().D;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d("AVActivity", 2, "Not get avtype inside intent default value: " + i2);
        i1 = i2;
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(i1);
    QLog.d("AVActivity", 2, "processIntentData :  set Value multiAVType: " + this.jdField_a_of_type_ComTencentAvVideoController.a().D);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().s != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().s).longValue();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_ArrayOfLong = ((Intent)localObject).getLongArrayExtra("DiscussUinList");
    this.jdField_a_of_type_ComTencentAvVideoController.a().as = ((Intent)localObject).getBooleanExtra("isConferenceFlyTicket", false);
    while (this.jdField_h_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVActivity", 2, "invalid sessionType!!!");
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
      label1038:
      this.jdField_a_of_type_ComTencentAvVideoController.a().ag = ((Intent)localObject).getBooleanExtra("isOtherTerminalOnChating", false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ag)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long = ((Intent)localObject).getLongExtra("otherTerminalChatingRoomId", 0L);
        this.jdField_a_of_type_ComTencentAvVideoController.a().ai = ((Intent)localObject).getBooleanExtra("startfromVideoEntry", false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "peerUin : " + this.jdField_c_of_type_JavaLangString + "bStartByTerminalSwitch : " + this.jdField_a_of_type_ComTencentAvVideoController.a().ag + ", sessionType : " + this.jdField_h_of_type_Int + ",StartFromVideoEntry:" + this.jdField_a_of_type_ComTencentAvVideoController.a().ai);
      }
    }
    if (((Intent)localObject).getIntExtra("istatus", 0) == 11) {}
    for (i1 = 0;; i1 = 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.d(i1);
      if (!this.jdField_a_of_type_Boolean) {
        break label2077;
      }
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "uin is empty");
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    }
    label1285:
    if ((this.jdField_j_of_type_Int != 1011) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 0);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int = this.jdField_m_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int = this.jdField_j_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString = str1;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentAvVideoController.a().K = this.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean = this.jdField_c_of_type_Boolean;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a().A = this.jdField_k_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a().B = this.jdField_l_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ComTencentAvVideoController.a().C = this.jdField_d_of_type_Boolean;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean = this.jdField_f_of_type_Boolean;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Int = this.o;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int = ((Intent)localObject).getIntExtra("friendTerminal", -1);
    this.jdField_a_of_type_ComTencentAvVideoController.a().z = this.jdField_g_of_type_Boolean;
    this.jdField_a_of_type_ComTencentAvVideoController.a().r = this.jdField_i_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a().T = ((Intent)localObject).getBooleanExtra("isAVMeeting", false);
    this.jdField_a_of_type_ComTencentAvVideoController.a().U = ((Intent)localObject).getBooleanExtra("isAVGroupMeeting", false);
    this.jdField_a_of_type_ComTencentAvVideoController.a().u = ((Intent)localObject).getIntExtra("graySwitch", 0);
    this.jdField_a_of_type_ComTencentAvVideoController.a().w = ((Intent)localObject).getIntExtra("ltC2CMembership", 5);
    this.jdField_a_of_type_ComTencentAvVideoController.a().v = ((Intent)localObject).getIntExtra("ltMultiMembership", 5);
    this.jdField_a_of_type_ComTencentAvVideoController.a().y = ((Intent)localObject).getIntExtra("ipPstnEnterType", 0);
    boolean bool = ((Intent)localObject).getBooleanExtra("pstnC2CSwitchMulti", false);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().y == 1) && (bool)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().O = true;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.M = ((Intent)localObject).getIntExtra("multiPstnMissDelayTime", 20);
    this.jdField_a_of_type_ComTencentAvVideoController.N = ((Intent)localObject).getIntExtra("multiPstnMissShowTime", 60);
    this.jdField_a_of_type_ComTencentAvVideoController.O = ((Intent)localObject).getIntExtra("multiPstnAutoTranTime", 100000);
    if ((this.jdField_j_of_type_Int == 1011) || (this.jdField_j_of_type_Int == 21))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = str2;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("name");
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue() > Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue()) {}
      for (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = false)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
        if (!FileUtil.a((String)localObject)) {
          break;
        }
        try
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile((String)localObject);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          return;
        }
        label2077:
        if (this.jdField_j_of_type_Int == 1006)
        {
          if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AVActivity", 2, "phoneNum is empty");
            }
            this.jdField_e_of_type_Boolean = true;
            finish();
            return;
          }
          this.jdField_c_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
          if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            this.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
          }
          if (!QLog.isColorLevel()) {
            break label1285;
          }
          QLog.d("AVActivity", 2, "mPeerUin: " + this.jdField_c_of_type_JavaLangString);
          break label1285;
        }
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AVActivity", 2, "Create video failed because uin is empty");
          }
          this.jdField_e_of_type_Boolean = true;
          finish();
          return;
        }
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          break label1285;
        }
        this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        break label1285;
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = false;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_m_of_type_Boolean = paramBoolean;
  }
  
  void e()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener == null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new gpw(this, super.getApplicationContext(), 2);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_n_of_type_Boolean = paramBoolean;
  }
  
  void f()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
  }
  
  public void finish()
  {
    if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (this.jdField_i_of_type_JavaLangString.equals("from_app_contact"))) {
      moveTaskToBack(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "finish");
    }
    super.finish();
  }
  
  void g()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
  }
  
  void h()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager == null) && (this.jdField_a_of_type_AndroidHardwareSensor == null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    }
  }
  
  void i()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
  }
  
  void j()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
  }
  
  void k()
  {
    if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) || (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c())) {
      return;
    }
    l();
    ActionSheet localActionSheet = ActionSheet.c(this);
    localActionSheet.getWindow().addFlags(524288);
    localActionSheet.getWindow().addFlags(2097152);
    localActionSheet.getWindow().addFlags(128);
    localActionSheet.c(2131363269);
    localActionSheet.a(new gpm(this));
    localActionSheet.setOnDismissListener(new gpc(this));
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.f(150);
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_k_of_type_Boolean = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void l()
  {
    if ((!this.jdField_k_of_type_Boolean) || ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_k_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_j_of_type_Boolean == true) {}
    for (;;)
    {
      return;
      boolean bool = false;
      if ((this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null) && (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.b())) {
        bool = this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a();
      }
      while (!bool)
      {
        super.onBackPressed();
        return;
        if ((this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.b())) {
          bool = this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a();
        } else if ((this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) {
          bool = this.jdField_a_of_type_ComTencentAvUiChildGuideUi.b();
        } else if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          bool = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    long l1;
    try
    {
      Object localObject1 = getApplicationContext();
      localObject1 = localObject1.getPackageManager().getPackageInfo(localObject1.getPackageName(), 64).signatures[0];
      Log.e("SIGNATURES", "hashCode : " + ((Signature)localObject1).hashCode());
      l1 = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_AVActivity", 4, ">>>onCreate(), ts=" + l1);
      }
      super.onCreate(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "onCreate");
      }
      super.requestWindowFeature(1);
      super.setContentView(2130903522);
      super.getWindow().addFlags(524288);
      super.getWindow().addFlags(2097152);
      super.getWindow().addFlags(128);
      if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        super.getWindow().addFlags(67108864);
      }
      c(true);
      if (QLog.isDevelopLevel()) {
        QLog.d("AVActivity", 4, "isSupporImmersive = " + ImmersiveUtils.isSupporImmersive());
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        super.getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
        {
          paramBundle = super.getString(2131363272) + " 0x00";
          Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
          this.jdField_e_of_type_Boolean = true;
          sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
          finish();
          return;
          localNameNotFoundException = localNameNotFoundException;
          localNameNotFoundException.printStackTrace();
        }
      }
      catch (NoSuchFieldException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AVActivity", 2, "Not exist FLAG_NEEDS_MENU_KEY filed", paramBundle);
          }
        }
      }
      catch (IllegalAccessException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AVActivity", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramBundle);
          }
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AVActivity", 2, "onCreate,VideoAppInterface.PROC_STATUS_CAN_CLOSED");
          }
          this.jdField_e_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
          finish();
          return;
        }
        AVReport.a().a(getIntent(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (this.jdField_a_of_type_ComTencentAvVideoController == null)
        {
          paramBundle = super.getString(2131363272) + " 0x01";
          Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
          this.jdField_e_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
          finish();
          return;
        }
        paramBundle = super.getIntent();
        if (paramBundle != null)
        {
          int i1 = paramBundle.getIntExtra("uinType", -1);
          paramBundle = paramBundle.getStringExtra("uin");
          if (i1 == 1008)
          {
            Object localObject2 = SessionMgr.a(3, paramBundle, new int[0]);
            localObject2 = SessionMgr.a().a((String)localObject2);
            if ((localObject2 == null) || (((SessionInfo)localObject2).jdField_l_of_type_Int == -1))
            {
              localObject2 = SessionMgr.a().a();
              if ((((SessionInfo)localObject2).jdField_l_of_type_Int != -1) && ((((SessionInfo)localObject2).c()) || (((SessionInfo)localObject2).d())))
              {
                localObject2 = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
                ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
                ((Intent)localObject2).putExtra("uin", paramBundle);
                ((Intent)localObject2).putExtra("uinType", i1);
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject2);
                this.jdField_e_of_type_Boolean = true;
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
                finish();
                return;
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
        this.jdField_a_of_type_ComTencentAvVideoController.l();
        this.jdField_a_of_type_ComTencentAvVideoController.e();
        e();
        h();
        this.jdField_a_of_type_JavaLangString = a(getIntent());
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label1074;
        }
      }
    }
    if ((!a(getIntent())) && (!SessionMgr.a().a(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
      SessionMgr.a().a(this.jdField_a_of_type_JavaLangString, false);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().O) {
        c();
      }
      GraphicRenderMgr.getInstance();
      ThreadManager.a(new gpd(this), 5, null, false);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_g_of_type_Int = 1;
      a();
      if ((!this.jdField_h_of_type_Boolean) || (2 != this.jdField_h_of_type_Int)) {
        break label1090;
      }
      SessionMgr.a();
      paramBundle = SessionMgr.a(3, "beautySetting", new int[0]);
      SessionMgr.a().a(this.jdField_a_of_type_JavaLangString, paramBundle);
      this.jdField_a_of_type_JavaLangString = paramBundle;
      f(false);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        VideoConnRateReport.a().a();
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_AVActivity", 4, "<<<onCreate(), ts=" + l2);
        QLog.d("IVR_TS_AVActivity", 4, String.format("onCreate(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips = new ConfigInfoTips(this);
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips.a();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = new SmallScreenActivityPlugin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      return;
      label1074:
      this.jdField_a_of_type_JavaLangString = SessionMgr.a().a().jdField_b_of_type_JavaLangString;
      break;
      label1090:
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().p) {}
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_g_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i();
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null)
    {
      this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.c();
      this.jdField_a_of_type_ComTencentAvUiBeautySettingUi = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
    {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.h();
      this.jdField_a_of_type_ComTencentAvUiEffectSettingUi = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null)
    {
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi.b();
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().O = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    if (this.jdField_a_of_type_ComTencentAvUiConfigInfoTips != null)
    {
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips.b();
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips = null;
    }
    if ((getIntent() != null) && ("gavideo_avmeeting".equals(getIntent().getStringExtra("jump_from"))))
    {
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uintype", 3000);
      startActivity(localIntent);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt, paramKeyEvent);; bool = false)
    {
      if (bool) {}
      do
      {
        return true;
        switch (paramInt)
        {
        case 84: 
        case 24: 
        case 25: 
        default: 
          return super.onKeyDown(paramInt, paramKeyEvent);
        case 4: 
          if (this.jdField_q_of_type_Int > 0)
          {
            MagicfaceViewControllerForAV.a().b(0);
            return true;
          }
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
      } while ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null) || (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int < 9) || (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) || (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c()))));
      k();
      return true;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
    setIntent(paramIntent);
    int i1 = paramIntent.getIntExtra("sessionType", 0);
    int i2 = paramIntent.getIntExtra("MultiAVType", 0);
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 2)) {
      if ((i1 == 3) || (i1 == 4))
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        c();
        this.jdField_g_of_type_Int = 1;
        a();
      }
    }
    label100:
    label210:
    do
    {
      do
      {
        do
        {
          break label100;
          do
          {
            return;
          } while ((this.jdField_h_of_type_Int != 3) && (this.jdField_h_of_type_Int != 4));
          if ((i2 != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
            break label210;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D != i2) {
            break;
          }
          c();
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f();
        } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramIntent);
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        c();
        this.jdField_g_of_type_Int = 1;
        a();
        return;
        if ((i1 != 3) && (i1 != 4)) {
          break;
        }
        c();
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f();
      } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramIntent);
      return;
    } while ((i1 != 1) && (i1 != 2));
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    c();
    this.jdField_g_of_type_Int = 1;
    a();
  }
  
  protected void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onPause");
    }
    try
    {
      super.onPause();
      this.jdField_g_of_type_Int = 4;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)) {
        this.jdField_a_of_type_ComTencentAvVideoController.jdField_n_of_type_Boolean = SmallScreenUtils.c(this);
      }
      return;
    }
    catch (Exception localException)
    {
      super.finish();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    }
  }
  
  public void onResume()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_AVActivity", 4, ">>>onResume(), ts=" + l1);
    }
    super.onResume();
    if ((this.jdField_l_of_type_Boolean) && ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 2)))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.E();
    }
    this.jdField_l_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 5;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onResume");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.h(true);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gpk(this), 200L);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().p) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
      }
    }
    label265:
    boolean bool2;
    boolean bool1;
    label590:
    label616:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e();
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
        }
        if (this.jdField_a_of_type_ComTencentAvUiBeautySettingUi != null)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
            break label1399;
          }
          this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.d();
        }
        if (this.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
          this.jdField_a_of_type_ComTencentAvUiChildGuideUi.c();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(false);
        f();
        i();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
        long l2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel())
        {
          QLog.d("IVR_TS_AVActivity", 4, "<<<onResume(), ts=" + l2);
          QLog.d("IVR_TS_AVActivity", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
        }
        this.jdField_a_of_type_ComTencentAvVideoController.jdField_n_of_type_Boolean = true;
        localObject = MagicfaceViewControllerForAV.a();
        if ((((MagicfaceViewControllerForAV)localObject).a() == 2) && (((MagicfaceViewControllerForAV)localObject).a() != null)) {
          a(((MagicfaceViewControllerForAV)localObject).a());
        }
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
        {
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString) == 5) {}
          boolean bool4;
          for (bool1 = true;; bool1 = false)
          {
            boolean bool3 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
            bool4 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean;
            if ((bool4) && (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b()) && (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c())) {
              this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
            }
            if ((!bool4) || (!bool2)) {
              break label616;
            }
            if (!bool3) {
              break label590;
            }
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, true, false, bool1);
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
            break;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, true, false, bool1);
          continue;
          if (bool4) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
          } else if (bool2) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, true, false, bool1);
          }
        }
        else if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ag) && (!this.jdField_f_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
        }
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
    Collections.sort(localArrayList, new gpl(this));
    int i3 = this.jdField_a_of_type_ComTencentAvVideoController.i();
    int i2 = 0;
    label757:
    VideoViewInfo localVideoViewInfo;
    String str2;
    int i4;
    int i1;
    label834:
    String str1;
    if (i2 < localArrayList.size())
    {
      localVideoViewInfo = (VideoViewInfo)localArrayList.get(i2);
      str2 = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
      i4 = localVideoViewInfo.jdField_a_of_type_Int;
      bool1 = localVideoViewInfo.jdField_a_of_type_Boolean;
      bool2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4);
      i1 = -1;
      if (this.jdField_j_of_type_Int != 3000) {
        break label1151;
      }
      i1 = 1004;
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, str2, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Long));
      if ((localVideoViewInfo.jdField_b_of_type_Boolean) && (!str2.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (bool1) && (!localVideoViewInfo.jdField_d_of_type_Boolean)) {
        if (CharacterUtil.a(str1) <= 20) {
          break label1409;
        }
      }
    }
    label974:
    label1043:
    label1151:
    label1220:
    label1307:
    label1335:
    label1399:
    label1409:
    for (Object localObject = CharacterUtil.a(str1, 0, 20) + "...";; localObject = str1)
    {
      if (i4 == 2)
      {
        localObject = String.format(getString(2131363459), new Object[] { localObject });
        TipsManager.a(106, (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106, (String)localObject, true);
        if ((localVideoViewInfo.jdField_b_of_type_Boolean) || (localVideoViewInfo.jdField_a_of_type_Boolean)) {
          break label1335;
        }
        if (i3 == 4) {
          break label1307;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {
          break label1220;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, this.jdField_b_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        if ((!bool2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().z))
        {
          float f1 = 10.0F;
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str2, i4)) {
            f1 = 14.0F;
          }
          f1 = UITools.a(getApplicationContext(), f1);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, str1, f1, -1);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4);
        }
        i2 += 1;
        break label757;
        break;
        if (this.jdField_j_of_type_Int == 1)
        {
          i1 = 1000;
          break label834;
        }
        if (this.jdField_j_of_type_Int != 0) {
          break label834;
        }
        i1 = 0;
        break label834;
        localObject = String.format(getString(2131363458), new Object[] { localObject });
        TipsManager.a(103, (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103, (String)localObject, true);
        break label974;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
          break label1043;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        break label1043;
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, this.jdField_c_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        continue;
        if (!localVideoViewInfo.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, this.jdField_c_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        } else {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, i4, this.jdField_a_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        }
      }
      this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.f();
      break label265;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSensorEvent != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramSensorEvent.values);
    }
  }
  
  protected void onStart()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_AVActivity", 4, ">>>onStart(), ts=" + l1);
    }
    super.onStart();
    this.jdField_g_of_type_Int = 3;
    this.jdField_l_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onStart");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g();
    }
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 2))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.E();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_AVActivity", 4, "<<<onStart(), ts=" + l2);
      QLog.d("IVR_TS_AVActivity", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_g_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onStop");
    }
    if (this.jdField_q_of_type_Int > 0) {
      MagicfaceViewControllerForAV.a().b(1);
    }
    b();
    m();
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)) {
      return;
    }
    this.jdField_g_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onUserLeaveHint");
    }
    m();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onWindowFocusChanged hasFocus = " + paramBoolean);
    }
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      return;
    }
    super.getWindow().getDecorView().postDelayed(new gpx(this), 500L);
    if (AVReport.a().jdField_a_of_type_Boolean)
    {
      AVReport.a().jdField_i_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().x = SystemClock.elapsedRealtime();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\AVActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */