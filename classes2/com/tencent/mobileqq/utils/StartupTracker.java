package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTracker
{
  public static final String A = "QQRt_entityManagerFactory_create";
  public static final String B = "QQRt_entityManagerFactory_verify";
  public static final String C = "QQRt_entityManagerFactory_veri_1";
  public static final String D = "QQRt_entityManagerFactory_veri_2";
  public static final String E = "QQRt_entityManagerFactory_veri_3";
  public static final String F = "AIO_Start_cost";
  public static final String G = "AIO_Click_cost";
  public static final String H = "AIO_Super_onAttach";
  public static final String I = "AIO_Super_onCreate";
  public static final String J = "AIO_Super_onViewCreated";
  public static final String K = "AIO_Super_onResume";
  public static final String L = "AIO_Super_onPause";
  public static final String M = "AIO_Super_onStop";
  public static final String N = "AIO_Super_onDestroyView";
  public static final String O = "AIO_Super_onDestroy";
  public static final String P = "AIO_onAttach";
  public static final String Q = "AIO_onCreate";
  public static final String R = "AIO_onCreateView";
  public static final String S = "AIO_onViewCreated";
  public static final String T = "AIO_onResume";
  public static final String U = "AIO_onPause";
  public static final String V = "AIO_onStop";
  public static final String W = "AIO_onDestroy";
  public static final String X = "AIO_doOnCreate_initUI";
  public static final String Y = "AIO_doOnCreate_initData";
  public static final String Z = "AIO_doOnCreate_handleRequest";
  public static long a = 0L;
  public static final String a = "AutoMonitor";
  private static ConcurrentHashMap a;
  public static final boolean a = false;
  public static final String aA = "AIO_apolloFooterview";
  public static final String aB = "AIO_EmoticonPanel_OpenDuration";
  public static final String aC = "AIO_EmoticonPanel_OnResume";
  public static final String aD = "AIO_EmoticonPanel_EnterSecond";
  public static final String aE = "AIO_EmoticonPanel_EnterFirst";
  public static final String aF = "AIO_EmoticonPanel_PageScroll";
  public static final String aG = "AIO_EmoticonPanel_TabClick";
  public static final String aH = "AIO_emosmDetailActivity_onCreate";
  public static final String aI = "AIO_emosmDetailActivity_onResume";
  public static final String aJ = "AIO_EmoticonPanel_Refresh";
  public static final String aK = "AIO_bubble_craete_bubble_info";
  public static final String aL = "Web_uiplugin_onActivityCreate";
  public static final String aM = "Web_uiplugin_step_";
  public static final String aN = "Recent_clk_enterchat";
  public static final String aO = "Recent_clk_enterchat_troop";
  public static final String aP = "Recent_clk_enterchat_cmr";
  public static final String aQ = "Recent_clk_enterchat_pub";
  public static final String aR = "Main_super_create";
  public static final String aS = "Main onCreateView";
  public static final String aT = "Main_onAttach";
  public static final String aU = "Main_ui_create_tab0";
  public static final String aV = "Main_ui_create_tab123";
  public static final String aW = "Main_base_create";
  public static final String aX = "Main_init_calltab";
  public static final String aY = "Main_init_nowtab";
  public static final String aZ = "Main_register_observers";
  public static final String aa = "AIO_doOnCreate_BeforeEnterCost";
  public static final String ab = "AIO_onCreate_getPieCost";
  public static final String ac = "AIO_doOnCreate_otherCost";
  public static final String ad = "AIO_preLoad_Cost";
  public static final String ae = "AIO_doOnResume_updateUI";
  public static final String af = "AIO_onDrawView";
  public static final String ag = "AIO_onShow";
  public static final String ah = "AIO_onShow_first";
  public static final String ai = "AIO_onShow_updateUI";
  public static final String aj = "AIO_onShow_videoStatus";
  public static final String ak = "AIO_onShow_setReaded";
  public static final String al = "AIO_onShow_otherThings";
  public static final String am = "AIO_onShow_report";
  public static final String an = "AIO_onShow_emotion";
  public static final String ao = "AIO_onShow_business";
  public static final String ap = "AIO_updateSession";
  public static final String aq = "AIO_updateSession_initIntentData";
  public static final String ar = "AIO_updateSession_updateUI";
  public static final String as = "AIO_updateSession_business";
  public static final String at = "AIO_updateSession_forwardType";
  public static final String au = "AIO_updateSession_otherThings";
  public static final String av = "AIO_updateSession_updateTitle";
  public static final String aw = "AIO_ChatAdapter_getView";
  public static final String ax = "AIO_onWindowFocusChanged";
  public static final String ay = "AIO_SysMsgCost";
  public static final String az = "AIO_apolloSurface";
  public static final String b = "Main_Start";
  public static final String ba = "Main_cancel_notify";
  public static final String bb = "Recent_LoadData_query_recent_list";
  public static final String bc = "Recent_LoadData_getManagers";
  public static final String bd = "Recent_LoadData_preloadData";
  public static final String be = "Recent_LoadData_convert";
  public static final String bf = "Recent_LoadData_conv_uin_record";
  public static final String bg = "Recent_LoadMoreData_getFaceDrawable";
  public static final String bh = "Recent_LoadData_build_item";
  public static final String bi = "Recent_LoadData_update";
  public static final String bj = "troop_nearby_mem_";
  public static final String bk = "troop_nearby_mem_on_create";
  public static final String bl = "troop_nearby_mem_on_resume";
  public static final String bm = "troop_nearby_mem_radar_view_init";
  public static final String bn = "troop_nearby_mem_radar_view_init";
  public static final String bo = "troop_nearby_mem_radar_bg_view_init";
  public static final String bp = "troop_nearby_mem_gallery_init";
  public static final String bq = "troop_nearby_mem_scan_view_init";
  public static final String br = "apollo_panel_open";
  private static final String bs = "STATE_";
  public static final String c = "Main_OnCreat";
  public static final String d = "Main_OnStart";
  public static final String e = "Main_OnPostCreat";
  public static final String f = "Main_OnResume";
  public static final String g = "Main_Resume_Sound";
  public static final String h = "Main_Resume_PCActive";
  public static final String i = "Recent_Start";
  public static final String j = "Recent_CreateView";
  public static final String k = "Recent_OnCreate";
  public static final String l = "Recent_OnResume";
  public static final String m = "Recent_OnLayout";
  public static final String n = "Recent_Draw";
  public static final String o = "QQRt_onCreate";
  public static final String p = "QQRt_superOnCreate";
  public static final String q = "QQRt_PushServlet";
  public static final String r = "QQRt_QQInitHandler";
  public static final String s = "QQRt_netHandler";
  public static final String t = "QQRt_MobileQQService";
  public static final String u = "QQRt_initTheme";
  public static final String v = "QQRt_initFaceIconCache";
  public static final String w = "QQRt_MemoryManager";
  public static final String x = "QQRt_startCoreService";
  public static final String y = "QQRt_videoMsgReceiver";
  public static final String z = "QQRt_initAvatarUploadState";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  }
  
  public static void a(String paramString, long paramLong) {}
  
  public static void a(String paramString1, String paramString2) {}
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("AIO_Start_cost");
  }
  
  public static final void b(String paramString1, String paramString2)
  {
    long l1 = SystemClock.uptimeMillis();
    if (paramString1 != null)
    {
      paramString2 = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      if (paramString2 != null)
      {
        jdField_a_of_type_Long = l1 - paramString2.longValue();
        paramString1 = paramString1 + ", cost=" + jdField_a_of_type_Long + "|" + QQAppInterface.c + "|" + AIOPreLoadEngine.a;
        if (!QLog.isColorLevel()) {
          break label93;
        }
        QLog.i("AutoMonitor", 2, paramString1);
      }
    }
    label93:
    while (paramString2 == null)
    {
      return;
      Log.i("AutoMonitor", paramString1);
      return;
    }
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, Long.valueOf(l1));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\StartupTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */