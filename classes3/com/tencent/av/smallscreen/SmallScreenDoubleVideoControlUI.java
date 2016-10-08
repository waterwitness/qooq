package com.tencent.av.smallscreen;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gog;
import goh;

public class SmallScreenDoubleVideoControlUI
  extends SmallScreenVideoControlUI
{
  static final String jdField_a_of_type_JavaLangString = "SmallScreenDoubleVideoControlUI";
  Runnable jdField_a_of_type_JavaLangRunnable;
  boolean jdField_a_of_type_Boolean;
  
  public SmallScreenDoubleVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new goh(this);
  }
  
  public void a()
  {
    super.a();
    if (this.b != null) {
      this.b.setText(2131363854);
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if (i == 5)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ak)
      {
        u();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ak)
      {
        u();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (j > 18)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ak) && (this.jdField_a_of_type_ComTencentAvVideoController.a().al))
      {
        u();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ak)
    {
      u();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<setInvitingState(), resId =" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011) && (paramInt != 2131363854) && (paramInt != 2131363174) && (!this.jdField_a_of_type_ComTencentAvVideoController.f)) {}
    while ((this.b == null) || (paramInt <= 0)) {
      return;
    }
    this.b.setText(paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onInviteReached remotePhoneState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().p + " # remoteTerminal = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int + " # phoneOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().o + " # pcOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().n + " # subState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().b + " # isPeerNetworkWell = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().c()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ag) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString.contains(paramString1)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().p < 0) || (this.b == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.b.setText(2131363860);
      return;
    }
    this.b.setText(paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2131363854;
    super.a(paramBoolean);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "matchStatus = " + localSessionInfo.a.b);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
      this.b.setText(2131363874);
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
            if ((localSessionInfo.a.b > 0) && (localSessionInfo.a.b != 5))
            {
              this.b.setText(2131363871);
              return;
            }
            if (!localSessionInfo.f()) {
              break label243;
            }
            if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
              break;
            }
          } while ((!localSessionInfo.d) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
          if (localSessionInfo.L)
          {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(38, true);
            return;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
          return;
        } while (this.jdField_a_of_type_ComTencentAvVideoController.b() < 2L);
        if (!localSessionInfo.d) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
      return;
    } while ((this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) != 5) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
    return;
    label243:
    int i;
    if (localSessionInfo.e())
    {
      if (localSessionInfo.K) {}
      for (i = 2131363460;; i = 2131363310)
      {
        this.b.setText(i);
        return;
      }
    }
    if (localSessionInfo.c())
    {
      i = 2131363864;
      if (localSessionInfo.ag) {
        i = 2131363854;
      }
      if (localSessionInfo.l != 1011) {
        break label390;
      }
      i = j;
    }
    label390:
    for (;;)
    {
      this.b.setText(i);
      return;
      if (localSessionInfo.d())
      {
        this.b.setText(2131363504);
        return;
      }
      if ((!localSessionInfo.g()) && (!localSessionInfo.h())) {
        break;
      }
      if (localSessionInfo.l == 1011) {
        this.b.setText(2131363867);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gog(this), 150L);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onPhoneCalling isSelf = " + paramBoolean1 + " # isCalling = " + paramBoolean2);
    }
    String str;
    if ((!paramBoolean1) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (!paramBoolean2) {
        break label113;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(38, true);
      }
    }
    label113:
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      }
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(38, false);
  }
  
  public void b()
  {
    super.b();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onStart(), ts=" + l1);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().p >= 0) && (this.b != null))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 1011) {
        break label167;
      }
      this.b.setText(2131363854);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onStart(), ts=" + l2);
        QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      return;
      label167:
      this.b.setText(2131363860);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().b == 1L);
    u();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    super.c();
  }
  
  public void d()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.b()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().ak)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    u();
  }
  
  public void e()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().b != 1L) {
        u();
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
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {
                break;
              }
              if (this.jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              }
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().b == 1L);
            u();
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().f());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().al);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().b == 1L);
      u();
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().b == 1L);
    u();
  }
  
  public void f()
  {
    super.f();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onResume(), ts=" + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().b != 1L)) {
      u();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onResume(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenDoubleVideoControlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */