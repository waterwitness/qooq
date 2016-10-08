package com.tencent.av.smallscreen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.ui.SysCallTransparentActivity;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.qphone.base.util.QLog;
import gnz;
import goa;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class PstnSmallScreenService
  extends BaseSmallScreenService
  implements SmallScreenRelativeLayout.FloatListener
{
  static final String b = "PstnSmallScreenService";
  public TextView a;
  PstnSessionInfo jdField_a_of_type_ComTencentAvAppPstnSessionInfo;
  public QQAppInterface a;
  PstnObserver jdField_a_of_type_ComTencentMobileqqQcallPstnObserver;
  public Runnable c;
  boolean f;
  
  public PstnSmallScreenService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new gnz(this);
    this.jdField_c_of_type_JavaLangRunnable = new goa(this);
  }
  
  public SmallScreenRelativeLayout a()
  {
    return this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("PstnSmallScreenService", 2, "WL_DEBUG onCallStateChanged state = " + paramInt);
      QLog.d("PstnSmallScreenService", 2, "WL_DEBUG onCallStateChanged incomingNumber = " + paramString);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      f();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (paramString != null) {
          if (paramString.e)
          {
            PstnSessionInfo localPstnSessionInfo = paramString.a();
            localPstnSessionInfo.jdField_b_of_type_Int = -1;
            paramString.e = false;
            paramString.jdField_f_of_type_Boolean = false;
            PSTNNotification.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).d();
            paramString.a(localPstnSessionInfo.jdField_a_of_type_JavaLangString, 0);
            h();
            stopSelf();
          }
          else if ((paramString.a().jdField_b_of_type_Int == -1) || (paramString.a().jdField_b_of_type_Int == 2))
          {
            stopSelf();
            h();
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              if (paramString != null)
              {
                paramString.e = true;
                a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 8000L);
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                {
                  paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  if (paramString != null) {
                    paramString.e = true;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (this.jdField_f_of_type_Boolean) {
      stopSelf();
    }
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = new Intent(getApplicationContext(), CallbackWaitingActivityExt.class);
    paramSmallScreenRelativeLayout.addFlags(262144);
    paramSmallScreenRelativeLayout.addFlags(268435456);
    paramSmallScreenRelativeLayout.addFlags(4194304);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_Int = a().a();
    paramSmallScreenRelativeLayout.putExtra("pstn_session_info", this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo);
    paramSmallScreenRelativeLayout.putExtra("ActivityStartFrom", "ActivityStartFromBall");
    startActivity(paramSmallScreenRelativeLayout);
    return true;
  }
  
  void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramInt);
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(0, paramString, paramString, true);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e) {
          break label81;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 5);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString);
      this.g = paramInt;
      return;
      label81:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0);
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "WL_DEBUG OnOpChanged mIsOpEnable = " + this.e);
    }
    f();
  }
  
  void f()
  {
    int j = 1;
    boolean bool1;
    boolean bool3;
    boolean bool2;
    if (!this.d)
    {
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label315;
      }
      bool1 = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)) {
        break label396;
      }
      bool3 = SmallScreenUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      bool2 = SmallScreenUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PstnSmallScreenService", 2, "WL_DEBUG showHideToast isOpEnable = " + bool3);
        QLog.d("PstnSmallScreenService", 2, "WL_DEBUG showHideToast isAudioVisible = " + bool1);
        QLog.d("PstnSmallScreenService", 2, "WL_DEBUG showHideToast mIsLock = " + this.jdField_c_of_type_Boolean);
        QLog.d("PstnSmallScreenService", 2, "WL_DEBUG showHideToast mIsInit = " + this.jdField_a_of_type_Boolean);
        QLog.d("PstnSmallScreenService", 2, "WL_DEBUG showHideToast isAudioToastCanShow = " + bool2);
      }
      int i;
      if ((bool3) && (!this.jdField_c_of_type_Boolean))
      {
        i = 1;
        label225:
        if ((i == 0) || (!bool2)) {
          break label325;
        }
        i = j;
        label236:
        if ((i == 0) || (this.jdField_a_of_type_Boolean)) {
          break label330;
        }
        if (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) {
          b();
        }
        if (!bool1)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.jdField_f_of_type_Int);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        }
        label283:
        if (i == 0) {
          break label355;
        }
        if (this.g != 3)
        {
          this.g = 3;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.g);
        }
      }
      label315:
      label325:
      label330:
      label355:
      while ((this.jdField_c_of_type_Boolean) || (this.g == 2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
      {
        return;
        bool1 = false;
        break;
        i = 0;
        break label225;
        i = 0;
        break label236;
        if (!bool1) {
          break label283;
        }
        this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
        break label283;
      }
      b(2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString);
      return;
      label396:
      bool2 = false;
      bool3 = false;
    }
  }
  
  void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "WL_DEBUG InitRunnable.run start");
    }
    this.jdField_a_of_type_Boolean = false;
    f();
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "WL_DEBUG InitRunnable.run end");
    }
  }
  
  void h()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    Message localMessage;
    if (localMqqHandler != null)
    {
      localMessage = localMqqHandler.obtainMessage();
      localMessage.what = 1047;
      localMessage.arg1 = -1;
      localMqqHandler.sendMessage(localMessage);
    }
    localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Call.class);
    if (localMqqHandler != null)
    {
      localMessage = Message.obtain();
      localMessage.what = 16;
      localMessage.arg1 = -1;
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "WL_DEBUG onCreate start");
    }
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131299090));
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
    if (i == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364011);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnSmallScreenService", 2, "WL_DEBUG onCreate end");
      }
      return;
      if (i == 2) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364012);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, "WL_DEBUG onDestroy start");
    }
    super.onDestroy();
    Object localObject4 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    Object localObject1 = ((PstnManager)localObject4).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Object localObject2;
    Object localObject3;
    String str2;
    String str1;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int == -1) && (((PstnCardInfo)localObject1).pstn_c2c_call_time == 0) && (((PstnManager)localObject4).b() == 1) && (((PstnCardInfo)localObject1).pstn_c2c_try_status == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131372503);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131372504);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131372505);
      str2 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_title");
      str1 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_content");
      localObject4 = ((PstnManager)localObject4).a("key_pstn_c2c_try_over_recharge_confirm_text");
      if (!TextUtils.isEmpty(str2)) {
        break label333;
      }
      if (!TextUtils.isEmpty(str1)) {
        break label339;
      }
      label201:
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label345;
      }
    }
    for (;;)
    {
      localObject4 = new Intent(getApplicationContext(), SysCallTransparentActivity.class);
      ((Intent)localObject4).putExtra("pstn_dialog_type", 2);
      ((Intent)localObject4).putExtra("pstn_guide_title", (String)localObject1);
      ((Intent)localObject4).putExtra("pstn_guide_content", (String)localObject2);
      ((Intent)localObject4).putExtra("pstn_guide_confirm", (String)localObject3);
      ((Intent)localObject4).addFlags(268435456);
      startActivity((Intent)localObject4);
      b(0, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      if (QLog.isColorLevel()) {
        QLog.d("PstnSmallScreenService", 2, "WL_DEBUG onDestroy end");
      }
      return;
      label333:
      localObject1 = str2;
      break;
      label339:
      localObject2 = str1;
      break label201;
      label345:
      localObject3 = localObject4;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = ((PstnSessionInfo)paramIntent.getParcelableExtra("pstn_session_info"));
    }
    if (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnSmallScreenService", 2, "PstnSmallScreenService mSession is null");
      }
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().d;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
    f();
    this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.jdField_f_of_type_Int);
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\PstnSmallScreenService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */