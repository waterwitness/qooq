package com.tencent.mobileqq.intervideo.od;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import swj;

public class ODLoadingActivity
  extends Activity
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, IVPluginEvtListener, LoadingUI.Event
{
  static final String jdField_a_of_type_JavaLangString = "XProxy|ODLoadingActivity";
  AlertDialog jdField_a_of_type_AndroidAppAlertDialog;
  Handler jdField_a_of_type_AndroidOsHandler;
  IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  LoadingUI jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  public ODLoadingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI = new LoadingUI();
    this.jdField_a_of_type_AndroidAppAlertDialog = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.b = false;
  }
  
  private void b()
  {
    ODProxy localODProxy = (ODProxy)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime((BaseActivity)null)).getManager(107);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo != null)
    {
      localODProxy.a(this);
      localODProxy.a(this, this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, false);
      return;
    }
    a("Live", 55535, "参数错误!");
  }
  
  private void c()
  {
    if (!NetworkUtil.h(this)) {
      a("Live", 55534, "网络连接错误，请稍候再试!");
    }
    do
    {
      return;
      if (NetworkUtil.b(this)) {
        break;
      }
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("提示");
      localBuilder.setMessage("当前处于移动网络环境下,是否继续？");
      this.jdField_a_of_type_Boolean = false;
      localBuilder.setPositiveButton("取消", this);
      localBuilder.setNegativeButton("继续", this);
      this.jdField_a_of_type_AndroidAppAlertDialog = localBuilder.create();
      this.jdField_a_of_type_AndroidAppAlertDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppAlertDialog.setOnDismissListener(this);
    } while (isFinishing());
    try
    {
      this.jdField_a_of_type_AndroidAppAlertDialog.show();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    b();
  }
  
  public void a()
  {
    this.b = false;
    b();
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(String paramString)
  {
    this.b = true;
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("首次进入需要初始化资源...", false);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a(paramInt);
    if (paramInt == 100) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("正在努力加载...", true);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("加载失败，请重试!");
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void b(String paramString) {}
  
  public void c(String paramString) {}
  
  public void onBackPressed()
  {
    ((ODProxy)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime((BaseActivity)null)).getManager(107)).a("odloadingback");
    finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = false;
        ((ODProxy)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime((BaseActivity)null)).getManager(107)).a("od_nowificancel");
      } while (isFinishing());
      try
      {
        this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
        return;
      }
      catch (IllegalArgumentException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    } while (isFinishing());
    try
    {
      this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
      return;
    }
    catch (IllegalArgumentException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a(this, getString(2131365317));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a(this);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = ((IVPluginInfo)getIntent().getSerializableExtra("plugininfo"));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new swj(this), 50L);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      return;
    }
    super.finish();
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.b) {
      finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\od\ODLoadingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */