package cooperation.buscard;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.proxy.QWalletNFCProxyActivity;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import xyn;
import xyp;
import xyq;

public class BuscardPluginInstallActivity
  extends BaseActivity
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = BuscardPluginInstallActivity.class.getSimpleName();
  public long a;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new xyp(this);
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private BuscardPluginRemoteCommand jdField_a_of_type_CooperationBuscardBuscardPluginRemoteCommand;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  protected QWalletPayProgressDialog a;
  private xyq jdField_a_of_type_Xyq;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BuscardPluginInstallActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("com.tenpay.android.qqplugin.activity.");
    if ((paramString == null) && (this.c != null)) {
      localStringBuffer.append("RedepositActivity");
    }
    if (("experience".equals(paramString)) || ("recharge".equals(paramString))) {
      localStringBuffer.append("BusCardActivity");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if ("load".equals(paramString)) {
        localStringBuffer.append("RedepositActivity");
      } else if ("friends".equals(paramString)) {
        localStringBuffer.append("FriendsActivity");
      } else if ("replace_load".equals(paramString)) {
        localStringBuffer.append("ReplaceLoadActivity");
      } else {
        localStringBuffer.append("BusCardActivity");
      }
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "step4:cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "goPlugin " + paramString);
    }
    for (;;)
    {
      try
      {
        localObject3 = getApplicationContext();
        if (!BridgeHelper.a("BuscardPlugin.apk", this.app.a(), (Context)localObject3)) {
          continue;
        }
        localObject1 = (TicketManager)this.app.getManager(2);
        if (localObject1 == null) {
          break label748;
        }
        str1 = ((TicketManager)localObject1).getSkey(this.app.a());
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("mPluginType", 1);
        ((JSONObject)localObject1).put("mPluginID", "BuscardPlugin.apk");
        ((JSONObject)localObject1).put("mPluginName", "公交卡");
        ((JSONObject)localObject1).put("mConponentName", a(this.jdField_b_of_type_JavaLangString));
        ((JSONObject)localObject1).put("mProxyActivityClass", QWalletNFCProxyActivity.class.getName());
        ((JSONObject)localObject1).put("mRequestCode", 19);
        ((JSONObject)localObject1).put("mTimeOut", 15000);
        ((JSONObject)localObject1).put("mDialogDismissBySDK", false);
        ((JSONObject)localObject1).put("skey", str1);
        ((JSONObject)localObject1).put("skey_type", 2);
        ((JSONObject)localObject1).put("font_level", FontSettingManager.a());
        localObject2 = ((JSONObject)localObject1).toString();
        if (getIntent() == null) {
          continue;
        }
        localObject1 = getIntent();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          String str1 = BridgeHelper.a((Context)localObject3, this.app.a()).a("buscard_pluginNewNfcAPIFlag");
          localObject3 = BridgeHelper.a((Context)localObject3, this.app.a()).a("buscard_pluginNewNfcAPIBlackModel");
          ((Intent)localObject1).putExtra("buscard_pluginNewNfcAPIFlag", str1);
          ((Intent)localObject1).putExtra("buscard_pluginNewNfcAPIBlackModel", (String)localObject3);
          BridgeHelper.a(this, this.app, (Intent)localObject1, (String)localObject2, "BuscardPlugin.apk", "公交卡");
          this.jdField_a_of_type_CooperationBuscardBuscardPluginRemoteCommand = new BuscardPluginRemoteCommand();
          this.jdField_a_of_type_CooperationBuscardBuscardPluginRemoteCommand.a();
          return;
          Object localObject1 = new Intent();
          continue;
          localThrowable1 = localThrowable1;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          localObject1 = jdField_a_of_type_JavaLangString;
          Object localObject2 = new StringBuilder().append("go brigde Plugin failed;where=").append(paramString).append("; app.getCurrentAccountUin()=");
          if (this.app.a() == null) {
            continue;
          }
          paramString = this.app.a();
          localObject2 = ((StringBuilder)localObject2).append(paramString).append("; error=");
          if ((localThrowable1 == null) || (localThrowable1.getMessage() == null)) {
            continue;
          }
          paramString = localThrowable1.getMessage();
          QLog.i((String)localObject1, 4, paramString);
          boolean bool = this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("BuscardPlugin.apk");
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 4, "installed=" + bool);
          if (!bool) {
            continue;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 4, "step5:cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          g();
          return;
        }
        catch (Throwable localThrowable2)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          Object localObject3 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder().append("go brigde Plugin failed; error=");
          if ((localThrowable2 == null) || (localThrowable2.getMessage() == null)) {
            continue;
          }
          str2 = localThrowable2.getMessage();
          QLog.i((String)localObject3, 4, str2);
          continue;
          str2 = "null";
          continue;
          paramString = "null";
          continue;
          paramString = "null";
          continue;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 4, "step6:cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("BuscardPlugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
          return;
        }
      }
      ((Intent)localObject1).putExtra("skey", str1);
      ((Intent)localObject1).putExtra("skey_type", "2");
      ((Intent)localObject1).putExtra("qq_version", DeviceInfoUtil.c());
      ((Intent)localObject1).putExtra("params_remote_connect_at_launch", true);
      ((Intent)localObject1).addFlags(67108864);
      label748:
      String str2 = "";
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = super.isFinishing();
    if (paramBoolean) {
      if (!bool)
      {
        if (this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) {
          break label28;
        }
        this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      }
    }
    label28:
    while ((this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) || (!this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.isShowing()))
    {
      return;
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setMessage("正在加载应用");
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "initPluginManager");
    }
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    if (QLog.isDevelopLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("mPluginManager.SUPPORT_NETWORKING = ");
      IPluginManager localIPluginManager = this.jdField_a_of_type_CooperationPluginIPluginManager;
      QLog.i((String)localObject, 4, true);
    }
    a(true);
    Object localObject = new xyn(this);
    ThreadManager.b().post((Runnable)localObject);
  }
  
  private void g()
  {
    PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putLong("KEY_BUSCARD_PLUGIN_CREATE_TIME", System.currentTimeMillis()).commit();
    Object localObject1 = (TicketManager)this.app.getManager(2);
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = ((TicketManager)localObject1).getSkey(this.app.a());
    }
    String str2;
    StringBuilder localStringBuilder;
    for (;;)
    {
      if (getIntent() != null)
      {
        localObject1 = getIntent();
        ((Intent)localObject1).putExtra("skey", (String)localObject2);
        ((Intent)localObject1).putExtra("skey_type", "2");
        ((Intent)localObject1).putExtra("font_level", FontSettingManager.a());
        if (this.c != null) {
          ((Intent)localObject1).putExtra("pay_result", this.c);
        }
        ((Intent)localObject1).putExtra("param_plugin_gesturelock", true);
        ((Intent)localObject1).putExtra("qq_version", DeviceInfoUtil.c());
        ((Intent)localObject1).putExtra("params_remote_connect_at_launch", true);
        ((Intent)localObject1).addFlags(67108864);
      }
      try
      {
        localObject2 = BridgeHelper.a(getApplicationContext(), this.app.a()).a("buscard_pluginNewNfcAPIFlag");
        str2 = BridgeHelper.a(getApplicationContext(), this.app.a()).a("buscard_pluginNewNfcAPIBlackModel");
        ((Intent)localObject1).putExtra("buscard_pluginNewNfcAPIFlag", (String)localObject2);
        ((Intent)localObject1).putExtra("buscard_pluginNewNfcAPIBlackModel", str2);
        localObject2 = new IPluginManager.PluginParams(1);
        ((IPluginManager.PluginParams)localObject2).jdField_b_of_type_JavaLangString = "BuscardPlugin.apk";
        ((IPluginManager.PluginParams)localObject2).d = "BuscardPlugin";
        ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidAppDialog = null;
        ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_JavaLangString = this.app.a();
        ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidContentIntent = ((Intent)localObject1);
        ((IPluginManager.PluginParams)localObject2).e = a(this.jdField_b_of_type_JavaLangString);
        ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_JavaLangClass = QWalletNFCProxyActivity.class;
        ((IPluginManager.PluginParams)localObject2).jdField_b_of_type_Int = 19;
        ((IPluginManager.PluginParams)localObject2).c = 15000;
        ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_Boolean = false;
        ((IPluginManager.PluginParams)localObject2).f = null;
        IPluginManager.a(this, (IPluginManager.PluginParams)localObject2);
        this.jdField_a_of_type_CooperationBuscardBuscardPluginRemoteCommand = new BuscardPluginRemoteCommand();
        this.jdField_a_of_type_CooperationBuscardBuscardPluginRemoteCommand.a();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("ret", "ok");
        setResult(-1, (Intent)localObject1);
        if (QLog.isDevelopLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString, 4, "step7:cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        finish();
        return;
        localObject2 = "";
        continue;
        localObject1 = new Intent();
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isDevelopLevel()) {}
        str2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("go brigde Plugin failed; error=");
        if (localThrowable == null) {
          break label487;
        }
      }
    }
    if (localThrowable.getMessage() != null) {}
    label487:
    for (String str1 = localThrowable.getMessage();; str1 = "null")
    {
      QLog.i(str2, 4, str1);
      break;
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      finish();
      return false;
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("bridge.plugin.onresume.broadcast");
    this.jdField_a_of_type_Xyq = new xyq(this, null);
    registerReceiver(this.jdField_a_of_type_Xyq, paramBundle);
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      paramBundle = localIntent.getStringExtra("options");
      if (paramBundle == null) {}
    }
    String str;
    StringBuilder localStringBuilder;
    try
    {
      this.jdField_b_of_type_JavaLangString = new JSONObject(paramBundle).optString("tag");
      this.c = localIntent.getDataString();
      if (QLog.isDevelopLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "step1:cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      f();
      return true;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isDevelopLevel()) {}
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("mPluginManager.queryPlugin->error:");
      if (paramBundle == null) {
        break label256;
      }
    }
    if (paramBundle.getMessage() != null) {}
    label256:
    for (paramBundle = paramBundle.getMessage();; paramBundle = "null")
    {
      QLog.e(str, 4, paramBundle);
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    String str2;
    StringBuilder localStringBuilder;
    try
    {
      if (this.jdField_a_of_type_Xyq != null) {
        unregisterReceiver(this.jdField_a_of_type_Xyq);
      }
      a(false);
      super.doOnDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      str2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("doOnDestroy->error:");
      if (localThrowable == null) {
        break label82;
      }
    }
    if (localThrowable.getMessage() != null) {}
    label82:
    for (String str1 = localThrowable.getMessage();; str1 = "null")
    {
      QLog.e(str2, 4, str1);
      break;
    }
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onInstallBegin, pluginId:");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "onActivityResult:requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if ((paramInt1 != 1) || (paramInt2 == 0)) {}
    for (;;)
    {
      if ((paramInt1 == 19) && ((paramInt2 == 20) || (paramInt2 == 4865))) {
        finish();
      }
      return;
      a("onActivityResult");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\buscard\BuscardPluginInstallActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */