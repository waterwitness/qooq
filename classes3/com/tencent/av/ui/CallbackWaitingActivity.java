package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import gqh;
import gqi;
import gqk;

public class CallbackWaitingActivity
  extends BaseActivity
{
  public static final String a = "ACTION_MULTI_CHAT_FINISH";
  private static final int d = 10;
  private static final int jdField_e_of_type_Int = 30000;
  private static final int f = 10;
  private static String g = "CallbackWaitingActivity";
  private static final String h = "com.tencent.lightalk.callbackwaiting.STOPMULTIAUDIO";
  int jdField_a_of_type_Int = 1001;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new gqk(this);
  AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new gqh(this, Looper.getMainLooper());
  public BaseCallbackUI a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public int b;
  public String b;
  int c;
  public String c;
  public String d = "";
  String jdField_e_of_type_JavaLangString;
  public String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CallbackWaitingActivity()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "user close!");
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      paramView = new Intent();
      paramView.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName());
      paramView.setAction("tencent.av.v2q.CancelCallBack");
      paramView.putExtra("fromPhone", this.d);
      paramView.putExtra("toPhone", this.jdField_c_of_type_JavaLangString);
      paramView.putExtra("fromUin", this.f);
      paramView.putExtra("uinType", this.jdField_b_of_type_Int);
      paramView.putExtra("toUin", this.e);
      paramView.putExtra("callBackId", this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramView);
      finish();
      return;
    }
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.requestWindowFeature(1);
    super.doOnCreate(paramBundle);
    setContentView(2130903523);
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      super.getWindow().addFlags(67108864);
    }
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), true);
    }
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("type", 1001);
    if (this.jdField_a_of_type_Int == 1001)
    {
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("toPhone");
      this.d = paramBundle.getStringExtra("fromPhone");
    }
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("callbackId");
    this.e = paramBundle.getStringExtra("toUin");
    this.f = paramBundle.getStringExtra("fromUin");
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("uinType", 0);
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI = new BaseCallbackUI(this, 1001);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("android.intent.action.PHONE_STATE"));
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.jdField_a_of_type_AndroidOsHandler.postDelayed(new gqi(this), 30000L);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onDestroy");
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_c_of_type_Int);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onPause");
    }
    AudioUtil.a();
    if (this.jdField_a_of_type_Int == 1001) {
      finish();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onResume");
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(2);
    AudioUtil.a(2131165194, 1, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\CallbackWaitingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */