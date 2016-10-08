package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gsl;
import gsm;
import gsn;
import gso;
import gsq;
import gsr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class DoubleVideoMeetingCtrlUI
  extends VideoControlUI
{
  static final String jdField_c_of_type_JavaLangString = "DoubleVideoMeetingCtrlUI";
  public long a;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  gso jdField_a_of_type_Gso;
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  public long b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  
  public DoubleVideoMeetingCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Gso = new gso(this);
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gsn(this);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_b_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentAvVideoController.a().l = 0;
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, null);
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = paramVideoAppInterface;
  }
  
  void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "displayToolBar");
    }
    if (!super.e())
    {
      this.m = false;
      super.j(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.k);
  }
  
  void F()
  {
    this.h = this.j;
  }
  
  public void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "request peer video");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoMeetingCtrlUI", 2, "requestPeerVideo-->ERROR mVideoControl is NULL");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoMeetingCtrlUI", 2, "Peer VideoInfoList Size is null");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.f();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    h(false);
    this.jdField_a_of_type_ComTencentAvVideoController.e();
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, paramInt);
    }
    return 0;
  }
  
  void a()
  {
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "processExtraData-->can not get the activity");
      }
      g(true);
    }
    for (;;)
    {
      return;
      localObject = ((AVActivity)localObject).getIntent();
      if (localObject != null) {}
      for (boolean bool = ((Intent)localObject).getBooleanExtra("isEnter", false); bool; bool = false)
      {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        TraeHelper.a();
        TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject = SessionMgr.a().a(SessionMgr.a(10, String.valueOf(this.jdField_a_of_type_Long), new int[0]));
        if ((localObject != null) && (((SessionInfo)localObject).j == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("DoubleVideoMeetingCtrlUI", 2, "Wrong state, finish activity");
          }
          g(true);
        }
        for (;;)
        {
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363460);
          this.j.setText((CharSequence)localObject);
          return;
          this.jdField_a_of_type_ComTencentAvVideoController.a(3, this.jdField_a_of_type_Long, null, false);
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "avSwitch sessionType = " + paramInt);
    }
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299126);
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.h.setVisibility(0);
      if (this.f != null) {
        this.f.setBackgroundDrawable(null);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(0);
      }
      j(0);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(false);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
      }
      if (localAVActivity != null)
      {
        localAVActivity.a(true);
        localAVActivity.c(true);
        localAVActivity.b(false);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().K) {
          super.q(2131299023);
        }
        localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 3) {
          break label409;
        }
        bool = true;
        label218:
        ((SensorHelper)localObject).c(bool);
        localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 3) {
          break label415;
        }
      }
    }
    label409:
    label415:
    for (boolean bool = true;; bool = false)
    {
      ((SensorHelper)localObject).b(bool);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      b(false);
      return;
      if (paramInt != 4) {
        break;
      }
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427379));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.f != null) {
        this.f.setBackgroundResource(2130839249);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.h.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(8);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(true);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(true);
      }
      if (localAVActivity == null) {
        break;
      }
      localAVActivity.a(false);
      localAVActivity.c(false);
      localAVActivity.b(true);
      break;
      bool = false;
      break label218;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "refreshUI-->relationId=" + paramLong1 + " ,friendUin=" + paramLong2 + " ,refreshType=" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().an) {}
    gsq localgsq;
    AVActivity localAVActivity;
    do
    {
      return;
      localgsq = new gsq(this, paramInt, paramLong2, paramLong1);
      localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoubleVideoMeetingCtrlUI", 2, "refreshUI-->Can not get AVActivity");
    return;
    localAVActivity.runOnUiThread(localgsq);
  }
  
  public void a(Intent paramIntent) {}
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoMeetingCtrlUI", 2, "OnClick-->VideoController is null");
      }
    }
    String str;
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
                  str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
                  switch (paramView.getId())
                  {
                  }
                } while (!QLog.isColorLevel());
                QLog.e("DoubleVideoMeetingCtrlUI", 2, "Error View Id.ID=" + paramView.getId());
                return;
                G();
                this.jdField_a_of_type_ComTencentAvVideoController.a().ao = true;
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("DoubleVideoMeetingCtrlUI", 2, "Click Camera Button");
                }
                if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("DoubleVideoMeetingCtrlUI", 2, "Open Camera");
                  }
                  v();
                  this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false) });
                }
                for (;;)
                {
                  super.ag();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("DoubleVideoMeetingCtrlUI", 2, "Close Camera");
                  }
                  w();
                  this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
                  y();
                }
                paramView = new Intent();
                paramView.setAction("tencent.video.v2q.AddContactsFromC2C");
                paramView.putExtra("peerUin", str);
                paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
                super.ag();
                ReportController.b(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
              } while ((!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
              paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            } while ((paramView == null) || (!(paramView instanceof AVActivity)));
            paramView = (AVActivity)paramView;
          } while (paramView == null);
          paramView = paramView.a();
        } while (paramView == null);
        paramView.c();
        return;
        if (this.t - this.v > 2)
        {
          this.v = this.t;
          this.u = 0;
        }
        this.u += 1;
      } while (this.u <= 5);
      super.p(true);
      return;
      if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gsm(this));
        return;
      }
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().K) {
        super.ag();
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, true, 0);
      super.ae();
      g(true);
      ReportController.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
      return;
      z();
      super.ag();
      return;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().H) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a != null)) {
        ReportController.b(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.ag();
        return;
        ReportController.b(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
      }
      b();
      ReportController.b(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "Press Switch Camera Button");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107) });
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "Press Leave Message Button");
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a(i, str, paramView, null, true);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onVideoViewChange-->BigViewUin = " + paramString1 + " ,BigViewVideoSrcType = " + paramInt1 + " ,SmallViewUin = " + paramString2 + " ,SmallViewVideoSrcType = " + paramInt2);
    }
    if ((paramString1 == null) || (paramString2 == null)) {}
    long l2;
    do
    {
      do
      {
        do
        {
          return;
        } while (super.e());
        if (paramInt1 == 2)
        {
          TipsManager.c(106);
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
        }
        long l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        paramInt1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l1, paramInt1);
        paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l2, paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoMeetingCtrlUI", 2, "onVideoViewChange-->BigViewIndex = " + paramInt1 + " ,SmallViewIndex = " + paramInt2);
        }
      } while ((paramInt1 == -1) || (l2 == -1L));
      paramString1 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1);
      paramString2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
      paramString2.jdField_a_of_type_Boolean = true;
      paramString1.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt1, paramString2);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt2, paramString1);
      G();
      if (l2 == this.jdField_b_of_type_Long)
      {
        ReportController.b(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
        return;
      }
    } while (l2 != this.jdField_a_of_type_Long);
    ReportController.b(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoMeetingCtrlUI", 2, "notifyShowVideo-->info list is null");
      }
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if ((((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Long == this.jdField_b_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList });
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break;
        }
        a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
        return;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onAfterOpenCamera success: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentAvVideoController.a().an);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
        }
        if (!paramBoolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoMeetingCtrlUI", 2, "Go On Stage onAfterOpenCamera");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.m();
        if ((this.jdField_b_of_type_AndroidWidgetImageButton != null) && (this.w > 1)) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        }
        super.p(2131299023);
        if ((paramInt == 3) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().H) && ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().r))) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
        }
      } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().g) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("DoubleVideoMeetingCtrlUI", 2, "Open Camera Failed");
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "show or close peer video, friendUin = " + paramLong + " ,video srouce type = " + paramInt + " ,bShow = " + paramBoolean);
    }
    a();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().g) {
      h("showOrClosePeerVideo");
    }
    if (paramBoolean)
    {
      f("showOrClosePeerVideo");
      return;
    }
    VideoViewInfo localVideoViewInfo = new VideoViewInfo();
    localVideoViewInfo.jdField_a_of_type_Long = paramLong;
    localVideoViewInfo.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localVideoViewInfo);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if (paramInt == 2)
    {
      TipsManager.c(106);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      f("showOrClosePeerVideo");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
    a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 24: 
    case 25: 
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
      return false;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
    return false;
  }
  
  void b()
  {
    super.n(2130903541);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      super.b();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = new SensorHelper((Activity)localObject, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        }
      }
    }
    this.d = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299060));
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "initUI-->mContext is null");
      }
      g(true);
      return;
    }
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "initUI-->activity is null");
      }
      g(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299085));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299086));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131296829));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((AVActivity)localObject).findViewById(2131298953));
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.f, null, this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299127), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299128), null);
  }
  
  void b(ArrayList paramArrayList)
  {
    if (paramArrayList.size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoMeetingCtrlUI", 2, "notifyCloseVideo-->info list is null");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList });
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 3);
    a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
  }
  
  void b(boolean paramBoolean)
  {
    int i = 0;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return;
    }
    int j = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(10, 0);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      i = this.jdField_a_of_type_ComTencentAvUiQavPanel.b();
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (paramBoolean)) {
        break label200;
      }
      if (j > 320) {
        break label154;
      }
      localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494014));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      if (this.e == null) {
        break;
      }
      i = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493989);
      break;
      label154:
      if (j <= 480)
      {
        localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494013));
      }
      else
      {
        localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494012));
        continue;
        label200:
        if (j <= 320) {
          localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494017));
        } else if (j <= 480) {
          localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494016));
        } else {
          localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494015));
        }
      }
    }
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(false) });
    if (!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
        super.a(2131363600, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492908));
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
            return false;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localObject == null) || (!(localObject instanceof AVActivity)));
        localObject = (AVActivity)localObject;
      } while (localObject == null);
      localObject = ((AVActivity)localObject).a();
    } while (localObject == null);
    ((SmallScreenActivityPlugin)localObject).a();
    return false;
  }
  
  protected void c() {}
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      s();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, false, 2);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    if ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    do
    {
      return;
      super.d();
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "onCreate SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int + ", localHasVideo = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean);
      }
      b();
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.x);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a();
      n();
      F();
      b(true);
      i(true);
    } while (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
  }
  
  void d(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void d_(boolean paramBoolean)
  {
    super.p(paramBoolean);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "refreshVideo");
    }
    ArrayList localArrayList = new ArrayList();
    VideoViewInfo localVideoViewInfo = new VideoViewInfo();
    localVideoViewInfo.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString).longValue();
    localVideoViewInfo.jdField_a_of_type_Int = 1;
    localArrayList.add(localVideoViewInfo);
    localVideoViewInfo = new VideoViewInfo();
    localVideoViewInfo.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString).longValue();
    localVideoViewInfo.jdField_a_of_type_Int = 2;
    localArrayList.add(localVideoViewInfo);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_b_of_type_Long, 1) == -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "Go On Stage ");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.m();
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().g)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().g)
    {
      G();
      C();
    }
  }
  
  void e(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      UITools.a(this.jdField_c_of_type_AndroidWidgetTextView, paramString);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onStart");
    }
    super.f();
  }
  
  void f(String paramString)
  {
    this.jdField_a_of_type_Gso.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gso);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gso, 1000L);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().g) {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
    }
  }
  
  public void g()
  {
    boolean bool2 = true;
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onResume");
    }
    SensorHelper localSensorHelper;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().an = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().am = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().A)
      {
        super.ad();
        localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 3) {
          break label178;
        }
        bool1 = true;
        localSensorHelper.c(bool1);
        localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 3) {
          break label183;
        }
      }
    }
    label178:
    label183:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localSensorHelper.b(bool1);
      e();
      x();
      this.jdField_a_of_type_ComTencentAvVideoController.E();
      if ((this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_JavaLangString);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "addRequestVideoTimeoutRunnable,Function = " + paramString);
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new gsr(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean) });
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().am = true;
      if (((!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) || ((!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.G();
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentAvVideoController.a().i = true;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().A) {
        super.ae();
      }
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
      h("OnPause");
      this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_b_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.k);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gso);
  }
  
  public void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())
    {
      super.j(paramInt);
      ag();
    }
  }
  
  public void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "removeRequestVideoTimeoutRunnbale-->Function = " + paramString);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "showOrHideAcceptBtn-->isShow = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131363191);
      TipsManager.a(107, str);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107, str, false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    TipsManager.c(107);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107);
  }
  
  public void i(int paramInt) {}
  
  void i(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299127);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramBoolean)
    {
      int j = 0;
      int i = j;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        i = j;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          i = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        }
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
  
  public void j()
  {
    super.j();
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
      if ((!this.jdField_a_of_type_Boolean) && (!SessionMgr.a().a()))
      {
        String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, null, true, true);
        if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString, str, localBitmap, this.jdField_a_of_type_ComTencentAvVideoController.a().s, 48, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
          this.jdField_a_of_type_ComTencentAvVideoController.D();
        }
      }
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "onDestory");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.c();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.k();
  }
  
  public void m() {}
  
  void n()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, null, true, true);
    str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, null);
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299056));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299058));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
  }
  
  public void q() {}
  
  void s()
  {
    super.u_();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation);
  }
  
  void t()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gsl(this));
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
    }
  }
  
  public void w() {}
  
  void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "resumeUI");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().A) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.h())
    {
      super.p(2131299015);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
        break label91;
      }
      super.p(2131299023);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
      return;
      super.q(2131299015);
      break;
      label91:
      super.q(2131299023);
    }
  }
  
  public void y()
  {
    this.jdField_a_of_type_ComTencentAvVideoController.G();
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    super.q(2131299023);
    super.a(2131299023, true);
  }
  
  void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoMeetingCtrlUI", 2, "pressMuteBtn");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.h())
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, true);
      super.q(2131299015);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
      ReportController.b(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, false);
    super.p(2131299015);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
    }
    ReportController.b(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\DoubleVideoMeetingCtrlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */