package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gvh;
import gvi;
import gvj;
import gvk;
import gvl;
import gvp;
import gvq;
import gvr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class MultiVideoCtrlLayerUI4Discussion
  extends MultiVideoCtrlLayerUIBase
{
  static final String jdField_a_of_type_JavaLangString = "MultiVideoCtrlLayerUI4Discussion";
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener;
  public long[] a;
  
  public MultiVideoCtrlLayerUI4Discussion(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new gvh(this);
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gvl(this);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "MultiVideoCtrlLayerUI4Discussion --> Create");
    }
  }
  
  public void F()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gvk(this));
    }
    do
    {
      return;
      super.ae();
      i(true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.e) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_E_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 0, new int[0]);
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
        if (((this.jdField_e_of_type_Int != 90) && (this.jdField_e_of_type_Int != 270)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) || (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int != 1)) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, 0, new int[0]);
      }
    } while (((this.jdField_e_of_type_Int != 90) && (this.jdField_e_of_type_Int != 270)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) || (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int != 2));
    ReportController.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
  }
  
  void H()
  {
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.a(7)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        p(2131299015);
      }
    }
    else
    {
      return;
    }
    q(2131299015);
  }
  
  public void I()
  {
    Object localObject = DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230, "购买时长包", "你的多人电话时长包已用完，无法拨打包含手机/固话的多人电话", "取消", "购买", new gvp(this), new gvq(this));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().n())
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().o()) {
        break label251;
      }
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddContactsToDiscuss");
      ((Intent)localObject).putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
      ((Intent)localObject).putExtra("uiFlag", 1);
      ((Intent)localObject).putExtra("notAcceptUserList", this.jdField_a_of_type_ComTencentAvVideoController.d());
      ((Intent)localObject).putExtra("notAcceptPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaUtilArrayList);
      ((Intent)localObject).putExtra("pstnInRoomPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.f());
      ((Intent)localObject).putExtra("selectNotAcceptFlag", true);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvVideoController.I = 2;
      if ((SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject != null) && ((localObject instanceof AVActivity)))
        {
          localObject = (AVActivity)localObject;
          if (localObject != null) {
            ((AVActivity)localObject).d(false);
          }
        }
      }
    }
    return;
    label251:
    ((QQCustomDialog)localObject).show();
  }
  
  public void J()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "processExtraData--> Type = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_E_of_type_Int + " , IntentRelationType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Long + " , isInRoom = " + this.jdField_a_of_type_ComTencentAvVideoController.e + " , RoomRelationId = " + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ArrayOfLong = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_ArrayOfLong;
    Object localObject1 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null)
    {
      localObject1 = ((AVActivity)localObject1).getIntent();
      this.jdField_d_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isVideo", false);
      Object localObject3 = (ArrayList)((Intent)localObject1).getExtras().getSerializable("phoneNumbers");
      if (localObject3 != null)
      {
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((ArrayList)localObject2).add(PstnUtils.a((String)((Iterator)localObject3).next()));
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a((ArrayList)localObject2);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
      }
      Object localObject2 = ((Intent)localObject1).getStringExtra("PstnLevel");
      if ((localObject2 != null) && ("LEVEL2".equals(localObject2))) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().ac = true;
      }
      localObject2 = ((Intent)localObject1).getStringExtra("PLACE");
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().u = ((String)localObject2);
      }
      localObject1 = ((Intent)localObject1).getStringExtra("CREATE_PLACE");
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().v = ((String)localObject1);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidContentResResources != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().y != 4))
    {
      f(paramInt);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      ReportController.b(null, "CliOper", "", "", "0X8006401", "0X8006401", 0, 0, "", "", "", "");
    }
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "setMembersInOrOutWording --> Type = " + paramInt1 + " , Id = " + paramInt2 + " , Uin = " + paramString1 + " , value = " + paramString2 + " , time = " + paramInt3 + " , flag = " + paramInt4);
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
      if (this.jdField_c_of_type_Boolean) {
        paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_Int);
      }
      for (;;)
      {
        float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
        paramString1 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString1, this.j, f);
        paramString1 = paramString1 + this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
        break;
        long l = Long.valueOf(paramString1).longValue();
        paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaUtilArrayList);
        if (paramString1 == null)
        {
          paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363414);
        }
        else
        {
          paramString2 = paramString1.telInfo.mobile;
          if (paramString2 == null)
          {
            paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363414);
          }
          else
          {
            paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString2);
            if (paramString1 == null) {
              paramString1 = PstnUtils.a(paramString2, 4);
            }
          }
        }
      }
      paramString1 = (String)localObject;
      if (paramInt1 == this.i) {
        paramString1 = paramString2;
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "drawUI-->refreshType = " + paramInt1 + " , uin = " + paramLong + " , needRefresh = " + paramBoolean + " , originalType = " + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject1;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().aj)) {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165195, null, 0, null);
      }
      if ((paramLong != this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long) && (paramLong != this.jdField_c_of_type_Long))
      {
        TipsManager.c(105);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(105);
        }
      }
      if (paramLong == this.jdField_c_of_type_Long) {
        Y();
      }
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label520;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j != 9) {
        break label420;
      }
      if (paramInt1 == 1) {
        a(this.h, 2131363452, String.valueOf(paramLong), null, 3000, 0);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaUtilArrayList;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          break label408;
        }
        paramInt1 = 1;
        label271:
        if (paramInt1 == 0) {
          break label413;
        }
        paramInt1 = 2131363614;
        label279:
        localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(paramInt1);
        if (this.j != null) {
          this.j.setText((CharSequence)localObject1);
        }
        if (this.l) {
          this.n = true;
        }
        UITools.a(this.j, this.jdField_a_of_type_AndroidContentResResources.getString(2131363614));
      }
      label334:
      O();
    }
    label338:
    label408:
    label413:
    label420:
    label520:
    Object localObject2;
    for (;;)
    {
      if (paramInt2 == 42)
      {
        a(paramLong, true);
        return;
        if (paramInt1 != 1) {
          break;
        }
        if (paramLong != this.jdField_c_of_type_Long) {
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165196, null, 0, null);
        }
        TipsManager.c(105);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(105);
        break;
        paramInt1 = 0;
        break label271;
        paramInt1 = 2131363512;
        break label279;
        if (paramInt1 == 0)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1)
          {
            this.n = false;
            ad();
          }
          if ((paramLong == this.jdField_c_of_type_Long) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().aj)) {
            break label334;
          }
          a(this.h, 2131363447, String.valueOf(paramLong), null, 3000, 0);
          break label334;
        }
        if (paramInt1 != 1) {
          break label334;
        }
        a(this.h, 2131363452, String.valueOf(paramLong), null, 3000, 0);
        break label334;
        if (paramInt1 == 68)
        {
          float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_Int);
          localObject2 = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject1, this.j, f);
          if (this.jdField_f_of_type_Int == 1) {}
          for (localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363500);; localObject1 = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131363499), new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }))
          {
            localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363498) + (String)localObject2 + (String)localObject1;
            a(this.i, 0, null, (String)localObject1, 3000, 0);
            break;
          }
        }
        if (paramInt1 == 82)
        {
          a(this.i, 0, null, this.jdField_c_of_type_JavaLangString, 3000, 0);
        }
        else if ((paramInt1 == 5) || (paramInt1 == 6))
        {
          paramBoolean = true;
          if (paramLong != this.jdField_c_of_type_Long) {
            break label1726;
          }
        }
      }
    }
    label979:
    label1135:
    label1304:
    label1479:
    label1726:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == 6)
      {
        paramBoolean = c();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().k())
        {
          C();
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
          break label1135;
        }
        if (i != 0) {
          break label979;
        }
        l(paramInt1);
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
          QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onSelfVideoIn.-->FirstVideo=" + j + ",index=" + i);
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
            W();
            a(true, true, true);
          }
        }
      }
      if ((paramInt1 == 7) || (paramInt1 == 8))
      {
        if (paramInt1 == 8)
        {
          localObject1 = new VideoViewInfo();
          ((VideoViewInfo)localObject1).jdField_a_of_type_Long = paramLong;
          ((VideoViewInfo)localObject1).jdField_a_of_type_Int = 2;
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(localObject1);
          this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localObject2 });
        }
        if (paramInt1 == 8)
        {
          boolean bool = c();
          paramBoolean = bool;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().k())
          {
            C();
            paramBoolean = bool;
            if (Build.VERSION.SDK_INT >= 11)
            {
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
              paramBoolean = bool;
            }
          }
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().aj) && (paramBoolean))
          {
            if (this.s >= 4) {
              break;
            }
            if ((!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
              break label1479;
            }
            l(paramInt1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gwo);
            this.jdField_a_of_type_Gwo.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gwo, 1000L);
          }
        }
        for (;;)
        {
          z();
          break;
          ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
          paramBoolean = true;
          break label1304;
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
          W();
          a(true, true, true);
        }
      }
      if ((paramInt1 == 97) || (paramInt1 == 98))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUI4Discussion", 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
        W();
        X();
        break label338;
      }
      if (paramInt1 == 11)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1) {
          break label338;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131364018);
        if (this.j != null) {
          this.j.setText((CharSequence)localObject1);
        }
        this.n = true;
        UITools.a(this.j, (String)localObject1);
        break label338;
      }
      if ((paramInt1 != 12) || (this.jdField_a_of_type_ComTencentAvVideoController.a().x != 1)) {
        break label338;
      }
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131364019);
      if (this.j != null) {
        this.j.setText((CharSequence)localObject1);
      }
      this.n = true;
      UITools.a(this.j, (String)localObject1);
      break label338;
      if (paramInt2 != 43) {
        break;
      }
      a(paramLong, false);
      return;
    }
  }
  
  public void a(View paramView)
  {
    int i = paramView.getId();
    if (this.q) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "BackBtn is Press, ignore other action");
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
                                    switch (i)
                                    {
                                    default: 
                                      return;
                                    case 2131298953: 
                                      DataReport.b(NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), 1);
                                      d();
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
                                DataReport.i(2131299022, 1);
                                return;
                                i = this.jdField_a_of_type_ComTencentAvVideoController.c();
                              } while ((this.jdField_c_of_type_Int != 3000) || (i < jdField_a_of_type_Int));
                              paramView = this.jdField_a_of_type_AndroidContentResResources.getString(2131363657);
                            } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
                            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(63, paramView, 3000L, 1);
                            ReportController.b(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
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
                            DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean, 1);
                            if ((!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
                              a(2131363600, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492908));
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
                          i(false);
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
                      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3)) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
                      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(20, true);
                      return;
                      ReportController.b(null, "CliOper", "", "", "0X8004CEC", "0X8004CEC", 0, 0, "", "", "", "");
                      paramView = new Intent();
                      paramView.setAction("tencent.video.v2q.AddContactsToDiscuss");
                      paramView.putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
                      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ab) {}
                      for (i = 0;; i = 2)
                      {
                        paramView.putExtra("uiFlag", i);
                        paramView.putExtra("notAcceptUserList", this.jdField_a_of_type_ComTencentAvVideoController.d());
                        paramView.putExtra("notAcceptPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaUtilArrayList);
                        paramView.putExtra("pstnInRoomPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.f());
                        paramView.putExtra("selectNotAcceptFlag", false);
                        paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
                        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
                        this.jdField_a_of_type_ComTencentAvVideoController.I = 1;
                        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
                          ag();
                        }
                        if (!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
                          break;
                        }
                        paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                        if ((paramView == null) || (!(paramView instanceof AVActivity))) {
                          break;
                        }
                        paramView = (AVActivity)paramView;
                        if (paramView == null) {
                          break;
                        }
                        paramView = paramView.a();
                        if (paramView == null) {
                          break;
                        }
                        paramView.c();
                        return;
                      }
                    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
                    if (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
                      this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.e();
                    }
                    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ab))
                    {
                      DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230).setTitle(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131364020)).setMessage(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131364021)).setNegativeButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131364023), new gvj(this)).setPositiveButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131364022), new gvi(this)).show();
                      return;
                    }
                    F();
                    return;
                  } while (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1);
                  U();
                } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
                ag();
                return;
              } while (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1);
              this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
            } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
            ag();
            return;
          } while (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1);
          R();
        } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().k()));
        ag();
        return;
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(107) });
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
          ag();
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().h)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().h = false;
          UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131363398));
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().h = true;
        UITools.a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131363397));
        return;
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
      PstnUtils.a(null, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2, 15);
      return;
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "OnKeyDown --> WRONG KeyCode = " + paramInt);
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
              DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean, 1);
              if (SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
                break;
              }
            } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean);
            a(2131363600, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492908));
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
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {}
    for (;;)
    {
      return;
      if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k()))
      {
        boolean bool;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) {
          bool = ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_b_of_type_Boolean;
        }
        for (int i = ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int; (bool) && (i != 0); i = 0)
        {
          DataReport.h(i, paramInt);
          return;
          bool = true;
        }
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "OnCreate");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    a();
    b();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().O)
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().r;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.x, str);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(str);
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "switchToGaudio config :" + this.x + "，connectDeviceName : " + str);
      }
      e();
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().n()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ab) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_E_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4))
      {
        int i = this.jdField_a_of_type_ComTencentAvVideoController.d().size();
        if (i <= 0) {
          break label316;
        }
        a(i);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().n()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().x == 1))
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().F) && (this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null)) {
          this.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.d();
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setMultiPstnCallback(true);
        }
        a(0L, 11, true, 0);
      }
      return;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.x);
      break;
      label316:
      J();
    }
  }
  
  void e()
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1))
    {
      N();
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
    QLog.e("MultiVideoCtrlLayerUI4Discussion", 2, "handleExterData-->Wrong gaudioStatusType-->type = " + this.jdField_b_of_type_Int + " , relationId = " + this.jdField_a_of_type_Long + " , relationType = " + this.jdField_d_of_type_Int);
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidContentResResources != null))
    {
      CharSequence localCharSequence = this.jdField_a_of_type_AndroidContentResResources.getText(2131364016);
      SpannableString localSpannableString = new SpannableString(localCharSequence);
      localSpannableString.setSpan(new gvr(this), 10, 18, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427713)), 10, 18, 33);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(localSpannableString);
      this.jdField_e_of_type_AndroidWidgetTextView.setMovementMethod(QavLinkMovementMethod.a());
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(localCharSequence);
      this.jdField_e_of_type_AndroidWidgetTextView.setHighlightColor(0);
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "OnDestroy");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    super.k();
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.e))
    {
      z();
      j(false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(7, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(7, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        break label123;
      }
      super.p(2131299015);
    }
    for (;;)
    {
      Y();
      long l = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_Int, String.valueOf(l));
      if (!g()) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(3, this.jdField_a_of_type_AndroidContentResResources.getString(2131363376));
      return;
      label123:
      super.q(2131299015);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(Long.toString(this.jdField_b_of_type_Long)) >= 100)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(3, this.jdField_a_of_type_AndroidContentResResources.getString(2131363376));
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, true);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, true);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(3, this.jdField_a_of_type_AndroidContentResResources.getString(2131363399));
  }
  
  void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "createOrEnterVideo");
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_Long <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI4Discussion", 2, "createOrEnterVideo --> RelationId is Error . RelationId = " + this.jdField_b_of_type_Long);
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
        if (this.jdField_a_of_type_ArrayOfLong == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MultiVideoCtrlLayerUI4Discussion", 2, "createOrEnterVideo --> DiscussionUinList is null");
          }
          i(true);
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, 0, this.jdField_a_of_type_ArrayOfLong, false);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    } while (this.jdField_b_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_ArrayOfLong, false);
  }
  
  void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "initViewList");
    }
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1)) {}
    for (long l = this.jdField_a_of_type_Long;; l = this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(l, 2, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(l, 2, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
      O();
      return;
    }
  }
  
  void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "refreshCameraBtnState");
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.c();
    int j = jdField_a_of_type_Int;
    if ((!VcSystemInfo.h()) || (!VcSystemInfo.d()))
    {
      Q();
      return;
    }
    if ((i >= j) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
    {
      Q();
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
    {
      c(true);
      return;
    }
    c(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiVideoCtrlLayerUI4Discussion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */