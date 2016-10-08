package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gvt;
import gvu;
import gvv;
import gvw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class MultiVideoCtrlLayerUI4NewGroupChat
  extends MultiVideoCtrlLayerUIBase
{
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener;
  public Runnable a;
  
  public MultiVideoCtrlLayerUI4NewGroupChat(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new gvt(this);
    this.jdField_a_of_type_JavaLangRunnable = new gvv(this);
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gvw(this);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "MultiVideoCtrlLayerUI4NewGroupChat --> Create");
    }
  }
  
  void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "refreshMuteBtnState");
    }
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        super.p(2131299015);
      }
    }
    else
    {
      return;
    }
    super.q(2131299015);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "processExtraData--> Type = " + this.jdField_a_of_type_ComTencentAvVideoController.a().E + " , IntentRelationType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().e + " , isInRoom = " + this.jdField_a_of_type_ComTencentAvVideoController.e + " , RoomRelationId = " + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null) {
      this.jdField_d_of_type_Boolean = localAVActivity.getIntent().getBooleanExtra("isVideo", false);
    }
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "setMembersInOrOutWording --> Type = " + paramInt1 + " , Id = " + paramInt2 + " , Uin = " + paramString1 + " , value = " + paramString2 + " , time = " + paramInt3 + " , flag = " + paramInt4);
    }
    Object localObject = null;
    if (paramInt1 == this.h) {
      if (paramString1 == null) {
        paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(62, paramString1, paramInt3, paramInt4);
      }
      return;
      paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_Int);
      float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
      paramString1 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString1, this.j, f);
      paramString1 = paramString1 + this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      continue;
      paramString1 = (String)localObject;
      if (paramInt1 == this.i) {
        paramString1 = paramString2;
      }
    }
  }
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "drawUI-->refreshType = " + paramInt1 + " , uin = " + paramLong + " , needRefresh = " + paramBoolean + " , originalType = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().aj)) {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165195, null, 0, null);
      }
      if (paramLong == this.jdField_c_of_type_Long) {
        super.Y();
      }
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label376;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j != 9) {
        break label290;
      }
      if (paramInt1 == 1) {
        a(this.h, 2131363453, String.valueOf(paramLong), null, 3000, 0);
      }
      localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131363614);
      if (this.j != null) {
        this.j.setText((CharSequence)localObject);
      }
      if (this.l) {
        this.n = true;
      }
      UITools.a(this.j, this.jdField_a_of_type_AndroidContentResResources.getString(2131363614));
    }
    for (;;)
    {
      super.O();
      label242:
      if (paramInt2 != 42) {
        break label1210;
      }
      super.a(paramLong, true);
      return;
      if ((paramInt1 != 1) || (paramLong == this.jdField_c_of_type_Long)) {
        break;
      }
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165196, null, 0, null);
      break;
      label290:
      if (paramInt1 == 0)
      {
        this.n = false;
        super.ad();
        if ((paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().aj)) {
          a(this.h, 2131363448, String.valueOf(paramLong), null, 3000, 0);
        }
      }
      else if (paramInt1 == 1)
      {
        a(this.h, 2131363453, String.valueOf(paramLong), null, 3000, 0);
      }
    }
    label376:
    if ((paramInt1 == 5) || (paramInt1 == 6))
    {
      paramBoolean = true;
      if (paramLong != this.jdField_c_of_type_Long) {
        break label1224;
      }
    }
    label636:
    label792:
    label1107:
    label1210:
    label1224:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == 6)
      {
        paramBoolean = super.c();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().k())
        {
          super.C();
          if (Build.VERSION.SDK_INT >= 11) {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
          }
        }
        if ((i != 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().am)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false);
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().aj) && (paramBoolean))
      {
        if (this.s >= 4) {
          break;
        }
        if ((!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
          break label792;
        }
        if (i != 0) {
          break label636;
        }
        super.l(paramInt1);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gwo);
        this.jdField_a_of_type_Gwo.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gwo, 1000L);
      }
      for (;;)
      {
        z();
        break;
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
        if (QLog.isColorLevel()) {
          QLog.d("MultiVideoCtrlLayerUIBase", 2, "onSelfVideoIn.-->FirstVideo=" + j + ",index=" + i);
        }
        if ((j == -1) || ((i == j) && (i != 0)))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gwo);
          this.jdField_a_of_type_Gwo.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gwo, 1000L);
          continue;
          if (i == 0)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
            super.W();
            super.a(true, true, true);
          }
        }
      }
      if ((paramInt1 == 7) || (paramInt1 == 8))
      {
        paramBoolean = true;
        if (paramInt1 == 8)
        {
          localObject = new VideoViewInfo();
          ((VideoViewInfo)localObject).jdField_a_of_type_Long = paramLong;
          ((VideoViewInfo)localObject).jdField_a_of_type_Int = 2;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject);
          this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
        }
        if (paramInt1 == 8)
        {
          boolean bool = super.c();
          paramBoolean = bool;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().k())
          {
            super.C();
            paramBoolean = bool;
            if (Build.VERSION.SDK_INT >= 11)
            {
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
              paramBoolean = bool;
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().aj) && (paramBoolean))
        {
          if (this.s >= 4) {
            break;
          }
          if ((!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
            break label1107;
          }
          super.l(paramInt1);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gwo);
          this.jdField_a_of_type_Gwo.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gwo, 1000L);
        }
        for (;;)
        {
          z();
          break;
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
          super.W();
          super.a(true, true, true);
        }
      }
      if ((paramInt1 != 97) && (paramInt1 != 98)) {
        break label242;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
      super.W();
      super.X();
      break label242;
      if (paramInt2 != 43) {
        break;
      }
      super.a(paramLong, false);
      return;
    }
  }
  
  public void a(View paramView)
  {
    if (this.q) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "BackBtn is Press, ignore other action");
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
              do
              {
                do
                {
                  do
                  {
                    return;
                    switch (paramView.getId())
                    {
                    default: 
                      return;
                    case 2131298953: 
                      DataReport.b(NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), 10);
                      super.d();
                      this.jdField_a_of_type_ComTencentAvVideoController.a().ao = true;
                      return;
                    }
                  } while (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1));
                  if ((VcSystemInfo.h()) && (VcSystemInfo.d()) && (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) != 1)) {
                    break;
                  }
                } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
                this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
                this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(19, true);
                return;
              } while (this.jdField_a_of_type_ComTencentAvVideoController.c() < jdField_a_of_type_Int);
              paramView = this.jdField_a_of_type_AndroidContentResResources.getString(2131363657);
            } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(63, paramView, 3000L, 1);
            return;
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
          this.q = true;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4)
          {
            DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a().g, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean, 10);
            if ((!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
              super.a(2131363600, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492908));
            }
          }
          if ((SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
          {
            paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if ((paramView != null) && ((paramView instanceof AVActivity)))
            {
              paramView = (AVActivity)paramView;
              if (paramView != null)
              {
                paramView = paramView.a();
                if (paramView != null) {
                  paramView.a();
                }
              }
            }
          }
          super.i(false);
          return;
          paramView = new Intent();
          paramView.setAction("tencent.video.v2q.MeetingMemberManager");
          paramView.putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
          paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
          if (this.jdField_c_of_type_Int == 1)
          {
            ReportController.b(null, "CliOper", "", "", "0X8005C26", "0X8005C26", 0, 0, "", "", "", "");
            return;
          }
        } while (this.jdField_c_of_type_Int != 3000);
        ReportController.b(null, "CliOper", "", "", "0X8005C21", "0X8005C21", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gvu(this));
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
        if (((this.e == 90) || (this.e == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 1)) {
          ReportController.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          super.ae();
          super.i(true);
          if (!this.jdField_a_of_type_ComTencentAvVideoController.e) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.E, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
          return;
          if (((this.e == 90) || (this.e == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 2)) {
            ReportController.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
          }
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
        return;
        super.U();
      } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
      super.ag();
      return;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().a;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().H) && (paramView != null)) {
        DataReport.c(true, 10);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
          break;
        }
        super.ag();
        return;
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MultiVideoCtrlLayerUIBase", 2, "DeviceList is null");
          }
        }
        else {
          DataReport.c(false, 10);
        }
      }
      super.R();
    } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
    super.ag();
    return;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(107) });
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
      super.ag();
    }
    paramView = (ImageButton)this.f.findViewById(2131299087);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().h = false;
      UITools.a(paramView, this.jdField_a_of_type_AndroidContentResResources.getString(2131363398));
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().h = true;
    UITools.a(paramView, this.jdField_a_of_type_AndroidContentResResources.getString(2131363397));
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnKeyDown --> WRONG KeyCode = " + paramInt);
      }
      break;
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
              do
              {
                return false;
                this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
                return false;
                this.q = true;
              } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
              DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().g, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean, 10);
              if (SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
                break;
              }
            } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean);
            super.a(2131363600, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492908));
            return false;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          paramKeyEvent = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((paramKeyEvent == null) || (!(paramKeyEvent instanceof AVActivity)));
        paramKeyEvent = (AVActivity)paramKeyEvent;
      } while (paramKeyEvent == null);
      paramKeyEvent = paramKeyEvent.a();
    } while (paramKeyEvent == null);
    paramKeyEvent.a();
    return false;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    a();
    b();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.x);
    e();
  }
  
  void e()
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1))
    {
      super.N();
      x();
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUIBase", 2, "handleExterData-->Wrong gaudioStatusType-->type = " + this.jdField_b_of_type_Int + " , relationId = " + this.jdField_a_of_type_Long + " , relationType = " + this.jdField_d_of_type_Int);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "OnDestroy");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    super.k();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.e)
    {
      z();
      super.j(false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(7, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        break label109;
      }
      super.p(2131299015);
    }
    for (;;)
    {
      super.Y();
      long l = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_Int, String.valueOf(l));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(3, this.jdField_a_of_type_AndroidContentResResources.getString(2131363376));
      return;
      label109:
      super.q(2131299015);
    }
  }
  
  void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "createOrEnterVideo");
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_Long <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "createOrEnterVideo --> RelationId is Error . RelationId = " + this.jdField_b_of_type_Long);
      }
    }
    do
    {
      return;
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131363460);
      if (this.j != null) {
        this.j.setText(str);
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, 0, null, false);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    } while (this.jdField_b_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, null, false);
  }
  
  void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "initViewList");
    }
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1)) {}
    for (long l = this.jdField_a_of_type_Long;; l = this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(l, 1, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(l, 1, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
      super.O();
      return;
    }
  }
  
  void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUIBase", 2, "refreshCameraBtnState");
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.c();
    int j = jdField_a_of_type_Int;
    if ((!VcSystemInfo.h()) || (!VcSystemInfo.d()))
    {
      super.Q();
      return;
    }
    if ((i >= j) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
    {
      super.Q();
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      super.c(true);
      return;
    }
    super.c(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiVideoCtrlLayerUI4NewGroupChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */