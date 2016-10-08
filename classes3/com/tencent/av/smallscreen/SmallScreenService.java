package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import goq;
import gor;
import gos;

public class SmallScreenService
  extends BaseSmallScreenService
  implements SmallScreenRelativeLayout.FloatListener
{
  static final String b = "SmallScreenService";
  public static boolean f;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  public VideoController a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  SmallScreenVideoController jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController;
  Runnable c;
  public Runnable d;
  boolean g;
  
  public SmallScreenService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewWindowManager = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new goq(this);
  }
  
  int a()
  {
    int j = 1000;
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a() != null)
        {
          SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
          if (localSessionInfo.jdField_f_of_type_Int != 1)
          {
            i = j;
            if (localSessionInfo.jdField_f_of_type_Int != 3) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    return i;
  }
  
  void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    f();
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenService", 2, "WL_DEBUG onCallStateChanged state = " + paramInt);
      QLog.d("SmallScreenService", 2, "WL_DEBUG onCallStateChanged incomingNumber = " + paramString);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      f();
      return;
      this.jdField_g_of_type_Boolean = false;
      continue;
      this.jdField_g_of_type_Boolean = true;
      continue;
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.b();
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a();
    return true;
  }
  
  public void b(int paramInt)
  {
    jdField_f_of_type_Boolean = false;
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) {
      this.jdField_g_of_type_Int = paramInt;
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "WL_DEBUG OnOpChanged mIsOpEnable = " + this.jdField_e_of_type_Boolean);
    }
    f();
    if (this.jdField_e_of_type_Boolean)
    {
      str = "0X80057D9";
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.jdField_e_of_type_Int > 0) {
        if (!this.jdField_e_of_type_Boolean) {
          break label116;
        }
      }
    }
    label116:
    for (String str = "0X80057DA";; str = "0X80057DC")
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      return;
      str = "0X80057DB";
      break;
    }
  }
  
  public void f()
  {
    boolean bool3;
    boolean bool4;
    label40:
    boolean bool5;
    label63:
    boolean bool7;
    boolean bool8;
    boolean bool1;
    boolean bool2;
    boolean bool6;
    label146:
    label167:
    int i;
    label474:
    label491:
    Object localObject1;
    int j;
    label523:
    label719:
    Object localObject2;
    if (!this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_e_of_type_Int <= 0) {
        break label931;
      }
      bool3 = true;
      if ((this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label937;
      }
      bool4 = true;
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label943;
      }
      bool5 = true;
      bool7 = false;
      bool8 = false;
      boolean bool9 = false;
      bool1 = bool9;
      bool2 = bool8;
      bool6 = bool7;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        bool1 = bool9;
        bool2 = bool8;
        bool6 = bool7;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)
        {
          bool6 = SmallScreenUtils.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
          if ((!bool3) || (!SmallScreenUtils.f(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))) {
            break label949;
          }
          bool2 = true;
          if ((bool3) || (!SmallScreenUtils.g(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))) {
            break label955;
          }
          bool1 = true;
        }
      }
      bool8 = this.jdField_a_of_type_ComTencentAvVideoController.q();
      if (QLog.isColorLevel())
      {
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast hasVideo = " + bool3);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast mIsInCall = " + this.jdField_g_of_type_Boolean);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast isOpEnable = " + bool6);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast isVideoVisible = " + bool4);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast isAudioVisible = " + bool5);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast isSelectMemberActivityIsResume = " + bool8);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast mIsLock = " + this.jdField_c_of_type_Boolean);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast mIsInit = " + this.jdField_a_of_type_Boolean);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast isVideoToastCanShow = " + bool2);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast isAudioToastCanShow = " + bool1);
      }
      if ((this.jdField_g_of_type_Boolean) || (!bool6) || (bool8) || (this.jdField_c_of_type_Boolean)) {
        break label961;
      }
      i = 1;
      if ((i == 0) || ((!bool2) && (!bool1))) {
        break label966;
      }
      bool6 = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      i = ((SessionInfo)localObject1).jdField_f_of_type_Int;
      j = ((SessionInfo)localObject1).F;
      if ((i != 1) && (i != 2)) {
        break label972;
      }
      bool7 = true;
      if (QLog.isColorLevel())
      {
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast isToastShow = " + bool6);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast SessionType = " + i);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast relationType = " + j);
        QLog.d("SmallScreenService", 2, "WL_DEBUG showHideToast isC2c = " + bool7);
      }
      if ((bool3) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.n = bool6;
      if ((!bool2) || (!bool6)) {
        break label1023;
      }
      if (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b())
      {
        localObject1 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
        if (this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getRotation() % 2 != 0) {
          break label978;
        }
        ((WindowManager.LayoutParams)localObject1).width = this.jdField_a_of_type_Int;
        ((WindowManager.LayoutParams)localObject1).height = this.jdField_b_of_type_Int;
        localObject2 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(this.jdField_f_of_type_Int);
        ((WindowManager.LayoutParams)localObject1).x = ((Point)localObject2).x;
        ((WindowManager.LayoutParams)localObject1).y = ((Point)localObject2).y;
        a();
      }
      if (bool4) {
        break label1214;
      }
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.jdField_f_of_type_Int);
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
      localObject2 = "0X80057E6";
      if (!bool5) {
        break label1221;
      }
      if (!bool7) {
        break label997;
      }
      localObject1 = "0X8005A4A";
    }
    for (;;)
    {
      label792:
      if ((bool1) && (bool6) && (!this.jdField_a_of_type_Boolean))
      {
        if (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) {
          b();
        }
        if (bool5) {
          break label1104;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        if (!bool4) {
          break label1104;
        }
        if (bool7)
        {
          localObject1 = "0X8005A4D";
          label860:
          if (!bool6) {
            break label1107;
          }
          if (this.jdField_g_of_type_Int != 3) {
            b(3);
          }
        }
      }
      for (;;)
      {
        if (localObject2 != null) {
          ReportController.b(null, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
        }
        if (localObject1 != null) {
          ReportController.b(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        }
        return;
        label931:
        bool3 = false;
        break;
        label937:
        bool4 = false;
        break label40;
        label943:
        bool5 = false;
        break label63;
        label949:
        bool2 = false;
        break label146;
        label955:
        bool1 = false;
        break label167;
        label961:
        i = 0;
        break label474;
        label966:
        bool6 = false;
        break label491;
        label972:
        bool7 = false;
        break label523;
        label978:
        ((WindowManager.LayoutParams)localObject1).width = this.jdField_b_of_type_Int;
        ((WindowManager.LayoutParams)localObject1).height = this.jdField_a_of_type_Int;
        break label719;
        label997:
        if (j == 1)
        {
          localObject1 = "0X8005A4C";
          break label792;
        }
        if (j != 2) {
          break label1221;
        }
        localObject1 = "0X8005A4B";
        break label792;
        label1023:
        if (!bool4) {
          break label1214;
        }
        this.jdField_f_of_type_Int = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
        localObject2 = "0X80057E5";
        localObject1 = null;
        break label792;
        if (j == 1)
        {
          localObject1 = "0X8005A4F";
          break label860;
        }
        if (j == 2)
        {
          localObject1 = "0X8005A4E";
          break label860;
          if (bool5)
          {
            this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
          }
        }
        label1104:
        break label860;
        label1107:
        if ((!bool8) && (!this.jdField_c_of_type_Boolean) && (this.jdField_g_of_type_Int != 2)) {
          if (this.jdField_g_of_type_Int == 1)
          {
            if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
            {
              if (this.jdField_c_of_type_JavaLangRunnable == null) {
                this.jdField_c_of_type_JavaLangRunnable = new gor(this);
              }
              a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
              jdField_f_of_type_Boolean = true;
              a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, a());
            }
          }
          else {
            b(2);
          }
        }
      }
      label1214:
      localObject1 = null;
      localObject2 = null;
      continue;
      label1221:
      localObject1 = null;
    }
  }
  
  void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "WL_DEBUG InitRunnable.run start");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.p()) {}
    }
    for (;;)
    {
      return;
      if (RandomMultiActivity.b != true)
      {
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (localSessionInfo != null)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("SmallScreenService", 2, "WL_DEBUG InitRunnable.run sessionInfo.SessionType = " + localSessionInfo.jdField_f_of_type_Int);
            QLog.d("SmallScreenService", 2, "WL_DEBUG InitRunnable.run sessionInfo.mAnychat_Info.matchStatus = " + localSessionInfo.a.jdField_b_of_type_Int);
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
            localSessionInfo.jdField_f_of_type_Int = 1;
          }
          if ((localSessionInfo.jdField_f_of_type_Int == 1) || (localSessionInfo.jdField_f_of_type_Int == 3) || (localSessionInfo.a.jdField_b_of_type_Int > 0))
          {
            this.jdField_a_of_type_Boolean = false;
            f();
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("SmallScreenService", 2, "WL_DEBUG InitRunnable.run end");
          return;
          if ((localSessionInfo.jdField_f_of_type_Int == 4) && (!NetworkUtil.i(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (!localSessionInfo.ao))
          {
            this.jdField_a_of_type_Boolean = false;
            f();
            continue;
            if (QLog.isColorLevel())
            {
              QLog.d("SmallScreenService", 2, "WL_DEBUG InitRunnable.run sessionInfo = null");
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("SmallScreenService", 2, "WL_DEBUG InitRunnable.run mVideoController = null");
              }
            }
          }
        }
      }
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "WL_DEBUG onCreate start");
    }
    super.onCreate();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    b(1);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    this.jdField_f_of_type_Int = ((SessionInfo)localObject).J;
    this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.jdField_f_of_type_Int);
    if (this.jdField_d_of_type_JavaLangRunnable == null) {
      this.jdField_d_of_type_JavaLangRunnable = new gos(this);
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.NEW_OUTGOING_CALL");
    ((IntentFilter)localObject).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = new SmallScreenVideoController(this);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a(this.app);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.d();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.e();
    f();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "WL_DEBUG onCreate end");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "WL_DEBUG onDestroy start");
    }
    if (this.jdField_e_of_type_Int > 0) {}
    for (this.jdField_a_of_type_ComTencentAvVideoController.a().J = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();; this.jdField_a_of_type_ComTencentAvVideoController.a().J = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())
    {
      super.onDestroy();
      b(0);
      this.jdField_c_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.f();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.g();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.h();
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_d_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      }
      this.jdField_d_of_type_JavaLangRunnable = null;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b();
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = null;
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "WL_DEBUG onDestroy end");
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */