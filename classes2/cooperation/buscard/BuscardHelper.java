package cooperation.buscard;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.ReaderCallback;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import xym;

public class BuscardHelper
{
  public static final String a = "nfcIntent";
  private static final String b = "BuscardHelper";
  private static final String c = "com.tencent.mobileqq.buscard.BuscardAppInterface";
  
  public BuscardHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static IPluginManager.PluginParams a(Intent paramIntent, String paramString, ServiceConnection paramServiceConnection)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.b = "BuscardPlugin.apk";
    localPluginParams.d = "公交卡";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.tenpay.android.qqplugin.ipc.IpcService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    return localPluginParams;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BuscardHelper", 4, "createBuscardAppInterface processName=" + paramString);
    }
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.buscard.BuscardAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("BuscardHelper", 4, "*createBuscardAppInterface load class fail");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        if (QLog.isDevelopLevel()) {
          QLog.d("BuscardHelper", 4, "createBuscardAppInterface 1");
        }
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "BuscardPlugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.buscard.BuscardAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        if (QLog.isDevelopLevel()) {
          QLog.d("BuscardHelper", 4, "createBuscardAppInterface 2");
        }
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (QLog.isDevelopLevel()) {
          QLog.d("BuscardHelper", 4, "createBuscardAppInterface 3");
        }
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {}
    return null;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT < 19) || (paramActivity == null)) {
      return;
    }
    NfcAdapter.getDefaultAdapter(paramActivity).disableReaderMode(paramActivity);
  }
  
  public static void a(Activity paramActivity, NfcAdapter.ReaderCallback paramReaderCallback)
  {
    if ((Build.VERSION.SDK_INT < 19) || (paramActivity == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("presence", 3000);
    NfcAdapter.getDefaultAdapter(paramActivity).enableReaderMode(paramActivity, paramReaderCallback, 131, localBundle);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramActivity == null) {}
    NfcAdapter localNfcAdapter;
    for (;;)
    {
      return;
      try
      {
        if (Build.VERSION.SDK_INT >= 10)
        {
          localNfcAdapter = NfcAdapter.getDefaultAdapter(paramActivity);
          if ((localNfcAdapter == null) || (!localNfcAdapter.isEnabled()) || (!a(paramActivity)))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("BuscardHelper", 2, "nfcAdapter 不可用");
          }
        }
      }
      catch (Throwable paramActivity)
      {
        QLog.e("BuscardHelper", 2, "disableNFCEvent failed");
        return;
      }
    }
    if ((paramBoolean) || (a(paramString1, paramString2)))
    {
      localNfcAdapter.disableForegroundDispatch(paramActivity);
      return;
    }
    a(paramActivity);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2, NfcAdapter.ReaderCallback paramReaderCallback)
  {
    try
    {
      if (Build.VERSION.SDK_INT < 10) {
        return;
      }
      NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(paramActivity);
      if ((localNfcAdapter == null) || (!localNfcAdapter.isEnabled()) || (!a(paramActivity)))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("BuscardHelper", 2, "nfcAdapter 不可用");
        return;
      }
      if ((paramBoolean) || (a(paramString1, paramString2)))
      {
        paramString1 = PendingIntent.getActivity(paramActivity, 0, new Intent(paramActivity, paramActivity.getClass()).addFlags(536870912), 0);
        paramString2 = new String[] { IsoDep.class.getName() };
        paramReaderCallback = new String[] { NfcV.class.getName() };
        String[] arrayOfString1 = { NfcF.class.getName() };
        String[] arrayOfString2 = { MifareClassic.class.getName() };
        String[] arrayOfString3 = { NfcA.class.getName() };
        String[] arrayOfString4 = { NfcB.class.getName() };
        localNfcAdapter.enableForegroundDispatch(paramActivity, paramString1, new IntentFilter[] { new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*") }, new String[][] { paramString2, paramReaderCallback, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4 });
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      QLog.e("BuscardHelper", 2, "registerNFCEvent failed");
      return;
    }
    a(paramActivity, paramReaderCallback);
  }
  
  public static void a(String paramString, Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardHelper", 4, "before jumpBuscardPlugin ; action=android.nfc.action.TECH_DISCOVERED");
    }
    paramString = "{ \"viewTag\":\"busCard\", \"comeForm\":4, \"appInfo\":\"appid#0|bargainor_id#0|channel#qwallet_gotonfc\", \"userId\":\"" + paramString + "\" }";
    Parcelable localParcelable = paramIntent.getParcelableExtra("android.nfc.extra.TAG");
    paramIntent = new Bundle();
    paramIntent.putString("json", paramString);
    paramIntent.putString("callbackSn", "0");
    paramIntent.putParcelable("android.nfc.extra.TAG", localParcelable);
    paramString = new Intent();
    paramString.setClass(paramActivity, BuscardPluginInstallActivity.class);
    paramString.putExtras(paramIntent);
    paramActivity.startActivity(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardHelper", 4, "after jumpBuscardPlugin");
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    Intent localIntent;
    IPluginManager localIPluginManager;
    if ((paramIntent != null) && (paramAppRuntime != null))
    {
      localIntent = new Intent(paramIntent);
      paramIntent = (ResultReceiver)paramIntent.getParcelableExtra("result");
      localIPluginManager = (IPluginManager)paramAppRuntime.getManager(26);
      if ((localIPluginManager != null) && (localIPluginManager.isReady())) {
        break label91;
      }
      if (QLog.isColorLevel()) {
        QLog.w("BuscardHelper", 2, "loadBuscardService plugin has not ready,return!");
      }
      if (paramIntent != null)
      {
        paramAppRuntime = new Bundle();
        paramAppRuntime.putParcelable("nfcIntent", localIntent);
        paramIntent.send(-2, paramAppRuntime);
      }
    }
    label91:
    do
    {
      do
      {
        return;
        if (!localIPluginManager.isPlugininstalled("BuscardPlugin.apk")) {
          break;
        }
      } while (paramIntent == null);
      paramAppRuntime = new Bundle();
      paramAppRuntime.putParcelable("nfcIntent", localIntent);
      paramIntent.send(4, paramAppRuntime);
      return;
      localIPluginManager.installPlugin("BuscardPlugin.apk", new xym(paramAppRuntime, localIntent));
    } while (!QLog.isColorLevel());
    QLog.i("BuscardHelper", 2, "Plugin not installed,install first.");
  }
  
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getAccount());; localObject = "")
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setClass(paramAppRuntime.getApplication(), BuscardProxyService.class);
      paramIntent.putExtra("useSkinEngine", -1);
      paramIntent.putExtra("skey", (String)localObject);
      paramIntent.putExtra("uin", paramAppRuntime.getAccount());
      paramIntent.putExtra("qq_version", DeviceInfoUtil.c());
      paramIntent = a(paramIntent, paramAppRuntime.getAccount(), paramServiceConnection);
      IPluginManager.b(paramAppRuntime.getApplication(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("BuscardHelper", 2, "launchPluginService");
      }
      return;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission("android.permission.NFC", "com.tencent.mobileqq");
      if (i == 0) {
        bool = true;
      }
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BuscardHelper", 2, "checkPermission failed");
    }
    return bool;
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString1)) {}
    for (boolean bool1 = false;; bool1 = Boolean.parseBoolean(paramString1))
    {
      paramString1 = Build.MODEL;
      if ((bool1) && (Build.VERSION.SDK_INT >= 19))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString2))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString1))
          {
            bool1 = bool2;
            if (!paramString2.contains(paramString1)) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\buscard\BuscardHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */