package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.ResidentTip;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import gvy;
import gvz;
import gwa;
import gwb;
import gwc;
import gwd;
import gwe;
import gwf;
import gwg;
import gwi;
import gwj;
import gwl;
import gwm;
import gwn;
import gwo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

public abstract class MultiVideoCtrlLayerUIBase
  extends VideoControlUI
{
  public static int a = 0;
  static final String jdField_b_of_type_JavaLangString = "MultiVideoCtrlLayerUIBase";
  public long a;
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public TextView a;
  public MultiMembersAudioUI a;
  public MultiMembersVideoUI a;
  public PstnCallbackWaitingUi a;
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  TraeMediaPlayer jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
  public gwg a;
  gwo jdField_a_of_type_Gwo = new gwo(this);
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  public int b;
  public long b;
  View jdField_b_of_type_AndroidViewView = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  GAudioUIObserver jdField_b_of_type_ComTencentAvAppGAudioUIObserver = new gwe(this);
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  View jdField_c_of_type_AndroidViewView = null;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  public String c;
  public boolean c;
  public int d;
  public TextView d;
  Runnable d;
  public String d;
  public boolean d;
  public int e;
  TextView jdField_e_of_type_AndroidWidgetTextView = null;
  Runnable jdField_e_of_type_JavaLangRunnable = null;
  public int f;
  TextView f;
  public Runnable f;
  public int g;
  public Runnable g;
  int jdField_h_of_type_Int = 0;
  Runnable jdField_h_of_type_JavaLangRunnable = new gvy(this);
  int i = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 4;
  }
  
  public MultiVideoCtrlLayerUIBase(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_f_of_type_JavaLangRunnable = null;
    this.jdField_g_of_type_JavaLangRunnable = null;
    this.jdField_g_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Gwg = new gwg(this);
    K();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "MultiVideoCtrlLayerUIBase --> UinType = " + this.jdField_c_of_type_Int + " , RelationType = " + this.jdField_d_of_type_Int + " , IntentRelationId = " + this.jdField_a_of_type_Long + " , StatusType = " + this.jdField_b_of_type_Int);
    }
  }
  
  public abstract void H();
  
  void K()
  {
    try
    {
      this.jdField_c_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
      if (this.jdField_c_of_type_Int == 3000)
      {
        this.jdField_d_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentAvVideoController.a().F = this.jdField_d_of_type_Int;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Long;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().S) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_E_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.c().size() == 0) && (this.jdField_a_of_type_ComTencentAvVideoController.b().size() == 0))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_E_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.e("MultiVideoCtrlLayerUIBase", 2, "multi meeting change StatusType to create!");
          }
        }
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_E_of_type_Int;
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiVideoCtrlLayerUIBase", 2, "Can not get AccountUin WHY!!!???");
        }
        this.jdField_c_of_type_Long = 0L;
        continue;
        if (this.jdField_c_of_type_Int == 1) {
          this.jdField_d_of_type_Int = 1;
        }
      }
    }
  }
  
  void L()
  {
    int j = 0;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.e))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        super.p(2131299015);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.C();
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1))
      {
        localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131364019);
        if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
          this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        this.n = true;
        UITools.a(this.jdField_j_of_type_AndroidWidgetTextView, (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().j == 9)
    {
      this.n = true;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaUtilArrayList;
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        j = 1;
      }
      if (j != 0)
      {
        j = 2131363614;
        label178:
        localObject = this.jdField_a_of_type_AndroidContentResResources.getString(j);
        if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
          this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
    }
    for (;;)
    {
      ad();
      break;
      j = 2131363512;
      break label178;
      this.n = false;
    }
  }
  
  void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "resumeVideo");
    }
    if (this.jdField_b_of_type_JavaLangRunnable == null) {
      this.jdField_b_of_type_JavaLangRunnable = new gwf(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "closeRemoteVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "closeRemoteVideo Error : VideoController is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.f();
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
        W();
        g("closeRemoteVideo");
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList });
        if (Build.VERSION.SDK_INT >= 19) {
          try
          {
            Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if ((localActivity != null) && (localActivity.getWindow() != null))
            {
              localActivity.getWindow().setFlags(2048, 1024);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "closeRemoteVideo --> SetFullScreenFailed. Exception = " + localException);
  }
  
  public void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "notifyDataChange");
    }
    P();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363614));
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131363614));
      }
    }
    int j;
    int k;
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null)
    {
      j = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      if (j >= 1080)
      {
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494138);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494139);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 4)
      {
        if (!this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a())
        {
          this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setTwoLineState(true);
          k(j);
        }
        label155:
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_a_of_type_JavaUtilArrayList);
        label166:
        if (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI == null) {
          break label325;
        }
        this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
      label325:
      while (!QLog.isColorLevel())
      {
        return;
        if (j >= 720)
        {
          k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494141);
          j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494142);
          break;
        }
        if (j >= 480)
        {
          k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494144);
          j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494145);
          break;
        }
        if (j < 320) {
          break label341;
        }
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494147);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494148);
        break;
        if (!this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a()) {
          break label155;
        }
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setTwoLineState(false);
        k(k);
        break label155;
        if (!QLog.isColorLevel()) {
          break label166;
        }
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "notifyDataChange --> MemberUI is null");
        break label166;
      }
      QLog.e("MultiVideoCtrlLayerUIBase", 2, "notifyDataChange --> MemberUI is null");
      return;
      label341:
      j = 0;
      k = 0;
    }
  }
  
  void P()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "refreshGAList");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentAvVideoController.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "refreshGAList --> VideoController is null");
  }
  
  public void Q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "disableCameraBtn");
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, this.jdField_a_of_type_AndroidContentResResources.getString(2131363363));
    }
  }
  
  public void R()
  {
    int m = 1;
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "On PressCameraBtn");
    }
    int k;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
    {
      DataReport.f(true);
      k = m;
      if (!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        if (VideoController.d(VideoController.jdField_d_of_type_JavaLangString + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) <= 0) {
          break label281;
        }
      }
    }
    label281:
    for (int j = 0;; j = 1)
    {
      k = m;
      Context localContext;
      if (j != 0)
      {
        localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localContext != null) {}
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
              DialogUtil.a(localContext, 230, this.jdField_a_of_type_AndroidContentResResources.getString(2131363525), this.jdField_a_of_type_AndroidContentResResources.getString(2131363520), 2131363532, 2131363537, new gwa(this), new gwb(this)).show();
              k = 0;
            } while (k == 0);
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())))
            {
              S();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
          if (a())
          {
            Q();
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
        return;
        T();
      } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
      return;
    }
  }
  
  public void S()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "goOnStageWithoutWiFiCheck");
    }
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "goOnStageWithoutWiFiCheck --> Can not get Context");
      }
      return;
    }
    DialogUtil.a(localContext, 230, null, this.jdField_a_of_type_AndroidContentResResources.getString(2131363524), 2131363532, 2131363537, new gwc(this), new gwd(this)).show();
  }
  
  public void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "Go Off Stage");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvUiControlUIObserver == null) || (this.jdField_b_of_type_AndroidWidgetImageButton == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "goOffStage --> Error");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.G();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, false);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    W();
  }
  
  void U()
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.h();
    long l;
    if (this.jdField_a_of_type_ComTencentAvVideoController.e)
    {
      l = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "pressMuteBtn --> RelationId = " + l + " ,IsMute = " + bool);
      }
      if (!bool) {
        break label141;
      }
      if (this.jdField_d_of_type_Int != 2) {
        break label132;
      }
      DataReport.a(true, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, true);
      super.q(2131299015);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
      return;
      l = this.jdField_a_of_type_Long;
      break;
      label132:
      DataReport.a(true, 10);
    }
    label141:
    if (this.jdField_d_of_type_Int == 2) {
      DataReport.a(false, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, false);
      super.p(2131299015);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      return;
      DataReport.a(false, 10);
    }
  }
  
  public void V()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "startOrResumeRemoteOrLocalVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "startOrResumeRemoteOrLocalVideo --> VideoController is null");
      }
    }
    label203:
    label251:
    label284:
    label289:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.e) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoCtrlLayerUIBase", 2, "startOrResumeRemoteOrLocalVideo --> Not in MultiVideoRoom");
      return;
      int k = this.jdField_a_of_type_ComTencentAvVideoController.c();
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "startOrResumeRemoteOrLocalVideo --> OnStage Number = " + k);
      }
      int j;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1) != -1)
      {
        j = 1;
        if ((!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
          break label289;
        }
        if (j != 0)
        {
          if (k >= jdField_a_of_type_Int) {
            break label251;
          }
          if (!a()) {
            break label203;
          }
          Q();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
          break label284;
        }
        d();
        return;
        j = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUIBase", 2, "startOrResumeRemoteOrLocalVideo --> Go on Stage Failed");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.F();
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.F();
      }
      C();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
      }
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.F();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label412;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
      W();
      if (NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, 0);
    return;
    a(true, true, true);
    return;
    label412:
    C();
  }
  
  public void W()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "switchUIMode --> SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setVisibility(0);
      if (this.jdField_d_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(true);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(true);
        }
        g(true);
        h(true);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
        b(false);
        return;
        this.jdField_a_of_type_ComTencentAvUiQavPanel.c(true);
      }
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.m = true;
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setVisibility(8);
    if (this.jdField_d_of_type_Int == 2) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(false);
      }
      g(false);
      h(false);
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_E_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (Build.VERSION.SDK_INT < 11)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
      break;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(false);
    }
  }
  
  public void X()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      TipsManager.c(103);
      TipsManager.c(106);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131363191);
      TipsManager.a(107, str);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107, str, false);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    a(true, false, true);
  }
  
  void Y()
  {
    if (this.jdField_c_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel.a(13) != 0) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(13, 0);
        }
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().aa) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ab)) {
          break label103;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.e) {
          break label92;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(13, true);
      }
    }
    label92:
    label103:
    while (this.jdField_c_of_type_Int != 3000)
    {
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(13, false);
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(13, false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ab)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.e)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(13, true);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(13, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(13, false);
  }
  
  public void Z()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0);
    int j = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ".level", 1);
    int k = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ".sendDura", 5000);
    int m = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ".validDura", 6000);
    this.jdField_a_of_type_ComTencentAvVideoController.b(j, k, m);
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "onApnChanged --> NetType = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, paramInt);
    }
    if ((NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.e) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      d();
    }
    return 0;
  }
  
  public String a(String paramString, int paramInt, TextView paramTextView)
  {
    String str;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "genDiscussTitle, name == null");
      }
      str = "";
    }
    TextPaint localTextPaint;
    float f2;
    float f1;
    do
    {
      do
      {
        return str;
        int j = AIOUtils.a(160.0F, this.jdField_a_of_type_AndroidContentResResources);
        localTextPaint = paramTextView.getPaint();
        f2 = j - localTextPaint.measureText(String.format("(%d)", new Object[] { Integer.valueOf(paramInt) })) - 4.0F * this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density;
        str = paramString;
      } while (f2 <= 0.0F);
      f1 = localTextPaint.measureText(paramString);
      str = paramString;
    } while (f1 <= f2);
    float f3 = f2 - localTextPaint.measureText("…");
    paramTextView = paramString;
    for (;;)
    {
      if ((f3 > 0.0F) && (f1 > f3) && (paramTextView.length() > 0))
      {
        paramTextView = paramTextView.substring(0, paramTextView.length() - 1);
        f2 = localTextPaint.measureText(paramTextView);
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = f2;
          if (paramTextView.length() > 0) {
            f1 = 1.0F + f3;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiVideoCtrlLayerUIBase", 2, "genDiscussTitle : name widht = " + f1);
        }
      }
      else
      {
        str = paramString;
        if (f3 <= 0.0F) {
          break;
        }
        str = paramString;
        if (paramTextView.length() <= 0) {
          break;
        }
        return paramTextView + "…";
      }
    }
  }
  
  abstract void a();
  
  abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4);
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "sendVideoMsgBroadcast--> discussionId = " + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      if (localIntent != null)
      {
        localIntent.setAction("tencent.video.v2q.AddVideoMsg");
        localIntent.putExtra("uinType", this.jdField_c_of_type_Int);
        localIntent.putExtra("msgType", 13);
        localIntent.putExtra("isVideoMsg", false);
        localIntent.putExtra("friendUin", Long.toString(paramLong));
        localIntent.putExtra("senderUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        localIntent.putExtra("isSender", true);
        localIntent.putExtra("isRead", true);
        localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvVideoController.a().D);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      }
    }
  }
  
  public abstract void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramBoolean);
    }
    do
    {
      while (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(paramLong, paramBoolean);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUIBase", 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + paramLong + " , Speak = " + paramBoolean);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + paramLong + " , Speak = " + paramBoolean);
  }
  
  void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI == null) || (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidViewView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "adapterScreen-->Container is null");
      }
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494140);
    int k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494134);
    int j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494162);
    int n = UITools.a(paramContext);
    UITools.b(paramContext);
    if (n >= 1080) {}
    for (;;)
    {
      localLayoutParams1.topMargin = m;
      localLayoutParams2.topMargin = k;
      localLayoutParams3.height = j;
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setLayoutParams(localLayoutParams2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams3);
      b(true);
      return;
      if (n >= 720)
      {
        m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494143);
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494135);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494162);
      }
      else if (n >= 480)
      {
        m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494146);
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494136);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494163);
      }
      else if (n >= 320)
      {
        m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494149);
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494137);
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494164);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    boolean bool = false;
    super.a(paramIntent);
    K();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnNewIntent");
    }
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("needStartTRAE", false);
      C();
    }
    a();
    if (bool) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    }
    e();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super.a(paramString1, paramInt1, paramString2, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "onVideoViewChange --> BigViewUin = " + paramString1 + " , BigViewVideoViewType = " + paramInt1 + " , SmallViewUin = " + paramString2 + " , SmallViewVideoViewType = " + paramInt2);
    }
    if ((paramString1 == null) || (paramString2 == null)) {}
    while (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0) {
      return;
    }
    for (;;)
    {
      try
      {
        Long.valueOf(paramString1).longValue();
        long l = Long.valueOf(paramString2).longValue();
        if (paramInt1 == 2)
        {
          TipsManager.c(106);
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
        }
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().a(Long.valueOf(paramString1).longValue(), paramInt1);
        if (j == -1) {
          break;
        }
        paramString1 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(j);
        paramInt1 = 0;
        if (paramInt1 < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
        {
          paramString2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1);
          if ((l == paramString2.jdField_a_of_type_Long) && (paramInt2 == paramString2.jdField_a_of_type_Int))
          {
            paramString1.jdField_a_of_type_Boolean = false;
            if ((paramString1.jdField_a_of_type_Long != this.jdField_c_of_type_Long) && (paramString2.jdField_a_of_type_Long != this.jdField_c_of_type_Long) && (4 != this.jdField_a_of_type_ComTencentAvVideoController.i())) {
              paramString1.jdField_c_of_type_Boolean = false;
            }
            paramString2.jdField_a_of_type_Boolean = true;
            if ((4 != this.jdField_a_of_type_ComTencentAvVideoController.i()) && (!paramString2.jdField_c_of_type_Boolean))
            {
              paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long);
              if (paramInt2 != -1) {
                ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt2)).jdField_c_of_type_Boolean = false;
              }
            }
            paramString2.jdField_c_of_type_Boolean = true;
            if ((paramString2.jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (this.jdField_d_of_type_Int == 2)) {
              ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
            }
            if ((!paramString2.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.i() != 4)) {
              DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().D);
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(j, paramString2);
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt1, paramString1);
          }
        }
        else
        {
          d();
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "onVideoViewChange --> Parse String 2 Long Failed");
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    int j = 0;
    for (;;)
    {
      if (j < paramArrayList.size())
      {
        if ((((VideoViewInfo)paramArrayList.get(j)).jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
          paramArrayList.remove(j);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList });
        return;
      }
      j += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "showOrHideRecvVideoBtnAndTips --> bShow = " + paramBoolean1 + " , needNoticeWiFiTips = " + paramBoolean2 + " , needShowGLView = " + paramBoolean3);
    }
    if (paramBoolean1)
    {
      DataReport.d(NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), this.jdField_a_of_type_ComTencentAvVideoController.a().D);
      C();
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        if (!paramBoolean2) {
          break label156;
        }
        String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131363721);
        TipsManager.a(102, str);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102, str, false);
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
      }
      return;
      label156:
      TipsManager.c(102);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102);
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      TipsManager.c(102);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102);
      }
      TipsManager.c(107);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107);
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "Go on Stage");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.m();
    }
    if (QLog.isColorLevel()) {
      QLog.e("MultiVideoCtrlLayerUIBase", 2, "Go On Stage, VideoController is null");
    }
    return false;
  }
  
  public void aa()
  {
    int j = 0;
    Object localObject;
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_f_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidContentResResources != null))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131364017));
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131364017));
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        localObject = new Rect();
        Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localActivity != null)
        {
          localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
          j = ((Rect)localObject).top;
        }
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        if (j == 0) {
          break label148;
        }
      }
    }
    label148:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = j;; ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494165))
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "initUI");
    }
    super.n(2130903544);
    super.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      if (this.jdField_d_of_type_Int != 2) {
        break label389;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(5);
    }
    Object localObject;
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = new SensorHelper((Activity)localObject, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(8);
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299142);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299143));
      this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299144);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299145));
      this.jdField_h_of_type_AndroidWidgetTextView = this.jdField_j_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299085));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299086));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131296829));
      this.jdField_j_of_type_AndroidWidgetTextView.post(this.jdField_h_of_type_JavaLangRunnable);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299058));
      if (!this.jdField_a_of_type_ComTencentAvVideoController.e)
      {
        Q();
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(13, false);
        }
      }
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "initUI-->can not get AVActivity");
      }
      return;
      label389:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(6);
    }
    this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi = new PstnCallbackWaitingUi((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((AVActivity)localObject).findViewById(2131298953));
    TintStateDrawable.a(this.jdField_a_of_type_AndroidWidgetButton, 2130839081, 2131428149);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject).findViewById(2131297996));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299140));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = ((MultiMembersVideoUI)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299141));
    a(((AVActivity)localObject).getApplicationContext());
    y();
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(3, this.jdField_a_of_type_AndroidContentResResources.getString(2131363376));
    }
    GAudioSoundUtil.a(((AVActivity)localObject).getApplicationContext());
    if (this.jdField_a_of_type_ComTencentAvVideoController.e)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b())) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.i();
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().O) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Long, false);
      super.p(2131299015);
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(new gvz(this));
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_b_of_type_AndroidWidgetTextView = this.jdField_k_of_type_AndroidWidgetTextView;
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() != 1))
    {
      localObject = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299464);
      if (localObject != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493874);
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
    if (this.jdField_g_of_type_JavaLangRunnable == null) {
      this.jdField_g_of_type_JavaLangRunnable = new gwi(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_g_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 3, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_f_of_type_AndroidWidgetRelativeLayout, null, null, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299128), null);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
  }
  
  public void b(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "refreshUI-->uin = " + paramLong + " , refreshType = " + paramInt1 + " , isRefreshTitle = " + paramBoolean + " , originalType = " + paramInt2);
    }
    if (paramLong == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, " refreshUI-->uin == 0");
      }
    }
    do
    {
      return;
      gwm localgwm = new gwm(this, paramLong, paramInt1, paramBoolean, paramInt2);
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        localAVActivity.runOnUiThread(localgwm);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "refreshUI-->Can not get AVActivity");
  }
  
  void b(boolean paramBoolean)
  {
    int j = 0;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    int k = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(10, 0);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      j = this.jdField_a_of_type_ComTencentAvUiQavPanel.b();
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (paramBoolean)) {
        break label193;
      }
      if (k > 320) {
        break label147;
      }
      localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494014));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout == null) {
        break;
      }
      j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493989);
      break;
      label147:
      if (k <= 480)
      {
        localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494013));
      }
      else
      {
        localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494012));
        continue;
        label193:
        if (k <= 320) {
          localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494017));
        } else if (k <= 480) {
          localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494016));
        } else {
          localLayoutParams.bottomMargin = (j + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494015));
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.y = paramInt;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {}
    while ((Build.VERSION.SDK_INT < 11) || (this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_e_of_type_Int = 0;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
      return;
    case 90: 
      this.jdField_e_of_type_Int = 270;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(270.0F);
      return;
    case 180: 
      this.jdField_e_of_type_Int = 180;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(180.0F);
      return;
    }
    this.jdField_e_of_type_Int = 90;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(90.0F);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "enableCameraBtn --> IconPress = " + paramBoolean);
    }
    int j = Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    if ((!VcSystemInfo.h()) || (!VcSystemInfo.d()) || (j == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "enableCameraBtn --> Disable Camera Button. IsNormalSharp = " + VcSystemInfo.h() + " , isSupportSharpVideo = " + VcSystemInfo.d() + " , GLVersion = " + j);
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      }
    }
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, this.jdField_a_of_type_AndroidContentResResources.getString(2131363360));
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(1, this.jdField_a_of_type_AndroidContentResResources.getString(2131363359));
  }
  
  boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "checkRemoteVideo --> checkRemoteVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "checkRemoteVideo --> VideoController is null");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      N();
      a(false, false, false);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_c_of_type_Long))
    {
      a(false, false, false);
      g("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnCreate");
    }
    if ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "Can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  void d(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "startRecvAllVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "startRecvAllVideo --> VideoController is null");
      }
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject == null) {}
      }
    }
    for (boolean bool = ((AVActivity)localObject).isResume();; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "startRecvAllVideo --> isResume = " + bool);
      }
      if (!bool) {
        return false;
      }
      int k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size();
      int j = k;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
        j = k - 1;
      }
      if (j <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUIBase", 2, "startRecvAllVideo --> There is no video need request");
        }
        return false;
      }
      bool = VcSystemInfo.d();
      j = Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      if ((!bool) || (j == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUIBase", 2, "startRecvAllVideo --> This version is not supportsharpvideo or opengl. IsSupportSharpVideo = " + bool + " , GlVersion = " + j);
        }
        return false;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
      j = this.jdField_a_of_type_ComTencentAvVideoController.i();
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "startRecvAllVideo --> Ability = " + j);
      }
      if (j != 4)
      {
        if (this.jdField_d_of_type_Int == 2) {
          ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 1)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(61, true);
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().d.clear();
      j = 0;
      while (j < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
      {
        localObject = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(j);
        if (((VideoViewInfo)localObject).jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().d.add(localObject);
        }
        j += 1;
      }
      a(false, false, false);
      TipsManager.c(106);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      TipsManager.c(103);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
      return this.jdField_a_of_type_ComTencentAvVideoController.e();
    }
  }
  
  public void d_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "showSharpInfo --> bShow = " + paramBoolean);
    }
    p(paramBoolean);
  }
  
  abstract void e();
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "onDetectNoDevicePermission --> IssueType = " + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      T();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
    }
    super.e(paramInt);
  }
  
  void e(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, paramString);
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnStart");
    }
    if (TipsManager.a.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.a.jdField_a_of_type_Int, TipsManager.a.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      a(this.jdField_b_of_type_Long);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "RequestVideoTimeoutRunnable-->Add-->FunctionName=" + paramString);
    }
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 30000L);
      return;
      this.jdField_c_of_type_JavaLangRunnable = new gwn(this);
    }
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnResume");
    }
    L();
    n();
    if (TipsManager.a.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.a.jdField_a_of_type_Int, TipsManager.a.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().am = false;
    }
    if ((this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().b);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.E();
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.e)) {
      M();
    }
    if (this.jdField_e_of_type_JavaLangRunnable == null)
    {
      this.jdField_e_of_type_JavaLangRunnable = new gwj(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 2000L);
    }
    if (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.a();
    }
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "showStatusTips --> Type = " + paramInt);
    }
    gwl localgwl = new gwl(this, paramInt, false);
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(localgwl);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "showStatusTips-->can not get AVActivity");
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "RequestVideoTimeoutRunnable-->Remove-->FunctionName=" + paramString);
    }
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
  }
  
  void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_f_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839249);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(8);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_f_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null);
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(8);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null);
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(0);
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnPause");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnPause Error : VideoController is null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.b();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().am = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
      if (((!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) || ((!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
        T();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) {
        this.jdField_a_of_type_ComTencentAvVideoController.f();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gwo);
  }
  
  public void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())
    {
      j(paramInt);
      ag();
    }
  }
  
  void h(boolean paramBoolean)
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "switchMode --> Can not get activity");
      }
    }
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299139);
        localObject = (AVActivity)localObject;
        if (!paramBoolean) {
          break;
        }
        localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427379));
      } while (localObject == null);
      ((AVActivity)localObject).a(false);
      ((AVActivity)localObject).c(false);
      ((AVActivity)localObject).b(true);
      return;
      localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427805));
    } while (localObject == null);
    ((AVActivity)localObject).a(true);
    ((AVActivity)localObject).c(true);
    ((AVActivity)localObject).b(false);
  }
  
  public void i(int paramInt) {}
  
  public void i(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean) });
  }
  
  public void j()
  {
    super.j();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnStop");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.e) && (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null))
    {
      String str1 = this.jdField_a_of_type_ComTencentAvVideoController.a().s;
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_Int, str1, null);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_Int, str1, null, true, true);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().b, str2, localBitmap, str1, 44, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.D();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  void j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(7, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, false);
      }
      return;
    }
    paramBoolean = this.jdField_a_of_type_ComTencentAvVideoController.h();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7, paramBoolean);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, true);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(7, true);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnDestroy");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gwg);
    if (this.jdField_f_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_j_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Gwg = null;
    this.jdField_f_of_type_JavaLangRunnable = null;
    this.jdField_g_of_type_JavaLangRunnable = null;
    TipsManager.c(102);
    TipsManager.c(103);
    TipsManager.c(107);
    TipsManager.c(106);
    TipsManager.c(104);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.jdField_d_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.c();
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a();
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.c();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.k();
  }
  
  void k(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setLayoutParams(localLayoutParams);
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = new TraeMediaPlayer((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (!paramBoolean) {
        break label91;
      }
      if (GAudioSoundUtil.a("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a(2, 0, null, GAudioSoundUtil.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label91:
    while (!GAudioSoundUtil.a("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a();
      break;
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a(2, 0, null, GAudioSoundUtil.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
  }
  
  void l(int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 8) || (paramInt == 74)) {}
    do
    {
      do
      {
        return;
      } while ((VcSystemInfo.d()) && (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) != 1));
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
      }
      ReportController.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "startRecvAllVideo-->GLVersion not support");
  }
  
  abstract void n();
  
  public void u()
  {
    super.u();
  }
  
  public void v() {}
  
  public void w() {}
  
  abstract void x();
  
  abstract void y();
  
  public abstract void z();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiVideoCtrlLayerUIBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */