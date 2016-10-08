package cooperation.qwallet.plugin;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.activity.qwallet.TenpayUtil;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qwallet.plugin.ipc.QWalletResultReceiver;
import cooperation.thirdpay.ThirdPayManager;
import cooperation.thirdpay.ThirdPayRemoteCommand;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import yjm;

public class QWalletHelper
{
  public static final String A = "QWalletExtra.MQQ.INFO.THR.RedPointInfo";
  public static final String B = "QWalletExtra.MQQ.INFO.THR.RedPointId";
  public static final String C = "QWalletExtra.MQQ.INFO.THR.RedPointDesc";
  public static final String D = "QWalletExtra.MQQ.INFO.THR.RedPointContent";
  public static final String E = "QWalletExtra.PayBridge.PayBundle";
  public static final String F = "QWalletExtra.PayBridge.isGetData";
  public static final String G = "QWalletExtra.PayBridge.PayTimeStart";
  public static final String H = "QWallet.load.beginTime";
  public static final String I = "report_seq";
  public static final String J = "is_need_open_pattern_lock";
  public static final String K = "QWalletExtra.isFling";
  public static final String L = "qwallet_multi";
  public static final String M = "is_refresh_home";
  public static final String N = "is_tenpay_yellowtip_valid";
  public static final String O = "is_refresh_center";
  public static final String P = "ads_update_time_prefix_";
  public static final String Q = "tenwatch_req_time_prefix_";
  public static final String R = "publicAcc_white_list";
  public static final String S = "ads_file_prefix_";
  public static final String T = "com.qwallet.refresh.home";
  public static final String U = "com.qwallet.refresh.center";
  public static final String V = "com.qwallet.activity.QWalletAppInterface";
  public static final String W = "QWalletExtra.PayBridge.LBS";
  private static final String X = "Q.qwallet.";
  private static final String Y = "com.tencent.mobileqq:tool";
  public static final long a = 1800000L;
  private static QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public static final String a = "Q.qwallet.pay";
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  public static boolean a = false;
  public static final long b = 7200000L;
  public static final String b = "Q.qwallet.home";
  private static boolean b = true;
  public static long c = -1L;
  public static final String c = "Q.qwallet.realevent";
  private static long d = 0L;
  public static final String d = "Q.qwallet.open";
  public static final String e = "Q.qwallet.push";
  public static final String f = "Q.qwallet.auth";
  public static final String g = "QWalletExtra.Account.Uin";
  public static final String h = "QWalletExtra.Account.NickName";
  public static final String i = "QWalletExtra.MQQ.APPID";
  public static final String j = "QWalletExtra.MQQ.GUID";
  public static final String k = "QWalletExtra.MQQ.Receiver";
  public static final String l = "QWalletExtra.Plugin.isloading";
  public static final String m = "QWalletExtra.Plugin.isRefreshHome";
  public static final String n = "QWalletExtra.MQQ.App.RedPointPath";
  public static final String o = "QWalletExtra.MQQ.App.RedPointInfo";
  public static final String p = "QWalletExtra.MQQ.App.RedPointBuf";
  public static final String q = "QWalletExtra.MQQ.App.RedPointId";
  public static final String r = "QWalletExtra.MQQ.App.RedPointPathThr";
  public static final String s = "QWalletExtra.MQQ.App.RedPointSubId";
  public static final String t = "QWalletExtra.MQQ.App.RedPointInfoThr";
  public static final String u = "QWalletExtra.MQQ.MSG.RedPointPath";
  public static final String v = "QWalletExtra.MQQ.MSG.RedPointInfo";
  public static final String w = "QWalletExtra.MQQ.MSG.RedPointBuf";
  public static final String x = "QWalletExtra.MQQ.INFO.TWO.RedPointPath";
  public static final String y = "QWalletExtra.MQQ.INFO.TWO.RedPointInfo";
  public static final String z = "QWalletExtra.MQQ.INFO.THR.RedPointPath";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0) {
      return localBaseApplicationImpl.getSharedPreferences("qwallet_multi", i1).getLong(paramString, 0L);
    }
  }
  
  public static QQAppInterface a()
  {
    return jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public static String a(String paramString)
  {
    return MD5.toMD5("qwallet_home_accountconfig_" + paramString);
  }
  
  public static HashMap a()
  {
    BaseApplicationImpl localBaseApplicationImpl;
    if ((jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      localBaseApplicationImpl = BaseApplicationImpl.a();
      if (Build.VERSION.SDK_INT <= 10) {
        break label52;
      }
    }
    label52:
    for (int i1 = 4;; i1 = 0)
    {
      a(localBaseApplicationImpl.getSharedPreferences("qwallet_multi", i1).getString("publicAcc_white_list", ""));
      return jdField_a_of_type_JavaUtilHashMap;
    }
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qwallet.activity.QWalletAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "qwallet_plugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.qwallet.activity.QWalletAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      if (!QLog.isColorLevel()) {
        break label100;
      }
      QLog.e("Q.qwallet.", 2, "*createQWalletAppInterface exception:" + paramBaseApplicationImpl.toString());
      label100:
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.", 2, "*createQWalletAppInterface load class fail");
      }
    }
    else
    {
      do
      {
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
  
  public static void a()
  {
    a(5000, "qwallet_default");
  }
  
  public static void a(int paramInt, String paramString)
  {
    ThreadManager.b().postDelayed(new yjm(paramString), paramInt);
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1"));
    localIntent.setAction("android.intent.action.VIEW");
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle, Dialog paramDialog, long paramLong)
  {
    boolean bool = true;
    if ((paramActivity == null) || (paramAppInterface == null)) {
      return;
    }
    if ((paramAppInterface instanceof QQAppInterface)) {
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    if ((paramActivity instanceof BaseActivity)) {
      a((BaseActivity)paramActivity);
    }
    String str;
    if (paramBundle.containsKey("tag"))
    {
      str = (String)paramBundle.get("tag");
      label62:
      if (paramDialog == null) {
        break label293;
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("userQqResources", 1);
      if ((!"graphb".equals(str)) && (jdField_a_of_type_Boolean)) {
        localIntent.putExtra("useSkinEngine", true);
      }
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("QWalletExtra.PayBridge.PayBundle", paramBundle);
      localIntent.putExtra("QWalletExtra.PayBridge.PayTimeStart", System.currentTimeMillis());
      if (paramLong != 0L) {
        localIntent.putExtra("report_seq", paramLong);
      }
      localIntent.putExtra("pluginsdk_disable_PatternLock", true);
      if (paramDialog != null) {}
      for (;;)
      {
        a(paramActivity, paramAppInterface, localIntent, bool);
        paramBundle = new IPluginManager.PluginParams(0);
        paramBundle.jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
        paramBundle.d = "QWallet";
        paramBundle.jdField_a_of_type_JavaLangString = paramAppInterface.a();
        paramBundle.e = "com.qwallet.activity.QvipPayBridgeActivity";
        paramBundle.jdField_a_of_type_JavaLangClass = QWalletPluginProxyActivity.class;
        paramBundle.jdField_a_of_type_AndroidContentIntent = localIntent;
        paramBundle.jdField_b_of_type_Int = 3001;
        paramBundle.jdField_a_of_type_AndroidAppDialog = paramDialog;
        paramBundle.jdField_a_of_type_Boolean = false;
        paramBundle.c = 10000;
        paramBundle.f = null;
        IPluginManager.a(paramActivity, paramBundle);
        if (paramLong == 0L) {
          break;
        }
        VACDReportUtil.a(paramLong, null, "plugin_begin", null, 0, null);
        return;
        str = null;
        break label62;
        label293:
        int i1;
        if ("graphb".equals(str)) {
          if (jdField_a_of_type_Boolean) {
            i1 = 0;
          }
        }
        for (;;)
        {
          if ((a(paramActivity)) || (i1 == 0)) {
            break label359;
          }
          paramDialog = new QWalletPayProgressDialog(paramActivity);
          paramDialog.show();
          break;
          i1 = 1;
          continue;
          i1 = 1;
        }
        bool = false;
      }
      label359:
      paramDialog = null;
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject2 = new JSONObject(paramString);
          if (localObject2 != null)
          {
            localObject1 = ((JSONObject)localObject2).optString("exec_code", "-1");
            paramString = ((JSONObject)localObject2).optString("url", "");
            localObject2 = ((JSONObject)localObject2).optString("uin", "");
            switch (Integer.valueOf((String)localObject1).intValue())
            {
            case 1: 
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                paramString = "mqqapi://im/chat?src_type=web&uin=" + (String)localObject2 + "&attach_content=&version=1&chat_type=c2c";
                localObject1 = new Intent(paramActivity, JumpActivity.class);
                ((Intent)localObject1).setData(Uri.parse(paramString));
                paramActivity.startActivity((Intent)localObject1);
                paramActivity.finish();
                return;
              }
              break;
            }
          }
        }
        catch (Exception paramActivity)
        {
          paramActivity.printStackTrace();
          return;
        }
      }
      paramString = new Intent(paramActivity, SplashActivity.class);
      paramString.putExtra("tab_index", MainFragment.a);
      paramString.setFlags(67108864);
      paramActivity.startActivity(paramString);
      paramActivity.finish();
      return;
    } while (TextUtils.isEmpty(paramString));
    Object localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramString);
    ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
    paramActivity.startActivity((Intent)localObject1);
    paramActivity.finish();
    return;
  }
  
  private static void a(Context paramContext, AppInterface paramAppInterface, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (paramIntent == null)) {
      return;
    }
    String str1 = paramAppInterface.a();
    String str2 = paramAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + str1);
    paramIntent.putExtra("QWalletExtra.Account.Uin", paramAppInterface.a());
    paramIntent.putExtra("QWalletExtra.Account.NickName", str2);
    paramIntent.putExtra("QWalletExtra.MQQ.APPID", AppSetting.a);
    paramIntent.putExtra("QWalletExtra.MQQ.GUID", NetConnInfoCenter.GUID);
    paramIntent.putExtra("QWalletExtra.MQQ.Receiver", QWalletResultReceiver.getInstance());
    paramIntent.putExtra("QWalletExtra.Plugin.isloading", paramBoolean);
    paramIntent.putExtra("QWalletExtra.Plugin.isRefreshHome", b);
    b = false;
    if (PatternLockUtils.a(paramContext, str1))
    {
      paramIntent.putExtra("pluginsdk_is_Use_QWallet_PatternLock", true);
      paramIntent.putExtra("pluginsdk_is_QWallet_PLock_Bg_interval_time", PatternLockUtils.b(paramContext, str1));
    }
    if (!GesturePWDUtils.getAppForground(paramContext)) {}
    for (paramBoolean = PatternLockUtils.a(paramContext, str1);; paramBoolean = PatternLockUtils.f(paramContext, str1))
    {
      paramIntent.putExtra("is_need_open_pattern_lock", paramBoolean);
      if (!paramBoolean) {
        break;
      }
      try
      {
        paramAppInterface = new Intent();
        paramAppInterface.setAction("com.tencent.mobileqq.gestureunlock");
        paramAppInterface.putExtra("timeid", System.currentTimeMillis());
        paramContext.sendBroadcast(paramAppInterface);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramAppInterface == null) || (paramBundle == null)) {
      return;
    }
    if ((paramAppInterface instanceof QQAppInterface)) {
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    PreloadProcHitPluginSession localPreloadProcHitPluginSession = new PreloadProcHitPluginSession("qwallet_data", "com.tencent.mobileqq:tool", "qwallet_plugin.apk");
    Intent localIntent = new Intent("cooperation.qwallet.QWALLET_PRELOAD");
    localIntent.putExtra("QWalletExtra.PayBridge.isGetData", true);
    localIntent.putExtra("QWalletExtra.PayBridge.PayBundle", paramBundle);
    localIntent.putExtra("QWalletExtra.PayBridge.PayTimeStart", System.currentTimeMillis());
    a(paramContext, paramAppInterface, localIntent, false);
    paramAppInterface = new IPluginManager.PluginParams(0);
    paramAppInterface.jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
    paramAppInterface.d = "Wallet";
    paramAppInterface.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = localPreloadProcHitPluginSession;
    paramAppInterface.e = "com.qwallet.receiver.QWallPreloadReceiver";
    paramAppInterface.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramContext, paramAppInterface);
  }
  
  private static void a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.addObserver(ThirdPayManager.a());
    ThirdPayRemoteCommand.a();
  }
  
  public static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    boolean bool = PatternLockUtils.f(paramBaseActivity, paramQQAppInterface.a());
    long l1 = VACDReportUtil.a(null, "qqwallet", "homepage", "click", null, 0, null);
    d = System.currentTimeMillis();
    if (a(paramBaseActivity))
    {
      a(paramBaseActivity, paramQQAppInterface, l1, null);
      return;
    }
    QWalletLoadingDialog localQWalletLoadingDialog = new QWalletLoadingDialog(paramBaseActivity, bool);
    localQWalletLoadingDialog.show();
    a(paramBaseActivity, paramQQAppInterface, l1, localQWalletLoadingDialog);
  }
  
  private static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, long paramLong, QWalletLoadingDialog paramQWalletLoadingDialog)
  {
    boolean bool = true;
    if ((paramBaseActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramBaseActivity);
    Intent localIntent = new Intent();
    localIntent.putExtra("userQqResources", 1);
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("QWallet.load.beginTime", d);
    localIntent.putExtra("QWalletExtra.isFling", true);
    if (SosoInterface.a() != null) {
      localIntent.putExtra("QWalletExtra.PayBridge.LBS", SosoInterface.a());
    }
    if (paramLong != 0L) {
      localIntent.putExtra("report_seq", paramLong);
    }
    if (paramQWalletLoadingDialog != null) {}
    for (;;)
    {
      a(paramBaseActivity, paramQQAppInterface, localIntent, bool);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
      localPluginParams.d = "QWallet";
      localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      localPluginParams.e = "com.qwallet.activity.QvipPayWalletActivity";
      localPluginParams.jdField_a_of_type_JavaLangClass = QWalletPluginProxyActivity.class;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      localPluginParams.jdField_b_of_type_Int = -1;
      localPluginParams.jdField_a_of_type_AndroidAppDialog = paramQWalletLoadingDialog;
      localPluginParams.jdField_a_of_type_Boolean = false;
      localPluginParams.c = 10000;
      localPluginParams.f = null;
      IPluginManager.a(paramBaseActivity, localPluginParams);
      if (paramLong == 0L) {
        break;
      }
      VACDReportUtil.a(paramLong, null, "plugin_begin", null, 0, null);
      return;
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      int i1 = paramString.indexOf("://qpay.qq.com/qr/");
      if (i1 == -1) {
        continue;
      }
      paramString = paramString.substring(i1 + "://qpay.qq.com/qr/".length());
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("tokenId", paramString);
        ((JSONObject)localObject).put("comeForm", "3");
        paramString = ((JSONObject)localObject).toString();
        if (paramString == null) {
          continue;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("payparmas_callback_sn", "0");
        ((Bundle)localObject).putString("payparmas_json", paramString);
        ((Bundle)localObject).putInt("payparmas_paytype", 8);
        ((Bundle)localObject).putString("payparmas_url_appinfo", "appid#3155944709|bargainor_id#|channel#offline");
        PayBridgeActivity.a(paramQQAppInterface, paramActivity, null, 9, (Bundle)localObject);
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 == 1)
      {
        jdField_a_of_type_Boolean = bool;
        return;
      }
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        int i1 = 0;
        continue;
        bool = false;
      }
    }
  }
  
  public static void a(String paramString)
  {
    int i1;
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap(16);
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      String[] arrayOfString = paramString.split("\\|");
      if (arrayOfString == null) {
        return;
      }
      int i2 = arrayOfString.length;
      i1 = 0;
      label44:
      if (i1 >= i2) {
        return;
      }
      paramString = arrayOfString[i1];
      if (!TextUtils.isEmpty(paramString)) {
        break label81;
      }
    }
    label81:
    do
    {
      i1 += 1;
      break label44;
      jdField_a_of_type_JavaUtilHashMap.clear();
      break;
      paramString = paramString.split("#");
    } while ((paramString == null) || (TextUtils.isEmpty(paramString[0])));
    HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
    Object localObject = paramString[0];
    if (paramString.length > 1) {}
    for (paramString = paramString[1];; paramString = "0")
    {
      localHashMap.put(localObject, paramString);
      break;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = paramContext.getSharedPreferences("qwallet_patternlock", 4).getBoolean("is_need_sync" + paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay", 2, "getSyncPatternLockState.uin=" + paramString + ",isNeedSync=" + bool);
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (NetConnInfoCenter.getServerTimeMillis() - a(paramString) < 1800000L) {
      return false;
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    return MD5.toMD5("qwallet_home_personalInfo_" + paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      VACDReportMgr localVACDReportMgr = (VACDReportMgr)paramQQAppInterface.getManager(147);
      if (localVACDReportMgr != null) {
        localVACDReportMgr.onDestroy();
      }
    }
    b = true;
    if ((jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface)) {
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    QWalletResultReceiver.clear();
    HbThemeConfigManager.a().a();
    PreloadImgManager.a().b();
    CustomizeStrategyFactory.a().a();
    TenpayUtil.a();
    c = -1L;
  }
  
  /* Error */
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokestatic 479	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 212	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 840
    //   24: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: bipush 124
    //   29: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 639	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   36: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: bipush 124
    //   41: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   44: ldc -17
    //   46: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: bipush 124
    //   51: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   54: ldc_w 845
    //   57: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: bipush 124
    //   62: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   65: ldc_w 847
    //   68: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: bipush 124
    //   73: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   76: iconst_0
    //   77: invokevirtual 850	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: bipush 124
    //   82: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: iconst_1
    //   86: invokevirtual 850	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: bipush 124
    //   91: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   94: iconst_0
    //   95: invokevirtual 850	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: bipush 124
    //   100: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   103: ldc -17
    //   105: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: bipush 124
    //   110: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   113: ldc -17
    //   115: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: bipush 124
    //   120: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   123: ldc -17
    //   125: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: bipush 124
    //   130: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   133: ldc -17
    //   135: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: bipush 124
    //   140: invokevirtual 843	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aconst_null
    //   145: invokestatic 855	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   148: aload_0
    //   149: aload_3
    //   150: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokevirtual 858	com/tencent/mobileqq/statistics/StatisticCollector:c	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   156: aload_2
    //   157: bipush 63
    //   159: invokevirtual 861	java/lang/String:indexOf	(I)I
    //   162: istore 8
    //   164: iload 8
    //   166: iconst_m1
    //   167: if_icmpeq -156 -> 11
    //   170: aload_2
    //   171: iload 8
    //   173: iconst_1
    //   174: iadd
    //   175: invokevirtual 686	java/lang/String:substring	(I)Ljava/lang/String;
    //   178: ldc_w 863
    //   181: invokevirtual 739	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   184: astore 5
    //   186: new 233	java/util/HashMap
    //   189: dup
    //   190: invokespecial 864	java/util/HashMap:<init>	()V
    //   193: astore 4
    //   195: aload 5
    //   197: arraylength
    //   198: istore 9
    //   200: iconst_0
    //   201: istore 8
    //   203: iload 8
    //   205: iload 9
    //   207: if_icmpge +106 -> 313
    //   210: aload 5
    //   212: iload 8
    //   214: aaload
    //   215: invokestatic 479	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifeq +6 -> 224
    //   221: goto +459 -> 680
    //   224: aload 5
    //   226: iload 8
    //   228: aaload
    //   229: bipush 61
    //   231: invokevirtual 861	java/lang/String:indexOf	(I)I
    //   234: istore 10
    //   236: iload 10
    //   238: iconst_m1
    //   239: if_icmpeq +441 -> 680
    //   242: aload 5
    //   244: iload 8
    //   246: aaload
    //   247: iconst_0
    //   248: iload 10
    //   250: invokevirtual 867	java/lang/String:substring	(II)Ljava/lang/String;
    //   253: astore 6
    //   255: aload 5
    //   257: iload 8
    //   259: aaload
    //   260: iload 10
    //   262: iconst_1
    //   263: iadd
    //   264: invokevirtual 686	java/lang/String:substring	(I)Ljava/lang/String;
    //   267: ldc_w 869
    //   270: invokestatic 874	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   273: astore_3
    //   274: aload 6
    //   276: invokestatic 479	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifne +401 -> 680
    //   282: aload 4
    //   284: aload 6
    //   286: aload_3
    //   287: invokeinterface 877 3 0
    //   292: pop
    //   293: goto +387 -> 680
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 518	java/lang/Exception:printStackTrace	()V
    //   301: return
    //   302: astore_3
    //   303: aload_3
    //   304: invokevirtual 518	java/lang/Exception:printStackTrace	()V
    //   307: ldc -17
    //   309: astore_3
    //   310: goto -36 -> 274
    //   313: aload 4
    //   315: invokeinterface 880 1 0
    //   320: ifle -309 -> 11
    //   323: aload 4
    //   325: ldc_w 881
    //   328: invokeinterface 884 2 0
    //   333: checkcast 371	java/lang/String
    //   336: astore_3
    //   337: aload 4
    //   339: ldc_w 885
    //   342: invokeinterface 884 2 0
    //   347: checkcast 371	java/lang/String
    //   350: astore 5
    //   352: aload_3
    //   353: invokestatic 479	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne -345 -> 11
    //   359: aload 5
    //   361: invokestatic 479	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   364: ifne -353 -> 11
    //   367: aload_3
    //   368: ldc_w 887
    //   371: invokevirtual 781	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   374: ifne -363 -> 11
    //   377: aload 5
    //   379: ldc_w 889
    //   382: invokevirtual 781	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   385: ifne -374 -> 11
    //   388: aload 4
    //   390: ldc_w 890
    //   393: invokeinterface 884 2 0
    //   398: checkcast 371	java/lang/String
    //   401: astore 5
    //   403: aload 4
    //   405: ldc_w 891
    //   408: invokeinterface 884 2 0
    //   413: checkcast 371	java/lang/String
    //   416: astore 6
    //   418: aload 4
    //   420: ldc_w 892
    //   423: invokeinterface 884 2 0
    //   428: checkcast 371	java/lang/String
    //   431: astore_3
    //   432: aload_3
    //   433: invokestatic 479	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   436: ifne +204 -> 640
    //   439: aload_3
    //   440: ldc_w 894
    //   443: invokevirtual 781	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   446: ifeq +194 -> 640
    //   449: new 212	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 896
    //   459: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_3
    //   463: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: astore_3
    //   470: new 481	org/json/JSONObject
    //   473: dup
    //   474: invokespecial 687	org/json/JSONObject:<init>	()V
    //   477: astore 4
    //   479: new 481	org/json/JSONObject
    //   482: dup
    //   483: invokespecial 687	org/json/JSONObject:<init>	()V
    //   486: astore 7
    //   488: aload 7
    //   490: ldc_w 491
    //   493: aload_2
    //   494: invokevirtual 693	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   497: pop
    //   498: aload 7
    //   500: ldc_w 493
    //   503: aload 5
    //   505: invokevirtual 693	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   508: pop
    //   509: aload 7
    //   511: ldc_w 898
    //   514: aload 6
    //   516: invokevirtual 693	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   519: pop
    //   520: aload 4
    //   522: ldc_w 900
    //   525: aload_0
    //   526: invokevirtual 639	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   529: invokevirtual 693	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   532: pop
    //   533: aload 4
    //   535: ldc_w 902
    //   538: ldc_w 904
    //   541: invokevirtual 693	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   544: pop
    //   545: aload 4
    //   547: ldc_w 906
    //   550: aload_3
    //   551: invokevirtual 693	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   554: pop
    //   555: aload 4
    //   557: ldc_w 908
    //   560: iconst_5
    //   561: invokevirtual 911	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   564: pop
    //   565: aload 4
    //   567: ldc_w 913
    //   570: aload 7
    //   572: invokevirtual 693	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   575: pop
    //   576: new 361	android/os/Bundle
    //   579: dup
    //   580: invokespecial 699	android/os/Bundle:<init>	()V
    //   583: astore_0
    //   584: aload_0
    //   585: ldc_w 915
    //   588: aload 4
    //   590: invokevirtual 698	org/json/JSONObject:toString	()Ljava/lang/String;
    //   593: invokevirtual 707	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: aload_0
    //   597: ldc_w 917
    //   600: ldc_w 703
    //   603: invokevirtual 707	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: new 324	android/content/Intent
    //   609: dup
    //   610: aload_1
    //   611: ldc_w 721
    //   614: invokespecial 512	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   617: astore_2
    //   618: aload_2
    //   619: aload_0
    //   620: invokevirtual 921	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   623: pop
    //   624: aload_2
    //   625: ldc_w 923
    //   628: iconst_5
    //   629: invokevirtual 377	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   632: pop
    //   633: aload_1
    //   634: aload_2
    //   635: iconst_1
    //   636: invokevirtual 927	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   639: return
    //   640: new 212	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 896
    //   650: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: ldc_w 929
    //   656: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: astore_3
    //   663: goto -193 -> 470
    //   666: astore_0
    //   667: invokestatic 932	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   670: ifeq -94 -> 576
    //   673: aload_0
    //   674: invokevirtual 518	java/lang/Exception:printStackTrace	()V
    //   677: goto -101 -> 576
    //   680: iload 8
    //   682: iconst_1
    //   683: iadd
    //   684: istore 8
    //   686: goto -483 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	paramQQAppInterface	QQAppInterface
    //   0	689	1	paramActivity	Activity
    //   0	689	2	paramString	String
    //   19	268	3	localObject1	Object
    //   302	2	3	localException	Exception
    //   309	354	3	str1	String
    //   193	396	4	localObject2	Object
    //   184	320	5	localObject3	Object
    //   253	262	6	str2	String
    //   486	85	7	localJSONObject	JSONObject
    //   162	523	8	i1	int
    //   198	10	9	i2	int
    //   234	30	10	i3	int
    // Exception table:
    //   from	to	target	type
    //   170	200	296	java/lang/Exception
    //   210	221	296	java/lang/Exception
    //   224	236	296	java/lang/Exception
    //   242	255	296	java/lang/Exception
    //   274	293	296	java/lang/Exception
    //   303	307	296	java/lang/Exception
    //   313	470	296	java/lang/Exception
    //   470	479	296	java/lang/Exception
    //   576	639	296	java/lang/Exception
    //   640	663	296	java/lang/Exception
    //   667	677	296	java/lang/Exception
    //   255	274	302	java/lang/Exception
    //   479	576	666	java/lang/Exception
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localBaseApplicationImpl.getSharedPreferences("qwallet_multi", i1).edit().putLong(paramString, NetConnInfoCenter.getServerTimeMillis());
      return;
    }
  }
  
  public static String c(String paramString)
  {
    return MD5.toMD5("qwallet_home_personalscore_" + paramString);
  }
  
  public static void c(QQAppInterface paramQQAppInterface) {}
  
  public static String d(String paramString)
  {
    return MD5.toMD5("qwallet_home_recomment_" + paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\QWalletHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */