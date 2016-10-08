package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.av.funchat.magicface.MagicfaceViewControllerForAV;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUI.SmallScreenListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;
import gov;
import gow;
import gox;
import goy;
import goz;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class SmallScreenVideoController
  implements VideoLayerUI.SmallScreenListener
{
  static final int jdField_a_of_type_Int = 0;
  static final String jdField_a_of_type_JavaLangString = "SmallScreenVideoController";
  static final int b = 1;
  static final int c = 2;
  static final int d = 3;
  static final int jdField_e_of_type_Int = 4;
  static final int f = 5;
  public Context a;
  public Bitmap a;
  public Display a;
  public VideoController a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver;
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver;
  public CameraUtils a;
  public SmallScreenService a;
  public SmallScreenVideoControlUI a;
  public AbstractOrientationEventListener a;
  public ControlUIObserver a;
  public VideoLayerUI a;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  boolean jdField_e_of_type_Boolean;
  public int g;
  public int h;
  public int i;
  public int j;
  int k;
  public int l;
  
  SmallScreenVideoController(SmallScreenService paramSmallScreenService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewDisplay = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_g_of_type_Int = 1;
    this.h = 0;
    this.i = -1;
    this.j = 0;
    this.k = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = null;
    this.l = 0;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new gox(this);
    this.jdField_a_of_type_ComTencentAvCameraCameraObserver = new gov(this);
    this.e = false;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = new goy(this);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_AndroidContentContext = paramSmallScreenService.getApplicationContext();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getSystemService("window")).getDefaultDisplay();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "WL_DEBUG onClick start");
    }
    MagicfaceViewControllerForAV.a().b(2);
    Intent localIntent;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (MultiIncomingCallsActivity.jdField_f_of_type_Boolean))
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.addFlags(4194304);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "WL_DEBUG onClick end");
      }
      label92:
      return;
    }
    SessionInfo localSessionInfo;
    int m;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      m = localSessionInfo.jdField_f_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "WL_DEBUG onClick sessionType =" + m);
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
        break label632;
      }
      m = 1;
    }
    label632:
    for (;;)
    {
      if ((m == 1) || (m == 2))
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
        if ((localSessionInfo.l == 1011) || (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean)) {
          localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RandomDoubleActivity.class);
        }
        localIntent.addFlags(262144);
        localIntent.addFlags(268435456);
        localIntent.addFlags(4194304);
        if (localSessionInfo.z)
        {
          localIntent.putExtra("sessionType", 3);
          localIntent.putExtra("GroupId", localSessionInfo.jdField_c_of_type_JavaLangString);
          localIntent.putExtra("isDoubleVideoMeeting", true);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        }
        for (;;)
        {
          localIntent.putExtra("Fromwhere", "SmallScreen");
          break;
          localIntent.putExtra("sessionType", m);
          localIntent.putExtra("uin", localSessionInfo.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        }
      }
      long l1 = localSessionInfo.jdField_e_of_type_Long;
      int n = localSessionInfo.F;
      if ((l1 != 0L) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b > 0))
      {
        if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b > 0) {
          if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L) {
            localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, GuildMultiActivity.class);
          }
        }
        for (;;)
        {
          localIntent.addFlags(262144);
          localIntent.addFlags(268435456);
          localIntent.addFlags(4194304);
          localIntent.putExtra("GroupId", String.valueOf(l1));
          localIntent.putExtra("Type", 2);
          localIntent.putExtra("sessionType", m);
          localIntent.putExtra("uinType", UITools.b(n));
          localIntent.putExtra("isDoubleVideoMeeting", localSessionInfo.z);
          localIntent.putExtra("MultiAVType", localSessionInfo.D);
          localIntent.putExtra("Fromwhere", "SmallScreen");
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          break;
          if ((localSessionInfo.jdField_f_of_type_Int == 1) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1))
          {
            localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RandomDoubleActivity.class);
          }
          else if ((localSessionInfo.jdField_f_of_type_Int == 3) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3))
          {
            localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RandomMultiActivity.class);
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label92;
            }
            QLog.e("SmallScreenVideoController", 2, "WL_DEBUG onClick status error");
            return;
            localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SmallScreenVideoController", 2, "WL_DEBUG onClick status error");
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SmallScreenVideoController", 2, "WL_DEBUG onClick app is null");
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(paramInt);
  }
  
  void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof VideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onCreate");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramAppRuntime);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvVideoController.l();
      this.jdField_a_of_type_ComTencentAvVideoController.e();
      j();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().O) {
        i();
      }
      GraphicRenderMgr.getInstance();
      a(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localObject != null) && (QLog.isColorLevel())) {
      QLog.d("SmallScreenVideoController", 2, "onCreateUI SessionType = " + ((SessionInfo)localObject).jdField_f_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130839012);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
    }
    View localView = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131298944);
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, localView, true, this);
      switch (this.h)
      {
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null)) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      }
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramBoolean);
      }
      if ((localObject != null) && (((SessionInfo)localObject).j != 4) && (this.h == 1) && (!this.jdField_a_of_type_Boolean))
      {
        int m = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 6, true, null);
        if (m > 0)
        {
          int n = VipFunCallManager.a();
          localObject = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, m, n, null);
          if (localObject != null)
          {
            localObject = new File((String)localObject);
            if ((localObject != null) && (((File)localObject).exists()) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d();
            }
          }
        }
      }
      return;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.y();
      break;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          if (localObject != null) {
            this.h = ((SessionInfo)localObject).jdField_f_of_type_Int;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          continue;
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          continue;
          if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
            if (this.jdField_d_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              if (localObject != null) {
                this.h = ((SessionInfo)localObject).jdField_f_of_type_Int;
              }
            }
            else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
            else
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              continue;
              if ((localObject != null) && (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b > 0)) {
                if (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3) {
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
                } else {
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
                }
              }
            }
          }
        }
      }
    }
  }
  
  void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
    }
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 8))
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
      return;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
  }
  
  public void d()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ">>>onStart(), ts=" + l1);
    }
    this.jdField_g_of_type_Int = 3;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStart");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onStart(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void e()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ">>>onResume(), ts=" + l1);
    }
    this.e = false;
    this.jdField_g_of_type_Int = 5;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onResume");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gow(this), 200L);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().p) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
    }
    Object localObject2;
    boolean bool2;
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e();
        }
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.f();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(false);
        k();
        long l2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel())
        {
          QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onResume(), ts=" + l2);
          QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
        }
        localObject1 = MagicfaceViewControllerForAV.a();
        if ((((MagicfaceViewControllerForAV)localObject1).a() == 1) && (((MagicfaceViewControllerForAV)localObject1).a() != null))
        {
          localObject2 = (ViewGroup)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131298944);
          MagicfaceManagerForAV.a().a(((MagicfaceViewControllerForAV)localObject1).a(), (ViewGroup)localObject2);
        }
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_b_of_type_JavaLangString) == 5) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject1, 1, bool2, false, bool1);
            if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f())) {
              break;
            }
            this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            break;
          }
        }
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ag) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, false);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        }
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
    int m = 0;
    label538:
    String str;
    int n;
    boolean bool3;
    if (m < ((ArrayList)localObject1).size())
    {
      localObject2 = (VideoViewInfo)((ArrayList)localObject1).get(m);
      str = String.valueOf(((VideoViewInfo)localObject2).jdField_a_of_type_Long);
      n = ((VideoViewInfo)localObject2).jdField_a_of_type_Int;
      bool2 = ((VideoViewInfo)localObject2).jdField_a_of_type_Boolean;
      bool3 = ((VideoViewInfo)localObject2).jdField_b_of_type_Boolean;
      if (((VideoViewInfo)localObject2).jdField_b_of_type_Long != 5L) {
        break label641;
      }
    }
    label641:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (bool3)) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, n, bool3, bool2, bool1);
      }
      m += 1;
      break label538;
      break;
    }
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPause");
    }
    l();
    this.jdField_g_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4)
      {
        ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
        int m = 0;
        while (m < localArrayList.size())
        {
          VideoViewInfo localVideoViewInfo = (VideoViewInfo)localArrayList.get(m);
          long l1 = localVideoViewInfo.jdField_a_of_type_Long;
          int n = localVideoViewInfo.jdField_a_of_type_Int;
          if ((localVideoViewInfo.jdField_b_of_type_Long != 5L) || (!String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))) {}
          m += 1;
        }
      }
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f();
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {}
    this.jdField_a_of_type_ComTencentAvVideoController.a(true);
  }
  
  void g()
  {
    this.jdField_g_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.r();
    }
  }
  
  void h()
  {
    this.jdField_g_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onDestroy");
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
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().O = false;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
  }
  
  void i()
  {
    this.h = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().z;
    this.i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.j = this.jdField_a_of_type_ComTencentAvVideoController.a().A;
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().q;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean;
    this.k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener == null) {
      this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = new goz(this, this.jdField_a_of_type_AndroidContentContext, 2);
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener != null) {
      this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener.enable();
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener != null) {
      this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener.disable();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenVideoController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */