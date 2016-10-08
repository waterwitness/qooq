package cooperation.qwallet.plugin;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.DebugHelper;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.proxy.BuscardLoadNFCProxyActivity;
import cooperation.qwallet.plugin.proxy.QWalletNFCProxyActivity;
import cooperation.thirdpay.ThirdPayPluginProxyActivity;
import yjr;

public class QWalletPluginProxyActivity
  extends PluginProxyActivity
{
  public static final String a = "pluginsdk_disable_PatternLock";
  private static long b = -1L;
  public static final String b = "pluginsdk_is_Use_QWallet_PatternLock";
  public static final String c = "pluginsdk_is_QWallet_PLock_Bg_interval_time";
  public static final String d = "pluginsdk_QWallet_PatternLock_closeAll";
  private long jdField_a_of_type_Long;
  private yjr jdField_a_of_type_Yjr;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool2;
    try
    {
      localObject = getIntent().getBundleExtra("pluginsdk_inner_intent_extras");
      bool1 = bool3;
      if (localObject != null)
      {
        bool1 = bool2;
        if (b < 0L)
        {
          bool1 = bool2;
          b = ((Bundle)localObject).getLong("pluginsdk_is_QWallet_PLock_Bg_interval_time", -1L);
        }
        bool1 = bool2;
        bool2 = ((Bundle)localObject).getBoolean("pluginsdk_is_Use_QWallet_PatternLock", false);
        bool1 = bool2;
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = getIntent().getBooleanExtra("pluginsdk_is_Use_QWallet_PatternLock", false);
      }
      bool3 = bool2;
      bool1 = bool2;
      if (b < 0L)
      {
        bool1 = bool2;
        b = getIntent().getLongExtra("pluginsdk_is_QWallet_PLock_Bg_interval_time", -1L);
        bool3 = bool2;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          this.jdField_a_of_type_Yjr = new yjr(this, null);
          Object localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("pluginsdk_QWallet_PatternLock_closeAll");
          registerReceiver(this.jdField_a_of_type_Yjr, (IntentFilter)localObject);
          return;
          localException1 = localException1;
          bool3 = bool1;
        } while (!DebugHelper.sDebug);
        DebugHelper.log("plugin_tag", "qwallet read data exception.", localException1);
        bool3 = bool1;
      }
      catch (Exception localException2)
      {
        while (!DebugHelper.sDebug) {}
        DebugHelper.log("plugin_tag", "register exception.", localException2);
      }
    }
    if (bool3) {}
  }
  
  protected Bundle a()
  {
    if ((this.mPluginActivity instanceof BasePluginActivity))
    {
      BasePluginActivity localBasePluginActivity = (BasePluginActivity)this.mPluginActivity;
      if (localBasePluginActivity.getIntent() != null) {
        return localBasePluginActivity.getIntent().getExtras();
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (b > 0L))
    {
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long + b > l) {
        return;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugintest", 2, "startQWalletUnlockActivity");
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("action_mode", 1);
      localIntent.putExtra("is_for_entrance", true);
      localIntent.putExtra("is_from_background", true);
      localIntent.putExtra("pluginsdk_disable_PatternLock", true);
      startPluginActivityForResult(this, "com.qwallet.activity.patternlock.PatternLockActivity", localIntent, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean enablePatternLock()
  {
    Bundle localBundle = a();
    if (localBundle != null)
    {
      if (localBundle.getBoolean("pluginsdk_disable_PatternLock", false)) {
        return false;
      }
      if (super.enablePatternLock()) {
        return true;
      }
      return localBundle.getBoolean("pluginsdk_is_Use_QWallet_PatternLock", false);
    }
    return super.enablePatternLock();
  }
  
  public String getPluginID()
  {
    return "qwallet_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if ("cooperation.thirdpay.CardPayPluginProxyActivity".equals(paramString)) {
      return ThirdPayPluginProxyActivity.class;
    }
    if ("com.tenpay.android.qqplugin.activity.BusCardActivity".equals(paramString)) {
      return QWalletNFCProxyActivity.class;
    }
    if ("com.tenpay.android.qqplugin.activity.RedepositActivity".equals(paramString)) {
      return BuscardLoadNFCProxyActivity.class;
    }
    return QWalletPluginProxyActivity.class;
  }
  
  protected boolean isPatternLockOpened()
  {
    Bundle localBundle = a();
    if (localBundle != null)
    {
      if (localBundle.getBoolean("pluginsdk_disable_PatternLock", false)) {
        return false;
      }
      if (localBundle.getBoolean("pluginsdk_is_Use_QWallet_PatternLock", false)) {
        return true;
      }
    }
    return super.isPatternLockOpened();
  }
  
  protected boolean isWrapContent()
  {
    boolean bool = false;
    if (super.getIntent() != null) {
      bool = super.getIntent().getBooleanExtra("QWalletExtra.isFling", false);
    }
    return bool;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.jdField_a_of_type_Yjr != null) {
        unregisterReceiver(this.jdField_a_of_type_Yjr);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onStop()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    super.onStop();
  }
  
  protected void startUnlockActivity(boolean paramBoolean)
  {
    Bundle localBundle = a();
    if ((localBundle != null) && (localBundle.getBoolean("pluginsdk_is_Use_QWallet_PatternLock", false)))
    {
      a(paramBoolean);
      return;
    }
    super.startUnlockActivity(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\QWalletPluginProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */