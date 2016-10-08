import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.funchat.magicface.MagicfaceViewControllerForAV;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BeautySettingUi;
import com.tencent.av.ui.ChildGuideUi;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class gpv
  extends VideoObserver
{
  public gpv(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.d();
    }
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
      if (paramInt == 0) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.t(true);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.t(false);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, String.format("onCrmIVRBeforeRequest, errorCode = %d, ivrRequestSeq = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.a(paramInt1, paramInt2);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, String.format("onCrmIVRRequestAck, ivrRequestSeq = %d, errorCode = %d, errorMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    super.a(paramInt1, paramInt2, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2, paramString);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, String.format("onRecvCrmIVRPush, errorCode=%d seq=%d url=%s data=%s, roomId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, Long.valueOf(paramLong) }));
    }
    super.a(paramInt1, paramInt2, paramString1, paramString2, paramLong);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2, paramString1, paramString2, paramLong);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("AVActivity", 2, "mControlUI is null, so we don't do onRecvCrmIVRPush");
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if ((paramString != null) && (!UITools.a(paramString, this.a.c))) {
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "UnConcerned onClose, peerUin:" + paramString + ", mPeerUin:" + this.a.c);
      }
    }
    do
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.b())) {
        AVActivity.a(this.a, false, -1);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) {
        this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.f();
      }
    } while ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramInt);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 1L) {
      if (paramLong2 == 0L) {
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(70, this.a.getString(2131363350), 3000L, 0);
      }
    }
    while (paramLong1 != 2L)
    {
      return;
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(70, this.a.getString(2131363351), 3000L, 0);
      return;
    }
    if (paramLong2 == 0L)
    {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(70, this.a.getString(2131363352), 3000L, 0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(70, this.a.getString(2131363353), 3000L, 0);
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    int j;
    int i;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        break label178;
      }
      j = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
      i = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
    }
    for (;;)
    {
      VideoLayerUI localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m) {}
      for (boolean bool = true;; bool = false)
      {
        localVideoLayerUI.a(j, i, bool);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramRecvMsg);
        i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
        if ((i != 1) && (i != 2)) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h(false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(2);
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(1);
      return;
      label178:
      i = 0;
      j = 0;
    }
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if ((this.a.jdField_a_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j(paramString);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    int i = 3;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "s2c level : " + paramInt);
    }
    if (paramInt < 0) {}
    int k;
    int j;
    do
    {
      return;
      k = paramInt >> 4 & 0x7;
      j = paramInt >> 7 & 0x7;
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "s2c self level : " + k + ",peer level:" + j);
      }
    } while (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    switch (k)
    {
    default: 
      paramInt = -1;
      switch (j)
      {
      default: 
        i = -1;
      }
      break;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramInt, i);
      return;
      paramInt = 3;
      break;
      paramInt = 2;
      break;
      paramInt = 1;
      break;
      i = 2;
      continue;
      i = 1;
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.a.j == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramString2);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onDestroyUI isQuit = " + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.b()) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {}
    label388:
    label596:
    for (;;)
    {
      return;
      super.a(paramString, paramBoolean);
      if ((this.a.jdField_h_of_type_Int == 1) || (this.a.jdField_h_of_type_Int == 2)) {
        if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
        {
          this.a.e = paramBoolean;
          if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().p))
          {
            SessionMgr.a();
            paramString = SessionMgr.a(3, "beautySetting", new int[0]);
            SessionMgr.a().c(paramString);
            this.a.jdField_a_of_type_ComTencentAvVideoController.i = false;
          }
          this.a.finish();
          if (paramBoolean) {
            break label388;
          }
          if ((this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (!this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.c())) {
            this.a.overridePendingTransition(2130968674, 2130968675);
          }
        }
        else if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          paramString = this.a.getApplicationContext().getSharedPreferences("qav_SP", 0).edit();
          paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c());
          paramString.commit();
          DataReport.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c());
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
          break label596;
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.h(0);
        return;
        int j = 2130968685;
        int i = j;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          i = j;
          if (paramString != null) {
            i = SmallScreenUtils.a(paramString.J);
          }
        }
        this.a.overridePendingTransition(0, i);
        break;
        this.a.overridePendingTransition(0, 2130968713);
        break;
        if ((this.a.jdField_h_of_type_Int == 3) || (this.a.jdField_h_of_type_Int == 4))
        {
          String str = null;
          if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
            str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().s;
          }
          if ((str != null) && (paramString != null) && (str.equals(paramString)))
          {
            this.a.e = paramBoolean;
            this.a.finish();
            if (!paramBoolean)
            {
              if ((this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (!this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.c()))
              {
                this.a.overridePendingTransition(2130968674, 2130968675);
              }
              else
              {
                j = 2130968685;
                i = j;
                if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
                {
                  paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
                  i = j;
                  if (paramString != null) {
                    i = SmallScreenUtils.a(paramString.J);
                  }
                }
                this.a.overridePendingTransition(0, i);
              }
            }
            else {
              this.a.overridePendingTransition(0, 2130968713);
            }
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.u();
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l();
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.j, this.a.c, this.a.jdField_h_of_type_JavaLangString);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.a.k = this.a.jdField_a_of_type_ComTencentAvVideoController.a().A;
        this.a.jdField_m_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().q;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "setBindInfo: mBindType = " + this.a.k + ",mBindId = " + this.a.jdField_m_of_type_JavaLangString);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.a.k, this.a.jdField_m_of_type_JavaLangString);
    }
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    int i = VipFunCallManager.a();
    String str = VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (str == null) {}
    do
    {
      return;
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j != 4) && (this.a.jdField_h_of_type_Int == 1) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) && (this.a.jdField_m_of_type_Int != 2))
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d();
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), (RelativeLayout)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
        }
        if (!VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener, paramInt, false)) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVActivity", 2, "yiler onPlayAnnimate finish id:" + paramInt);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2);
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt, paramString);
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(paramString);
    }
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "peerUin = " + paramString + " # isQuit :" + paramBoolean);
    }
    Object localObject;
    if ((this.a.jdField_h_of_type_Int == 1) || (this.a.jdField_h_of_type_Int == 2))
    {
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) {
        break label201;
      }
      SessionMgr.a();
      localObject = SessionMgr.a(3, "beautySetting", new int[0]);
      SessionMgr.a().c((String)localObject);
      this.a.finish();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().p = false;
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        localObject = this.a.getApplicationContext().getSharedPreferences("qav_SP", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c());
        ((SharedPreferences.Editor)localObject).commit();
        DataReport.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c());
      }
      super.b(paramString, paramBoolean);
      return;
      label201:
      if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
      {
        this.a.e = paramBoolean;
        this.a.finish();
        if (!paramBoolean)
        {
          if ((this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (!this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.c()))
          {
            this.a.overridePendingTransition(2130968674, 2130968675);
          }
          else
          {
            int j = 2130968685;
            int i = j;
            if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
            {
              localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
              i = j;
              if (localObject != null) {
                i = SmallScreenUtils.a(((SessionInfo)localObject).J);
              }
            }
            this.a.overridePendingTransition(0, i);
          }
        }
        else {
          this.a.overridePendingTransition(0, 2130968713);
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramBoolean);
    }
  }
  
  protected void c()
  {
    super.c();
  }
  
  protected void c(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramInt);
    }
    while (this.a.jdField_a_of_type_ComTencentAvUiBeautySettingUi == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiBeautySettingUi.b(paramInt);
  }
  
  protected void c(String paramString)
  {
    super.c(paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramString);
    }
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramString, paramBoolean);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.e();
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().N) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(1, "SUPPORT_TRUE");
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(1, "SUPPORT_FALSE");
  }
  
  protected void d()
  {
    boolean bool2 = false;
    super.d();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
    }
    Object localObject;
    boolean bool1;
    label118:
    label219:
    int j;
    int i;
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4))
    {
      this.a.a(false);
      this.a.c(false);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        if (this.a.jdField_f_of_type_Boolean) {
          break label540;
        }
        bool1 = true;
        ((SessionInfo)localObject).jdField_f_of_type_Boolean = bool1;
        if (this.a.jdField_f_of_type_Boolean) {
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
          boolean bool3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().g;
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
            break label546;
          }
          bool1 = true;
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, bool3, false, bool1);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
          break label570;
        }
        j = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
        i = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
      }
    }
    for (;;)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      bool1 = bool2;
      if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m) {
        bool1 = true;
      }
      ((VideoLayerUI)localObject).a(j, i, bool1);
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.k();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m();
        if ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int) || (this.a.g)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.al();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.e();
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().N) {
          break label552;
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(1, "SUPPORT_TRUE");
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
        return;
        this.a.a(true);
        this.a.c(true);
        break;
        label540:
        bool1 = false;
        break label118;
        label546:
        bool1 = false;
        break label219;
        label552:
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(1, "SUPPORT_FALSE");
      }
      label570:
      i = 0;
      j = 0;
    }
  }
  
  protected void d(String paramString)
  {
    if ((this.a.j == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString);
    }
    super.d(paramString);
  }
  
  protected void d(String paramString, boolean paramBoolean)
  {
    super.d(paramString, paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBoolean);
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onPauseVideo");
    }
    super.e();
    if (!VcSystemInfo.d()) {
      return;
    }
    String str;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if ((!this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c()) && (this.a.q > 0)) {
        MagicfaceViewControllerForAV.a().b(0);
      }
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, false, false, bool);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.o();
      return;
    }
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onResumeVideo");
    }
    super.f();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.p();
    }
    if (!VcSystemInfo.d()) {
      break label45;
    }
    label45:
    while (this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) {
      return;
    }
    String str;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
        break label215;
      }
    }
    label215:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, true, false, bool);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, this.a.jdField_a_of_type_AndroidGraphicsBitmap, true, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m();
      if ((2 != this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int) && (!this.a.g)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
      return;
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.r(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.ab();
    }
  }
  
  protected void h()
  {
    super.h();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.r(false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.ac();
    }
  }
  
  protected void i()
  {
    super.i();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.q();
    }
  }
  
  protected void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onNeedShowPeerVideo");
    }
    super.k();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.r();
    }
    if (!VcSystemInfo.d()) {
      break label45;
    }
    label45:
    while (this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) {
      return;
    }
    VideoLayerUI localVideoLayerUI;
    String str;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
        break label184;
      }
    }
    label184:
    for (boolean bool = true;; bool = false)
    {
      localVideoLayerUI.a(str, 1, true, false, bool);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m();
      if ((2 != this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int) && (!this.a.g)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
      return;
    }
  }
  
  protected void l()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.A();
    }
  }
  
  protected void m()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.B();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */