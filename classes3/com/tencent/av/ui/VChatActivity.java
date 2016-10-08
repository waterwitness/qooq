package com.tencent.av.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import gyr;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

public class VChatActivity
  extends BaseActivity
{
  static final String jdField_a_of_type_JavaLangString = "VChatActivity";
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  public VideoController a;
  public VideoAppInterface a;
  
  public VChatActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new gyr(this);
  }
  
  public void a()
  {
    super.finish();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VChatActivity", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    if ((super.getAppRuntime() instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    paramBundle = super.getIntent();
    String str = paramBundle.getStringExtra("uin");
    if (str != null) {
      try
      {
        ((MobileQQ)super.getApplication()).getAppRuntime(str);
        switch (paramBundle.getIntExtra("istatus", 0))
        {
        default: 
          super.finish();
          return;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          QLog.d("VChatActivity", 1, "AV_UIN_NOT_MATCH, MSFUIN: " + str + " AVUIN:" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
          HashMap localHashMap = new HashMap();
          localHashMap.put("avuin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
          localHashMap.put("msfuin", String.valueOf(str));
          StatisticCollector.a(super.getApplicationContext()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), "AV_UIN_NOT_MATCH", false, 0L, 0L, localHashMap, "", true);
          if (!str.equals("0"))
          {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str);
            continue;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().d(0);
            continue;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().d(1);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.l();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    super.finish();
    a();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    String str = super.getString(2131363567);
    DialogUtil.a(this, 230, super.getString(2131363525), str, 2131363540, 2131363540, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, null).show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\VChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */