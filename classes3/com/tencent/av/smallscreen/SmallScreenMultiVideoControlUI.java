package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import goi;
import gol;
import gom;
import gon;
import goo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SmallScreenMultiVideoControlUI
  extends SmallScreenVideoControlUI
{
  static int jdField_a_of_type_Int = 4;
  static final String jdField_a_of_type_JavaLangString = "SmallScreenMultiVideoControlUI";
  public long a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new goi(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  public goo a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  boolean jdField_a_of_type_Boolean = false;
  public long[] a;
  public int b;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  String jdField_b_of_type_JavaLangString = null;
  public int c;
  Runnable c;
  public int d;
  Runnable d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  SmallScreenMultiVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Goo = new goo(this);
    this.jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().l;
  }
  
  public long a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L)) {
      return localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long;
    }
    return localSessionInfo.e;
  }
  
  public void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "drawUI-->type=" + paramInt1 + " uin=" + paramLong + " fresh=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().aj) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165195, null, 0, null);
      }
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label367;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j != 9) {
        break label351;
      }
      localObject2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363860);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.n())
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
          break label337;
        }
        localObject1 = localObject2;
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = true;
      }
      UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, (String)localObject1);
      l();
    }
    label275:
    label337:
    label351:
    label367:
    while ((paramInt1 == 68) || (paramInt1 == 82)) {
      for (;;)
      {
        q();
        return;
        if ((paramInt1 != 1) || (paramLong == this.jdField_a_of_type_Long) || (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) || (!this.jdField_a_of_type_ComTencentAvVideoController.o())) {
          break;
        }
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165196, null, 0, null);
        break;
        localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363872);
        continue;
        if (paramInt1 == 0)
        {
          this.jdField_c_of_type_Boolean = false;
          u();
        }
      }
    }
    if ((paramInt1 == 5) || (paramInt1 == 6))
    {
      paramBoolean = true;
      if (paramLong != this.jdField_a_of_type_Long) {
        break label1329;
      }
    }
    label865:
    label1323:
    label1327:
    label1329:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt1 == 6)
      {
        paramBoolean = a();
        if ((paramInt2 != 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().am)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false);
        }
      }
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().aj) || (!paramBoolean)) {
        break label275;
      }
      if (this.l >= 4) {
        break;
      }
      if ((NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ao))
      {
        if (paramInt2 == 0)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Goo);
          this.jdField_a_of_type_Goo.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Goo, 1000L);
          break label275;
        }
        paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_a_of_type_Long, 1);
        int i = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenMultiVideoControlUI", 2, "onSelfVideoIn.-->FirstVideo=" + i + ",index=" + paramInt2);
        }
        if ((i != -1) && ((paramInt2 != i) || (paramInt2 == 0))) {
          break label275;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Goo);
        this.jdField_a_of_type_Goo.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Goo, 1000L);
        break label275;
      }
      if (paramInt2 != 0) {
        break label275;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
      p();
      a(true, true, true);
      break label275;
      if ((paramInt1 == 7) || (paramInt1 == 8)) {
        if (paramInt1 == 8)
        {
          localObject1 = new VideoViewInfo();
          ((VideoViewInfo)localObject1).jdField_a_of_type_Long = paramLong;
          ((VideoViewInfo)localObject1).jdField_a_of_type_Int = 2;
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(localObject1);
          this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localObject2 });
          if (paramInt1 != 8) {
            break label1323;
          }
        }
      }
      for (paramBoolean = a();; paramBoolean = true)
      {
        if (((!this.jdField_a_of_type_ComTencentAvVideoController.a().z) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().aj)) || (!paramBoolean)) {
          break label1327;
        }
        if (this.l >= 4) {
          break;
        }
        if ((NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ao))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Goo);
          this.jdField_a_of_type_Goo.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Goo, 1000L);
          break label275;
          if (this.jdField_d_of_type_Int != 2) {
            break label865;
          }
          ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
          break label865;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
        p();
        a(true, true, true);
        break label275;
        if ((paramInt1 == 97) || (paramInt1 == 98))
        {
          if (!QLog.isColorLevel()) {
            break label275;
          }
          QLog.e("SmallScreenMultiVideoControlUI", 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
          break label275;
        }
        if (paramInt1 != 10) {
          break label275;
        }
        paramBoolean = a();
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().aj) || (!paramBoolean)) {
          break label275;
        }
        if (this.l >= 4) {
          break;
        }
        if ((NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ao))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Goo);
          this.jdField_a_of_type_Goo.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Goo, 1000L);
          break label275;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
        p();
        a(true, true, true);
        break label275;
      }
      break label275;
    }
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin=" + paramLong + " type=" + paramInt1 + " isRefreshTitle=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin == 0");
      }
      return;
    }
    gom localgom = new gom(this, paramInt1, paramLong, paramBoolean, paramInt2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(localgom);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Add-->FunctionName=" + paramString);
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
      return;
      this.jdField_b_of_type_JavaLangRunnable = new gon(this);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if ((((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Long == this.jdField_a_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList });
        return;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    h();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().O)
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().r;
      TraeHelper.a().a(this.e, str);
      TraeHelper.a().b(str);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "switchToGaudio config :" + this.e + "，connectDeviceName : " + str);
      }
    }
    c(paramBoolean);
    q();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.n()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.setBackgroundResource(2130839244);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      if (this.jdField_d_of_type_Int == 2) {
        if (!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
        {
          ReportController.b(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
          {
            if (!paramBoolean2) {
              break label255;
            }
            String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131363721);
            TipsManager.a(102, str);
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102, str, false);
          }
        }
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        a(this.jdField_a_of_type_ComTencentAvVideoController.a().c);
      }
      return;
      ReportController.b(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
      break;
      if (this.jdField_d_of_type_Int != 1) {
        break;
      }
      if (NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        ReportController.b(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
      break;
      label255:
      TipsManager.c(102);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102);
      continue;
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        TipsManager.c(102);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102);
        TipsManager.c(107);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107);
      }
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() == 0)
    {
      k();
      a(false, false, false);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() == 1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Long == this.jdField_a_of_type_Long))
    {
      a(false, false, false);
      b("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Remove-->FunctionName=" + paramString);
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return false;
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().c.size();
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          i = j - 1;
        }
        if (i != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->There is no dispaly view");
      return false;
    } while ((!VcSystemInfo.d()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1));
    ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
    int i = this.jdField_a_of_type_ComTencentAvVideoController.i();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->VideoAblityLevel=" + i);
    }
    if (i != 4)
    {
      if (this.jdField_d_of_type_Int != 2) {
        break label309;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(61, true);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().d.clear();
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().c.size())
      {
        if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(i)).jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().d.add(this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(i));
        }
        i += 1;
      }
      label309:
      if (this.jdField_d_of_type_Int != 1) {}
    }
    a(false, false, false);
    return this.jdField_a_of_type_ComTencentAvVideoController.e();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    super.c();
  }
  
  void c(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1))
    {
      k();
      d(paramBoolean);
    }
    for (;;)
    {
      g();
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        String str1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().j == 9)
        {
          this.jdField_c_of_type_Boolean = true;
          String str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363860);
          str1 = str2;
          if (this.jdField_a_of_type_ComTencentAvVideoController.n())
          {
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
              str1 = str2;
            }
          }
          else {
            label131:
            if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
            }
          }
        }
        for (;;)
        {
          u();
          break;
          str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363872);
          break label131;
          this.jdField_c_of_type_Boolean = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "handleExterData-->Wrong gaudioStatusType-->type=" + this.jdField_b_of_type_Int + ",relationId=" + a() + ",relationType=" + this.jdField_d_of_type_Int);
      }
    }
  }
  
  void d(boolean paramBoolean)
  {
    long l = a();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio mType: " + this.jdField_b_of_type_Int + ".DiscussionID=" + l);
    }
    if (l == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio-->mGroupId == 0");
      }
    }
    do
    {
      do
      {
        return;
        String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131363854);
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        }
        if (this.jdField_b_of_type_Int != 0) {
          break;
        }
      } while ((this.jdField_a_of_type_ArrayOfLong != null) || (this.jdField_d_of_type_Int != 2));
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio uinList is null");
      }
      e(true);
      return;
    } while ((this.jdField_b_of_type_Int != 1) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, l, this.jdField_a_of_type_ArrayOfLong, false);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(a()), Boolean.valueOf(paramBoolean) });
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onResume");
    }
    String str1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.e)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.C();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().j != 9) {
          break label223;
        }
        this.jdField_c_of_type_Boolean = true;
        String str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363860);
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentAvVideoController.n())
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
            break label210;
          }
          str1 = str2;
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
        }
      }
    }
    for (;;)
    {
      u();
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().am = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.e) {
        i();
      }
      g();
      return;
      label210:
      str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363872);
      break;
      label223:
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.e) {}
    long l = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_Int, String.valueOf(l));
  }
  
  void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData-->mType=" + this.jdField_a_of_type_ComTencentAvVideoController.a().E + " IntentGroupId=" + this.jdField_a_of_type_ComTencentAvVideoController.a().e + " isInRoom=" + this.jdField_a_of_type_ComTencentAvVideoController.e + " mRoomDiscussionId=" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo != null)
    {
      this.jdField_c_of_type_Int = localSessionInfo.l;
      if (this.jdField_c_of_type_Int != 3000) {
        break label278;
      }
      this.jdField_d_of_type_Int = 2;
    }
    for (;;)
    {
      if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long <= 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenMultiVideoControlUI", 2, "WL_DEBUG processExtraData sessionInfo.mAnychat_Info.matchStatus = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int);
        }
        if (((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 1) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 2)) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363871);
        }
      }
      this.jdField_b_of_type_Int = localSessionInfo.E;
      this.jdField_a_of_type_ArrayOfLong = localSessionInfo.jdField_b_of_type_ArrayOfLong;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "WL_DEBUG processExtraData mGroupId = " + a());
      }
      return;
      label278:
      if (this.jdField_c_of_type_Int == 1) {
        this.jdField_d_of_type_Int = 1;
      }
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new gol(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  protected void j()
  {
    super.j();
    String str2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().j == 9)
    {
      str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363860);
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.n()) {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
          break label109;
        }
      }
    }
    label109:
    for (String str1 = str2;; str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131363872))
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      }
      return;
    }
  }
  
  void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "closeRemoteVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
      p();
    }
    b("closeRemoteVideo");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().c });
    }
  }
  
  public void l()
  {
    m();
  }
  
  void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshGAFList");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) && (QLog.isColorLevel())) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshGAFList-->mVideoContrl is null");
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "goOffStage");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.G();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, false);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
    p();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoControl is null");
      }
    }
    label230:
    label248:
    do
    {
      int i;
      for (;;)
      {
        return;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.e)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoController.mGAudioInRoom =" + this.jdField_a_of_type_ComTencentAvVideoController.e);
          }
        }
        else
        {
          i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_a_of_type_Long, 1);
          int j = this.jdField_a_of_type_ComTencentAvVideoController.c();
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->index=" + i + ", onstageNum=" + j);
          }
          if ((!NetworkUtil.i((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
            break;
          }
          if (i != -1)
          {
            if (this.jdField_a_of_type_ComTencentAvVideoController.c() >= jdField_a_of_type_Int) {
              break label248;
            }
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.m())) {
              break label230;
            }
          }
          while (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0)
          {
            b();
            return;
            if (QLog.isColorLevel())
            {
              QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->go on stage fail,can not find the session");
              continue;
              this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false);
              this.jdField_a_of_type_ComTencentAvVideoController.F();
            }
          }
        }
      }
      if (i != -1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.F();
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 0);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
    p();
    a(true, true, true);
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "switchUIMode, sessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
  }
  
  void q()
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.n()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1")))
    {
      int k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int;
      int j = 0;
      i = j;
      switch (k)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (i != 0)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(i);
      }
      return;
      i = 2131363854;
      continue;
      i = 2131363860;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenMultiVideoControlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */