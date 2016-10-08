package cooperation.qwallet.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PayLSUnlockActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppActivity;
import yjn;
import yjo;

public class QWalletLockScreenActivity
  extends AppActivity
  implements View.OnClickListener
{
  public static int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  yjo jdField_a_of_type_Yjo;
  private final int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  private final int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  
  public QWalletLockScreenActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 9;
    this.jdField_a_of_type_AndroidOsHandler = new yjn(this, Looper.getMainLooper());
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    registerReceiver(this.jdField_a_of_type_Yjo, localIntentFilter);
  }
  
  private boolean a()
  {
    if ((Build.VERSION.SDK_INT == 20) && (Build.VERSION.RELEASE.equals("L"))) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.push", 2, "QWalletLockScreenActivity isKeyguardLock SDK is androidL !");
      }
    }
    for (;;)
    {
      return true;
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
          if (QLog.isColorLevel()) {
            QLog.e("Q.qwallet.push", 2, "QWalletLockScreenActivity kgm.isKeyguardLocked()=" + localKeyguardManager.isKeyguardLocked() + ". kgm.isKeyguardSecure()=" + localKeyguardManager.isKeyguardSecure());
          }
          if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
          {
            bool = localKeyguardManager.isKeyguardSecure();
            if (!bool) {}
          }
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (SecurityException localSecurityException) {}
      }
    }
    QLog.e("Q.qwallet.push", 2, "QWalletLockScreenActivity kgm.isKeyguardLocked()=" + localSecurityException);
    return true;
  }
  
  private void b()
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity isKeyGuardLock=" + bool);
    }
    if (!bool)
    {
      startActivity(new Intent(this, PayLSUnlockActivity.class));
      return;
    }
    moveTaskToBack(true);
    finish();
  }
  
  protected void doOnBackPressed()
  {
    super.doOnBackPressed();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity onBackPressed=== ");
    }
    if (!isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity onBackPressed not finish ");
      }
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnCreate taskId" + getTaskId() + Thread.currentThread().getId());
    }
    setContentView(2130904595);
    getWindow().addFlags(524288);
    this.jdField_a_of_type_Yjo = new yjo(this, null);
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity app null,  finish");
      }
      finish();
    }
    do
    {
      return true;
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("title");
      this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("content");
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("time");
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302645));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301840));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301841));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301835));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity new brightWakeLock");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Yjo != null) {
      unregisterReceiver(this.jdField_a_of_type_Yjo);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnPause by :" + (String)localObject);
      }
      if ("com.tencent.mobileqq.activity.GesturePWDUnlockActivity".equals(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnPause by locking activity need to front");
        }
        localObject = new Intent(this, QWalletLockScreenActivity.class);
        ((Intent)localObject).addFlags(131072);
        startActivity((Intent)localObject);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnPause taskId" + getTaskId());
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    boolean bool = QQUtils.a(this);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnStart isScreenLocked=" + bool);
    }
    if (!bool) {
      finish();
    }
    GuardManager localGuardManager = GuardManager.a;
    if (localGuardManager != null) {
      localGuardManager.b();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnStop taskId" + getTaskId());
    }
    GuardManager localGuardManager = GuardManager.a;
    if (localGuardManager != null) {
      localGuardManager.c();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301840: 
      paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (GesturePWDUtils.getJumpLock(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
      for (long l = 500L;; l = 0L)
      {
        localHandler.sendMessageDelayed(paramView, l);
        return;
      }
    }
    paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1500L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\QWalletLockScreenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */