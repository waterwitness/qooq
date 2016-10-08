package cooperation.qqhotspot.hotspotnode;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.QQHotSpotHelper.AP;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeAPInfo;
import cooperation.qqhotspot.QQHotSpotHelper.HotSpotNodeApEx;
import cooperation.qqhotspot.WifiConversationManager;
import cooperation.qqhotspot.WifiConversationManager.FocusApInfo;
import cooperation.qqhotspot.WifiNetworkUtil;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheckResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import yhf;
import yhg;

public class HotSpotNodeUtil
{
  static final int jdField_a_of_type_Int = 0;
  private static final long jdField_a_of_type_Long = 3600000L;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static SosoInterface.SosoLbsInfo jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  public static final String a = "qq_hotspot_config";
  static final int jdField_b_of_type_Int = 1;
  private static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "HotSpotNodeUtil";
  private static final String c = "qq_hotspot_lasttime_shownode";
  private static final String d = "qq_hotspot_lasttime_showsamenode";
  
  public HotSpotNodeUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a()
  {
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("qq_hotspot_config", i).getString("max_interval_shownode_time", "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      try
      {
        long l = Long.parseLong((String)localObject);
        return l;
      }
      catch (Exception localException)
      {
        return 1800000L;
      }
    }
    return 1800000L;
  }
  
  public static long a(int paramInt)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.a().a();
    localObject = ((QQAppInterface)localObject).a().getSharedPreferences(((QQAppInterface)localObject).a(), 0);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HotSpotNodeUtil", 2, "getLastShowNodeTime()" + ((SharedPreferences)localObject).getLong("qq_hotspot_lasttime_shownode", 0L));
      }
      return ((SharedPreferences)localObject).getLong("qq_hotspot_lasttime_shownode", 0L);
    }
    if (paramInt == 1) {
      return ((SharedPreferences)localObject).getLong("qq_hotspot_lasttime_showsamenode", 0L);
    }
    return 0L;
  }
  
  public static Bundle a()
  {
    String str = null;
    Bundle localBundle = new Bundle();
    if (!WifiNetworkUtil.c())
    {
      localBundle.putBoolean("isSureResult", true);
      return localBundle;
    }
    Object localObject2 = (HashMap)HotSpotNodeCacheManager.a().a();
    WifiConversationManager.FocusApInfo localFocusApInfo = WifiConversationManager.a().a();
    int i;
    if ((localFocusApInfo != null) && (localFocusApInfo.a != null))
    {
      localObject1 = str;
      if (((HashMap)localObject2).get(localFocusApInfo.a.Apinfo.BSSID) != null)
      {
        localObject2 = (ArrayList)((HashMap)localObject2).get(localFocusApInfo.a.Apinfo.BSSID);
        i = 0;
        localObject1 = str;
        if (i < ((ArrayList)localObject2).size())
        {
          if (!WifiNetworkUtil.a(((QQHotSpotHelper.HotSpotNodeAPInfo)((ArrayList)localObject2).get(i)).mApInfo.SSID, localFocusApInfo.a.Apinfo.SSID)) {
            break label189;
          }
          localObject1 = (QQHotSpotHelper.HotSpotNodeAPInfo)((ArrayList)localObject2).get(i);
        }
      }
      if (localObject1 != null)
      {
        localBundle.putBoolean("isSureResult", true);
        localBundle.putSerializable("HotSpotNodeAPInfo", new QQHotSpotHelper.HotSpotNodeAPInfo(localFocusApInfo.a.Apinfo, ((QQHotSpotHelper.HotSpotNodeAPInfo)localObject1).mApInfoEx));
      }
      for (;;)
      {
        return localBundle;
        label189:
        i += 1;
        break;
        localBundle.putBoolean("isSureResult", false);
        localBundle.putSerializable("HotSpotNodeAPInfo", new QQHotSpotHelper.HotSpotNodeAPInfo(localFocusApInfo.a.Apinfo, localFocusApInfo.a.APInfoEx));
      }
    }
    Object localObject1 = WifiNetworkUtil.b();
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).toUpperCase();
      str = WifiNetworkUtil.a();
      if (((HashMap)localObject2).get(localObject1) == null) {
        break label374;
      }
      localObject1 = (ArrayList)((HashMap)localObject2).get(localObject1);
      i = 0;
      label274:
      if (i >= ((ArrayList)localObject1).size()) {
        break label407;
      }
      if (!WifiNetworkUtil.a(((QQHotSpotHelper.HotSpotNodeAPInfo)((ArrayList)localObject1).get(i)).mApInfo.SSID, str)) {
        break label333;
      }
    }
    label333:
    label374:
    label407:
    for (localObject1 = (QQHotSpotHelper.HotSpotNodeAPInfo)((ArrayList)localObject1).get(i);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localBundle.putBoolean("isSureResult", true);
        return localBundle;
        localObject1 = null;
        break;
        i += 1;
        break label274;
      }
      if (a())
      {
        localBundle.putBoolean("isSureResult", false);
        localBundle.putSerializable("HotSpotNodeAPInfo", (Serializable)localObject1);
      }
      for (;;)
      {
        return localBundle;
        localBundle.putBoolean("isSureResult", false);
      }
      if (HotSpotNodeCacheManager.a().b().contains(localObject1))
      {
        localBundle.putBoolean("isSureResult", true);
        return localBundle;
      }
      localBundle.putBoolean("isSureResult", false);
      return localBundle;
    }
  }
  
  /* Error */
  public static HandlerThread a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   6: ifnull +12 -> 18
    //   9: getstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 241	android/os/HandlerThread
    //   21: dup
    //   22: ldc -13
    //   24: invokespecial 246	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   27: putstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   30: getstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   33: invokevirtual 249	android/os/HandlerThread:start	()V
    //   36: new 251	android/os/Handler
    //   39: dup
    //   40: getstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   43: invokevirtual 255	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   46: invokespecial 258	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   49: putstatic 260	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   52: getstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   55: astore_0
    //   56: goto -43 -> 13
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	44	0	localHandlerThread	HandlerThread
    //   59	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	59	finally
    //   18	56	59	finally
  }
  
  public static List a(List paramList)
  {
    int j = 0;
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    Object localObject1 = new HashMap();
    Object localObject2 = new HashSet();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramList.size())
    {
      String str1 = ((QQHotSpotHelper.HotSpotNodeAPInfo)paramList.get(i)).mApInfo.SSID;
      String str2 = ((QQHotSpotHelper.HotSpotNodeAPInfo)paramList.get(i)).mApInfo.StoreName;
      if (!((HashMap)localObject1).containsKey(str1))
      {
        ((HashMap)localObject1).put(str1, str2);
        label117:
        if (((HashSet)localObject2).contains(str2)) {
          break label169;
        }
        ((HashSet)localObject2).add(str2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (str2.equals(((HashMap)localObject1).get(str1))) {
          break label117;
        }
        localHashSet1.add(str1);
        break label117;
        label169:
        localHashSet2.add(str2);
      }
    }
    localObject1 = new ArrayList();
    i = j;
    if (i < paramList.size())
    {
      if (!localHashSet1.contains(((QQHotSpotHelper.HotSpotNodeAPInfo)paramList.get(i)).mApInfo.SSID))
      {
        localObject2 = ((QQHotSpotHelper.HotSpotNodeAPInfo)paramList.get(i)).mApInfo.StoreName;
        j = ((QQHotSpotHelper.HotSpotNodeAPInfo)paramList.get(i)).mApInfo.SignLevel;
        if (localHashSet2.contains(localObject2)) {
          break label299;
        }
        ((List)localObject1).add(paramList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        label299:
        if (!localHashMap.containsKey(localObject2)) {
          localHashMap.put(localObject2, (QQHotSpotHelper.HotSpotNodeAPInfo)paramList.get(i));
        } else if (j > ((QQHotSpotHelper.HotSpotNodeAPInfo)localHashMap.get(localObject2)).mApInfo.SignLevel) {
          localHashMap.put(localObject2, (QQHotSpotHelper.HotSpotNodeAPInfo)paramList.get(i));
        }
      }
    }
    paramList = localHashMap.values().iterator();
    while (paramList.hasNext()) {
      ((List)localObject1).add((QQHotSpotHelper.HotSpotNodeAPInfo)paramList.next());
    }
    return (List)localObject1;
  }
  
  public static void a(int paramInt)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.a().a();
    localObject = ((QQAppInterface)localObject).a().getSharedPreferences(((QQAppInterface)localObject).a(), 0);
    if (paramInt == 0) {
      ((SharedPreferences)localObject).edit().putLong("qq_hotspot_lasttime_shownode", System.currentTimeMillis()).commit();
    }
    while (paramInt != 1) {
      return;
    }
    ((SharedPreferences)localObject).edit().putLong("qq_hotspot_lasttime_showsamenode", System.currentTimeMillis()).commit();
  }
  
  public static void a(HotSpotNodeUtil.GetLocalWiFiListCallBack paramGetLocalWiFiListCallBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    new QQHotSpotWiFiScanTool().a(new yhg(paramGetLocalWiFiListCallBack), paramBoolean1, paramBoolean2);
  }
  
  public static void a(HotSpotNodeUtil.LocationCallBack paramLocationCallBack)
  {
    if (b())
    {
      if (paramLocationCallBack != null) {
        paramLocationCallBack.a(true, null);
      }
      return;
    }
    if ((System.currentTimeMillis() - b < 3600000L) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null) && (paramLocationCallBack != null))
    {
      QLog.d("HotSpotNodeUtil", 2, "getCurLocation from cache onLocationFinish lat:" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + " lon:" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + " city:" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.e);
      if (a(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c, jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d, jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.e))
      {
        paramLocationCallBack.a(true, jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.e);
        return;
      }
      paramLocationCallBack.a(false, jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.e);
      return;
    }
    SosoInterface.a(new yhf(3, true, true, 3600000L, false, false, "HotSpotNodeUtil", paramLocationCallBack));
  }
  
  public static void a(APNodeCheckResult paramAPNodeCheckResult, Map paramMap)
  {
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList2 = new ArrayList(paramMap.keySet());
    Iterator localIterator = paramAPNodeCheckResult.arrApInfo.iterator();
    QQHotSpotHelper.HotSpotNodeAPInfo localHotSpotNodeAPInfo;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localHotSpotNodeAPInfo = (QQHotSpotHelper.HotSpotNodeAPInfo)localIterator.next();
        paramAPNodeCheckResult = (ArrayList)paramMap.get(localHotSpotNodeAPInfo.mApInfo.BSSID);
        if (paramAPNodeCheckResult != null)
        {
          i = 0;
          label87:
          if (i >= paramAPNodeCheckResult.size()) {
            break label325;
          }
          if (WifiNetworkUtil.a(localHotSpotNodeAPInfo.mApInfo.SSID, ((QQHotSpotHelper.HotSpotNodeApEx)paramAPNodeCheckResult.get(i)).mSsid)) {
            paramAPNodeCheckResult = ((QQHotSpotHelper.HotSpotNodeApEx)paramAPNodeCheckResult.get(i)).mLevel;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      localHotSpotNodeAPInfo.mApInfo.SignLevel = paramAPNodeCheckResult.intValue();
      if (localHashMap.get(localHotSpotNodeAPInfo.mApInfo.BSSID) == null)
      {
        localArrayList1.add(localHotSpotNodeAPInfo.mApInfo.BSSID);
        paramAPNodeCheckResult = new ArrayList();
        paramAPNodeCheckResult.add(localHotSpotNodeAPInfo);
        localHashMap.put(localHotSpotNodeAPInfo.mApInfo.BSSID, paramAPNodeCheckResult);
      }
      for (;;)
      {
        if (i != 0) {
          break label300;
        }
        if (QLog.isColorLevel()) {
          QLog.i("HotSpotNodeUtil", 2, "svr 返回的ssid和本地的ssid不一致, svr的ssid：" + localHotSpotNodeAPInfo.mApInfo.SSID);
        }
        localIterator.remove();
        break;
        i += 1;
        break label87;
        ((ArrayList)localHashMap.get(localHotSpotNodeAPInfo.mApInfo.BSSID)).add(localHotSpotNodeAPInfo);
      }
      label300:
      break;
      paramAPNodeCheckResult = HotSpotNodeUtil.SetOpt.c(localArrayList2, localArrayList1);
      HotSpotNodeCacheManager.a().a(localArrayList1, localHashMap);
      HotSpotNodeCacheManager.a().a(paramAPNodeCheckResult);
      return;
      label325:
      paramAPNodeCheckResult = Integer.valueOf(0);
    }
  }
  
  public static boolean a()
  {
    int i = LoadingStateManager.a().a();
    return (i == 2) || (i == 3);
  }
  
  public static boolean a(int paramInt)
  {
    return WifiManager.calculateSignalLevel(paramInt, 3) > 0;
  }
  
  public static boolean a(Context paramContext)
  {
    for (bool1 = true;; bool1 = false)
    {
      try
      {
        List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
        if ((localList != null) && (localList.size() > 0))
        {
          if (((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName().equalsIgnoreCase(paramContext.getPackageName()))
          {
            boolean bool2 = b(paramContext);
            if (bool2) {}
          }
          for (bool1 = true;; bool1 = false) {
            return bool1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          if ((!GesturePWDUtils.isAppOnForeground(BaseApplication.getContext())) || (b(paramContext))) {
            bool1 = false;
          }
        }
      }
      finally
      {
        if ((!GesturePWDUtils.isAppOnForeground(BaseApplication.getContext())) || (b(paramContext))) {
          break;
        }
      }
      return bool1;
    }
  }
  
  /* Error */
  public static boolean a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 260	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   6: ifnull +16 -> 22
    //   9: getstatic 260	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   12: aload_0
    //   13: invokevirtual 508	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   16: istore_1
    //   17: ldc 2
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: new 241	android/os/HandlerThread
    //   25: dup
    //   26: ldc -13
    //   28: invokespecial 246	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   31: putstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   34: getstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   37: invokevirtual 249	android/os/HandlerThread:start	()V
    //   40: new 251	android/os/Handler
    //   43: dup
    //   44: getstatic 239	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   47: invokevirtual 255	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   50: invokespecial 258	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   53: putstatic 260	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   56: getstatic 260	cooperation/qqhotspot/hotspotnode/HotSpotNodeUtil:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   59: aload_0
    //   60: invokevirtual 508	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   63: pop
    //   64: iconst_0
    //   65: istore_1
    //   66: goto -49 -> 17
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramRunnable	Runnable
    //   16	50	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	17	69	finally
    //   22	64	69	finally
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    List localList = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getScanResults();
    boolean bool1 = bool2;
    int i;
    if (localList != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < localList.size())
      {
        ScanResult localScanResult = (ScanResult)localList.get(i);
        if ((!TextUtils.isEmpty(localScanResult.BSSID)) && (localScanResult.BSSID.equalsIgnoreCase(paramString1)) && (WifiNetworkUtil.a(localScanResult.SSID, paramString2))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    Object localObject1 = BaseApplication.getContext();
    Object localObject2;
    label101:
    boolean bool1;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject2 = ((BaseApplication)localObject1).getSharedPreferences("qq_hotspot_config", i);
      Object localObject3 = ((SharedPreferences)localObject2).getString("country_list", "");
      localObject1 = ((SharedPreferences)localObject2).getString("province_list", "");
      localObject2 = ((SharedPreferences)localObject2).getString("city_list", "");
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (paramString1 == null) || (TextUtils.isEmpty(paramString1))) {
        break label142;
      }
      localObject3 = ((String)localObject3).split("\\|");
      i = 0;
      if (i >= localObject3.length) {
        break label142;
      }
      if (!localObject3[i].equals(paramString1)) {
        break label133;
      }
      bool1 = true;
    }
    label133:
    label142:
    do
    {
      do
      {
        do
        {
          return bool1;
          i = 0;
          break;
          i += 1;
          break label101;
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
          {
            paramString1 = ((String)localObject1).split("\\|");
            i = 0;
            while (i < paramString1.length)
            {
              if (paramString1[i].equals(paramString2)) {
                return true;
              }
              i += 1;
            }
          }
          bool1 = bool2;
        } while (TextUtils.isEmpty((CharSequence)localObject2));
        bool1 = bool2;
      } while (paramString3 == null);
      bool1 = bool2;
    } while (TextUtils.isEmpty(paramString3));
    paramString1 = ((String)localObject2).split("\\|");
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramString1.length) {
        break;
      }
      if (paramString1[i].equals(paramString3)) {
        return true;
      }
      i += 1;
    }
  }
  
  public static long b()
  {
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("qq_hotspot_config", i).getString("max_interval_showsamenode_time", "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      try
      {
        long l = Long.parseLong((String)localObject);
        return l;
      }
      catch (Exception localException)
      {
        return 10800000L;
      }
    }
    return 10800000L;
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    Object localObject = BaseApplication.getContext();
    int i;
    boolean bool1;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("qq_hotspot_config", i).getString("country_list", "");
      bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < localObject.length)
      {
        if (localObject[i].equals(BaseApplicationImpl.a().getString(2131366414))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
        i = 0;
        break;
      }
      i += 1;
    }
  }
  
  private static boolean b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (;;)
    {
      try
      {
        bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).isKeyguardLocked();
        if (QLog.isColorLevel()) {
          QLog.e("HotSpotNodeUtil", 2, "isKeyguardLock=" + bool);
        }
        return bool;
      }
      catch (SecurityException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HotSpotNodeUtil", 2, "kgm.isKeyguardLocked()=" + paramContext);
        }
        return true;
      }
      boolean bool = QQUtils.a(paramContext);
    }
  }
  
  public static boolean c()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("qq_hotspot_config", i).getString("hotspot_open", "").equals("1");
    }
  }
  
  public static boolean d()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("qq_hotspot_config", i).getString("hotspot_open", "").equals("0");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\HotSpotNodeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */