package cooperation.qqwifi;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.format.Time;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.MD5;
import cooperation.plugin.IPluginManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yjj;

public class QQWiFiPluginInstallActivity
  extends IphoneTitleBarActivity
{
  private static final String b = "com.tencent.process.exit";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected IPluginManager a;
  private QQWiFiHelper.QQWIFIInstallListener jdField_a_of_type_CooperationQqwifiQQWiFiHelper$QQWIFIInstallListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public QQWiFiPluginInstallActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private void a()
  {
    setContentView(2130904514);
    setTitle(2131370959);
    setContentBackgroundResource(2130837958);
  }
  
  private boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:qqwifi".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("QQWifiPlugin.apk");
    this.jdField_a_of_type_CooperationQqwifiQQWiFiHelper$QQWIFIInstallListener = new QQWiFiHelper.QQWIFIInstallListener(this, 0, this.app, null);
    this.jdField_a_of_type_JavaLangString = this.app.a();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_CooperationPluginIPluginManager != null) && (this.jdField_a_of_type_CooperationQqwifiQQWiFiHelper$QQWIFIInstallListener != null)) {
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("QQWifiPlugin.apk", this.jdField_a_of_type_CooperationQqwifiQQWiFiHelper$QQWIFIInstallListener);
    }
  }
  
  private void d()
  {
    int i;
    if ((getIntent() != null) && ("com.tencent.mobileqq.action.QQWiFi".equals(getIntent().getAction())))
    {
      i = getIntent().getIntExtra("type", 0);
      if (i != 101) {
        break label67;
      }
      ReportController.b(this.app, "CliOper", "", "", "QQWIFI", "clk_permanent", 0, 0, "", "", "", "");
    }
    label67:
    while (i != 102) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "QQWIFI", "clk_availNotify", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("qqwifi.plugin.onresume.broadcast");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yjj(this, null);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("QQWifiPlugin.apk"))
    {
      QQWiFiHelper.b(this, this.app);
      return;
    }
    this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("QQWifiPlugin.apk", this.jdField_a_of_type_CooperationQqwifiQQWiFiHelper$QQWIFIInstallListener);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
      paramBundle.putExtra("intervalTime", QQWiFiHelper.a);
      sendBroadcast(paramBundle);
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      finish();
      return false;
    }
    a();
    b();
    e();
    d();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqwifi\QQWiFiPluginInstallActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */