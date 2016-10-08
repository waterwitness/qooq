package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gpy;
import gpz;
import java.lang.ref.SoftReference;

public class AVLoadingDialogActivity
  extends BaseActivity
{
  static final int jdField_a_of_type_Int = 0;
  public static Handler a;
  public static final String a = "com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH";
  static final int b = 0;
  public static final String b = "avactivity_intent";
  static final int jdField_c_of_type_Int = 1;
  static final String jdField_c_of_type_JavaLangString = "AVLoadingDialogActivity";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new gpz(this);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidOsHandler = new gpy();
  }
  
  Dialog a()
  {
    Dialog localDialog = new Dialog(this, 2131558973);
    localDialog.setContentView(2130903453);
    localDialog.setCancelable(false);
    TextView localTextView = (TextView)localDialog.findViewById(2131298665);
    if (localTextView != null) {
      localTextView.setText(2131363965);
    }
    return localDialog;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    showDialog(0);
    SoftReference localSoftReference = new SoftReference(this);
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = localSoftReference;
    jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 300L);
    localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = localSoftReference;
    jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 5000L);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return a();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\AVLoadingDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */